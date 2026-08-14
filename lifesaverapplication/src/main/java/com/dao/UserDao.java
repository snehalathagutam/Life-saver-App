package com.dao;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.model.User;
import com.utility.DBConnection;



	public class UserDao {



	    Connection con = DBConnection.getConnection();



	    // REGISTER USER

	    public boolean registerUser(User user)
	    {

	        boolean result=false;


	        try
	        {

	            String sql=
	            "insert into users(name,email,password,phone,blood_group,city,role) values(?,?,?,?,?,?,?)";


	            PreparedStatement ps =
	            con.prepareStatement(sql);



	            ps.setString(1,user.getName());
	            ps.setString(2,user.getEmail());
	            ps.setString(3,user.getPassword());
	            ps.setString(4,user.getPhone());
	            ps.setString(5,user.getBloodGroup());
	            ps.setString(6,user.getCity());
	            ps.setString(7,"USER");



	            int row=ps.executeUpdate();


	            if(row>0)
	                result=true;


	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }


	        return result;

	    }






	    // LOGIN USER


	    public User login(String email,String password)
	    {


	        User user=null;


	        try
	        {


	            String sql=
	            "select * from users where email=? and password=?";


	            PreparedStatement ps=
	            con.prepareStatement(sql);



	            ps.setString(1,email);
	            ps.setString(2,password);



	            ResultSet rs=ps.executeQuery();



	            if(rs.next())
	            {

	                user=new User();


	                user.setId(rs.getInt("id"));
	                user.setName(rs.getString("name"));
	                user.setEmail(rs.getString("email"));
	                user.setPassword(rs.getString("password"));
	                user.setPhone(rs.getString("phone"));
	                user.setBloodGroup(rs.getString("blood_group"));
	                user.setCity(rs.getString("city"));
	                user.setRole(rs.getString("role"));

	            }


	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }


	        return user;

	    }








	    // UPDATE PROFILE


	    public boolean updateUser(User user)
	    {


	        boolean result=false;


	        try
	        {


	            String sql=
	            "update users set name=?,phone=?,blood_group=?,city=? where id=?";



	            PreparedStatement ps=
	            con.prepareStatement(sql);



	            ps.setString(1,user.getName());
	            ps.setString(2,user.getPhone());
	            ps.setString(3,user.getBloodGroup());
	            ps.setString(4,user.getCity());
	            ps.setInt(5,user.getId());



	            int row=ps.executeUpdate();



	            if(row>0)
	                result=true;


	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }


	        return result;

	    }







	    // SEARCH DONOR


	    public ArrayList<User> searchDonor(String blood,String city)
	    {


	        ArrayList<User> list=
	                new ArrayList<>();


	        try
	        {


	            String sql=
	            "select * from users where blood_group=? and city=? and role='USER'";



	            PreparedStatement ps=
	            con.prepareStatement(sql);



	            ps.setString(1,blood);
	            ps.setString(2,city);



	            ResultSet rs=
	            ps.executeQuery();



	            while(rs.next())
	            {


	                User user=new User();


	                user.setId(rs.getInt("id"));
	                user.setName(rs.getString("name"));
	                user.setPhone(rs.getString("phone"));
	                user.setBloodGroup(rs.getString("blood_group"));
	                user.setCity(rs.getString("city"));



	                list.add(user);


	            }


	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }



	        return list;

	    }








	    // VIEW ALL DONORS


	    public ArrayList<User> getAllDonors()
	    {


	        ArrayList<User> list=
	                new ArrayList<>();


	        try
	        {


	            String sql=
	            "select * from users where role='USER'";


	            PreparedStatement ps=
	            con.prepareStatement(sql);


	            ResultSet rs=
	            ps.executeQuery();



	            while(rs.next())
	            {

	                User user=new User();


	                user.setId(rs.getInt("id"));
	                user.setName(rs.getString("name"));
	                user.setEmail(rs.getString("email"));
	                user.setPhone(rs.getString("phone"));
	                user.setBloodGroup(rs.getString("blood_group"));
	                user.setCity(rs.getString("city"));



	                list.add(user);

	            }


	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }



	        return list;

	    }








	    // DELETE DONOR


	    public boolean deleteUser(int id)
	    {

	        boolean result=false;


	        try
	        {


	            String sql= "delete from users where id=?";


	            PreparedStatement ps=
	            con.prepareStatement(sql);



	            ps.setInt(1,id);



	            int row=
	            ps.executeUpdate();



	            if(row>0)
	                result=true;


	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }



	        return result;

	    }



	}
