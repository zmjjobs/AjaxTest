package com.ajax.app.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/validateUsername")
public class ValidateUsernameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ValidateUsernameServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> usernameList = Arrays.asList("AAA","BBB","CCC");
		String username = request.getParameter("username");
		String result;
		if (usernameList.contains(username)) {
			result = "<font color='red'>该用户名已被使用</font>";
		} else {
			result = "<font color='green'>该用户名可以使用</font>";
		}
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print(result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
