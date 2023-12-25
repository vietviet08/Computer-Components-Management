package controller;

import java.util.ArrayList;

import model.ProductNhap;

public class LuuTam {
	
	public static LuuTam getInstance() {
		return new LuuTam();
	}
	
	public static ArrayList<ProductNhap> sanPham = new ArrayList<ProductNhap>();
	
	public ArrayList<ProductNhap> sanPham(){
		return sanPham;
	}
	
	
	public static double tongTien ;
}
