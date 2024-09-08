package vmarchuk.dao;

import vmarchuk.domain.User;
import vmarchuk.shared.AbstractCRUD;

public interface UserDao extends AbstractCRUD<User> {
	public User read(String email);
}
