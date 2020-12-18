import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: yyq
 * @Date 9:39 上午 2020/12/1
 * @Description:
 */
public class QueryWeek {
    @Test
    public void QueryWeek() throws ParseException {
        String date="2020-01-29";
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("MM.dd");
        Date parse = df.parse(date);
        String format = simpleDateFormat.format(parse);
        System.out.println(format);


        Calendar calendar=Calendar.getInstance();
        calendar.setTime(parse);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DATE);
        int time = calendar.get(Calendar.DAY_OF_MONTH);
        int dayofweek = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println(year);
        System.out.println(month);
        System.out.println(day);
        System.out.println(time);
        System.out.println(dayofweek);

    }
}
