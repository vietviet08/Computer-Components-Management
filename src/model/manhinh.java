package model;

import java.util.Objects;

public class manhinh {
	private String hangManhinh;
	private String tanSoQuet;
	private String tamNen;
	private String kichThuoc;
	private String kieuManHinh;
	private String doPhanGiai;

	public manhinh() {
		super();
	}

	public manhinh(String hangManhinh, String tanSoQuet, String tamNen, String kichThuoc, String kieuManHinh,
			String doPhanGiai) {
		super();
		this.hangManhinh = hangManhinh;
		this.tanSoQuet = tanSoQuet;
		this.tamNen = tamNen;
		this.kichThuoc = kichThuoc;
		this.kieuManHinh = kieuManHinh;
		this.doPhanGiai = doPhanGiai;
	}

	public String getHangManhinh() {
		return hangManhinh;
	}

	public void setHangManhinh(String hangManhinh) {
		this.hangManhinh = hangManhinh;
	}

	public String getTanSoQuet() {
		return tanSoQuet;
	}

	public void setTanSoQuet(String tanSoQuet) {
		this.tanSoQuet = tanSoQuet;
	}

	public String getTamNen() {
		return tamNen;
	}

	public void setTamNen(String tamNen) {
		this.tamNen = tamNen;
	}

	public String getKichThuoc() {
		return kichThuoc;
	}

	public void setKichThuoc(String kichThuoc) {
		this.kichThuoc = kichThuoc;
	}

	public String getKieuManHinh() {
		return kieuManHinh;
	}

	public void setKieuManHinh(String kieuManHinh) {
		this.kieuManHinh = kieuManHinh;
	}

	public String getDoPhanGiai() {
		return doPhanGiai;
	}

	public void setDoPhanGiai(String doPhanGiai) {
		this.doPhanGiai = doPhanGiai;
	}

	@Override
	public String toString() {
		return "manhinh [hangManhinh=" + hangManhinh + ", tanSoQuet=" + tanSoQuet + ", tamNen=" + tamNen
				+ ", kichThuoc=" + kichThuoc + ", kieuManHinh=" + kieuManHinh + ", doPhanGiai=" + doPhanGiai + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(doPhanGiai, hangManhinh, kichThuoc, kieuManHinh, tamNen, tanSoQuet);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		manhinh other = (manhinh) obj;
		return Objects.equals(doPhanGiai, other.doPhanGiai) && Objects.equals(hangManhinh, other.hangManhinh)
				&& Objects.equals(kichThuoc, other.kichThuoc) && Objects.equals(kieuManHinh, other.kieuManHinh)
				&& Objects.equals(tamNen, other.tamNen) && Objects.equals(tanSoQuet, other.tanSoQuet);
	}

}
