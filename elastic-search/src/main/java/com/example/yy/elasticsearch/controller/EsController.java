package com.example.yy.elasticsearch.controller;

import org.elasticsearch.action.admin.indices.alias.IndicesAliasesRequest;
import org.elasticsearch.action.admin.indices.alias.get.GetAliasesRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.GetAliasesResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexTemplatesRequest;
import org.elasticsearch.client.indices.GetIndexTemplatesResponse;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.ParsedStringTerms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.AvgAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.annotations.DynamicTemplates;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.*;

/**
 * @Author: yyq
 * @Date 11:22 上午 2020/11/30
 * @Description:
 */

@RestController
public class EsController {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @RequestMapping("/es")
    public String es() throws IOException {
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        MatchAllQueryBuilder matchAllQueryBuilder = QueryBuilders.matchAllQuery();
        sourceBuilder.query(matchAllQueryBuilder);

        SearchResponse search = restHighLevelClient.search(new SearchRequest(new String[]{"supermarket"}, sourceBuilder), RequestOptions.DEFAULT);
        SearchHits hits = search.getHits();
        SearchHit[] searchHits = hits.getHits();
        for (SearchHit searchHit : searchHits) {
            Map<String, Object> sourceAsMap = searchHit.getSourceAsMap();
            System.out.println(sourceAsMap);

        }
        return "success";

    }

    /**
     * @Author:yyq
     * @Description: 创建索引，添加数据
     * @Date: 2:09 下午 2020/11/30
     */
    @RequestMapping("/createIndex")
    public String createIndex() throws IOException {
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("user", "kimchy");
        jsonMap.put("postDate", new Date());
        jsonMap.put("message", "trying out Elasticsearch");
        IndexRequest indexRequest = new IndexRequest("posts")
                .id("1").source(jsonMap);
        restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);

        IndicesAliasesRequest request = new IndicesAliasesRequest();
        IndicesAliasesRequest.AliasActions aliasAction =
                new IndicesAliasesRequest.AliasActions(IndicesAliasesRequest.AliasActions.Type.ADD)
                        .index("posts")
                        .alias("alias1");
        request.addAliasAction(aliasAction);
        restHighLevelClient.indices().updateAliases(request, RequestOptions.DEFAULT);
        return "success";
    }

    /**
     * @Author:yyq
     * @Description: 删除数据
     * @Date: 3:18 下午 2020/12/1
     */
    @RequestMapping("/deleteIndex")
    public String deleteIndex() throws IOException {
        DeleteRequest request = new DeleteRequest(
                "posts",
                "1");
        restHighLevelClient.delete(request, RequestOptions.DEFAULT);

        return "success";
    }

    /**
     * @Author:yyq
     * @Description: 获取索引
     * @Date: 3:18 下午 2020/12/1
     */
    @RequestMapping("/getIndices")
    public String getIndices() throws IOException {
        GetAliasesRequest request = new GetAliasesRequest("alias1");//此处是别名
        GetAliasesResponse response = restHighLevelClient.indices().getAlias(request, RequestOptions.DEFAULT);

        System.out.println(response.getAliases());
        return "success";
    }


    /**
     * @Author:yyq
     * @Description: 获取模版
     * @Date: 3:18 下午 2020/12/1
     */
    @RequestMapping("/getTemplate")
    public String getTemplate() throws IOException {
        GetIndexTemplatesRequest request = new GetIndexTemplatesRequest("posts");

        GetIndexTemplatesResponse response = restHighLevelClient.indices().getIndexTemplate(request, RequestOptions.DEFAULT);

        System.out.println(response.getIndexTemplates());
        return "success";
    }


    @RequestMapping("/query")
    public String query() throws IOException {

        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        //根据单个字段查询
       /* MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("title", "手机");
        sourceBuilder.query(matchQueryBuilder);

        //must中的条件是并列关系
        TermQueryBuilder termbulider = QueryBuilders.termQuery("price", 2999);
        RangeQueryBuilder price = QueryBuilders.rangeQuery("price").lt(3999).gt(1999);
        BoolQueryBuilder must = QueryBuilders.boolQuery()
                .must(termbulider)
                .must(price);
        sourceBuilder.query(must);*/

      /*  BoolQueryBuilder should = QueryBuilders.boolQuery().should(QueryBuilders.rangeQuery("price").lt(2999).gt(1999))
                .should(QueryBuilders.rangeQuery("price").gte(2999).lte(3999));*/


        BoolQueryBuilder must = QueryBuilders.boolQuery().must(QueryBuilders.rangeQuery("price").lt(2999).gt(1999))
                .must(QueryBuilders.rangeQuery("price").gte(1999).lte(3999));


        //价格聚合
        // AvgAggregationBuilder price = AggregationBuilders.avg("priceAvg").field("price");


        //品牌聚合
        TermsAggregationBuilder brandagg = AggregationBuilders.terms("brandagg").field("attr.brand.keyword");
        //根据数据的id查询
        IdsQueryBuilder idsQueryBuilder = QueryBuilders.idsQuery().addIds("1", "2");
        //sourceBuilder.query(idsQueryBuilder);
        //sourceBuilder.aggregation(price);

        //品牌下的类别下的
        sourceBuilder.aggregation(brandagg.subAggregation(AggregationBuilders.terms("catagg").field("attr.category.keyword")
                .subAggregation(AggregationBuilders.avg("priceAvg").field("price"))));

        SearchResponse search = restHighLevelClient.search(new SearchRequest(new String[]{"supermarket"}, sourceBuilder), RequestOptions.DEFAULT);

        SearchHit[] hits = search.getHits().getHits();
        Map<String, Aggregation> stringAggregationMap = search.getAggregations().asMap();

        for (SearchHit hit : hits) {
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            String images = (String) sourceAsMap.get("images");
            System.out.println(sourceAsMap);
        }
        ParsedStringTerms brandAgg = (ParsedStringTerms) stringAggregationMap.get("brandagg");
        List<? extends Terms.Bucket> buckets = brandAgg.getBuckets();
        for (Terms.Bucket bucket : buckets) {
            String keyAsString = bucket.getKeyAsString();
            System.out.println(keyAsString);
        }
        return "success";
    }
}
