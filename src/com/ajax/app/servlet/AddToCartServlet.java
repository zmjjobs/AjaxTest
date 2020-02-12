package com.ajax.app.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ajax.app.bean.ShoppingCart;

@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddToCartServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookName = request.getParameter("bookName");
		double price = Double.parseDouble(request.getParameter("price"));
		
		//获取购物车对象
		HttpSession session = request.getSession();
		ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
		if (shoppingCart == null) {
			shoppingCart = new ShoppingCart();
			session.setAttribute("shoppingCart", shoppingCart);
		}
		
		//加入购物车
		shoppingCart.addToCart(bookName, price);
		
		//准备JSON对象
		StringBuilder builder = new StringBuilder();
		builder.append("{")
				.append("\"bookName\":\"")
				.append(bookName)
				.append("\",\"totalBookNum\":")
				.append(shoppingCart.getTotalBookNum())
				.append(",\"totalMoney\":")
				.append(shoppingCart.getTotalMoney())
				.append("}");
		//发送响应
		response.setContentType("text/javascript");
		response.getWriter().print(builder.toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
