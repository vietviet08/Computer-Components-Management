package model;

import java.util.Objects;

public class mainboard extends Products {
	private String idMainboard;
	private String tenMain;
	private String tenHang;
	private int tonKho;
	private double donGia;

	public mainboard() {
		super();
	}

	public mainboard(String idMainboard, String tenMain, String tenHang, int tonKho, double donGia) {
		super();
		this.idMainboard = idMainboard;
		this.tenMain = tenMain;
		this.tenHang = tenHang;
		this.tonKho = tonKho;
		this.donGia = donGia;
	}

	public mainboard(String idSanPham, String idMainboard, String tenMain, String tenHang, int tonKho, double donGia) {
		super(idSanPham);
		this.idMainboard = idMainboard;
		this.tenMain = tenMain;
		this.tenHang = tenHang;
		this.tonKho = tonKho;
		this.donGia = donGia;
	}

	public mainboard(String idSanPham, String tenSanPham, int trangThai, String moTa, String idMainboard,
			String tenMain, String tenHang, int tonKho, double donGia) {
		super(idSanPham, tenSanPham, trangThai, moTa);
		this.idMainboard = idMainboard;
		this.tenMain = tenMain;
		this.tenHang = tenHang;
		this.tonKho = tonKho;
		this.donGia = donGia;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public String getTenMain() {
		return tenMain;
	}

	public void setTenMain(String tenMain) {
		this.tenMain = tenMain;
	}

	public String getTenHang() {
		return tenHang;
	}

	public void setTenHang(String tenHang) {
		this.tenHang = tenHang;
	}

	public String getIdMainboard() {
		return idMainboard;
	}

	public void setIdMainboard(String idMainboard) {
		this.idMainboard = idMainboard;
	}

	public int getTonKho() {
		return tonKho;
	}

	public void setTonKho(int tonKho) {
		this.tonKho = tonKho;
	}

	@Override
	public String toString() {
		return "mainboard [idMainboard=" + idMainboard + ", tenMain=" + tenMain + ", tenHang=" + tenHang + ", tonKho="
				+ tonKho + ", donGia=" + donGia + ", getIdSanPham()=" + getIdSanPham() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(donGia, idMainboard, tenHang, tenMain, tonKho);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		mainboard other = (mainboard) obj;
		return Double.doubleToLongBits(donGia) == Double.doubleToLongBits(other.donGia)
				&& Objects.equals(idMainboard, other.idMainboard) && Objects.equals(tenHang, other.tenHang)
				&& Objects.equals(tenMain, other.tenMain) && tonKho == other.tonKho;
	}

}
