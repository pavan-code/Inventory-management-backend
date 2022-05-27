package com.IMS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IMS.entity.Request;
import com.IMS.entity.User;
import com.IMS.entity.UserResponse;
import com.IMS.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public User register(User user) {
		return userRepo.save(user);
	}

	public UserResponse<User> login(Request request) {
		String email = request.getEmail();
		String password = request.getPassword();
		String role = request.getRole();
		User user = userRepo.findByEmail(email);
		if (user == null) {
			return new UserResponse<>(false, 404, "User not found", null, null);
		} else {
			if (email.equals(user.getEmail())) {
				if (password.equals(user.getPassword())) {
					if (role.equals(user.getRole()))
						return new UserResponse<>(true, 200, "Login Successfull",
								new User(user.getId(), user.getFirstname(), user.getRole()), null);
					else
						return new UserResponse<>(false, 403, "Unauthorized Credentials for " + role, null, null);

				} else {
					return new UserResponse<>(false, 403, "Password Incorrect", null, null);
				}
			} else {
				return new UserResponse<>(false, 403, "Invalid Username", null, null);
			}
		}
	}

}
