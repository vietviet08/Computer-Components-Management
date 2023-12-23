package controller;

import java.util.ArrayList;

import dao.ramDAO;
import model.ram;

public class TimKiemRAM {

	public static ArrayList<ram> byID(String key) {
		ArrayList<ram> list = new ArrayList<ram>();
		ArrayList<ram> listram = ramDAO.getInstance().selectAll();

		for (ram ram : listram) {
			if (ram.getIdSanPham().contains(key.toLowerCase())) {
				list.add(ram);
			}
		}
		return list;
	}
	
	public static ArrayList<ram> byIDRAM(String key) {
		ArrayList<ram> list = new ArrayList<ram>();
		ArrayList<ram> listram = ramDAO.getInstance().selectAll();

		for (ram ram : listram) {
			if (ram.getIdRam().contains(key.toLowerCase())) {
				list.add(ram);
			}
		}
		return list;
	}
	
	
	public static ArrayList<ram> byTen(String key) {
		ArrayList<ram> list = new ArrayList<ram>();
		ArrayList<ram> listram = ramDAO.getInstance().selectAll();

		for (ram ram : listram) {
			if (ram.getTenRam().contains(key.toLowerCase())) {
				list.add(ram);
			}
		}
		return list;
	}
	public static ArrayList<ram> byLoai(String key) {
		ArrayList<ram> list = new ArrayList<ram>();
		ArrayList<ram> listram = ramDAO.getInstance().selectAll();

		for (ram ram : listram) {
			if (ram.getLoai().contains(key.toLowerCase())) {
				list.add(ram);
			}
		}
		return list;
	}
	public static ArrayList<ram> byDungLuong(String key) {
		ArrayList<ram> list = new ArrayList<ram>();
		ArrayList<ram> listram = ramDAO.getInstance().selectAll();

		for (ram ram : listram) {
			if (ram.getDungLuong().contains(key.toLowerCase())) {
				list.add(ram);
			}
		}
		return list;
	}
	public static ArrayList<ram> byBus(String key) {
		ArrayList<ram> list = new ArrayList<ram>();
		ArrayList<ram> listram = ramDAO.getInstance().selectAll();

		for (ram ram : listram) {
			if (ram.getBus().contains(key.toLowerCase())) {
				list.add(ram);
			}
		}
		return list;
	}
	
	public static ArrayList<ram> byTonKho(String key) {
		ArrayList<ram> list = new ArrayList<ram>();
		ArrayList<ram> listram = ramDAO.getInstance().selectAll();

		for (ram ram : listram) {
			if (String.valueOf(ram.getTonkho()).contains(key.toLowerCase())) {
				list.add(ram);
			}
		}
		return list;
	}
	
	public static ArrayList<ram> byGia(String key) {
		ArrayList<ram> list = new ArrayList<ram>();
		ArrayList<ram> listram = ramDAO.getInstance().selectAll();

		for (ram ram : listram) {
			if (String.valueOf(ram.getDonGia()).contains(key.toLowerCase())) {
				list.add(ram);
			}
		}
		return list;
	}
	
}
