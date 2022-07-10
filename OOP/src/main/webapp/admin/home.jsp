<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin: Home</title>
<%@include file="allCss.jsp"%>

<style type="text/css">
a {
	text-decoration: none;
	color: black;
}
a:hover {
	text-decoration: none;
	color: black;
}
</style>


</head>
<body style="background-color: #f0f1f2;">

     <%@include file="navbar.jsp"%>
     
     <div class="container">
		<div class="row p-5">
			<div class="col-md-3">
				<a href="add_slots.jsp">
					<div class="card">
						<div class="card-body text-center">
							<br>
							<h4>Add Slots</h4>
							-----------
						</div>
					</div>
				</a>
			</div>


			<div class="col-md-3">
				<a href="all_slots.jsp">
					<div class="card">
						<div class="card-body text-center">
							<br>
							<h4>All Slots</h4>
							-----------
						</div>
					</div>
				</a>
			</div>


			<div class="col-md-3">
				<a data-toggle="modal" data-target="#exampleModalCenter">
					<div class="card">
						<div class="card-body text-center"><br>
							<h4><a href="../Login.html">Logout</a></h4>
							-----------
						</div>
					</div>
				</a>
			</div>
		</div>

	</div>
     
<footer style="position:absolute;bottom:0;text">&copy;Group55</footer>
</body>

</html>

<style>
<style>
body{
  background-color:rgb(28, 7, 63);
}
</style>