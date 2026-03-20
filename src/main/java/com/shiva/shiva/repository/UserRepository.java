package com.shiva.shiva.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shiva.shiva.entity.User;
import com.shiva.shiva.security.Users;

public interface UserRepository extends JpaRepository<User,Long>{

	Optional<User> findByEmail(String email);

}
