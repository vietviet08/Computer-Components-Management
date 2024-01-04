package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.JDBCUntil;
import model.ChiTietPhieu;

public class ChiTietPhieuXuatDAO implements DAOInterface<ChiTietPhieu> {

	public static ChiTietPhieuXuatDAO getInstance() {
		return new ChiTietPhieuXuatDAO();
	}

	@Override
	public int insert(ChiTietPhieu t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "insert into chitietdonnhap (iddonxuat, idsanpham, idrieng = ?, tensanpham, soluong, dongia, baohanh) values (?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdPhieu());
			ps.setString(2, t.getIdSanPham());
			ps.setString(3, t.getIdRieng());
			ps.setString(4, t.getTenSanPham());
			ps.setInt(5, t.getSoLuong());
			ps.setDouble(6, t.getDonGia());
			ps.setString(7, t.getBaoHanh());

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

			String sql = "update chitietdonnhap set  idsanpham = ?, idrieng = ?, tensanpham = ?, soluong = ?, dongia = ?, baohanh = ? where iddonxuat = ?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getIdRieng());
			ps.setString(3, t.getTenSanPham());
			ps.setInt(4, t.getSoLuong());
			ps.setDouble(5, t.getDonGia());
			ps.setString(6, t.getBaoHanh());
			ps.setString(7, t.getIdPhieu());

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

			String sql = "delete from chitietdonnhap where iddonxuat = ?";

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
				ChiTietPhieu ct = new ChiTietPhieu(rs.getString("iddonxuat"), rs.getString("idsanpham"),
						rs.getString("idrieng"), rs.getString("tensanpham"), rs.getInt("soluong"),
						rs.getDouble("dongia"), rs.getString("baohanh"));

				ttp.add(ct);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ttp;
	}

	public ArrayList<ChiTietPhieu> selectAllByID(String t) {
		ArrayList<ChiTietPhieu> ttp = new ArrayList<ChiTietPhieu>();

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "select * from chitietdonxuat where idkhachhang = ?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ChiTietPhieu ct = new ChiTietPhieu(rs.getString("iddonxuat"), rs.getString("idsanpham"),
						rs.getString("idrieng"), rs.getString("tensanpham"), rs.getInt("soluong"),
						rs.getDouble("dongia"), rs.getString("baohanh"));

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
				ttp = new ChiTietPhieu(rs.getString("iddonxuat"), rs.getString("idsanpham"), rs.getString("tensanpham"),
						rs.getString("idrieng"), rs.getInt("soluong"), rs.getDouble("dongia"), rs.getString("baohanh"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ttp;
	}

}
