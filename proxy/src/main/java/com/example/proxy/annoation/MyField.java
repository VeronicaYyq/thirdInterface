package com.example.proxy.annoation;

import java.lang.annotation.*;

/**
 * 
 * @author T_Antry
 * @describe 用于与数据库对应
 * @target - 标记这个注解应该是那种java成员：类。字段、属性、方法
 * @Retention - 标识这个注解怎么保存，只在代码中，还是编入class文件中，或者是在运行时可以反射
 * @Documented - 标记这些注解是否包含在用户文档中
 * @Inherited - 标记这个注解是继承哪个注解类（默认注解没有继承于任何注解）
 * return
 * 2020年8月11日
 */
@Target(ElementType.FIELD)//声明是修饰属性的
@Retention(RetentionPolicy.RUNTIME)//通常都是选这个属性，运行时存活，因为一般要配合反射使用
@Documented
@Inherited
public @interface MyField {
	String value();//声明了一个value的key她的值是string
}
