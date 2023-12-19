package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.JDBCUntil;
import model.ram;

public class ramDAO implements DAOInterface<ram> {

	public static ramDAO getInstance() {
		return new ramDAO();
	}

	@Override
	public int insert(ram t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "INSERT INTO ram (idsanpham, tenram, loairam, dungluong, bus dongia) VALUES (?, ?, ?, ?, ?, ?);";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getTenRam());
			ps.setString(3, t.getLoai());
			ps.setString(4, t.getDungLuong());
			ps.setString(5, t.getBus());
			ps.setDouble(6, t.getDonGia());
			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	@Override
	public int update(ram t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "UPDATE ram SET  tenram = ?, loairam = ?, dungluong = ?, bus = ?, dongia = ? WHERE idsanpham = ?;";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getTenRam());
			ps.setString(2, t.getLoai());
			ps.setString(3, t.getDungLuong());
			ps.setString(4, t.getBus());
			ps.setString(5, t.getIdSanPham());
			ps.setDouble(6, t.getDonGia());

			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	@Override
	public int delete(ram t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "DELETE FORM ram WHERE idsanpham = ?;";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());

			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	@Override
	public ArrayList<ram> selectAll() {
		ArrayList<ram> r = new ArrayList<ram>();

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "SELECT * FROM ram;";

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ram ram = new ram(rs.getString("idsanpham"), rs.getString("tenram"), rs.getString("loairam"),
						rs.getString("dungluong"), rs.getString("bus"), rs.getDouble("dongia"));
				r.add(ram);
			}

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return r;
	}

	@Override
	public ram selectById(String t) {
		ram r = null;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "SELECT * FROM ram WHERE idsanpham = ?;";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(0, t);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				r = new ram(rs.getString("idsanpham"), rs.getString("tenram"), rs.getString("loairam"),
						rs.getString("dungluong"), rs.getString("bus"), rs.getDouble("dongia"));
			}

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return r;
	}

}
