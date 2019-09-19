package com.bank.application.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class LoggedUser implements UserDetails {

	private static final long serialVersionUID = 1L;

	private String username;
	
	private String password;

	private String firstName;

	private String lastName;

	private List<GrantedAuthority> authorities;
	
	public LoggedUser(String username, String password, String firstName, String lastName,
			List<GrantedAuthority> grantedAuthorities) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	
		this.authorities = grantedAuthorities;
	}

	public String getFirstName() {
		return firstName;
	}


	public String getLastName() {
		return lastName;
	}


	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	
	/*
	 * @Override public Collection<? extends GrantedAuthority> getAuthorities() {
	 * 
	 * return Collections.singleton(new SimpleGrantedAuthority("USER"));
	 * 
	 * }
	 */

	@Override
	public String getPassword() {
		return password;
	}


}
