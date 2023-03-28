<%@page import="conn.entity.Booking"%>
<%@page import="conn.dao.BookingDAO"%>
<%@page import="conn.entity.Customer"%>
<%@page import="java.util.*"%>
<%@page import="conn.dao.CustomerDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.Connection" %>
<%@page import="com.conn.DBConnect" %>

 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@page isELIgnored="false" %>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="all_css.jsp" %>
</head>
<body>
<%@include file="navbar.jsp" %>







<div class="container p-3">
<div class="card">
<div class="card-body">

<p class="text-center fs-1">All Customer Details</p>
<c:if test="${not empty succMg }">
				<p class="text-center text-success">${succMg}</p>
				<c:remove var="succMg"/>
				</c:if>
				
				<c:if test="${not empty errorMsg }">
				<p class="text-center text-success">${errorMg}</p>
				<c:remove var="errorMg"/>
				</c:if>

<table class="table">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Customer Name</th>
      <th scope="col">Email</th>
      <th scope="col">Phone Number</th>
      <th scope="col">Address</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  
  	<%
  	CustomerDAO dao=new CustomerDAO(DBConnect.getConn());
  	List<Customer>list=dao.getAllCustomer();
  	for(Customer s : list){
  	%>
    <tr>
      <td scope="row"><%=s.getId() %></td> 
       <td ><%=s.getCusName() %></td>
      <td><%=s.getEmail() %></td> 
      <td><%=s.getNumber() %></td>
      <td><%=s.getAddress() %></td>
      
      <td>
      <a href="edit_customer.jsp?id=<%=s.getId() %>" class="btn btn-sm btn-primary">Edit</a>
      <a href="delete?id=<%=s.getId() %>" class="btn btn-sm btn-danger ms-1">Delete</a>
      </td>
    </tr>
  
  <%
  	}
  %>
  
    
  </tbody>
</table>

<%--  --%>

<p class="text-center fs-1">All Customer Booking Details</p>

<table class="table">
  <thead>
    <tr>
      <th scope="col">Location ID</th>
      
      <th scope="col">Drone Shot</th>
      <th scope="col">Created Time</th>
     
    </tr>
  </thead>
  <tbody>
  
  	<%
    BookingDAO dao1=new BookingDAO(DBConnect.getConn());
  	List<Booking>list1=dao1.getAllBookingDetails();
  	for(Booking s : list1){
  	%>
    <tr>
      
       <td scope="row"><%=s.getLocation_id() %></td>
      <td><%=s.getDrone_shot_id() %></td> 
      <td><%=s.getCreated_time() %></td>
     
      
      <td>
      <a href="bookingForm.jsp?id=<%=s.getBooking_id()%>" class="btn btn-sm btn-primary">Book</a>
      <a href="delete1?booking_id=<%=s.getBooking_id() %>" class="btn btn-sm btn-danger ms-1">Delete</a>
      </td>
    </tr>
  
  <%
  	}
  %>
  
    
  </tbody>
</table>




</div>
</div>
</div>

















</body>
</html>