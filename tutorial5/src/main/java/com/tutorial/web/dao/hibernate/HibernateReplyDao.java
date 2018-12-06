package com.tutorial.web.dao.hibernate;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tutorial.web.dao.ReplyDao;
import com.tutorial.web.entity.Reply;

@Repository
public class HibernateReplyDao implements ReplyDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public int insert(Reply reply) {
		Session session = sessionFactory.getCurrentSession();
		Object id = session.save(reply);
		if (id != null)
			return 1;
		return 0;
	}

	@Override
	@Transactional
	public int update(Reply reply) {
		Session session = sessionFactory.getCurrentSession();
		session.update(reply);
		return 1;
	}

	@Override
	@Transactional
	public int delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Reply reply = new Reply();
		reply.setId(id);
		session.remove(reply);
		return 1;
	}

	@Override
	@Transactional
	public Reply get(int id) {
		Session session = sessionFactory.getCurrentSession();
		Reply reply = session.get(Reply.class, id);
		return reply;
	}

	@Override
	@Transactional
	public List<Reply> getList() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Reply";
		List<Reply> list = session
							.createQuery(hql, Reply.class)	//SQL이 아니라 HQL이다. 주의!!
							.getResultList();
		return list;
	}

}
