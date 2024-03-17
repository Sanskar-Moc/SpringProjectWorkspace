package com.wileyedge;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IService {
	@Autowired
//	@Qualifier("memDao")
	@Qualifier("dataJPADao")
	private IDao dao;
	
	
	@Override
	public List<User> findAll() {
		System.out.println("Inside findAll() of UserService");
		return dao.findAll();
	}

	@Override
	public Optional<User> findById(int id) {
		System.out.println("Inside findById() of UserService");
		return dao.findById(id);
	}

	@Override
	public User save(User user) {
		System.out.println("Inside save() of UserService");
		return dao.save(user);
	}

	@Override
	public User deleteById(int id) {
		System.out.println("Inside deleteById() of UserService");
		return dao.deleteById(id);
	}

	@Override
	public List<User> findByName(String name) {
		System.out.println("Inside findByName() of UserService");
		return dao.findByName(name);
	}

	@Override
	public List<User> findByNameAndId(String name, int id) {
		System.out.println("Inside findByNameAndID() of UserService");
		return dao.findByNameAndId(name, id);
	}
	
}
