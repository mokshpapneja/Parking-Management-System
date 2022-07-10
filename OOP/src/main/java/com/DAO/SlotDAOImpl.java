package com.DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.SlotDtls;

public class SlotDAOImpl implements SlotDAO {
	private Connection conn;

	public SlotDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addSlots(SlotDtls b) {
		boolean f = false;
		try {
			PreparedStatement ps = conn.prepareStatement("insert into slots values(?,?,?,?,?)");
			ps.setInt(1, (int)Math.round(Math.random()*1000));
			ps.setString(2, b.getLocation());
			ps.setString(3, b.getTime());
			ps.setString(4, b.getPrice());
			ps.setString(5, b.getStatus());
			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public List<SlotDtls> getAllSlots() {

		List<SlotDtls> list = new ArrayList<SlotDtls>();
		SlotDtls b = null;

		try {
			String sql = "select * from slots";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				b = new SlotDtls();
				b.setId(rs.getInt(1));
				b.setLocation(rs.getString(2));
				b.setTime(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setStatus(rs.getString(5));
				list.add(b);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public SlotDtls getslotById(int id) {

		SlotDtls b = null;
		try {
			String sql = "select * from slots where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				b = new SlotDtls();
				b.setId(rs.getInt(1));
				b.setLocation(rs.getString(2));
				b.setTime(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setStatus(rs.getString(5));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	public boolean updateEditslots(SlotDtls b) {
		boolean f = false;
		try {
			String sql = "update slots set Location=?,Time=?,price=?,status=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, b.getLocation());
			ps.setString(2, b.getTime());
			ps.setString(3, b.getPrice());
			ps.setString(4, b.getStatus());
			ps.setInt(5, b.getId());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean deleteslots(int id) {
		boolean f = false;
		try {
			String sql = "delete from slots where Id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public List<SlotDtls> getslotBySerch(String ch) {

		List<SlotDtls> list = new ArrayList<SlotDtls>();
		SlotDtls b = null;
		try {

			String sql = "select * from slos where Location like ? or Time like ? or slotCategory like ? and status=? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+ch+"%");
			ps.setString(2, "%"+ch+"%");
			ps.setString(3, "%"+ch+"%");
			ps.setString(4, "Active");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				b = new SlotDtls();
				b.setId(rs.getInt(1));
				b.setLocation(rs.getString(2));
				b.setTime(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setStatus(rs.getString(5));
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<SlotDtls> getAllNewSlot() {
		List<SlotDtls> list = new ArrayList<SlotDtls>();
		SlotDtls b = null;
		try {
			String sql = "select * from slots where status=? order by id DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "Active");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				b = new SlotDtls();
				b.setId(rs.getInt(1));
				b.setLocation(rs.getString(2));
				b.setTime(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setStatus(rs.getString(5));
				list.add(b);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
