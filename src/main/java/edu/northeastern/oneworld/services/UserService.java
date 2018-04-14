package edu.northeastern.oneworld.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.oneworld.models.Trip;
import edu.northeastern.oneworld.models.User;
import edu.northeastern.oneworld.repositories.TripRepository;
import edu.northeastern.oneworld.repositories.UserRepository;

@RestController
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TripRepository tripRepository;

    /**
     * Method to create a new user
     *
     * @param user user object
     * @return user
     */
    @PostMapping("/api/user/register")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    /**
     * Method to find all people
     *
     * @param username
     * @param password
     * @return
     */
    @GetMapping("/api/user")
    public Iterable<User> findAllPeople(@RequestParam(name = "username", required = false) String username,
                                        @RequestParam(name = "password", required = false) String password) {
        if (username != null && password != null)
            return userRepository.findUserByCredentials(username, password);
        else if (username != null)
            return userRepository.findUserByUsername(username);
        else
            return userRepository.findAll();
    }

    /**
     * Find a specific user
     *
     * @param id
     * @return
     */
    @GetMapping("/api/user/{userId}")
    public Optional<User> findUserById(@PathVariable("userId") int id) {
        return userRepository.findById(id);
    }

    /**
     * @param id
     * @param newuser
     * @return
     */
    @PutMapping("/api/user/{userId}")
    public User updateuser(@PathVariable("userId") int id, @RequestBody User newuser) {
        Optional<User> optionaluser = userRepository.findById(id);
        if (optionaluser.isPresent()) {
            User user = optionaluser.get();
            user.set(newuser);
            return userRepository.save(user);
        } else
            return null;
    }

    /**
     * @param id
     */
    @DeleteMapping("/api/user/{userId}")
    public void deleteUser(@PathVariable("userId") int id) {
        userRepository.deleteById(id);
    }

}
