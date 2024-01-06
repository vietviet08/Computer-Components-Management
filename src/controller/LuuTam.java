package controller;

import java.util.ArrayList;

import model.ChiTietPhieu;

public class LuuTam {
	
	public static LuuTam getInstance() {
		return new LuuTam();
	}
	
	public static ArrayList<ChiTietPhieu> sanPham = new ArrayList<ChiTietPhieu>();
	
	public ArrayList<ChiTietPhieu> sanPham(){
		return sanPham;
	}
	
	
	public static double tongTien ;
}
