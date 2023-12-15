package model;

import java.util.Objects;

public class banphim {
	private String hangBanPhim;
	private String ketNoi;
	private String kieuSwitch;
	private String denLED;
	private String loaiBanPhim;
	private String keyCap;
	private String trongLuong;
	public banphim() {
		super();
	}
	public banphim(String hangBanPhim, String ketNoi, String kieuSwitch, String denLED, String loaiBanPhim,
			String keyCap, String trongLuong) {
		super();
		this.hangBanPhim = hangBanPhim;
		this.ketNoi = ketNoi;
		this.kieuSwitch = kieuSwitch;
		this.denLED = denLED;
		this.loaiBanPhim = loaiBanPhim;
		this.keyCap = keyCap;
		this.trongLuong = trongLuong;	
	}
	public String getHangBanPhim() {
		return hangBanPhim;
	}
	public void setHangBanPhim(String hangBanPhim) {
		this.hangBanPhim = hangBanPhim;
	}
	public String getKetNoi() {
		return ketNoi;
	}
	public void setKetNoi(String ketNoi) {
		this.ketNoi = ketNoi;
	}
	public String getKieuSwitch() {
		return kieuSwitch;
	}
	public void setKieuSwitch(String kieuSwitch) {
		this.kieuSwitch = kieuSwitch;
	}
	public String getDenLED() {
		return denLED;
	}
	public void setDenLED(String denLED) {
		this.denLED = denLED;
	}
	public String getLoaiBanPhim() {
		return loaiBanPhim;
	}
	public void setLoaiBanPhim(String loaiBanPhim) {
		this.loaiBanPhim = loaiBanPhim;
	}
	public String getKeyCap() {
		return keyCap;
	}
	public void setKeyCap(String keyCap) {
		this.keyCap = keyCap;
	}
	public String getTrongLuong() {
		return trongLuong;
	}
	public void setTrongLuong(String trongLuong) {
		this.trongLuong = trongLuong;
	}
	@Override
	public String toString() {
		return "banphim [hangBanPhim=" + hangBanPhim + ", ketNoi=" + ketNoi + ", kieuSwitch=" + kieuSwitch + ", denLED="
				+ denLED + ", loaiBanPhim=" + loaiBanPhim + ", keyCap=" + keyCap + ", trongLuong=" + trongLuong + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(denLED, hangBanPhim, ketNoi, keyCap, kieuSwitch, loaiBanPhim, trongLuong);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		banphim other = (banphim) obj;
		return Objects.equals(denLED, other.denLED) && Objects.equals(hangBanPhim, other.hangBanPhim)
				&& Objects.equals(ketNoi, other.ketNoi) && Objects.equals(keyCap, other.keyCap)
				&& Objects.equals(kieuSwitch, other.kieuSwitch) && Objects.equals(loaiBanPhim, other.loaiBanPhim)
				&& Objects.equals(trongLuong, other.trongLuong);
	}
	
}
