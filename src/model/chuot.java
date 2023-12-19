package model;

public class chuot extends Products {
	private String hangChuot;
	private int soNut;
	private String kieuKetNoi;
	private String denLED;
	private String mauSac;
	private String doPhanGiai;
	private String kichCo;
	private String trongLuong;
	private double donGia;

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

	public chuot(String idSanPham, String hangChuot, int soNut, String kieuKetNoi, String denLED, String mauSac,
			String doPhanGiai, String kichCo, String trongLuong, double donGia) {
		super(idSanPham);
		this.hangChuot = hangChuot;
		this.soNut = soNut;
		this.kieuKetNoi = kieuKetNoi;
		this.denLED = denLED;
		this.mauSac = mauSac;
		this.doPhanGiai = doPhanGiai;
		this.kichCo = kichCo;
		this.trongLuong = trongLuong;
		this.donGia = donGia;
	}

	public chuot(String idSanPham, String tenSanPham, String idNPP, int soLuongTonKho, String hangChuot, int soNut,
			String kieuKetNoi, String denLED, String mauSac, String doPhanGiai, String kichCo, String trongLuong) {
		super(idSanPham, tenSanPham, idNPP, soLuongTonKho);
		this.hangChuot = hangChuot;
		this.soNut = soNut;
		this.kieuKetNoi = kieuKetNoi;
		this.denLED = denLED;
		this.mauSac = mauSac;
		this.doPhanGiai = doPhanGiai;
		this.kichCo = kichCo;
		this.trongLuong = trongLuong;
	}

	public chuot(String idSanPham, String tenSanPham, int soLuongTonKho, String hangChuot, int soNut, String kieuKetNoi,
			String denLED, String mauSac, String doPhanGiai, String kichCo, String trongLuong) {
		super(idSanPham, tenSanPham, soLuongTonKho);
		this.hangChuot = hangChuot;
		this.soNut = soNut;
		this.kieuKetNoi = kieuKetNoi;
		this.denLED = denLED;
		this.mauSac = mauSac;
		this.doPhanGiai = doPhanGiai;
		this.kichCo = kichCo;
		this.trongLuong = trongLuong;
	}

	public chuot(String idNPP, String tenNPP, String diaChi, String email, int sdt, String idSanPham, String tenSanPham,
			int soLuongTonKho, String hangChuot, int soNut, String kieuKetNoi, String denLED, String mauSac,
			String doPhanGiai, String kichCo, String trongLuong) {
		super(idNPP, tenNPP, diaChi, email, sdt, idSanPham, tenSanPham, soLuongTonKho);
		this.hangChuot = hangChuot;
		this.soNut = soNut;
		this.kieuKetNoi = kieuKetNoi;
		this.denLED = denLED;
		this.mauSac = mauSac;
		this.doPhanGiai = doPhanGiai;
		this.kichCo = kichCo;
		this.trongLuong = trongLuong;
	}

	public chuot(String idSanPham, String tenSanPham, NhaPhanPhoi npp, int soLuongTonKho, String hangChuot, int soNut,
			String kieuKetNoi, String denLED, String mauSac, String doPhanGiai, String kichCo, String trongLuong) {
		super(idSanPham, tenSanPham, npp, soLuongTonKho);
		this.hangChuot = hangChuot;
		this.soNut = soNut;
		this.kieuKetNoi = kieuKetNoi;
		this.denLED = denLED;
		this.mauSac = mauSac;
		this.doPhanGiai = doPhanGiai;
		this.kichCo = kichCo;
		this.trongLuong = trongLuong;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
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
