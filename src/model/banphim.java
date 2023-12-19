package model;

import java.util.Objects;

public class banphim extends Products {
	private String hangBanPhim;
	private String ketNoi;
	private String kieuSwitch;
	private String denLED;
	private String loaiBanPhim;
	private String keyCap;
	private String trongLuong;
	private double donGia;

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

	public banphim(String idSanPham, String hangBanPhim, String ketNoi, String kieuSwitch, String denLED,
			String loaiBanPhim, String keyCap, String trongLuong, double donGia) {
		super(idSanPham);
		this.hangBanPhim = hangBanPhim;
		this.ketNoi = ketNoi;
		this.kieuSwitch = kieuSwitch;
		this.denLED = denLED;
		this.loaiBanPhim = loaiBanPhim;
		this.keyCap = keyCap;
		this.trongLuong = trongLuong;
		this.donGia = donGia;
	}

	public banphim(String idSanPham, String tenSanPham, String idNPP, int soLuongTonKho, String hangBanPhim,
			String ketNoi, String kieuSwitch, String denLED, String loaiBanPhim, String keyCap, String trongLuong) {
		super(idSanPham, tenSanPham, idNPP, soLuongTonKho);
		this.hangBanPhim = hangBanPhim;
		this.ketNoi = ketNoi;
		this.kieuSwitch = kieuSwitch;
		this.denLED = denLED;
		this.loaiBanPhim = loaiBanPhim;
		this.keyCap = keyCap;
		this.trongLuong = trongLuong;
	}

	public banphim(String idNPP, String tenNPP, String diaChi, String email, int sdt, String idSanPham,
			String tenSanPham, int soLuongTonKho, String hangBanPhim, String ketNoi, String kieuSwitch, String denLED,
			String loaiBanPhim, String keyCap, String trongLuong) {
		super(idNPP, tenNPP, diaChi, email, sdt, idSanPham, tenSanPham, soLuongTonKho);
		this.hangBanPhim = hangBanPhim;
		this.ketNoi = ketNoi;
		this.kieuSwitch = kieuSwitch;
		this.denLED = denLED;
		this.loaiBanPhim = loaiBanPhim;
		this.keyCap = keyCap;
		this.trongLuong = trongLuong;
	}

	public banphim(String idSanPham, String tenSanPham, NhaPhanPhoi npp, int soLuongTonKho, String hangBanPhim,
			String ketNoi, String kieuSwitch, String denLED, String loaiBanPhim, String keyCap, String trongLuong) {
		super(idSanPham, tenSanPham, npp, soLuongTonKho);
		this.hangBanPhim = hangBanPhim;
		this.ketNoi = ketNoi;
		this.kieuSwitch = kieuSwitch;
		this.denLED = denLED;
		this.loaiBanPhim = loaiBanPhim;
		this.keyCap = keyCap;
		this.trongLuong = trongLuong;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
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
