package crm.service;

import java.util.List;

import crm.model.User;
import crm.repository.UserRepository;

public class LoginService {
	private UserRepository userRepository = new UserRepository();
	public boolean checkLogin(String username, String password) {
		List<User> list = userRepository.getUserByUsernameAndPassword(username, password);
		return list.size()>0 ? true: false;
	}
}
