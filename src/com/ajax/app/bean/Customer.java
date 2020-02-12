package com.ajax.app.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Customer {
	private String name;
	private int id;
	
	public Customer(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	//@JsonIgnore
	//这个注解可以使Jackson忽略这个getter方法定义的属性
	public String getCity(){
		return "BeiJing";
	}
	
	public Date getBirth() {
		return new Date();
	}
	
	public static void main(String[] args) {
		//1.导入 jackson的jar包三个
		//2.创建ObjectMapper对象
		ObjectMapper objectMapper = new ObjectMapper();
		//3.调用mapper的writeValueAsString()方法把一个对象转成Json字符串
		Customer customer = new Customer("xmj", 123);
		try {
			String jsonStr = objectMapper.writeValueAsString(customer);
			System.out.println(jsonStr);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		List<Customer> list = new ArrayList<>();
		list.add(customer);
		customer = new Customer("wer", 445);
		list.add(customer);
		try {
			//3.调用mapper的writeValueAsString()方法把一个对象集合转成Json字符串
			String jsonStr = objectMapper.writeValueAsString(list);
			System.out.println(jsonStr);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
