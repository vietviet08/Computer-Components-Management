package model;

import java.util.Objects;

public class vga extends Products {
	private String idVga;
	private String tenVGA;
	private String hangVGA;
	private String boNho;
	private int tonKho;
	private double donGia;

	public vga() {
		super();
	}

	public vga(String idVga, String tenVGA, String hangVGA, String boNho, int tonKho, double donGia) {
		super();
		this.idVga = idVga;
		this.tenVGA = tenVGA;
		this.hangVGA = hangVGA;
		this.boNho = boNho;
		this.tonKho = tonKho;
		this.donGia = donGia;
	}

	public vga(String idSanPham, String idVga, String tenVGA, String hangVGA, String boNho, int tonKho, double donGia) {
		super(idSanPham);
		this.idVga = idVga;
		this.tenVGA = tenVGA;
		this.hangVGA = hangVGA;
		this.boNho = boNho;
		this.tonKho = tonKho;
		this.donGia = donGia;
	}

	public vga(String idSanPham, String tenSanPham, int trangThai, String moTa, String idVga, String tenVGA,
			String hangVGA, String boNho, int tonKho, double donGia) {
		super(idSanPham, tenSanPham, trangThai, moTa);
		this.idVga = idVga;
		this.tenVGA = tenVGA;
		this.hangVGA = hangVGA;
		this.boNho = boNho;
		this.tonKho = tonKho;
		this.donGia = donGia;
	}

	public String getIdVga() {
		return idVga;
	}

	public void setIdVga(String idVga) {
		this.idVga = idVga;
	}

	public int getTonKho() {
		return tonKho;
	}

	public void setTonKho(int tonKho) {
		this.tonKho = tonKho;
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
		return "vga [idVga=" + idVga + ", tenVGA=" + tenVGA + ", hangVGA=" + hangVGA + ", boNho=" + boNho + ", tonKho="
				+ tonKho + ", donGia=" + donGia + ", getIdSanPham()=" + getIdSanPham() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(boNho, donGia, hangVGA, idVga, tenVGA, tonKho);
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
		vga other = (vga) obj;
		return Objects.equals(boNho, other.boNho)
				&& Double.doubleToLongBits(donGia) == Double.doubleToLongBits(other.donGia)
				&& Objects.equals(hangVGA, other.hangVGA) && Objects.equals(idVga, other.idVga)
				&& Objects.equals(tenVGA, other.tenVGA) && tonKho == other.tonKho;
	}

}
