package com.DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Slot_order;

public class SlotOrderImpl implements SlotOrderDAO {

	private Connection conn;

	public SlotOrderImpl(Connection conn) {
		super();
		this.conn = conn;
	}


	public boolean saveOrder(List<Slot_order> blist) {
		boolean f = false;
		try {

			String sql = "insert into slot_order(order_id,user_name,email,address,phno,slot_name,price,payment) values(?,?,?,?,?,?,?,?)";

			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(sql);

			for (Slot_order b : blist) {
				ps.setString(1, b.getOrderId());
				ps.setString(2, b.getUserName());
				ps.setString(3, b.getEmail());
				ps.setString(4, b.getFulladd());
				ps.setString(5, b.getPhno());
				ps.setString(6, b.getLocation());
				ps.setString(8, b.getPrice());
				ps.setString(9, b.getPaymentType());
				ps.addBatch();

			}
			
			int[] count=ps.executeBatch();
			conn.commit();
			f=true;
			conn.setAutoCommit(true);
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}


	public List<Slot_order> getslot(String email) {
		List<Slot_order> list=new ArrayList<Slot_order>();
		Slot_order o=null;

		try {
			
			String sql="select * from slot_order where email=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				o=new Slot_order();
				o.setId(rs.getInt(1));
				o.setOrderId(rs.getString(2));
				o.setUserName(rs.getString(3));
				o.setEmail(rs.getString(4));
				o.setFulladd(rs.getString(5));
				o.setPhno(rs.getString(6));
				o.setLocation(rs.getString(7));
				o.setPrice(rs.getString(8));
				o.setPaymentType(rs.getString(9));
				list.add(o);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}


	public List<Slot_order> getAllOrder() {
		List<Slot_order> list=new ArrayList<Slot_order>();
		Slot_order o=null;

		try {
			
			String sql="select * from slot_order ";
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				o=new Slot_order();
				o.setId(rs.getInt(1));
				o.setOrderId(rs.getString(2));
				o.setUserName(rs.getString(3));
				o.setEmail(rs.getString(4));
				o.setFulladd(rs.getString(5));
				o.setPhno(rs.getString(6));
				o.setLocation(rs.getString(7));
				o.setPrice(rs.getString(8));
				o.setPaymentType(rs.getString(9));
				list.add(o);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}



}
