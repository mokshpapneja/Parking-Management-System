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
<body style="background-color: #f0f1f2;">
	<%@include file="all_components/navbar.jsp"%>
	<%
	User u = (User) session.getAttribute("userobj");
	%>
	<%
	int bid = Integer.parseInt(request.getParameter("bid"));
	SlotDAOImpl dao = new SlotDAOImpl(DBConnect.getConn());
	SlotDtls b = dao.getslotById(bid);
	%>

	<div class="container p-3">
		<div class="row">
			<div class="col-md-6 text-center p-5 border bg-white">
				
				<h4 class="mt-3">
					Location: <span class="text-success"><%=b.getLocation()%></span>
				</h4>
				<h4>
					Time: <span class="text-success"><%=b.getTime()%></span>
				</h4>
				<h4>
					Price: <span class="text-success"><%=b.getPrice()%></span>
				</h4>
				
			</div>

			<div class="col-md-6 text-center p-5 border bg-white">
				<h2><%=b.getLocation()%></h2>

			</div>
		</div>
	</div>
</body>
</html>
<style>
body{
  background-color:rgb(28, 7, 63);
}
</style>