package edu.northeastern.oneworld.services;

import java.util.Optional;

import com.google.gson.Gson;
import edu.northeastern.oneworld.models.Destination;
import edu.northeastern.oneworld.models.Review;
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
	 * @param json owner object
	 * @return owner
	 */
	@PostMapping("/api/owner")
	public Owner createOwner(@RequestBody String json) {
		Gson gson = new Gson();
		Owner owner = gson.fromJson(json, Owner.class);
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

	@GetMapping("/api/owner/{ownerId}/destination")
	public Iterable<Destination> findDestinationForOwner(@PathVariable("ownerId") int id){
		Optional<Owner> optionalOwner = findUserById(id);
		if(optionalOwner.isPresent()){
			Owner owner = optionalOwner.get();
			return owner.getDestinations();
		}
		return null;
	}
	@PutMapping("/api/owner/{ownerId}")
	public Owner updateOwner(@PathVariable("ownerId") int id, @RequestBody Owner newowner) {
		Optional<Owner> optionalOwner = ownerRepository.findById(id);
		if (optionalOwner.isPresent()) {
			Owner owner = optionalOwner.get();
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
