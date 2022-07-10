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

@WebServlet("/delete")

public class SlotsDeleteServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(req.getParameter("id"));

			SlotDAOImpl dao = new SlotDAOImpl(DBConnect.getConn());
			boolean f = dao.deleteslots(id);
			HttpSession session = req.getSession();

			if (f) {
				session.setAttribute("succMsg", "slot Delete Successfully..");
				resp.sendRedirect("admin/all_slots.jsp");
			} else {
				session.setAttribute("failedMsg", "Something wrong on server");
				resp.sendRedirect("admin/all_slots.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
