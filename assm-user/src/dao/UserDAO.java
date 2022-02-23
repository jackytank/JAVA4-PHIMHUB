package dao;

import model.User;

public class UserDAO extends EntityDAO<User> {
	public UserDAO() {
		super(User.class);
	}
}
