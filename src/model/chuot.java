package model;

public class chuot {
	private String hangChuot;
	private int soNut;
	private String kieuKetNoi;
	private String denLED;
	private String mauSac;
	private String doPhanGiai;
	private String kichCo;
	private String trongLuong;

	public chuot() {
		super();
	}

	public chuot(String hangChuot, int soNut, String kieuKetNoi, String denLED, String mauSac, String doPhanGiai,
			String kichCo, String trongLuong) {
		super();
		this.hangChuot = hangChuot;
		this.soNut = soNut;
		this.kieuKetNoi = kieuKetNoi;
		this.denLED = denLED;
		this.mauSac = mauSac;
		this.doPhanGiai = doPhanGiai;
		this.kichCo = kichCo;
		this.trongLuong = trongLuong;
	}

	public String getHangChuot() {
		return hangChuot;
	}

	public void setHangChuot(String hangChuot) {
		this.hangChuot = hangChuot;
	}

	public int getSoNut() {
		return soNut;
	}

	public void setSoNut(int soNut) {
		this.soNut = soNut;
	}

	public String getKieuKetNoi() {
		return kieuKetNoi;
	}

	public void setKieuKetNoi(String kieuKetNoi) {
		this.kieuKetNoi = kieuKetNoi;
	}

	public String getDenLED() {
		return denLED;
	}

	public void setDenLED(String denLED) {
		this.denLED = denLED;
	}

	public String getMauSac() {
		return mauSac;
	}

	public void setMauSac(String mauSac) {
		this.mauSac = mauSac;
	}

	public String getDoPhanGiai() {
		return doPhanGiai;
	}

	public void setDoPhanGiai(String doPhanGiai) {
		this.doPhanGiai = doPhanGiai;
	}

	public String getKichCo() {
		return kichCo;
	}

	public void setKichCo(String kichCo) {
		this.kichCo = kichCo;
	}

	public String getTrongLuong() {
		return trongLuong;
	}

	public void setTrongLuong(String trongLuong) {
		this.trongLuong = trongLuong;
	}

}
