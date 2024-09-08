package vmarchuk.service.impl;

import java.sql.SQLException;
import java.util.List;

import vmarchuk.dao.UserDao;
import vmarchuk.dao.impl.UserDaoImpl;
import vmarchuk.domain.User;
import vmarchuk.service.UserService;

public class UserServiceImpl implements UserService {
	private static UserService userServiceImpl;
	private UserDao userDao;

	public static UserService getUserService() throws ClassNotFoundException, SQLException {
		if (userServiceImpl == null) {
			userServiceImpl = new UserServiceImpl();
		}

		return userServiceImpl;
	}

	private UserServiceImpl()  throws ClassNotFoundException, SQLException {
		try {
			userDao = new UserDaoImpl();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User create(User t) {
		return userDao.create(t);
	}

	@Override
	public User read(Integer id) {
		return userDao.read(id);
	}

	@Override
	public User update(User t) {
		return userDao.update(t);
	}

	@Override
	public void delete(Integer id) {
		userDao.delete(id);
	}

	@Override
	public List<User> readAll() {
		return userDao.readAll();
	}

	@Override
	public User read(String email) {
		return userDao.read(email);
	}

}
