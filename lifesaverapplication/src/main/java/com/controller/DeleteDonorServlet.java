package com.controller;


import java.io.IOException;

import com.dao.UserDao;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteDonor")
public class DeleteDonorServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		UserDao dao = new UserDao();

		dao.deleteUser(id);

		response.sendRedirect("viewDonors");

	}

}
