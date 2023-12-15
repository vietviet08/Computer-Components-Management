package model;

import java.util.Objects;

public class nguon {
	private String thuongHieu;
	private String congSuat;

	public nguon() {
		super();
	}

	public nguon(String thuongHieu, String congSuat) {
		super();
		this.thuongHieu = thuongHieu;
		this.congSuat = congSuat;
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
