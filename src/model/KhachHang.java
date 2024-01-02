package model;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Objects;

public class KhachHang {
	private String idKhachHang;
	private String tenKhachHang;
	private String diaChi;
	private String email;
	private String sdt;
	private Timestamp ngayThamGia;
	private Blob img;

	public KhachHang() {
		super();
	}

	public KhachHang(String idKhachHang, String tenKhachHang, String diaChi, String email, String sdt,
			Timestamp ngayThamGia, Blob img) {
		super();
		this.idKhachHang = idKhachHang;
		this.tenKhachHang = tenKhachHang;
		this.diaChi = diaChi;
		this.email = email;
		this.sdt = sdt;
		this.ngayThamGia = ngayThamGia;
		this.img = img;
	}
//update
	public KhachHang(String idKhachHang, String tenKhachHang, String diaChi, String email, String sdt, Blob img) {
		super();
		this.idKhachHang = idKhachHang;
		this.tenKhachHang = tenKhachHang;
		this.diaChi = diaChi;
		this.email = email;
		this.sdt = sdt;
		this.img = img;
	}
	
	

	public KhachHang(String idKhachHang, String tenKhachHang, String diaChi, String email, String sdt) {
		super();
		this.idKhachHang = idKhachHang;
		this.tenKhachHang = tenKhachHang;
		this.diaChi = diaChi;
		this.email = email;
		this.sdt = sdt;
	}
	
	

	public KhachHang(String idKhachHang, String tenKhachHang, String diaChi, String email, String sdt,
			Timestamp ngayThamGia) {
		super();
		this.idKhachHang = idKhachHang;
		this.tenKhachHang = tenKhachHang;
		this.diaChi = diaChi;
		this.email = email;
		this.sdt = sdt;
		this.ngayThamGia = ngayThamGia;
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

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public Timestamp getNgayThamGia() {
		return ngayThamGia;
	}

	public void setNgayThamGia(Timestamp ngayThamGia) {
		this.ngayThamGia = ngayThamGia;
	}

	public Blob getImg() {
		return img;
	}

	public void setImg(Blob img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "KhachHang [idKhachHang=" + idKhachHang + ", tenKhachHang=" + tenKhachHang + ", diaChi=" + diaChi
				+ ", email=" + email + ", sdt=" + sdt + ", ngayThamGia=" + ngayThamGia + ", img=" + img + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(diaChi, email, idKhachHang, img, ngayThamGia, sdt, tenKhachHang);
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
				&& Objects.equals(idKhachHang, other.idKhachHang) && Objects.equals(img, other.img)
				&& Objects.equals(ngayThamGia, other.ngayThamGia) && sdt == other.sdt
				&& Objects.equals(tenKhachHang, other.tenKhachHang);
	}

}
