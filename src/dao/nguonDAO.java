package dao;

import java.util.ArrayList;

import model.nguon;

public class nguonDAO implements DAOInterface<nguon>{
	public static nguonDAO getInstance() {
		return new nguonDAO();
	}

	@Override
	public int insert(nguon t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(nguon t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(nguon t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<nguon> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public nguon selectById(String t) {
		// TODO Auto-generated method stub
		return null;
	}
}
