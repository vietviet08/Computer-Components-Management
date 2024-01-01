package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.JDBCUntil;
import model.ProductNhap;
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

			String sql = "INSERT INTO ram (idsanpham, idram, tenram, loairam, dungluong, bus, tonkho, dongia) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getIdRam());
			ps.setString(3, t.getTenRam());
			ps.setString(4, t.getLoai());
			ps.setString(5, t.getDungLuong());
			ps.setString(6, t.getBus());
			ps.setInt(7, t.getTonkho());
			ps.setDouble(8, t.getDonGia());
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

			String sql = "UPDATE ram SET idsanpham = ?, tenram = ?, loairam = ?, dungluong = ?, bus = ?, tonkho = ?, dongia = ? WHERE idram = ?;";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getTenRam());
			ps.setString(3, t.getLoai());
			ps.setString(4, t.getDungLuong());
			ps.setString(5, t.getBus());
			ps.setInt(6, t.getTonkho());
			ps.setDouble(7, t.getDonGia());
			ps.setString(8, t.getIdRam());

			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	public int updateTonKho(ArrayList<ProductNhap> pn) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			for (ProductNhap productNhap : pn) {
				if (productNhap.getPrivateId().contains("r")) {
					String sql = "UPDATE ram SET tonkho = tonkho + ? WHERE idram = ? ;";
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
	public int delete(ram t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "DELETE FORM ram WHERE idram = ?;";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdRam());

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
				ram ram = new ram(rs.getString("idsanpham"), rs.getString("idram"), rs.getString("tenram"),
						rs.getString("loairam"), rs.getString("dungluong"), rs.getString("bus"), rs.getInt("tonkho"),
						rs.getDouble("dongia"));
				r.add(ram);
			}

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return r;
	}

	public ArrayList<ram> selectNhapHang() {
		ArrayList<ram> list = new ArrayList<ram>();

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "SELECT * FROM ram;";

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ram ram = new ram(rs.getString("idsanpham"), rs.getString("idram"), rs.getString("tenram"),
						rs.getDouble("dongia"));
				list.add(ram);
			}

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public ram selectById(String t) {
		ram r = null;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "SELECT * FROM ram WHERE idram = ?;";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				r = new ram(rs.getString("idsanpham"), rs.getString("idram"), rs.getString("tenram"),
						rs.getString("loairam"), rs.getString("dungluong"), rs.getString("bus"), rs.getInt("tonkho"),
						rs.getDouble("dongia"));
			}

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return r;
	}

}
