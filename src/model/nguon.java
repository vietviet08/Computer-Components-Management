package model;

import java.util.Objects;

public class nguon extends Products {
	private String thuongHieu;
	private String congSuat;
	private double donGia;

	public nguon() {
		super();
	}

	public nguon(String thuongHieu, String congSuat) {
		super();
		this.thuongHieu = thuongHieu;
		this.congSuat = congSuat;
	}

	public nguon(String idSanPham, String thuongHieu, String congSuat, double donGia) {
		super(idSanPham);
		this.thuongHieu = thuongHieu;
		this.congSuat = congSuat;
		this.donGia = donGia;

	}

	public nguon(String idSanPham, String tenSanPham, String idNPP, int soLuongTonKho, String thuongHieu,
			String congSuat) {
		super(idSanPham, tenSanPham, idNPP, soLuongTonKho);
		this.thuongHieu = thuongHieu;
		this.congSuat = congSuat;
	}

	public nguon(String idSanPham, String tenSanPham, int soLuongTonKho, String thuongHieu, String congSuat) {
		super(idSanPham, tenSanPham, soLuongTonKho);
		this.thuongHieu = thuongHieu;
		this.congSuat = congSuat;
	}

	public nguon(String idNPP, String tenNPP, String diaChi, String email, int sdt, String idSanPham, String tenSanPham,
			int soLuongTonKho, String thuongHieu, String congSuat) {
		super(idNPP, tenNPP, diaChi, email, sdt, idSanPham, tenSanPham, soLuongTonKho);
		this.thuongHieu = thuongHieu;
		this.congSuat = congSuat;
	}

	public nguon(String idSanPham, String tenSanPham, NhaPhanPhoi npp, int soLuongTonKho, String thuongHieu,
			String congSuat) {
		super(idSanPham, tenSanPham, npp, soLuongTonKho);
		this.thuongHieu = thuongHieu;
		this.congSuat = congSuat;
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

	@Override
	public String toString() {
		return "nguon [thuongHieu=" + thuongHieu + ", congSuat=" + congSuat + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(congSuat, thuongHieu);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		nguon other = (nguon) obj;
		return Objects.equals(congSuat, other.congSuat) && Objects.equals(thuongHieu, other.thuongHieu);
	}

}
