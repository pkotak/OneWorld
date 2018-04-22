package edu.northeastern.oneworld.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.northeastern.oneworld.models.Owner;
import edu.northeastern.oneworld.repositories.OwnerRepository;

@RestController
@CrossOrigin(origins = {"http://localhost:63342", "http://localhost:63343"})
public class OwnerService {

	@Autowired
	OwnerRepository ownerRepository;

	/**
	 * Method to create a new owner
	 * @param owner owner object
	 * @return owner
	 */
	@PostMapping("/api/owner")
	public Owner createOwner(@RequestBody Owner owner) {
		return ownerRepository.save(owner);
	}

	/**
	 * Method to find all people 
	 * @param username
	 * @param password
	 * @return
	 */
	@GetMapping("/api/owner")
	public Iterable<Owner> findAllPeople(@RequestParam(name = "username", required = false) String username,
			@RequestParam(name = "password", required = false) String password) {
		if (username != null && password != null)
			return ownerRepository.findUserByCredentials(username, password);
		else if (username != null)
			return ownerRepository.findUserByUsername(username);
		else
			return ownerRepository.findAll();
	}

	@GetMapping("/api/owner/{ownerId}")
	public Optional<Owner> findUserById(@PathVariable("ownerId") int id) {
		return ownerRepository.findById(id);
	}

	@PutMapping("/api/owner/{ownerId}")
	public Owner updateowner(@PathVariable("ownerId") int id, @RequestBody Owner newowner) {
		Optional<Owner> optionalowner = ownerRepository.findById(id);
		if (optionalowner.isPresent()) {
			Owner owner = optionalowner.get();
//			owner.set(newowner);
			return ownerRepository.save(owner);
		} else
			return null;

	}

	@DeleteMapping("/api/owner/{ownerId}")
	public void deleteUser(@PathVariable("ownerId") int id) {
		ownerRepository.deleteById(id);
	}
}
