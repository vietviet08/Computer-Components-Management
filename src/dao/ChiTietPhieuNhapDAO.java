package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.JDBCUntil;
import model.ChiTietPhieu;

public class ChiTietPhieuNhapDAO implements DAOInterface<ChiTietPhieu> {
	
	public static ChiTietPhieuNhapDAO getInstance() {
		return new ChiTietPhieuNhapDAO();
	}

	@Override
	public int insert(ChiTietPhieu t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "insert into chitietdonnhap (iddonnhap, idsanpham, soluong, dongia) values (?, ?, ?, ?)";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdPhieu());
			ps.setString(2, t.getIdSanPham());
			ps.setInt(3, t.getSoLuong());
			ps.setDouble(4, t.getDonGia());

			check = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	@Override
	public int update(ChiTietPhieu t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "update chitietdonnhap set  idsanpham = ?, soluong = ?, dongia = ? where iddonnhap = ?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setInt(2, t.getSoLuong());
			ps.setDouble(3, t.getDonGia());
			ps.setString(4, t.getIdPhieu());

			check = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public int delete(ChiTietPhieu t) {

		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "delete from chitietdonnhap where iddonnhap = ?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdPhieu());

			check = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public ArrayList<ChiTietPhieu> selectAll() {
		ArrayList<ChiTietPhieu> ttp = new ArrayList<ChiTietPhieu>();

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "select * from chitietdonnhap";

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ChiTietPhieu ct = new ChiTietPhieu(rs.getString("iddonnhap"), rs.getString("idsanpham"),
						rs.getInt("soluong"), rs.getDouble("dongia"));

				ttp.add(ct);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ttp;
	}

	@Override
	public ChiTietPhieu selectById(String t) {

		ChiTietPhieu ttp = null;
		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "select * from chitietdonnhap";

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ttp = new ChiTietPhieu(rs.getString("iddonnhap"), rs.getString("idsanpham"), rs.getInt("soluong"),
						rs.getDouble("dongia"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ttp;
	}

}
