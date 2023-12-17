package model;

import java.sql.Timestamp;
import java.util.Objects;

public class PhieuXuat extends Phieu {
	private String idKhachHang;

	public PhieuXuat() {
		super();
	}

	public PhieuXuat(String idKhachHang) {
		super();
		this.idKhachHang = idKhachHang;
	}

	public PhieuXuat(String idPhieu, Timestamp thoiGianTao, String nguoiTao, double tongTien, String idKhachHang) {
		super(idPhieu, thoiGianTao, nguoiTao, tongTien);
		this.idKhachHang = idKhachHang;
	}

	public PhieuXuat(String idPhieu, Timestamp thoiGianTao, String nguoiTao, double tongTien, ChiTietPhieu ctp,
			String idKhachHang) {
		super(idPhieu, thoiGianTao, nguoiTao, tongTien, ctp);
		this.idKhachHang = idKhachHang;
	}

	public String getIdKhachHang() {
		return idKhachHang;
	}

	public void setIdKhachHang(String idKhachHang) {
		this.idKhachHang = idKhachHang;
	}

	@Override
	public String toString() {
		return "PhieuXuat [idKhachHang=" + idKhachHang + ", getIdPhieu()=" + getIdPhieu() + ", getThoiGianTao()="
				+ getThoiGianTao() + ", getNguoiTao()=" + getNguoiTao() + ", getTongTien()=" + getTongTien()
				+ ", getCtp()=" + getCtp() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(idKhachHang);
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
		PhieuXuat other = (PhieuXuat) obj;
		return Objects.equals(idKhachHang, other.idKhachHang);
	}

}
