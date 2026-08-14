package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.model.BloodRequest;
import com.utility.DBConnection;

public class BloodRequestDao {

	Connection con = DBConnection.getConnection();

// ADD REQUEST

	public boolean addRequest(BloodRequest request) {

		boolean result = false;

		try {

			String sql = "insert into blood_requests(user_id,patient_name,blood_group,units,hospital,city) values(?,?,?,?,?,?)";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, request.getUserId());
			ps.setString(2, request.getPatientName());
			ps.setString(3, request.getBloodGroup());
			ps.setInt(4, request.getUnits());
			ps.setString(5, request.getHospital());
			ps.setString(6, request.getCity());

			int row = ps.executeUpdate();

			if (row > 0)
				result = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

// VIEW ALL REQUESTS

	public ArrayList<BloodRequest> getRequests() {

		ArrayList<BloodRequest> list = new ArrayList<>();

		try {

			String sql = "select * from blood_requests";

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				BloodRequest br = new BloodRequest();

				br.setRequestId(rs.getInt("request_id"));
				br.setUserId(rs.getInt("user_id"));
				br.setPatientName(rs.getString("patient_name"));
				br.setBloodGroup(rs.getString("blood_group"));
				br.setUnits(rs.getInt("units"));
				br.setHospital(rs.getString("hospital"));
				br.setCity(rs.getString("city"));
				br.setStatus(rs.getString("status"));

				list.add(br);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;

	}

// DELETE REQUEST

	public boolean deleteRequest(int id) {

		boolean result = false;

		try {

			String sql = "delete from blood_requests where request_id=?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id);

			int row = ps.executeUpdate();

			if (row > 0)
				result = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

}
