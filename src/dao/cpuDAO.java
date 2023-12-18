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

			String sql = "INSERT INTO cpu (idsanpham, tencpu, xungnhip, sonhan, soluong, diennangtieuthu, bonhodem) VALUES (?, ?, ?, ?, ?, ?, ?);";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getNameCpu());
			ps.setString(3, t.getXungNhip());
			ps.setInt(4, t.getSoNhan());
			ps.setInt(5, t.getSoLuong());
			ps.setString(6, t.getDienNangTieuThu());
			ps.setString(7, t.getBoNhoDem());
			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	@Override
	public int update(cpu t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(cpu t) {
		// TODO Auto-generated method stub
		return 0;
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
						rs.getString("bonhodem"));
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
		// TODO Auto-generated method stub
		return null;
	}

}
