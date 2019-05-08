package edu.hcmuaf.fit.itse.noon.group03.repository;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.hcmuaf.fit.itse.noon.group03.entity.Member;

@Repository
public class LoginDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Member getOneByUserName(String userName) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "Select m from Member m where m.userName =:userName";
		@SuppressWarnings("unchecked")
		Query<Member> query = session.createQuery(hql);
		query.setParameter("userName", userName);
		return query.getSingleResult();
	}

}
