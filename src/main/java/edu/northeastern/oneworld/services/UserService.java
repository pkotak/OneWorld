package edu.northeastern.oneworld.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.oneworld.models.Person;
import edu.northeastern.oneworld.models.User;
import edu.northeastern.oneworld.repositories.UserRepository;

@RestController
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	/**
	 * @param user
	 * @return
	 */
	@PostMapping("/api/user")
	public Person createUser(@RequestBody User user) {
		return userRepository.save(user);
	}
}
