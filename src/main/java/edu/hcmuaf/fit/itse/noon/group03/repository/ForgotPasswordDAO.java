package edu.hcmuaf.fit.itse.noon.group03.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.hcmuaf.fit.itse.noon.group03.entity.ForgotPassword;

@Repository
public class ForgotPasswordDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addOneRecord(ForgotPassword forgotPassword) {
		Session session = sessionFactory.getCurrentSession();

		session.save(forgotPassword);
	}

	public ForgotPassword getOneByToken(String token) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(ForgotPassword.class, token);
	}

	public void remove(ForgotPassword forgotPassword) {
		Session session = sessionFactory.getCurrentSession();
		session.remove(forgotPassword);
	}
}
