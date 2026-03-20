package com.shiva.shiva.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.shiva.shiva.entity.User;
import com.shiva.shiva.payload.UserDto;
import com.shiva.shiva.repository.UserRepository;
import com.shiva.shiva.service.UserService;
@Service
public class UserServiceImp implements UserService{
	@Autowired
 private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Override
	public UserDto createUser(UserDto userDto) {
		userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
		// TODO Auto-generated method stub
		User user=userDtoToEntity(userDto);
		
		
		User savedUser=userRepository.save(user);
		return entityToUserDto(savedUser);
	}
    private User userDtoToEntity(UserDto userDto) {
    User users=new User();
    
    users.setName(userDto.getName());
    users.setEmail(userDto.getEmail());
    users.setPassword(userDto.getPassword());
    return users;
    	
    }
    private UserDto entityToUserDto(User savedUser) {
    	UserDto userDto=new UserDto();
    	userDto.setId(savedUser.getId());
    	userDto.setEmail(savedUser.getEmail());
    	userDto.setPassword(savedUser.getPassword());
    	userDto.setName(savedUser.getName());
		return userDto;
    }
}
