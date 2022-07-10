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
<title>Admin: All Slots</title>
<%@include file="allCss.jsp"%>
</head>
<body>
    <%@include file="navbar.jsp"%>
    
    <h3 class="text-center" style="color:white">Hello Admin</h3>
    
    <table class="table table-striped table-dark">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Location</th>
      <th scope="col">Time</th>
      <th scope="col">Price</th>
      <th scope="col">Status</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  <%
			SlotDAOImpl dao = new SlotDAOImpl(DBConnect.getConn());
			List<SlotDtls> list = dao.getAllSlots();
			for (SlotDtls b : list) {
  %>
    <tr>
                <td><%=b.getId()%></td>
				<td><%=b.getLocation()%></td>
				<td><%=b.getTime()%></td>
				<td><%=b.getPrice()%></td>
				<td><%=b.getStatus()%></td>
				<td><a href="edit_slot.jsp?id=<%=b.getId()%>"
					class="btn btn-sm btn-primary"><i class="fas fa-edit"></i> Edit</a>
					<a href="../delete?id=<%=b.getId()%>"
					class="btn btn-sm btn-danger"><i class="fas fa-trash-alt"></i>
						Delete</a></td>
    </tr>
    <% }%>
    
  </tbody>
</table>
</body>
</html> 
<style>
body{
  background-color:rgb(28, 7, 63);
}
</style>