package com.tutorial.web.dao.hibernate;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tutorial.web.dao.MemberDao;
import com.tutorial.web.entity.Member;
import com.tutorial.web.entity.Reply;

@Repository
public class HibernateMemberDao implements MemberDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public Member get(String memberId) {
		Session session = sessionFactory.getCurrentSession();
		Member member = session.get(Member.class, memberId);
		return member;
	}

	@Override
	@Transactional
	public int insert(Member member) {
		Session session = sessionFactory.getCurrentSession();
		Object id = session.save(member);
		if (id != null)
			return 1;
		return 0;
	}

	@Override
	@Transactional
	public int update(Member member) {
		Session session = sessionFactory.getCurrentSession();
		session.update(member);
		return 1;
	}

	@Override
	@Transactional
	public int delete(String id) {
		Session session = sessionFactory.getCurrentSession();
		Member member = new Member();
		member.setId(id);
		session.remove(member);
		return 1;
	}

	@Override
	@Transactional
	public List<Member> getList() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Member";
		List<Member> list = session
							.createQuery(hql, Member.class)	//SQL이 아니라 HQL이다. 주의!!
							.getResultList();
		return list;
	}

}
