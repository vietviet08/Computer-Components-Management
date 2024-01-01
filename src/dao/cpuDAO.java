package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.JDBCUntil;
import model.ProductNhap;
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

			String sql = "INSERT INTO cpu (idsanpham, idcpu, tencpu, xungnhip, sonhan, soluong, diennangtieuthu, bonhodem, tonkho, dongia) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?);";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getIdCpu());
			ps.setString(3, t.getNameCpu());
			ps.setString(4, t.getXungNhip());
			ps.setInt(5, t.getSoNhan());
			ps.setInt(6, t.getSoLuong());
			ps.setString(7, t.getDienNangTieuThu());
			ps.setString(8, t.getBoNhoDem());
			ps.setInt(9, t.getTonKho());
			ps.setDouble(10, t.getDonGia());
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

			String sql = "UPDATE cpu SET idsanpham = ?, tencpu = ?, xungnhip = ?, sonhan = ?, soluong = ?, diennangtieuthu = ?, bonhodem = ?, tonkho = ?, dongia = ? WHERE idcpu = ?;";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getNameCpu());
			ps.setString(3, t.getXungNhip());
			ps.setInt(4, t.getSoNhan());
			ps.setInt(5, t.getSoLuong());
			ps.setString(6, t.getDienNangTieuThu());
			ps.setString(7, t.getBoNhoDem());
			ps.setInt(8, t.getTonKho());
			ps.setDouble(9, t.getDonGia());
			ps.setString(10, t.getIdCpu());
			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

//	cần tạo method update số lượng sản phẩm khi được nhập hàng hoặc xuất hàng

	public int updateTonKho(ArrayList<ProductNhap> pn) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			for (ProductNhap productNhap : pn) {

				if (productNhap.getPrivateId().contains("cpu")) {
					String sql = "UPDATE cpu SET  tonkho = tonkho + ? WHERE idcpu = ?;";

					PreparedStatement ps = con.prepareStatement(sql);
					ps.setInt(1, productNhap.getSoLuong());
					ps.setString(2, productNhap.getPrivateId());
					check = ps.executeUpdate();
				}

			}
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

			String sql = "DELETE FROM cpu WHERE idcpu = ?;";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdCpu());
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
				cpu chip = new cpu(rs.getString("idsanpham"), rs.getString("idcpu"), rs.getString("tencpu"),
						rs.getString("xungnhip"), rs.getInt("sonhan"), rs.getInt("soluong"),
						rs.getString("diennangtieuthu"), rs.getString("bonhodem"), rs.getInt("tonkho"),
						rs.getDouble("dongia"));
				c.add(chip);
			}
			JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	public ArrayList<cpu> selectNhapHang() {
		ArrayList<cpu> c = new ArrayList<cpu>();
		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "SELECT * FROM cpu;";

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				cpu chip = new cpu(rs.getString("idsanpham"), rs.getString("idcpu"), rs.getString("tencpu"),
						rs.getDouble("dongia"));
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

			String sql = "SELECT * FROM cpu WHERE idcpu = ?;";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				c = new cpu(rs.getString("idsanpham"), rs.getString("idcpu"), rs.getString("tencpu"),
						rs.getString("xungnhip"), rs.getInt("sonhan"), rs.getInt("soluong"),
						rs.getString("diennangtieuthu"), rs.getString("bonhodem"), rs.getInt("tonkho"),
						rs.getDouble("dongia"));
			}
			JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return c;
	}
	

	public ArrayList<cpu> selectByIdSanPham(String t) {
		ArrayList<cpu> list = new ArrayList<cpu>();
		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "SELECT * FROM cpu WHERE idsanpham = ?;";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				cpu c = new cpu(rs.getString("idsanpham"), rs.getString("idcpu"), rs.getString("tencpu"),
						rs.getString("xungnhip"), rs.getInt("sonhan"), rs.getInt("soluong"),
						rs.getString("diennangtieuthu"), rs.getString("bonhodem"), rs.getInt("tonkho"),
						rs.getDouble("dongia"));
				list.add(c);
			}
			JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

}
