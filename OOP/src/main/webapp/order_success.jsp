<%@page import="com.entity.User"%>
<%@page import="com.entity.SlotDtls"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.SlotDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="all_components/allCss.jsp"%>
</head>
<body style="background-color: #f0f1f2">
<%
	int bid = Integer.parseInt(request.getParameter("bid"));
	SlotDAOImpl dao = new SlotDAOImpl(DBConnect.getConn());
	SlotDtls b = dao.getslotById(bid);
	b.setStatus("Inactive");
	boolean x=dao.updateEditslots(b);
	
	%>
	<%@include file="all_components/navbar.jsp"%>
	
	<div class="container text-center mt-3">
		<i class="fas fa-check-circle fa-5x text-success"></i>
		<h1>Thank You</h1>
		<h2>Your Slot is Booked Successfully</h2>
		<a href="index.jsp" class="btn btn-primary mt-3">Home</a> <a
			href="order.jsp" class="btn btn-danger mt-3">View Order</a>
	</div>
</body>
</html>