package model;

import java.util.Objects;

public class ChiTietPhieu {
	private String idPhieu;
	private String idSanPham;
	private int soLuong;
	private double donGia;

	public ChiTietPhieu() {
		super();
	}

	public ChiTietPhieu(String idPhieu, String idSanPham, int soLuong, double donGia) {
		super();
		this.idPhieu = idPhieu;
		this.idSanPham = idSanPham;
		this.soLuong = soLuong;
		this.donGia = donGia;
	}

	public String getIdPhieu() {
		return idPhieu;
	}

	public void setIdPhieu(String idPhieu) {
		this.idPhieu = idPhieu;
	}

	public String getIdSanPham() {
		return idSanPham;
	}

	public void setIdSanPham(String idSanPham) {
		this.idSanPham = idSanPham;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	@Override
	public String toString() {
		return "ChiTietPhieu [idPhieu=" + idPhieu + ", idSanPham=" + idSanPham + ", soLuong=" + soLuong + ", donGia="
				+ donGia + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(donGia, idPhieu, idSanPham, soLuong);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietPhieu other = (ChiTietPhieu) obj;
		return Double.doubleToLongBits(donGia) == Double.doubleToLongBits(other.donGia)
				&& Objects.equals(idPhieu, other.idPhieu) && Objects.equals(idSanPham, other.idSanPham)
				&& soLuong == other.soLuong;
	}

}
