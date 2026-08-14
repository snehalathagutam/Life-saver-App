package com.controller;



import java.io.IOException;

import com.dao.BloodRequestDao;
import com.model.BloodRequest;
import com.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/bloodRequest")
public class BloodRequestServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		HttpSession session = request.getSession();

		User user = (User) session.getAttribute("user");

		BloodRequest br = new BloodRequest();

		br.setUserId(user.getId());

		br.setPatientName(request.getParameter("patient"));

		br.setBloodGroup(request.getParameter("blood"));

		br.setUnits(Integer.parseInt(request.getParameter("units")));

		br.setHospital(request.getParameter("hospital"));

		br.setCity(request.getParameter("city"));

		BloodRequestDao dao = new BloodRequestDao();

		boolean result = dao.addRequest(br);

		if (result) {
			response.sendRedirect("dashboard.jsp");
		} else {
			response.sendRedirect("requestBlood.jsp");
		}

	}

}