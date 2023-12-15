package model;

import java.util.Objects;

public class vga {
	private String tenVGA;
	private String hangVGA;
	private String boNho;

	public vga() {
		super();
	}

	public vga(String tenVGA, String hangVGA, String boNho) {
		super();
		this.tenVGA = tenVGA;
		this.hangVGA = hangVGA;
		this.boNho = boNho;
	}

	public String getTenVGA() {
		return tenVGA;
	}

	public void setTenVGA(String tenVGA) {
		this.tenVGA = tenVGA;
	}

	public String getHangVGA() {
		return hangVGA;
	}

	public void setHangVGA(String hangVGA) {
		this.hangVGA = hangVGA;
	}

	public String getBoNho() {
		return boNho;
	}

	public void setBoNho(String boNho) {
		this.boNho = boNho;
	}

	@Override
	public String toString() {
		return "vga [tenVGA=" + tenVGA + ", hangVGA=" + hangVGA + ", boNho=" + boNho + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(boNho, hangVGA, tenVGA);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		vga other = (vga) obj;
		return Objects.equals(boNho, other.boNho) && Objects.equals(hangVGA, other.hangVGA)
				&& Objects.equals(tenVGA, other.tenVGA);
	}

}
