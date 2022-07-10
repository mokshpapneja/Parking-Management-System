<%@page import="com.entity.SlotDtls"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.SlotDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin: Edit Slots</title>
<%@include file="allCss.jsp"%>
</head>
<body style="background-color: #f0f2f2;">
	<%@include file="navbar.jsp"%>
	<div class="caontainer">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center">Edit Slots</h4>
						

						<%
						int id = Integer.parseInt(request.getParameter("id"));
						SlotDAOImpl dao = new SlotDAOImpl(DBConnect.getConn());
						SlotDtls b = dao.getslotById(id);
						%>

						<form action="../editslots" method="post">
							<input type="hidden" name="id" value="<%=b.getId()%>">
							<div class="form-group">
								<label for="exampleInputEmail1">Location*</label> <input
									name="location" type="text" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									value="<%=b.getLocation()%>">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Time*</label> <input
									name="time" type="text" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									value="<%=b.getTime()%>">
							</div>

							<div class="form-group">
								<label for="exampleInputPassword1">Price*</label> <input
									name="price" type="number" class="form-control"
									id="exampleInputPassword1" value="<%=b.getPrice()%>">
							</div>


							<div class="form-group">
								<label for="inputState">slot Status</label> <select
									id="inputState" name="status" class="form-control">
									<%
									if ("Active".equals(b.getStatus())) {
									%>
									<option value="Active">Active</option>
									<option value="Inactive">Inactive</option>
									<%
									} else {
									%>
									<option value="Inactive">Inactive</option>
									<option value="Active">Active</option>
									<%
									}
									%>
								</select>
							</div>
							<button type="submit" class="btn btn-primary">Update</button>
						</form>

					</div>
				</div>
			</div>
		</div>

	</div>

</body>
</html>