package com.vrm.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vrm.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	public User getByUserId(int id);
	public User findByUserIdAndPassword(int id ,String password);
	public User findByUserIdAndPasswordAndRole(int id,String password,String role);

}
