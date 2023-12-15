package model;

import java.util.Objects;

public class cpu {
	private String nameCpu;
	private String xungNhip;
	private int soNhan;
	private int soLuong;
	private String dienNangTieuThu;
	private String boNhoDem;

	public cpu(String nameCpu, String xungNhip, int soNhan, int soLuong, String dienNangTieuThu, String boNhoDem) {
		super();
		this.nameCpu = nameCpu;
		this.xungNhip = xungNhip;
		this.soNhan = soNhan;
		this.soLuong = soLuong;
		this.dienNangTieuThu = dienNangTieuThu;
		this.boNhoDem = boNhoDem;
	}

	public cpu() {
		super();
	}

	public String getNameCpu() {
		return nameCpu;
	}

	public void setNameCpu(String nameCpu) {
		this.nameCpu = nameCpu;
	}

	public String getXungNhip() {
		return xungNhip;
	}

	public void setXungNhip(String xungNhip) {
		this.xungNhip = xungNhip;
	}

	public int getSoNhan() {
		return soNhan;
	}

	public void setSoNhan(int soNhan) {
		this.soNhan = soNhan;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getDienNangTieuThu() {
		return dienNangTieuThu;
	}

	public void setDienNangTieuThu(String dienNangTieuThu) {
		this.dienNangTieuThu = dienNangTieuThu;
	}

	public String getBoNhoDem() {
		return boNhoDem;
	}

	public void setBoNhoDem(String boNhoDem) {
		this.boNhoDem = boNhoDem;
	}

	@Override
	public String toString() {
		return "cpu [nameCpu=" + nameCpu + ", xungNhip=" + xungNhip + ", soNhan=" + soNhan + ", soLuong=" + soLuong
				+ ", dienNangTieuThu=" + dienNangTieuThu + ", boNhoDem=" + boNhoDem + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(boNhoDem, dienNangTieuThu, nameCpu, soLuong, soNhan, xungNhip);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		cpu other = (cpu) obj;
		return Objects.equals(boNhoDem, other.boNhoDem) && Objects.equals(dienNangTieuThu, other.dienNangTieuThu)
				&& Objects.equals(nameCpu, other.nameCpu) && soLuong == other.soLuong && soNhan == other.soNhan
				&& Objects.equals(xungNhip, other.xungNhip);
	}

}
