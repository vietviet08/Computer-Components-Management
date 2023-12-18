package model;

import java.util.Objects;

public class Products extends NhaPhanPhoi {
	private String idSanPham;
	private String tenSanPham;
//	private String idLoaiSP;
	private NhaPhanPhoi npp;
	private int soLuongTonKho;

	public Products() {
		super();
	}
//
	public Products(String idSanPham) {
		super();
		this.idSanPham = idSanPham;
	}
//
	public Products(String idSanPham, String tenSanPham, String idNPP, int soLuongTonKho) {
		super(idNPP);
		this.idSanPham = idSanPham;
		this.tenSanPham = tenSanPham;
		this.soLuongTonKho = soLuongTonKho;
	}

	public Products(String idSanPham, String tenSanPham, int soLuongTonKho) {
		super();
		this.idSanPham = idSanPham;
		this.tenSanPham = tenSanPham;
		this.soLuongTonKho = soLuongTonKho;
	}

	public Products(String idNPP, String tenNPP, String diaChi, String email, int sdt, String idSanPham,
			String tenSanPham, int soLuongTonKho) {
		super(idNPP, tenNPP, diaChi, email, sdt);
		this.idSanPham = idSanPham;
		this.tenSanPham = tenSanPham;
		this.soLuongTonKho = soLuongTonKho;
	}

	public Products(String idSanPham, String tenSanPham, NhaPhanPhoi npp, int soLuongTonKho) {
		super();
		this.idSanPham = idSanPham;
		this.tenSanPham = tenSanPham;
		this.npp = npp;
		this.soLuongTonKho = soLuongTonKho;
	}

	public NhaPhanPhoi getNpp() {
		return npp;
	}

	public void setNpp(NhaPhanPhoi npp) {
		this.npp = npp;
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

	public int getSoLuongTonKho() {
		return soLuongTonKho;
	}

	public void setSoLuongTonKho(int soLuongTonKho) {
		this.soLuongTonKho = soLuongTonKho;
	}

	@Override
	public String toString() {
		return "Products [idSanPham=" + idSanPham + ", tenSanPham=" + tenSanPham + ", soLuongTonKho=" + soLuongTonKho
				+ ", getIdNPP()=" + getIdNPP() + ", getTenNPP()=" + getTenNPP() + ", getDiaChi()=" + getDiaChi()
				+ ", getEmail()=" + getEmail() + ", getSdt()=" + getSdt() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(idSanPham, soLuongTonKho, tenSanPham);
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
		Products other = (Products) obj;
		return Objects.equals(idSanPham, other.idSanPham) && soLuongTonKho == other.soLuongTonKho
				&& Objects.equals(tenSanPham, other.tenSanPham);
	}

}
