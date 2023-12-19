package model;

import java.util.Objects;

public class cpu extends Products {
	private String nameCpu;
	private String xungNhip;
	private int soNhan;
	private int soLuong;
	private String dienNangTieuThu;
	private String boNhoDem;
	private double donGia;

	public cpu() {
		super();
	}

	public cpu(String nameCpu, String xungNhip, int soNhan, int soLuong, String dienNangTieuThu, String boNhoDem) {
		super();
		this.nameCpu = nameCpu;
		this.xungNhip = xungNhip;
		this.soNhan = soNhan;
		this.soLuong = soLuong;
		this.dienNangTieuThu = dienNangTieuThu;
		this.boNhoDem = boNhoDem;
	}

//	
	public cpu(String idSanPham, String nameCpu, String xungNhip, int soNhan, int soLuong, String dienNangTieuThu,
			String boNhoDem, double donGia) {
		super(idSanPham);
		this.nameCpu = nameCpu;
		this.xungNhip = xungNhip;
		this.soNhan = soNhan;
		this.soLuong = soLuong;
		this.dienNangTieuThu = dienNangTieuThu;
		this.boNhoDem = boNhoDem;
		this.donGia = donGia;
	}

	public cpu(String idSanPham, String tenSanPham, int soLuongTonKho, String nameCpu, String xungNhip, int soNhan,
			int soLuong, String dienNangTieuThu, String boNhoDem) {
		super(idSanPham, tenSanPham, soLuongTonKho);
		this.nameCpu = nameCpu;
		this.xungNhip = xungNhip;
		this.soNhan = soNhan;
		this.soLuong = soLuong;
		this.dienNangTieuThu = dienNangTieuThu;
		this.boNhoDem = boNhoDem;
	}

	public cpu(String idNPP, String tenNPP, String diaChi, String email, int sdt, String idSanPham, String tenSanPham,
			int soLuongTonKho, String nameCpu, String xungNhip, int soNhan, int soLuong, String dienNangTieuThu,
			String boNhoDem) {
		super(idNPP, tenNPP, diaChi, email, sdt, idSanPham, tenSanPham, soLuongTonKho);
		this.nameCpu = nameCpu;
		this.xungNhip = xungNhip;
		this.soNhan = soNhan;
		this.soLuong = soLuong;
		this.dienNangTieuThu = dienNangTieuThu;
		this.boNhoDem = boNhoDem;
	}

	 public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public String getNameCpu() {
		return nameCpu;
	}

	public void setNameCpu(String nameCpu) {
		this.nameCpu = nameCpu;
	}

	public String getXungNhip() {
		return xungNhip;
	}

	public void setXungNhip(String xungNhip) {
		this.xungNhip = xungNhip;
	}

	public int getSoNhan() {
		return soNhan;
	}

	public void setSoNhan(int soNhan) {
		this.soNhan = soNhan;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getDienNangTieuThu() {
		return dienNangTieuThu;
	}

	public void setDienNangTieuThu(String dienNangTieuThu) {
		this.dienNangTieuThu = dienNangTieuThu;
	}

	public String getBoNhoDem() {
		return boNhoDem;
	}

	public void setBoNhoDem(String boNhoDem) {
		this.boNhoDem = boNhoDem;
	}

	@Override
	public String toString() {
		return "cpu [nameCpu=" + nameCpu + ", xungNhip=" + xungNhip + ", soNhan=" + soNhan + ", soLuong=" + soLuong
				+ ", dienNangTieuThu=" + dienNangTieuThu + ", boNhoDem=" + boNhoDem + ", getIdSanPham()="
				+ getIdSanPham() + ", getTenSanPham()=" + getTenSanPham() + ", getSoLuongTonKho()=" + getSoLuongTonKho()
				+ ", toString()=" + super.toString() + ", hashCode()=" + hashCode() + ", getIdNPP()=" + getIdNPP()
				+ ", getTenNPP()=" + getTenNPP() + ", getDiaChi()=" + getDiaChi() + ", getEmail()=" + getEmail()
				+ ", getSdt()=" + getSdt() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(boNhoDem, dienNangTieuThu, nameCpu, soLuong, soNhan, xungNhip);
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
		cpu other = (cpu) obj;
		return Objects.equals(boNhoDem, other.boNhoDem) && Objects.equals(dienNangTieuThu, other.dienNangTieuThu)
				&& Objects.equals(nameCpu, other.nameCpu) && soLuong == other.soLuong && soNhan == other.soNhan
				&& Objects.equals(xungNhip, other.xungNhip);
	}

}
