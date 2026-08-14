package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.dao.BloodRequestDao;
import com.model.BloodRequest;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/viewRequests")
public class ViewRequestsServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BloodRequestDao dao = new BloodRequestDao();

		ArrayList<BloodRequest> requests = dao.getRequests();

		request.setAttribute("requests", requests);

		request.getRequestDispatcher("viewRequests.jsp").forward(request, response);

	}

}