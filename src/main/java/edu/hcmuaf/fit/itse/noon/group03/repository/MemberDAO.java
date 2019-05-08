package edu.hcmuaf.fit.itse.noon.group03.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.hcmuaf.fit.itse.noon.group03.entity.Member;

@Repository
public class MemberDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public List<String> getListEmail() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		Query<String> query1 = session.createQuery("select m.email from Member m");
		return query1.getResultList();
	}

	public void save(Member member) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(member);
	}

	public List<Member> getListMember() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		Query<Member> query = session.createQuery("select m from Member m");
		return query.getResultList();
	}

	public Member getOneByUserName(String userName) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "Select m from Member m where m.userName =:userName";
		@SuppressWarnings("unchecked")
		Query<Member> query = session.createQuery(hql);
		query.setParameter("userName", userName);
		try {
			Member result = query.getSingleResult();
			return result;
		} catch (Exception e) {
			return null;
		}
	}

	public Member getOneByEmail(String email) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "Select m from Member m where m.email =:email";
		@SuppressWarnings("unchecked")
		Query<Member> query = session.createQuery(hql);
		query.setParameter("email", email);
		try {
			Member result = query.getSingleResult();
			return result;
		} catch (Exception e) {
			return null;
		}
	}

}
