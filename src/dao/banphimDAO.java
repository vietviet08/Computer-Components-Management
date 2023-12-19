package dao;

import java.util.ArrayList;

import model.banphim;

public class banphimDAO implements DAOInterface<banphim>{
	public static banphimDAO getInstance() {
		return new banphimDAO();
	}

	@Override
	public int insert(banphim t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(banphim t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(banphim t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<banphim> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public banphim selectById(String t) {
		// TODO Auto-generated method stub
		return null;
	}
}
