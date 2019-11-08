package com.moneyhub.web.usr;

import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
	public void insertClient(User user);
	public User selectUserById(User user);
	public int existId(String aid);
}
