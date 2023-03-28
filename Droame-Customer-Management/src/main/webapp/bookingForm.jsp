<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">

</head>
<body>
    <h1>Booking Form</h1>
  			    <c:if test="${not empty succMg }">
				<p class="text-center text-success">${succMg}</p>
				<c:remove var="succMg"/>
				</c:if>
				
				<c:if test="${not empty errorMsg }">
				<p class="text-center text-success">${errorMg}</p>
				<c:remove var="errorMg"/>
				</c:if>
    
    
    <form action="BookingServlet" method="post" class="form-center">
		<label for="booking_id">Booking ID:</label>
		<input type="text" id="booking_id" name="booking_id" required>

		<label for="location_id">Location ID:</label>
		<input type="text" id="location_id" name="location_id" required>

		<label for="drone_shot_id">Drone Shot ID:</label>
		<input type="text" id="drone_shot_id" name="drone_shot_id" required>

		<label for="created_time">Created Time:</label>
		<input type="text" id="created_time" name="created_time" required>

		<input type="submit" value="Submit">
	</form>
</body>
<style type="text/css">
.form-center {
  display:flex;
  justify-content: center;
}

form {
			display: flex;
			flex-direction: column;
			align-items: left;
			display:flex;
 			 justify-content: center;
		}

		input[type="text"], select {
			width: 50%;
			padding: 12px;
			border: 1px solid #ccc;
			border-radius: 4px;
			box-sizing: border-box;
			margin-top: 6px;
			margin-bottom: 16px;
		}

		input[type="submit"] {
			background-color: #4CAF50;
			width: 50%;
			color: white;
			padding: 12px 20px;
			border: none;
			border-radius: 4px;
			cursor: pointer;
		}

		input[type="submit"]:hover {
			background-color: #45a049;
		}
</style>
</html>