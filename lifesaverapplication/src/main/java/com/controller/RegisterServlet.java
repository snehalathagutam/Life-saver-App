package com.controller;


import java.io.IOException;

import com.dao.UserDao;
import com.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = new User();

		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		user.setPhone(request.getParameter("phone"));
		user.setBloodGroup(request.getParameter("blood"));
		user.setCity(request.getParameter("city"));

		UserDao dao = new UserDao();

		boolean result = dao.registerUser(user);

		if (result) {
			response.sendRedirect("login.jsp");
		} else {
			response.sendRedirect("register.jsp");
		}

	}

}