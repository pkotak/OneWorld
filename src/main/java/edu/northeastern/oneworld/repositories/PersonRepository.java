package edu.northeastern.oneworld.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.northeastern.oneworld.models.Person;

public interface PersonRepository extends CrudRepository<Person, Integer> {

	/**
	 * Method to find user by username
	 * @param u
	 * @return Person
	 */
	@Query("SELECT p FROM Person p WHERE p.username=:username")
	Iterable<Person> findUserByUsername(@Param("username") String u);

	/**
	 * Method to find user by credentials
	 * @param username
	 * @param password
	 * @return Person
	 */
	@Query("SELECT p FROM Person p WHERE p.username=:username AND p.password=:password")
	Iterable<Person> findUserByCredentials(@Param("username") String username, @Param("password") String password);

}
