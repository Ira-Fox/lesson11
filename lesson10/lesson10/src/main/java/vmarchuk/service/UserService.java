package vmarchuk.service;

import vmarchuk.domain.User;
import vmarchuk.shared.AbstractCRUD;

public interface UserService extends AbstractCRUD<User> {
	public User read(String email);
}

