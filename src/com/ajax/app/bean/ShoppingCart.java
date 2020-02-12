package com.ajax.app.bean;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
	private String bookName;
	private Map<String,ShoppingCartItem> itemsMap = new HashMap<>();
	
	/**
	 * 加入购物车
	 * @param bookName
	 * @param price
	 */
	public void addToCart(String bookName,double price) {
		if(itemsMap.containsKey(bookName)) {
			ShoppingCartItem item = itemsMap.get(bookName);
			item.setPrice(item.getPrice() + price);
			item.setNumber(item.getNumber() +1);
		} else {
			ShoppingCartItem item = new ShoppingCartItem();
			item.setBookName(bookName);
			item.setPrice(price);
			item.setNumber(1);
			itemsMap.put(bookName, item);
		}
	}
	
	public int getTotalBookNum(){
		int total = 0;
		for(Map.Entry<String,ShoppingCartItem> entry : itemsMap.entrySet()){
			total += entry.getValue().getNumber();
		}
		return total;
	}
	public double getTotalMoney(){
		double total = 0;
		for(Map.Entry<String,ShoppingCartItem> entry : itemsMap.entrySet()){
			total += entry.getValue().getPrice();
		}
		return total;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
}
