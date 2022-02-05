package com.sjp.practice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjp.practice.model.User;
import com.sjp.practice.repository.UserRepo;
import com.sjp.practice.util.BusinessException;
import com.sjp.practice.util.EmptyInputException;

/**
 * 
 * @author Puneeth SJ
 *https://stackoverflow.com/questions/69109649/hibernate-findbyid-vs-getbyid
 *
 *
Usually we can use either findById or getById. There's no issue in using either of it.

But if we want to understand more specific differences the those differences are as follows:

- getById: This is used only if we are sure about getting an entity we requested from the database. If we don't get any entity, it gives an exception. This is similar to a child who get's whatever it wants but starts screaming if it doesn't get what he requires.

- findById: This is used if we are not sure that whether the requested entity in the database is present or not. So even if the entity is not present in the database it returns null and doesn't throw any exception.
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepo userRepo;
	
	@Override
	public User getUserById(int id) {
		//return userRepo.getById(id); //invalid
		/**
		 * You got LazyInitializationException exactly because you set fetch = Fetch.EAGER. getById() returns a lazily fetched entity and thus the exception.
Just guessing here, but maybe because of the laziness behaviour of getById(). 
		 */
//		User u = new User();
//		u.setName("N"+ Math.random());
//		userRepo.save(u);
		//System.out.println(userRepo.findAll().toString());
		//Optional<User> u1 = userRepo.findById(id);
		//return u1.get();
		if(id==0) {
			throw new BusinessException("CE-1122", "Send valid Id > 0 ");
		}
		User u2 = userRepo.getById(id);
		User u3 = new User();
		u3.setId(u2.getId());
		u3.setName(u2.getName());
		return u3;
	}
}
