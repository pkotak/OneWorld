package edu.northeastern.oneworld.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.northeastern.oneworld.models.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
