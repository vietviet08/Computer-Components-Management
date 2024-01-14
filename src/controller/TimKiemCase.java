package controller;

import java.util.ArrayList;

import dao.caseDAO;
import model.Case;

public class TimKiemCase {
//	"ID SP", "ID Case", "Tên case", "Hãng", "Loại case", "Chất liệu", "Kích thước mb",
//	"Tồn kho", "Giá" 

//	 if (c.getIdCase().toLowerCase().contains(key.toLowerCase()))
//		list.add(c);
//	if (c.getTenCase().toLowerCase().contains(key.toLowerCase()))
//		list.add(c);
//	if (c.getHangCase().toLowerCase().contains(key.toLowerCase()))
//		list.add(c);
//	if (c.getLoaiCase().toLowerCase().contains(key.toLowerCase()))
//		list.add(c);
//	if (c.getChatLieu().toLowerCase().contains(key.toLowerCase()))
//		list.add(c);
//	if (c.getKichThuocMainboard().toLowerCase().contains(key.toLowerCase()))
//		list.add(c);
//	if (String.valueOf(c.getTonKho()).toLowerCase().contains(key.toLowerCase()))
//		list.add(c);
//	if (String.valueOf(c.getGia()).toLowerCase().contains(key.toLowerCase()))
//		list.add(c);

	public static ArrayList<Case> byIDSP(String key) {
		ArrayList<Case> list = new ArrayList<Case>();
		ArrayList<Case> cases = caseDAO.getInstance().selectAll();
		for (Case c : cases)
			if (c.getIdSanPham().toLowerCase().contains(key.toLowerCase()))
				list.add(c);
		return list;
	}

	public static ArrayList<Case> byIDCase(String key) {
		ArrayList<Case> list = new ArrayList<Case>();
		ArrayList<Case> cases = caseDAO.getInstance().selectAll();
		for (Case c : cases)
			if (c.getIdCase().toLowerCase().contains(key.toLowerCase()))
				list.add(c);
		return list;
	}

	public static ArrayList<Case> byTen(String key) {
		ArrayList<Case> list = new ArrayList<Case>();
		ArrayList<Case> cases = caseDAO.getInstance().selectAll();
		for (Case c : cases)
			if (c.getTenCase().toLowerCase().contains(key.toLowerCase()))
				list.add(c);
		return list;
	}

	public static ArrayList<Case> byHang(String key) {
		ArrayList<Case> list = new ArrayList<Case>();
		ArrayList<Case> cases = caseDAO.getInstance().selectAll();
		for (Case c : cases)
			if (c.getHangCase().toLowerCase().contains(key.toLowerCase()))
				list.add(c);
		return list;
	}

	public static ArrayList<Case> byLoai(String key) {
		ArrayList<Case> list = new ArrayList<Case>();
		ArrayList<Case> cases = caseDAO.getInstance().selectAll();
		for (Case c : cases)
			if (c.getLoaiCase().toLowerCase().contains(key.toLowerCase()))
				list.add(c);
		return list;
	}

	public static ArrayList<Case> byChatLieu(String key) {
		ArrayList<Case> list = new ArrayList<Case>();
		ArrayList<Case> cases = caseDAO.getInstance().selectAll();
		for (Case c : cases)
			if (c.getChatLieu().toLowerCase().contains(key.toLowerCase()))
				list.add(c);
		return list;
	}

	public static ArrayList<Case> byKichThuoc(String key) {
		ArrayList<Case> list = new ArrayList<Case>();
		ArrayList<Case> cases = caseDAO.getInstance().selectAll();
		for (Case c : cases)
			if (c.getKichThuocMainboard().toLowerCase().contains(key.toLowerCase()))
				list.add(c);
		return list;
	}

	public static ArrayList<Case> byTonKho(String key) {
		ArrayList<Case> list = new ArrayList<Case>();
		ArrayList<Case> cases = caseDAO.getInstance().selectAll();
		for (Case c : cases)
			if (String.valueOf(c.getTonKho()).contains(key.toLowerCase()))
				list.add(c);
		return list;
	}

	public static ArrayList<Case> byGia(String key) {
		ArrayList<Case> list = new ArrayList<Case>();
		ArrayList<Case> cases = caseDAO.getInstance().selectAll();
		for (Case c : cases)
			if (String.valueOf(c.getGia()).toLowerCase().contains(key.toLowerCase()))
				list.add(c);
		return list;
	}
}
