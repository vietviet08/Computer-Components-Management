package model;

import java.util.Objects;

public class Products {
	private String idSanPham;
	private String tenSanPham;
	private String idLoaiSP;
	private String idNhaPhanPhoi;
	private int soLuongTonKho;

	public Products() {
		super();
	}

	public Products(String idSanPham, String tenSanPham, String idLoaiSP, String idNhaPhanPhoi, int soLuongTonKho) {
		super();
		this.idSanPham = idSanPham;
		this.tenSanPham = tenSanPham;
		this.idLoaiSP = idLoaiSP;
		this.idNhaPhanPhoi = idNhaPhanPhoi;
		this.soLuongTonKho = soLuongTonKho;
	}

	public String getIdSanPham() {
		return idSanPham;
	}

	public void setIdSanPham(String idSanPham) {
		this.idSanPham = idSanPham;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public String getIdLoaiSP() {
		return idLoaiSP;
	}

	public void setIdLoaiSP(String idLoaiSP) {
		this.idLoaiSP = idLoaiSP;
	}

	public String getIdNhaPhanPhoi() {
		return idNhaPhanPhoi;
	}

	public void setIdNhaPhanPhoi(String idNhaPhanPhoi) {
		this.idNhaPhanPhoi = idNhaPhanPhoi;
	}

	public int getSoLuongTonKho() {
		return soLuongTonKho;
	}

	public void setSoLuongTonKho(int soLuongTonKho) {
		this.soLuongTonKho = soLuongTonKho;
	}

	@Override
	public String toString() {
		return "Products [idSanPham=" + idSanPham + ", tenSanPham=" + tenSanPham + ", idLoaiSP=" + idLoaiSP
				+ ", idNhaPhanPhoi=" + idNhaPhanPhoi + ", soLuongTonKho=" + soLuongTonKho + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idLoaiSP, idNhaPhanPhoi, idSanPham, soLuongTonKho, tenSanPham);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Products other = (Products) obj;
		return Objects.equals(idLoaiSP, other.idLoaiSP) && Objects.equals(idNhaPhanPhoi, other.idNhaPhanPhoi)
				&& Objects.equals(idSanPham, other.idSanPham) && soLuongTonKho == other.soLuongTonKho
				&& Objects.equals(tenSanPham, other.tenSanPham);
	}

}
