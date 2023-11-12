package com.revly.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.revly.models.Users;
import com.revly.repository.UserRepository;

@Service
public class UserDetailServiceClass implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Users> opt = userRepository.findByEmailId(username);
		
		
		if(opt.isPresent()) {
			Users user = opt.get();
			
			List<GrantedAuthority> list = new ArrayList<>();
			SimpleGrantedAuthority auth = new SimpleGrantedAuthority(user.getUserType());
			list.add(auth);
			
			return new User(user.getEmailId(),user.getPassword(),list);
		}else {
			throw new BadCredentialsException("User not found with email : "+username);
		}
		
	}

}
