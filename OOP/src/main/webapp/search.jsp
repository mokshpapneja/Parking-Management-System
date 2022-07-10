<%@page import="com.entity.User"%>
<%@page import="com.entity.SlotDtls"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.SlotDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Slots</title>
<%@include file="all_components/allCss.jsp"%>
<style type="text/css">
.crd-ho:hover {
	background-color: #fcf7f7;
}
</style>
</head>
<body>
	<%
	User u = (User) session.getAttribute("userobj");
	%>
	<%@include file="all_components/navbar.jsp"%>
	<div class="container-fluid">
		<div class="row p-3">
			<%
			String ch = request.getParameter("ch");
			SlotDAOImpl dao2 = new SlotDAOImpl(DBConnect.getConn());
			List<SlotDtls> list2 = dao2.getslotBySerch(ch);
			for (SlotDtls b : list2) {
			%>
			<div class="col-md-3">
				<div class="card crd-ho mt-2">
					<div class="card-body text-center">
						
						<p><%=b.getLocation()%></p>
						<p><%=b.getTime()%></p>
						<p>

						
							<%
							if (u == null) {
							%>
							<a href="login.jsp" class="btn btn-danger btn-sm ml-2"><i class="fas fa-cart-plus"></i> Add
								Cart </a>
							<%
							} else {
							%>
							<a href="cart?bid=<%=b.getId()%>&&uid=<%=u.getId()%>"
								class="btn btn-danger btn-sm ml-2"><i class="fas fa-cart-plus"></i> Add Cart</a>
							<%
							}
							%>
							<a href="view_slots.jsp?bid=<%=b.getId()%>"
								class="btn btn-success btn-sm ml-1">View Details</a> <a href=""
								class="btn btn-danger btn-sm "><%=b.getPrice()%><i
								class="fas fa-rupee-sign"></i></a>
						</div>
						<%
						}
						%>
					</div>
				</div>
			</div>
			
		</div>
</body>
</html>