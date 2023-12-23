package model;

import java.util.Objects;

public class nguon extends Products {
	private String idNguon;
	private String thuongHieu;
	private String congSuat;
	private int tonKho;
	private double donGia;

	public nguon() {
		super();
	}

	public nguon(String idNguon, String thuongHieu, String congSuat, int tonKho, double donGia) {
		super();
		this.idNguon = idNguon;
		this.thuongHieu = thuongHieu;
		this.congSuat = congSuat;
		this.tonKho = tonKho;
		this.donGia = donGia;
	}

	public nguon(String idSanPham, String idNguon, String thuongHieu, String congSuat, int tonKho, double donGia) {
		super(idSanPham);
		this.idNguon = idNguon;
		this.thuongHieu = thuongHieu;
		this.congSuat = congSuat;
		this.tonKho = tonKho;
		this.donGia = donGia;
	}

	public nguon(String idSanPham, String tenSanPham, int trangThai, String moTa, String idNguon, String thuongHieu,
			String congSuat, int tonKho, double donGia) {
		super(idSanPham, tenSanPham, trangThai, moTa);
		this.idNguon = idNguon;
		this.thuongHieu = thuongHieu;
		this.congSuat = congSuat;
		this.tonKho = tonKho;
		this.donGia = donGia;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public String getThuongHieu() {
		return thuongHieu;
	}

	public void setThuongHieu(String thuongHieu) {
		this.thuongHieu = thuongHieu;
	}

	public String getCongSuat() {
		return congSuat;
	}

	public void setCongSuat(String congSuat) {
		this.congSuat = congSuat;
	}

	public String getIdNguon() {
		return idNguon;
	}

	public void setIdNguon(String idNguon) {
		this.idNguon = idNguon;
	}

	public int getTonKho() {
		return tonKho;
	}

	public void setTonKho(int tonKho) {
		this.tonKho = tonKho;
	}

	@Override
	public String toString() {
		return "nguon [idNguon=" + idNguon + ", thuongHieu=" + thuongHieu + ", congSuat=" + congSuat + ", tonKho="
				+ tonKho + ", donGia=" + donGia + ", getIdSanPham()=" + getIdSanPham() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(congSuat, donGia, idNguon, thuongHieu, tonKho);
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
		nguon other = (nguon) obj;
		return Objects.equals(congSuat, other.congSuat)
				&& Double.doubleToLongBits(donGia) == Double.doubleToLongBits(other.donGia)
				&& Objects.equals(idNguon, other.idNguon) && Objects.equals(thuongHieu, other.thuongHieu)
				&& tonKho == other.tonKho;
	}

}
