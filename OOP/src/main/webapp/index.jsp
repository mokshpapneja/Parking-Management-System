<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title >Car Parking</title>
<%@include file="all_components/allCss.jsp" %>
</head>
<body>

<%@include file="all_components/navbar.jsp"%>
    <div class="container-fluid" >
     
     	<div class="conatiner">
		<div class="row p-5">
			<div class="col-md-4 offset-md-4 text-center" style="color:white">
			<h3 style="color:pink;font-family:monospace;"> Welcome to User Dashboard! </h3>
				<h3><% String uname=String.valueOf(request.getParameter("uname"));System.out.println(uname); %><%=uname %></h3>
			</div>

		</div>


	</div>
      
      
      <div class="text-center mt-1">
          <a href="all_new_slots.jsp" class="btn btn-danger btn-sm text-white">View All Slots Available</a>
      </div>
    </div>
    <footer style="position:absolute;bottom:0;color:white;">&copy;Group55</footer>
</body>
</html>
<style>
body{
  background-color:rgb(28, 7, 63);
}
conatiner{
margin-top:2em;
}
</style>