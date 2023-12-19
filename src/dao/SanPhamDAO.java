package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.JDBCUntil;
import model.Products;

public class SanPhamDAO implements DAOInterface<Products> {

	public static SanPhamDAO getInstance() {
		return new SanPhamDAO();
	}

	@Override
	public int insert(Products t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "INSERT INTO sanpham (idsanpham, tensanpham, idnpp, soluongtonkho) VALUES (?, ?, ?, ?, ?);";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getTenSanPham());
			ps.setString(4, t.getIdNPP());
			ps.setInt(5, t.getSoLuongTonKho());

			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	@Override
	public int update(Products t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "update sanpham set tensanpham = ?, idloaisp = ?, idnpp = ?, soluongtonkho = ? where idsanpham = ?;";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getTenSanPham());
			ps.setString(3, t.getIdNPP());
			ps.setInt(4, t.getSoLuongTonKho());
			ps.setString(5, t.getIdSanPham());

			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public int delete(Products t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "delete from sanpham where idsanpham = ?;";

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
	public ArrayList<Products> selectAll() {
		ArrayList<Products> list = new ArrayList<Products>();

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "select * from sanpham;";

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Products p = new Products(rs.getString("idsanpham"), rs.getString("tensanpham"), rs.getString("idnpp"),
						rs.getInt("soluongtonkho"));

				list.add(p);
			}

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public Products selectById(String t) {
		Products p = null;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "select * from sanpham where idsanpham = ?;";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				p = new Products(rs.getString("idsanpham"), rs.getString("tensanpham"), rs.getString("idnpp"),
						rs.getInt("soluongtonkho"));

			}

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return p;
	}

	public static ArrayList<Products> getIDSanPham(String name) {
		ArrayList<Products> list = new ArrayList<>();
		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "select * from sanpham where idsanpham like 'cpu%';";

			switch (name) {
			case "cpu":
				sql = "select * from sanpham where idsanpham like 'cpu%';";
				break;
			case "ram":
				sql = "select * from sanpham where idsanpham like 'ram%';";
				break;
			case "vga":
				sql = "select * from sanpham where idsanpham like 'RTX%' or idsanpham like 'GTX%';";
				break;

			case "mainboard":
				sql = "select * from sanpham where idsanpham like 'main%';";
				break;
			case "chuot":
				sql = "select * from sanpham where idsanpham like 'mou%';";
				break;

			case "banphim":
				sql = "select * from sanpham where idsanpham like 'keyb%';";
				break;

			case "manhinh":
				sql = "select * from sanpham where idsanpham like 'scr%';";
				break;

			default:
				break;
			}

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Products p = new Products(rs.getString("idsanpham"), rs.getString("tensanpham"), rs.getString("idnpp"),
						rs.getInt("soluongtonkho"));

				list.add(p);
			}

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

}
