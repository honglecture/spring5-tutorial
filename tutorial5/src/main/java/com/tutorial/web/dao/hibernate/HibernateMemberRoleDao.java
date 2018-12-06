package com.tutorial.web.dao.hibernate;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tutorial.web.dao.MemberRoleDao;
import com.tutorial.web.entity.MemberRole;

@Repository
public class HibernateMemberRoleDao implements MemberRoleDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional

	public int insert(MemberRole memberRole) {
		Session session = sessionFactory.getCurrentSession();
		Object id = session.save(memberRole);
		if (id != null)
			return 1;
		return 0;
	}

	@Override
	@Transactional
	public int update(MemberRole memberRole) {
		Session session = sessionFactory.getCurrentSession();
		session.update(memberRole);
		return 1;
	}

	@Override
	@Transactional
	public int delete(MemberRole memberRole) {
		Session session = sessionFactory.getCurrentSession();
		session.remove(memberRole);
		return 1;
	}

	@Override
	@Transactional
	public MemberRole get(MemberRole memberRole) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from MemberRole where memberId=:memberId and roleName=:roleName";
		MemberRole role = session.createQuery(hql, MemberRole.class)
				.setParameter("memberId", memberRole.getMemberId())
				.setParameter("roleName", memberRole.getRoleName())
				.getSingleResult();
		//MemberRole role = session.get(MemberRole.class, memberRole.getMemberId()); // where 절의 들어갈 id
		return role;
	}

	@Override
	@Transactional
	public List<MemberRole> getList() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from MemberRole";
		List<MemberRole> list = session
							.createQuery(hql, MemberRole.class)	//SQL이 아니라 HQL이다. 주의!!
							.getResultList();
		return list;
	}
	
	@Override
	@Transactional
	public List<MemberRole> getListByMemberId(String memberId) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from MemberRole where memberId=:memberId";
		List<MemberRole> list = session.createQuery(hql, MemberRole.class)
				.setParameter("memberId", memberId)
				.getResultList();
		return list;
	}

}
