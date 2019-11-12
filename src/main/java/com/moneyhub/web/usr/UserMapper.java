package com.moneyhub.web.usr;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
	public void insertUser(User user);
	public User selectUserById(User user);
	public int existId(String aid);
	public int existEmail(String cemail);
	public int countUsers();
	public void createUser(HashMap<String, String> paramMap);
	public void createDB(HashMap<String, String> paramMap);
}
