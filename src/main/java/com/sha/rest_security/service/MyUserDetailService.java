package com.sha.rest_security.service;

import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sha.rest_security.bean.MyUserPrincipal;
import com.sha.rest_security.domains.ClientInfo;
import com.sha.rest_security.domains.Role;
import com.sha.rest_security.domains.User;
import com.sha.rest_security.domains.UserRole;
import com.sha.rest_security.dto.SignUpRequest;
import com.sha.rest_security.mapper.UserMapper;
import com.sha.rest_security.repository.ClientInfoRepository;
import com.sha.rest_security.repository.RoleRepository;
import com.sha.rest_security.repository.UserRepository;
import com.sha.rest_security.repository.UserRoleRepository;
import com.sha.rest_security.util.CryptographyUtil;
import com.sha.rest_security.util.JwtUtil;

@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
    private UserRepository userRepository;
	
	@Autowired
    private RoleRepository roleRepository;
	
	@Autowired
    private UserRoleRepository userRoleRepository;
	
	@Autowired
    private ClientInfoRepository clientInfoRepository;
	
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
	
	@Transactional
	public User addNewUser(SignUpRequest signUpReq) throws NoSuchAlgorithmException {
		 User user=userMapper.signUpToEntity(signUpReq);
		 user.setEnabled(Boolean.TRUE);
		 user.setPasswordEncrypted(Boolean.FALSE);
		 user=userRepository.save(user);
		 UserRole userRole=updateUserRole(user,signUpReq.getRole());
		 user.addUserRole(userRole);
		 ClientInfo clientInfo=addClientInfo(user);
		 user.addClientInfo(clientInfo);
		 user=userRepository.save(user);
		 return user;
	}
	
	public UserRole updateUserRole(User user,String roleName) {
		if(null==user) {
			throw new UsernameNotFoundException("Null User");
		}
		Role role=roleRepository.findByRolename(roleName);
		UserRole userRole=new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);
		userRole=userRoleRepository.save(userRole);
		return userRole;
	}
	
	public ClientInfo addClientInfo(User user) throws NoSuchAlgorithmException {
		if(null==user) {
			throw new UsernameNotFoundException("Null User");
		}
		String secretKey=CryptographyUtil.generateSecretKey();
		ClientInfo clientInfo=new ClientInfo();
		clientInfo.setEnabled(Boolean.TRUE);
		clientInfo.setSecretKey(secretKey);
		clientInfo.setSecretKeyEncrypted(Boolean.FALSE);
		clientInfo.setUser(user);
		return clientInfoRepository.save(clientInfo);
	}

	public String getUserToken(MyUserPrincipal userPrincipal) throws UnrecoverableKeyException, KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {
		KeyPair keyPair=CryptographyUtil.getRSAKey("api_key");
		String jwtToken=JwtUtil.createJWT(keyPair.getPrivate(), userPrincipal);
		//save jwt token for user in db
		return jwtToken;
	}
}
