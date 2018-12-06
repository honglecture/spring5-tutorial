package com.tutorial.web.dao.hibernate;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tutorial.web.dao.BoardDao;
import com.tutorial.web.entity.Board;

@Repository
public class HibernateBoardDao implements BoardDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public int insert(Board board) {
		Session session = sessionFactory.getCurrentSession();
		Object id = session.save(board);
		if (id != null)
			return 1;
		return 0;
	}

	@Override
	@Transactional
	public int update(Board board) {
		Session session = sessionFactory.getCurrentSession();
		session.update(board);
		return 1;
	}

	@Override
	@Transactional
	public int delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Board board = new Board();
		board.setId(id);
		session.remove(board);
		return 1;
	}

	@Override
	@Transactional
	public Board get(int id) {
		Session session = sessionFactory.getCurrentSession();
		Board board = session.get(Board.class, id);
		return board;
	}

	@Override
	@Transactional
	public List<Board> getList() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Board";
		List<Board> list = session
							.createQuery(hql, Board.class)	//SQL이 아니라 HQL이다. 주의!!
							.getResultList();
		return list;
	}

}
