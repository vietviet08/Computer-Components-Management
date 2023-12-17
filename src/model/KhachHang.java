package model;

import java.util.Objects;

public class KhachHang {
	private String idKhachHang;
	private String tenKhachHang;
	private String diaChi;
	private String email;
	private int sdt;

	public KhachHang() {
		super();
	}

	public KhachHang(String idKhachHang, String tenKhachHang, String diaChi, String email, int sdt) {
		super();
		this.idKhachHang = idKhachHang;
		this.tenKhachHang = tenKhachHang;
		this.diaChi = diaChi;
		this.email = email;
		this.sdt = sdt;
	}

	public String getIdKhachHang() {
		return idKhachHang;
	}

	public void setIdKhachHang(String idKhachHang) {
		this.idKhachHang = idKhachHang;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSdt() {
		return sdt;
	}

	public void setSdt(int sdt) {
		this.sdt = sdt;
	}

	@Override
	public String toString() {
		return "KhachHang [idKhachHang=" + idKhachHang + ", tenKhachHang=" + tenKhachHang + ", diaChi=" + diaChi
				+ ", email=" + email + ", sdt=" + sdt + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(diaChi, email, idKhachHang, sdt, tenKhachHang);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		return Objects.equals(diaChi, other.diaChi) && Objects.equals(email, other.email)
				&& Objects.equals(idKhachHang, other.idKhachHang) && sdt == other.sdt
				&& Objects.equals(tenKhachHang, other.tenKhachHang);
	}

}
