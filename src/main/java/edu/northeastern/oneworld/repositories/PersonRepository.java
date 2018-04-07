package edu.northeastern.oneworld.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.northeastern.oneworld.models.Person;

public interface PersonRepository extends CrudRepository<Person, Integer> {

	@Query("SELECT p FROM Person p WHERE p.username=:username")
	Iterable<Person> findUserByUsername(@Param("username") String u);

	@Query("SELECT p FROM Person p WHERE p.username=:username AND p.password=:password")
	Iterable<Person> findUserByCredentials(@Param("username") String username, @Param("password") String password);

}
