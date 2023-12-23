package controller;

import java.util.ArrayList;

import dao.vgaDAO;
import model.vga;

public class TimKiemVGA {
	public static ArrayList<vga> byID(String key) {
		ArrayList<vga> list = new ArrayList<vga>();
		ArrayList<vga> listram = vgaDAO.getInstance().selectAll();

		for (vga vga : listram) {
			if (vga.getIdSanPham().contains(key.toLowerCase())) {
				list.add(vga);
			}
		}
		return list;
	}
	
	public static ArrayList<vga> byIDVGA(String key) {
		ArrayList<vga> list = new ArrayList<vga>();
		ArrayList<vga> listram = vgaDAO.getInstance().selectAll();

		for (vga vga : listram) {
			if (vga.getIdVga().contains(key.toLowerCase())) {
				list.add(vga);
			}
		}
		return list;
	}

	public static ArrayList<vga> byTen(String key) {
		ArrayList<vga> list = new ArrayList<vga>();
		ArrayList<vga> listram = vgaDAO.getInstance().selectAll();

		for (vga vga : listram) {
			if (vga.getTenVGA().contains(key.toLowerCase())) {
				list.add(vga);
			}
		}
		return list;
	}

	public static ArrayList<vga> byHang(String key) {
		ArrayList<vga> list = new ArrayList<vga>();
		ArrayList<vga> listram = vgaDAO.getInstance().selectAll();

		for (vga vga : listram) {
			if (vga.getHangVGA().contains(key.toLowerCase())) {
				list.add(vga);
			}
		}
		return list;
	}

	public static ArrayList<vga> byBoNho(String key) {
		ArrayList<vga> list = new ArrayList<vga>();
		ArrayList<vga> listram = vgaDAO.getInstance().selectAll();

		for (vga vga : listram) {
			if (vga.getBoNho().contains(key.toLowerCase())) {
				list.add(vga);
			}
		}
		return list;
	}
	
	public static ArrayList<vga> byTonKho(String key) {
		ArrayList<vga> list = new ArrayList<vga>();
		ArrayList<vga> listram = vgaDAO.getInstance().selectAll();

		for (vga vga : listram) {
			if (String.valueOf(vga.getTonKho()).contains(key.toLowerCase())) {
				list.add(vga);
			}
		}
		return list;
	}

	public static ArrayList<vga> byGia(String key) {
		ArrayList<vga> list = new ArrayList<vga>();
		ArrayList<vga> listram = vgaDAO.getInstance().selectAll();

		for (vga vga : listram) {
			if (String.valueOf(vga.getDonGia()).contains(key.toLowerCase())) {
				list.add(vga);
			}
		}
		return list;
	}

}
