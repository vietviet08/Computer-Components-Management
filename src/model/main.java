package model;

import java.util.Objects;

public class main {
	private String tenMain;
	private String tenHang;

	public main() {
		super();
	}

	public main(String tenMain, String tenHang) {
		super();
		this.tenMain = tenMain;
		this.tenHang = tenHang;
	}

	public String getTenMain() {
		return tenMain;
	}

	public void setTenMain(String tenMain) {
		this.tenMain = tenMain;
	}

	public String getTenHang() {
		return tenHang;
	}

	public void setTenHang(String tenHang) {
		this.tenHang = tenHang;
	}

	@Override
	public String toString() {
		return "main [tenMain=" + tenMain + ", tenHang=" + tenHang + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(tenHang, tenMain);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		main other = (main) obj;
		return Objects.equals(tenHang, other.tenHang) && Objects.equals(tenMain, other.tenMain);
	}

}
