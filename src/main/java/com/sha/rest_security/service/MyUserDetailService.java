package com.sha.rest_security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sha.rest_security.bean.MyUserPrincipal;
import com.sha.rest_security.domains.User;
import com.sha.rest_security.dto.SignUpRequest;
import com.sha.rest_security.mapper.UserMapper;
import com.sha.rest_security.repository.UserRepository;

@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
    private UserRepository userRepository;
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//List<User> users=userRepository.findAll();
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new MyUserPrincipal(user);
      }
	
	public void register(SignUpRequest signUpReq) {
		 User user=userMapper.signUpToEntity(signUpReq);
	}

}
