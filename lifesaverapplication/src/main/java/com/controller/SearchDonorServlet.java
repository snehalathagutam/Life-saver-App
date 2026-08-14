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

@WebServlet("/searchDonor")
public class SearchDonorServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String blood = request.getParameter("blood");

		String city = request.getParameter("city");

		UserDao dao = new UserDao();

		ArrayList<User> donors = dao.searchDonor(blood, city);

		request.setAttribute("donors", donors);

		request.getRequestDispatcher("search.jsp").forward(request, response);

	}

}