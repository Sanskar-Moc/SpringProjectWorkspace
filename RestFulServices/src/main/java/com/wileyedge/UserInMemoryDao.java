package com.wileyedge;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository(value = "memDao")
public class UserInMemoryDao implements IDao {
	private static List<User> users;
	static int userCount;
	
	static {
		users=new ArrayList<>();
		userCount=3;
		users.add(new User(44,"Sanskar",new Date()));
		users.add(new User(43,"Saleem",new Date()));
		users.add(new User(42,"Vimal",new Date()));
	}
	
	@Override
	public List<User> findAll() {
		System.out.println("Inside findAll() of UserInMemoryDao");
		return users;
	}

	@Override
	public Optional<User> findById(int id) {
		System.out.println("Inside findById() of UserInMemoryDao");
		Optional<User> user=users.stream().filter(a->a.getId()==id).findAny();
		return user;
	}

	@Override
	public User save(User user) {
		System.out.println("Inside save() of UserInMemoryDao");
		users.add(user);
		return user;
	}

	@Override
	public User deleteById(int id) {
		System.out.println("Inside deleteById() of UserInMemoryDao");
		Iterator<User>it=users.iterator();
		for(;it.hasNext();) {
			User user=it.next();
			if(user.getId()==id) {
				users.remove(user);
				return user;
			}
		}
		return null;
	}

	@Override
	public List<User> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findByNameAndId(String name, int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
