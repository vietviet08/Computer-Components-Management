package model;

import java.util.Objects;

public class vga extends Products {
	private String tenVGA;
	private String hangVGA;
	private String boNho;
	private double donGia;

	public vga() {
		super();
	}

	public vga(String tenVGA, String hangVGA, String boNho) {
		super();
		this.tenVGA = tenVGA;
		this.hangVGA = hangVGA;
		this.boNho = boNho;
	}

	public vga(String idSanPham, String tenVGA, String hangVGA, String boNho, double donGia) {
		super(idSanPham);
		this.tenVGA = tenVGA;
		this.hangVGA = hangVGA;
		this.boNho = boNho;
		this.donGia = donGia;
	}

	public vga(String idSanPham, String tenSanPham, String idNPP, int soLuongTonKho, String tenVGA, String hangVGA,
			String boNho) {
		super(idSanPham, tenSanPham, idNPP, soLuongTonKho);
		this.tenVGA = tenVGA;
		this.hangVGA = hangVGA;
		this.boNho = boNho;
	}

	public vga(String idSanPham, String tenSanPham, int soLuongTonKho, String tenVGA, String hangVGA, String boNho) {
		super(idSanPham, tenSanPham, soLuongTonKho);
		this.tenVGA = tenVGA;
		this.hangVGA = hangVGA;
		this.boNho = boNho;
	}

	public vga(String idNPP, String tenNPP, String diaChi, String email, int sdt, String idSanPham, String tenSanPham,
			int soLuongTonKho, String tenVGA, String hangVGA, String boNho) {
		super(idNPP, tenNPP, diaChi, email, sdt, idSanPham, tenSanPham, soLuongTonKho);
		this.tenVGA = tenVGA;
		this.hangVGA = hangVGA;
		this.boNho = boNho;
	}

	public vga(String idSanPham, String tenSanPham, NhaPhanPhoi npp, int soLuongTonKho, String tenVGA, String hangVGA,
			String boNho) {
		super(idSanPham, tenSanPham, npp, soLuongTonKho);
		this.tenVGA = tenVGA;
		this.hangVGA = hangVGA;
		this.boNho = boNho;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public String getTenVGA() {
		return tenVGA;
	}

	public void setTenVGA(String tenVGA) {
		this.tenVGA = tenVGA;
	}

	public String getHangVGA() {
		return hangVGA;
	}

	public void setHangVGA(String hangVGA) {
		this.hangVGA = hangVGA;
	}

	public String getBoNho() {
		return boNho;
	}

	public void setBoNho(String boNho) {
		this.boNho = boNho;
	}

	@Override
	public String toString() {
		return "vga [tenVGA=" + tenVGA + ", hangVGA=" + hangVGA + ", boNho=" + boNho + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(boNho, hangVGA, tenVGA);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		vga other = (vga) obj;
		return Objects.equals(boNho, other.boNho) && Objects.equals(hangVGA, other.hangVGA)
				&& Objects.equals(tenVGA, other.tenVGA);
	}

}
