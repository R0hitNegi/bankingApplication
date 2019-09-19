package com.bank.application.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bank.application.model.Users;
import com.bank.application.repository.UserLoginRepo;


@Service("customUserDetailsService")
@Transactional
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UserLoginRepo userLoginRepo;
	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

			Users user = userLoginRepo.findByUsername(username);
			System.out.println(user.toString());
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	
	}
		
//				if ("javainuse".equals(username)) {
//			return new User("javainuse", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
//					new ArrayList<>());
//		} else {
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}
//	}
//	
	
	public Users save(Users user) {
		Users newUser = new Users();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userLoginRepo.save(newUser);
	}

	
	
//	@Autowired
//	private UserLoginRepo userLoginRepo;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		System.out.println(username+" = user Name form ui");
//		Users user = userLoginRepo.findByUsername(username);
//		System.out.println("user="+user.toString());
//
//		if (user == null)
//			throw new UsernameNotFoundException("User Not Found");
//
//		return new LoggedUser(user.getUsername(), user.getPassword(), user.getFirstName(), user.getLastName(),getGrantedAuthorities(user));
//		
//
//	}
//
//	
//
//	private List<GrantedAuthority> getGrantedAuthorities(Users user) {
//		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//		authorities.add(new SimpleGrantedAuthority("ROLE_"+user.getGroup().getRole().getName()));
//		System.out.println(user.getGroup().getRole().getName());
//		return authorities;
//	}

}
