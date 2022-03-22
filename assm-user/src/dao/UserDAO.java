package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.User;
import utils.JpaUtils;

public class UserDAO extends EntityDAO<User> { 
	public UserDAO() {
		super(User.class);
	}

	public void changePassword(String userId, String oldPass, String newPass) {

		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		String jpql = "select u from User u where u.userId= :userId and u.password= :password";

		try {
			trans.begin();
			TypedQuery<User> query = em.createQuery(jpql, User.class);
			query.setParameter("userId", userId);
			query.setParameter("password", oldPass);

			User user = query.getSingleResult();
			if (user == null) {
				throw new Exception("Current password or username are incorrect!");
			}
			user.setPassword(newPass);
			em.merge(user);

			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public User findByUserIdAndEmail(String userId, String email) {
		EntityManager em = JpaUtils.getEntityManager();

		String jpql = "select u from User u where u.userId=:userId and u.email=:email";

		try {
			TypedQuery<User> query = em.createQuery(jpql, User.class);
			query.setParameter("userId", userId);
			query.setParameter("email", email);
			return query.getSingleResult();
		} finally {
			em.close();
		}
	}
}
