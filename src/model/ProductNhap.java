package model;

import java.util.Objects;

public class ProductNhap {
	private String idsanpham;
	private String privateId;
	private String name;
	private int soLuong;
	private double gia;
	private String baohanh;

	public ProductNhap(String idsanpham, String privateId, String name, int soLuong, double gia, String baohanh) {
		super();
		this.idsanpham = idsanpham;
		this.privateId = privateId;
		this.name = name;
		this.soLuong = soLuong;
		this.gia = gia;
		this.baohanh = baohanh;
	}

	public ProductNhap() {
		super();
	}

	public String getIdsanpham() {
		return idsanpham;
	}

	public void setIdsanpham(String idsanpham) {
		this.idsanpham = idsanpham;
	}

	public String getPrivateId() {
		return privateId;
	}

	public void setPrivateId(String privateId) {
		this.privateId = privateId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getBaohanh() {
		return baohanh;
	}

	public void setBaohanh(String baohanh) {
		this.baohanh = baohanh;
	}

	@Override
	public String toString() {
		return "ProductNhap [idsanpham=" + idsanpham + ", privateId=" + privateId + ", name=" + name + ", soLuong="
				+ soLuong + ", gia=" + gia + ", baohanh=" + baohanh + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(baohanh, gia, idsanpham, name, privateId, soLuong);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductNhap other = (ProductNhap) obj;
		return Objects.equals(baohanh, other.baohanh)
				&& Double.doubleToLongBits(gia) == Double.doubleToLongBits(other.gia)
				&& Objects.equals(idsanpham, other.idsanpham) && Objects.equals(name, other.name)
				&& Objects.equals(privateId, other.privateId) && soLuong == other.soLuong;
	}

}
