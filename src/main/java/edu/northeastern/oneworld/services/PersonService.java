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

import edu.northeastern.oneworld.models.Person;
import edu.northeastern.oneworld.repositories.PersonRepository;

/**
 * Person Service class
 *
 */
@RestController
public class PersonService {
	@Autowired
	PersonRepository personRepository;

	/**
	 * Method to create a new Person
	 * @param person person object
	 * @return Person
	 */
	@PostMapping("/api/person")
	public Person createPerson(@RequestBody Person person) {
		return personRepository.save(person);
	}

	/**
	 * Method to find all people 
	 * @param username
	 * @param password
	 * @return
	 */
	@GetMapping("/api/person")
	public Iterable<Person> findAllPeople(@RequestParam(name = "username", required = false) String username,
			@RequestParam(name = "password", required = false) String password) {
		if (username != null && password != null)
			return personRepository.findUserByCredentials(username, password);
		else if (username != null)
			return personRepository.findUserByUsername(username);
		else
			return personRepository.findAll();
	}

	@GetMapping("/api/person/{personId}")
	public Optional<Person> findUserById(@PathVariable("personId") int id) {
		return personRepository.findById(id);
	}

	@PutMapping("/api/person/{personId}")
	public Person updatePerson(@PathVariable("personId") int id, @RequestBody Person newPerson) {
		Optional<Person> optionalPerson = personRepository.findById(id);
		if (optionalPerson.isPresent()) {
			Person person = optionalPerson.get();
			person.set(newPerson);
			return personRepository.save(person);
		} else
			return null;

	}

	@DeleteMapping("/api/person/{personId}")
	public void deleteUser(@PathVariable("personId") int id) {
		personRepository.deleteById(id);
	}

}
