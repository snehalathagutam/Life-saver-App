package com.controller;

import java.io.IOException;

import com.dao.UserDao;
import com.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");

		String password = request.getParameter("password");

		UserDao dao = new UserDao();

		User user = dao.login(email, password);

		if (user != null) {

			HttpSession session = request.getSession();

			session.setAttribute("user", user);

			if (user.getRole().equals("ADMIN")) {

				response.sendRedirect("adminDashboard.jsp");

			} else {

				response.sendRedirect("dashboard.jsp");

			}

		} else {

			response.sendRedirect("login.jsp");

		}

	}

}