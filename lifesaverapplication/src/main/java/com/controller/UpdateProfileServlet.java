package com.controller;

import java.io.IOException;

import com.dao.UserDao;
import com.model.User;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/updateProfile")
public class UpdateProfileServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		HttpSession session = request.getSession();

		User user = (User) session.getAttribute("user");

		user.setName(request.getParameter("name"));

		user.setPhone(request.getParameter("phone"));

		user.setBloodGroup(request.getParameter("blood"));

		user.setCity(request.getParameter("city"));

		UserDao dao = new UserDao();

		dao.updateUser(user);

		session.setAttribute("user", user);

		response.sendRedirect("profile.jsp");

	}

}