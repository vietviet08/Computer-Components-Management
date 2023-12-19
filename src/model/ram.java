package model;

import java.util.Objects;

public class ram extends Products {
	private String tenRam;
	private String loai;
	private String dungLuong;
	private String bus;
	private double donGia;

	public ram() {
		super();
	}

	public ram(String tenRam, String loai, String dungLuong, String bus) {
		super();
		this.tenRam = tenRam;
		this.loai = loai;
		this.dungLuong = dungLuong;
		this.bus = bus;
	}

	public ram(String idSanPham, String tenRam, String loai, String dungLuong, String bus, double donGia) {
		super(idSanPham);
		this.tenRam = tenRam;
		this.loai = loai;
		this.dungLuong = dungLuong;
		this.bus = bus;
		this.donGia = donGia;
	}

	public ram(String idSanPham, String tenSanPham, String idNPP, int soLuongTonKho, String tenRam, String loai,
			String dungLuong, String bus) {
		super(idSanPham, tenSanPham, idNPP, soLuongTonKho);
		this.tenRam = tenRam;
		this.loai = loai;
		this.dungLuong = dungLuong;
		this.bus = bus;
	}

	public ram(String idSanPham, String tenSanPham, int soLuongTonKho, String tenRam, String loai, String dungLuong,
			String bus) {
		super(idSanPham, tenSanPham, soLuongTonKho);
		this.tenRam = tenRam;
		this.loai = loai;
		this.dungLuong = dungLuong;
		this.bus = bus;
	}

	public ram(String idNPP, String tenNPP, String diaChi, String email, int sdt, String idSanPham, String tenSanPham,
			int soLuongTonKho, String tenRam, String loai, String dungLuong, String bus) {
		super(idNPP, tenNPP, diaChi, email, sdt, idSanPham, tenSanPham, soLuongTonKho);
		this.tenRam = tenRam;
		this.loai = loai;
		this.dungLuong = dungLuong;
		this.bus = bus;
	}

	public ram(String idSanPham, String tenSanPham, NhaPhanPhoi npp, int soLuongTonKho, String tenRam, String loai,
			String dungLuong, String bus) {
		super(idSanPham, tenSanPham, npp, soLuongTonKho);
		this.tenRam = tenRam;
		this.loai = loai;
		this.dungLuong = dungLuong;
		this.bus = bus;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public String getTenRam() {
		return tenRam;
	}

	public void setTenRam(String tenRam) {
		this.tenRam = tenRam;
	}

	public String getLoai() {
		return loai;
	}

	public void setLoai(String loai) {
		this.loai = loai;
	}

	public String getDungLuong() {
		return dungLuong;
	}

	public void setDungLuong(String dungLuong) {
		this.dungLuong = dungLuong;
	}

	public String getBus() {
		return bus;
	}

	public void setBus(String bus) {
		this.bus = bus;
	}

	@Override
	public String toString() {
		return "ram [tenRam=" + tenRam + ", loai=" + loai + ", dungLuong=" + dungLuong + ", bus=" + bus + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(bus, dungLuong, loai, tenRam);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ram other = (ram) obj;
		return Objects.equals(bus, other.bus) && Objects.equals(dungLuong, other.dungLuong)
				&& Objects.equals(loai, other.loai) && Objects.equals(tenRam, other.tenRam);
	}

}
