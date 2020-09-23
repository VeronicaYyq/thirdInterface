package com.example.rabbitmq.bean;

import javax.persistence.*;
import java.io.Serializable;

import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.Data;
import lombok.Getter;

import lombok.ToString;

/**
 * @Description  
 * @Author  yyq
 * @Date 2020-09-23 
 */

@Data
@ToString
@Entity
@Table ( name ="user" )
public class UserEntity  implements Serializable {

	private static final long serialVersionUID =  5917103335530542438L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id" )
	private Long id;

   	@Column(name = "name" )
	private String name;

   	@Column(name = "age" )
	private Long age;

	/**
	 * 状态（1，删除，2，未删除）
	 */
   	@Column(name = "status" )
	private Long status;

}
