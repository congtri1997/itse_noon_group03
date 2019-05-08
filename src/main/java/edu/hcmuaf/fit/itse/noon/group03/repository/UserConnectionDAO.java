package edu.hcmuaf.fit.itse.noon.group03.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.hcmuaf.fit.itse.noon.group03.entity.UserConnection;

@Repository
public class UserConnectionDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public UserConnection getOne(String providerID, String providerUserID) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "Select u from UserConnection u where u.providerID =:providerID and u.providerUserID =:providerUserID ";
		@SuppressWarnings("unchecked")
		Query<UserConnection> query = session.createQuery(hql);
		query.setParameter("providerID", providerID);
		query.setParameter("providerUserID", providerUserID);
		try {
			UserConnection result = query.getSingleResult();
			return result;
		} catch (Exception e) {
			return null;
		}
	}

	public void addOne(UserConnection userConnection) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(userConnection);
	}
}
