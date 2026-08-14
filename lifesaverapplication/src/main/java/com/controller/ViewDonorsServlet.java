package com.controller;


import java.io.IOException;
import java.util.ArrayList;

import com.dao.UserDao;
import com.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/viewDonors")
public class ViewDonorsServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserDao dao = new UserDao();

		ArrayList<User> donors = dao.getAllDonors();

		request.setAttribute("donors", donors);

		request.getRequestDispatcher("viewDonors.jsp").forward(request, response);

	}

}