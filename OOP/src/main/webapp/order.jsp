<%@page import="com.entity.Slot_order"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.SlotOrderImpl"%>
<%@page import="com.entity.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book slot</title>
<%@include file="all_components/allCss.jsp"%>
</head>
<body>
	
	<%@include file="all_components/navbar.jsp"%>
	<div class="container p-1">
		<h3 class="text-center text-primary">Your Book</h3>

		<table class="table table-striped mt-3">
			<thead class="bg-primary text-white">
				<tr>
					<th scope="col">Order Id</th>
					<th scope="col">Name</th>
					<th scope="col">Location</th>
					<th scope="col">Time</th>
					<th scope="col">Price</th>
					<th scope="col">Payment Type</th>
				</tr>
			</thead>
			<tbody>
				<%
				User u = (User) session.getAttribute("userobj");
				SlotOrderImpl dao = new SlotOrderImpl(DBConnect.getConn());
				List<Slot_order> blist = dao.getslot(u.getEmail());
				for (Slot_order b : blist) {
				%>
				<tr>
					<th scope="row"><%=b.getOrderId()%></th>
					<td><%=b.getUserName()%></td>
					<td><%=b.getLocation()%></td>
					<td><%=b.getTime()%></td>
					<td><%=b.getPrice()%></td>
					<td><%=b.getPaymentType()%></td>
				</tr>
				<%
				}
				%>




			</tbody>
		</table>

	</div>
</body>
</html>