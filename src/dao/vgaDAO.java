package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.JDBCUntil;
import model.ProductNhap;
import model.vga;
import view.CapNhatVGA;
import view.ThemVGA;

public class vgaDAO implements DAOInterface<vga> {

	public static vgaDAO getInstance() {
		return new vgaDAO();
	}

	@Override
	public int insert(vga t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "INSERT INTO vga (idsanpham, idvga, tenvga, hangvga, bonho, tonkho, dongia, baohanh, img) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getIdVga());
			ps.setString(3, t.getTenVGA());
			ps.setString(4, t.getHangVGA());
			ps.setString(5, t.getBoNho());
			ps.setInt(6, t.getTonKho());
			ps.setDouble(7, t.getDonGia());
			ps.setString(8, t.getBaoHanh());

			try {
				InputStream is = new FileInputStream(new File(ThemVGA.getInsert()));
				ps.setBlob(9, is);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	public int insertNotIMG(vga t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "INSERT INTO vga (idsanpham, idvga, tenvga, hangvga, bonho, tonkho, dongia, baohanh) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?);";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getIdVga());
			ps.setString(3, t.getTenVGA());
			ps.setString(4, t.getHangVGA());
			ps.setString(5, t.getBoNho());
			ps.setInt(6, t.getTonKho());
			ps.setDouble(7, t.getDonGia());
			ps.setString(8, t.getBaoHanh());

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

			String sql = "UPDATE vga SET idsanpham = ?, tenvga = ?, hangvga = ?, bonho = ?, tonkho = ?, dongia = ?, baohanh = ?, img = ? WHERE idvga = ?;";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getTenVGA());
			ps.setString(3, t.getHangVGA());
			ps.setString(4, t.getBoNho());
			ps.setInt(5, t.getTonKho());
			ps.setDouble(6, t.getDonGia());
			ps.setString(7, t.getBaoHanh());

			try {
				InputStream is = new FileInputStream(new File(CapNhatVGA.getInsert()));
				ps.setBlob(8, is);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			ps.setString(9, t.getIdVga());

			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	public int updateNotIMG(vga t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "UPDATE vga SET idsanpham = ?, tenvga = ?, hangvga = ?, bonho = ?, tonkho = ?, dongia = ?, baohanh = ? WHERE idvga = ?;";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getTenVGA());
			ps.setString(3, t.getHangVGA());
			ps.setString(4, t.getBoNho());
			ps.setInt(5, t.getTonKho());
			ps.setDouble(6, t.getDonGia());
			ps.setString(7, t.getBaoHanh());
			ps.setString(8, t.getIdVga());

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
				if (productNhap.getPrivateId().contains("vga")) {

					String sql = "UPDATE vga SET  tonkho = tonkho + ? WHERE idvga = ?;";

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
	public int delete(vga t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "DELETE FROM vga WHERE idvga = ?;";

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
						rs.getString("hangvga"), rs.getString("bonho"), rs.getInt("tonkho"), rs.getDouble("dongia"),
						rs.getString("baohanh"), rs.getBlob("img"));
				v.add(vga);
			}
			JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return v;
	}

	public ArrayList<vga> selectNhapHang() {
		ArrayList<vga> v = new ArrayList<>();

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "SELECT * FROM vga;";

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				vga vga = new vga(rs.getString("idsanpham"), rs.getString("idvga"), rs.getString("tenvga"),
						rs.getDouble("dongia"), rs.getString("baohanh"));
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
						rs.getString("hangvga"), rs.getString("bonho"), rs.getInt("tonkho"), rs.getDouble("dongia"),
						rs.getString("baohanh"), rs.getBlob("img"));
			}

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return v;
	}

}
