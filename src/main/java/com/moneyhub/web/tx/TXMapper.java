package com.moneyhub.web.tx;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;


import com.moneyhub.web.usr.User;

@Repository
public interface TXMapper {
	@Insert(" INSERT INTO CLIENT (AID,CNAME,PWD) VALUES (\n" + 
			"            #{aid}, #{cname}, #{pwd})")
	public int insertUser(User u);

}
