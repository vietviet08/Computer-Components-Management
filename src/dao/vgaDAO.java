package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.JDBCUntil;
import model.vga;

public class vgaDAO implements DAOInterface<vga> {

	public static vgaDAO getInstance() {
		return new vgaDAO();
	}

	@Override
	public int insert(vga t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "INSERT INTO vga (idsanpham, idvga, tenvga, hangvga, bonho, tonkho, dongia) VALUES (?, ?, ?, ?, ?, ?, ?);";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getIdVga());
			ps.setString(3, t.getTenVGA());
			ps.setString(4, t.getHangVGA());
			ps.setString(5, t.getBoNho());
			ps.setInt(6, t.getTonKho());
			ps.setDouble(7, t.getDonGia());

			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	@Override
	public int update(vga t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "UPDATE vga SET idsanpham = ?, tenvga = ?, hangvga = ?, bonho = ?, tonkho = ?, dongia = ? WHERE idram = ?;";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getTenVGA());
			ps.setString(3, t.getHangVGA());
			ps.setString(4, t.getBoNho());
			ps.setInt(5, t.getTonKho());
			ps.setDouble(6, t.getDonGia());
			ps.setString(7, t.getIdVga());

			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	@Override
	public int delete(vga t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "DELETE FROM vga WHERE idram = ?;";

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
	public ArrayList<vga> selectAll() {
		ArrayList<vga> v = new ArrayList<>();

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "SELECT * FROM vga;";

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				vga vga = new vga(rs.getString("idsanpham"), rs.getString("idvga"), rs.getString("tenvga"),
						rs.getString("hangvga"), rs.getString("bonho"), rs.getInt("tonkho"), rs.getDouble("dongia"));
				v.add(vga);
			}
			JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return v;
	}

	@Override
	public vga selectById(String t) {
		vga v = null;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "SELECT * FROM vga;";

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				v = new vga(rs.getString("idsanpham"), rs.getString("idvga"), rs.getString("tenvga"),
						rs.getString("hangvga"), rs.getString("bonho"), rs.getInt("tonkho"), rs.getDouble("dongia"));
			}

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return v;
	}

}
