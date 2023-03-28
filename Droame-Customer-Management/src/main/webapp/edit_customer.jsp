<%@page import="conn.entity.Customer"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="conn.dao.CustomerDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="all_css.jsp" %>
</head>
<body class="bg-light">
	<%@include file="navbar.jsp" %>
	<div class="container-4">
	    <div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
					<p class="fs-3 text-center">Edit Customer</p>
				
				<%
				int id=Integer.parseInt(request.getParameter("id"));
				CustomerDAO dao = new CustomerDAO(DBConnect.getConn());
			    Customer s =dao.getCustomerByID(id);
				%>
				
				
				
				
				<form action="update" method="post">
	                 
	
	                 <div class="mb-3">
                        <label  class="form-label">Customer Name</label>
                        <input type="text" value="<%=s.getCusName() %>" name="name" class="form-control" >
                     </div>
   
                     <div class="mb-3">
                        <label  class="form-label">Email</label>
                        <input type="email" value="<%=s.getEmail() %>" name="email" class="form-control" >
                     </div>
   
   					<div class="mb-3">
    					<label  class="form-label">Phone Number</label>
    					<input type="text" value="<%=s.getNumber() %>" name="number" class="form-control" >
  				   </div>
   
  					<div class="mb-3">
    				  <label  class="form-label">Address</label>
    				  <input type="text" value="<%=s.getAddress() %>" name="address" class="form-control" >
    				</div>
   	
  						<input type="hidden" name="id" value="<%=s.getId()%>">
    
  			          	<button type="submit" class="btn btn-primary col-md-12">Update</button>
						</form>
			
					</div>
				</div>
			</div>
		</div>
	</div>
	
	
	
	
	
</body>
</html>