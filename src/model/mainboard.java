package model;

import java.util.Objects;

public class mainboard extends Products {
	private String tenMain;
	private String tenHang;
	private double donGia;

	public mainboard() {
		super();
	}

	public mainboard(String tenMain, String tenHang) {
		super();
		this.tenMain = tenMain;
		this.tenHang = tenHang;
	}

	public mainboard(String idSanPham, String tenMain, String tenHang, double donGia) {
		super(idSanPham);
		this.tenMain = tenMain;
		this.tenHang = tenHang;
		this.donGia = donGia;
	}

	public mainboard(String idSanPham, String tenSanPham, String idNPP, int soLuongTonKho, String tenMain,
			String tenHang, double donGia) {
		super(idSanPham, tenSanPham, idNPP, soLuongTonKho);
		this.tenMain = tenMain;
		this.tenHang = tenHang;
		this.donGia = donGia;
	}

	public mainboard(String idSanPham, String tenSanPham, int soLuongTonKho, String tenMain, String tenHang,
			double donGia) {
		super(idSanPham, tenSanPham, soLuongTonKho);
		this.tenMain = tenMain;
		this.tenHang = tenHang;
		this.donGia = donGia;
	}

	public mainboard(String idNPP, String tenNPP, String diaChi, String email, int sdt, String idSanPham,
			String tenSanPham, int soLuongTonKho, String tenMain, String tenHang, double donGia) {
		super(idNPP, tenNPP, diaChi, email, sdt, idSanPham, tenSanPham, soLuongTonKho);
		this.tenMain = tenMain;
		this.tenHang = tenHang;
		this.donGia = donGia;
	}

	public mainboard(String idSanPham, String tenSanPham, NhaPhanPhoi npp, int soLuongTonKho, String tenMain,
			String tenHang, double donGia) {
		super(idSanPham, tenSanPham, npp, soLuongTonKho);
		this.tenMain = tenMain;
		this.tenHang = tenHang;
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

	@Override
	public String toString() {
		return "main [tenMain=" + tenMain + ", tenHang=" + tenHang + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(tenHang, tenMain);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		mainboard other = (mainboard) obj;
		return Objects.equals(tenHang, other.tenHang) && Objects.equals(tenMain, other.tenMain);
	}

}
