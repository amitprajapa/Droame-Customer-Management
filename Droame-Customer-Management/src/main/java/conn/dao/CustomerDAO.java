package conn.dao;

import java.sql.Connection;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import conn.entity.Customer;

public class CustomerDAO {
	private Connection conn;

	public CustomerDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean addCustomer(Customer customer)
	{
		boolean f=false;
		try {
			String sql="insert into droame.customer_details(custName,email,number,address) values(?,?,?,?)";
			
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ps.setString(1, customer.getCusName());
			ps.setString(2, customer.getEmail());
			ps.setString(3, customer.getNumber());
			ps.setString(4, customer.getAddress());
			
			
		    int i= ps.executeUpdate();
		    
		    if(i==1) {
		    	f=true;
		    }
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public List<Customer> getAllCustomer()
	{
		List<Customer> list=new ArrayList<Customer>();
		Customer s=null;
		
		try {
			String sql="select * from customer_details";
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				s=new Customer(); 
				s.setId(rs.getInt(1));
				s.setCusName(rs.getString(2));
				s.setEmail(rs.getString(3));
				s.setNumber(rs.getString(4));
				s.setAddress(rs.getString(5));
				list.add(s);
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
	}
	
	public Customer getCustomerByID(int id) {
		Customer s=null;
		
		try {
			String sql="select * from customer_details where id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				s=new Customer();
				s.setId(rs.getInt(1));
				s.setCusName(rs.getString(2));
				s.setEmail(rs.getString(3));
				s.setNumber(rs.getString(4));
				s.setAddress(rs.getString(5));
				
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return s;
	}
	
	public boolean UpdateCustomer(Customer customer)
	{
		boolean f=false;
		try {
			String sql="update  droame.customer_details set custName=?,email=?,number=?,address=? where id=?";
			
			PreparedStatement ps=conn.prepareStatement(sql);
		
			ps.setString(1, customer.getCusName());
			ps.setString(2, customer.getEmail());
			ps.setString(3, customer.getNumber());
			ps.setString(4, customer.getAddress());
			ps.setInt(5, customer.getId());
			
		    int i= ps.executeUpdate();
		    
		    if(i==1) {
		    	f=true;
		    }
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public boolean deleteCustomer(int id) {
		boolean f=false;
		try {
			String sql="delete from droame.customer_details where id=? ";
			
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
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
