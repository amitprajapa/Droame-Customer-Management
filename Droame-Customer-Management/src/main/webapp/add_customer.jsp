<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@page isELIgnored="false" %>
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
					<p class="fs-3 text-center">Add Customer</p>
					
				<c:if test="${not empty succMg }">
				<p class="text-center text-success">${succMg}</p>
				<c:remove var="succMg"/>
				</c:if>
				
				<c:if test="${not empty errorMsg }">
				<p class="text-center text-success">${errorMg}</p>
				<c:remove var="errorMg"/>
				</c:if>
				
				
				
				
				<form action="register" method="post">
	                  
	
	                 <div class="mb-3">
                        <label  class="form-label">Customer Name</label>
                        <input type="text" name="name" class="form-control" required>
                     </div>
   
                     <div class="mb-3">
                        <label  class="form-label">Email</label>
                        <input type="email" name="email" class="form-control" required>
                     </div>
   
   					<div class="mb-3">
    					<label  class="form-label">Phone Number</label>
    					<input type="text" name="number" class="form-control" required>
  				   </div>
   
  					<div class="mb-3">
    				  <label  class="form-label">Address</label>
    				  <input type="text" name="address" class="form-control" required>
    				</div>
   	
  
    
  			          	<button type="submit" class="btn btn-primary col-md-12">Submit</button>
						</form>
			
					</div>
				</div>
			</div>
		</div>
	</div>
	
	
	
	
	
</body>
</html>