package test;

import java.util.ArrayList;

import dao.SanPhamDAO;
import model.Products;

public class chooseID {
	public static void main(String[] args) {
		ArrayList<Products> list = SanPhamDAO.getIDSanPham("cpu");
		int size = list.size();
		String choose[] = new String[size];
		for (int i = 0; i < size ; i++) {
			Products pr = list.get(i);
			choose[i] = pr.getIdSanPham();
		}
	}
}
