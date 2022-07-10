package com.admin.servlet;

import java.io.File;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.entity.SlotDtls;

import com.DAO.SlotDAOImpl;
import com.DB.DBConnect;

@WebServlet("/add_slots")
@MultipartConfig
public class SlotsAdd extends HttpServlet {

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
		int Id=(int)Math.round(Math.random()*1000);
		String Location = req.getParameter("location");
		String Time = req.getParameter("Time");
		String price = req.getParameter("price");
		String status = req.getParameter("status");

		SlotDtls b = new SlotDtls(Id,Location, Time, price, status);

		SlotDAOImpl dao = new SlotDAOImpl(DBConnect.getConn());

		boolean f = dao.addSlots(b);

		HttpSession session = req.getSession();

		session.setAttribute("succMsg", "Slot Add Sucessfully");
		resp.sendRedirect("admin/add_slots.jsp");


	} catch (Exception e) {
		e.printStackTrace();
	}
}

}
