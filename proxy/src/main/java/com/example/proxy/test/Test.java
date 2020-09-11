package com.example.proxy.test;

import com.example.proxy.annoation.MyField;
import com.example.proxy.bean.Student;

import java.lang.reflect.Field;

/**
 * 
 * @author T_Antry
 * @describe 反射测试
 * T_Antry-Test
 * 2020年9月9日
 */
public class Test {
	/**
	 * 
	 * @param args
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @describe
	 */
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Student st = new Student();//创建一个实例

		/**
		 * 首先我们要拿到类
		 */
		Class<?> c = st.getClass();
		Field[] fArr = c.getDeclaredFields();//获取本类所有属性，包括私有属性
		//	fArr = c.getFields();//只获取公有属性，且包括继承来的属性
		for (Field field : fArr) {
			field.setAccessible(true);//注意，我们的模板类写的是几个私有成员，这条是开启权限，使得我们都能够操作和读取私有属性的值

			MyField declaredAnnotation = field.getDeclaredAnnotation(MyField.class);
			String value = declaredAnnotation.value();
			System.out.println(value);

		}
	}
}
