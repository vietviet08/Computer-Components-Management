package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.JDBCUntil;
import model.cpu;

public class cpuDAO implements DAOInterface<cpu> {

	public static cpuDAO getInstance() {
		return new cpuDAO();
	}

	@Override
	public int insert(cpu t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "INSERT INTO cpu (idsanpham, tencpu, xungnhip, sonhan, soluong, diennangtieuthu, bonhodem, dongia) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getNameCpu());
			ps.setString(3, t.getXungNhip());
			ps.setInt(4, t.getSoNhan());
			ps.setInt(5, t.getSoLuong());
			ps.setString(6, t.getDienNangTieuThu());
			ps.setString(7, t.getBoNhoDem());
			ps.setDouble(8, t.getDonGia());
			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	@Override
	public int update(cpu t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "UPDATE cpu SET tencpu = ?, xungnhip = ?, sonhan = ?, soluong = ?, diennangtieuthu = ?, bonhodem = ?, dongia = ? WHERE idsanpham = ?;";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getNameCpu());
			ps.setString(2, t.getXungNhip());
			ps.setInt(3, t.getSoNhan());
			ps.setInt(4, t.getSoLuong());
			ps.setString(5, t.getDienNangTieuThu());
			ps.setString(6, t.getBoNhoDem());
			ps.setDouble(7, t.getDonGia());
			ps.setString(8, t.getIdSanPham());
			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	@Override
	public int delete(cpu t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "DELETE FROM cpu WHERE idsanpham = ?;";

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
	public ArrayList<cpu> selectAll() {
		ArrayList<cpu> c = new ArrayList<cpu>();
		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "SELECT * FROM cpu;";

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				cpu chip = new cpu(rs.getString("idsanpham"), rs.getString("tencpu"), rs.getString("xungnhip"),
						rs.getInt("sonhan"), rs.getInt("soluong"), rs.getString("diennangtieuthu"),
						rs.getString("bonhodem"), rs.getDouble("dongia"));
				c.add(chip);
			}
			JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public cpu selectById(String t) {
		cpu c = null;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "SELECT * FROM cpu WHERE idsanpham = ?;";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				c = new cpu(rs.getString("idsanpham"), rs.getString("tencpu"), rs.getString("xungnhip"),
						rs.getInt("sonhan"), rs.getInt("soluong"), rs.getString("diennangtieuthu"),
						rs.getString("bonhodem"), rs.getDouble("dongia"));
			}
			JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return c;
	}
	

}
