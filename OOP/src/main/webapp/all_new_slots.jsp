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
#toast {
	min-width: 300px;
	position: fixed;
	bottom: 30px;
	left: 50%;
	margin-left: -125px;
	background: #333;
	padding: 10px;
	color: white;
	text-align: center;
	z-index: 1;
	font-size: 18px;
	visibility: hidden;
	box-shadow: 0px 0px 100px #000;
}
#toast.display {
	visibility: visible;
	animation: fadeIn 0.5, fadeOut 0.5s 2.5s;
}
@
keyframes fadeIn {from { bottom:0;
	opacity: 0;
}
to {
	bottom: 30px;
	opacity: 1;
}
}
@
keyframes fadeOut {form { bottom:30px;
	opacity: 1;
}
to {
	bottom: 0;
	opacity: 0;
}
}
</style>
</head>
<body>
	<%
	User u = (User) session.getAttribute("userobj");
	%>
	<c:if test="${not empty addCart }">

		<div id="toast">${addCart}</div>

		<script type="text/javascript">
		showToast();
		function showToast(content)
		{
		    $('#toast').addClass("display");
		    $('#toast').html(content);
		    setTimeout(()=>{
		        $("#toast").removeClass("display");
		    },2000)
		}	
</script>

		<c:remove var="addCart" scope="session" />
	</c:if>


	<%@include file="all_components/navbar.jsp"%>
	<div class="container-fluid">
		<div class="row p-3">
			<%
			SlotDAOImpl dao = new SlotDAOImpl(DBConnect.getConn());
			List<SlotDtls> list = dao.getAllNewSlot();
			for (SlotDtls b : list) {
			%>
			<div class="col-md-3">
				<div class="card crd-ho">
					<div class="card-body text-center">
						
						<p><%=b.getLocation()%></p>
						<p><%=b.getTime()%></p>
						<p><%=b.getPrice()%><i class="fas fa-rupee-sign"></i></p>
						
						<div class="row">
							<%
							if (u == null) {
							%>
							<a href="checkout.jsp?bid=<%=b.getId()%>" class="btn btn-danger btn-sm ml-2"><i class="fas fa-cart-plus"></i> Book</a>
							<%
							} else {
							%>
							<a href="cart?bid=<%=b.getId()%>&&uid=<%=u.getId()%>"
								class="btn btn-danger btn-sm ml-2"><i class="fas fa-cart-plus"></i> Add Cart</a>
							<%
							}
							%>

							<a href="view_slots.jsp?bid=<%=b.getId()%>" class="btn btn-success btn-sm ml-1">View Details</a>
						</div>
					</div>
				</div>
			</div>
			<%
			}
			%>
		</div>
	</div>
</body>
</html>
<style>
body{
  background-color:rgb(28, 7, 63);
}
</style>