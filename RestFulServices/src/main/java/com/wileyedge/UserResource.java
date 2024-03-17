package com.wileyedge;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {
	@Autowired
	private IService service;
	
//	@RequestMapping(value = "/users", method = RequestMethod.GET)
	@GetMapping(value = "/users")
	public List<User> retreiveAllUsers(){
		System.out.println("Inside retreiveAllUsers() of UserResponse");
		return service.findAll();
	}
	@GetMapping(path="/users/{id}")
	public User retreiveUser(@PathVariable("id")int id) {
		System.out.println("Inside retreiveUser() of UserResponse");
		Optional<User> user= service.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
		else {
			System.out.println("Throwing Exception");
			throw new UserNotFoundException("User with the following ID not present. id="+id);
		}
//		return null;
	}
	@PostMapping(path="/users",consumes = "application/json")
	public String createUser(@Valid @RequestBody User user,BindingResult result,Model model) throws MethodArgumentNotValidException {
		System.out.println("Inside createUser() of UserResource");
		if(result.hasErrors()) {
			System.out.println("Validation errors occured");
			throw new MethodArgumentNotValidException(null, result);
		}
		
		service.save(user);
		return "added";
	}
	@DeleteMapping(path="/users/{id}")
	public String deleteUser(@PathVariable("id") int id) {
		System.out.println("Inside deleteUser() of UserResource");
		service.deleteById(id);
		return "deleted";
	}
	@GetMapping(path="/users/name/{name}")
	public List<User> retreiveUserByName(@PathVariable("name")String name) {
		System.out.println("Inside retreiveUser() of UserResponse");
		List<User> users= service.findByName(name);
		if(users==null) {
			throw new UserNotFoundException(name+" not found");
		}
		return users;
	}
	@GetMapping(path="/users/name/{name}/id/{id}")
	public List<User> retreiveUserByNameAndId(@PathVariable("name")String name,@PathVariable("id")int id) {
		System.out.println("Inside retreiveUserByNameAndId() of UserResponse");
		List<User> users= service.findByNameAndId(name, id);
		if(users==null) {
			throw new UserNotFoundException(name+" not found");
		}
		return users;
	}
}
