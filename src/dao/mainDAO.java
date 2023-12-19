package dao;

import java.util.ArrayList;

import model.mainboard;

public class mainDAO implements DAOInterface<mainboard>{
	public static mainDAO getInstance() {
		return new mainDAO();
	}

	@Override
	public int insert(mainboard t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(mainboard t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(mainboard t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<mainboard> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public mainboard selectById(String t) {
		// TODO Auto-generated method stub
		return null;
	}
}
