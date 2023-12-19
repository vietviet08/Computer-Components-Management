package dao;

import java.util.ArrayList;

import model.manhinh;

public class manhinhDAO implements DAOInterface<manhinh>{
	public static manhinhDAO getInstance() {
		return new manhinhDAO();
	}

	@Override
	public int insert(manhinh t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(manhinh t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(manhinh t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<manhinh> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public manhinh selectById(String t) {
		// TODO Auto-generated method stub
		return null;
	}
}
