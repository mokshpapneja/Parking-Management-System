package com.admin.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.SlotDAOImpl;
import com.DB.DBConnect;
import com.entity.SlotDtls;

@WebServlet("/editslots")

public class EditSlotsServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id=Integer.parseInt(req.getParameter("id"));
			String Location = req.getParameter("location");
			String Time = req.getParameter("time");
			String price = req.getParameter("price");
			String status = req.getParameter("status");
			
			SlotDtls b=new SlotDtls();
			b.setId(id);
			b.setLocation(Location);
			b.setTime(Time);
			b.setPrice(price);
			b.setStatus(status);
			
			SlotDAOImpl dao=new SlotDAOImpl(DBConnect.getConn());
			boolean f=dao.updateEditslots(b);
			
			HttpSession session=req.getSession();
			
			if(f)
			{
				session.setAttribute("succMsg", "slot Update Successfully..");
				resp.sendRedirect("admin/all_slots.jsp");
			}else {
				session.setAttribute("failedMsg", "Something wrong on server");
				resp.sendRedirect("admin/all_slots.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
