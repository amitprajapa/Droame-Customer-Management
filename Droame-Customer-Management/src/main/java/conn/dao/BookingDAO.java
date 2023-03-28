package conn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import conn.entity.Booking;
import conn.entity.Customer;

public class BookingDAO {
	private Connection conn;
	public BookingDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean addBookingDetails(Booking booking)
	{
		boolean f=false;
		try {
			String sql="insert into droame.booking_details(booking_id,location,drone_shot,created_time) values(?,?,?,?)";
			
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, booking.getBooking_id());
			ps.setString(2, booking.getLocation_id());
			ps.setString(3, booking.getDrone_shot_id());
			ps.setString(4, booking.getCreated_time());
			
			  int i= ps.executeUpdate();
			    
			    if(i==1) {
			    	f=true;
			    }
				
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}
	
	
	public List<Booking> getAllBookingDetails()
	{
		List<Booking> list=new ArrayList<Booking>();
		Booking s=null;
		
		try {
			String sql="select * from droame.booking_details";
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				s=new Booking(); 
			//	s.getBooking_id(rs.getInt(1));
				s.setLocation_id(rs.getString(2));
				s.setDrone_shot_id(rs.getString(3));
				s.setCreated_time(rs.getString(4));
				
				list.add(s);
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
	}
	public boolean deleteOder(int booking_id) {
		boolean f=false;
		try {
			String sql="delete from droame.booking_details where booking_id=? ";
			
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, booking_id);
			int i=ps.executeUpdate();
			if(i==1)
			{
				f=true;
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}

}
