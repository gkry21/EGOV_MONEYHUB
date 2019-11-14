package com.moneyhub.web.tx;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

import com.moneyhub.web.trade.Trade;
import com.moneyhub.web.usr.User;

@Repository
public interface TXMapper {
	@Insert("INSERT INTO USER (CEMAIL, CPWD, CNAME, CDATE) \n" + 
			"VALUES (\n" +  
			"  #{cemail}, #{cpwd}, #{cname}, #{cdate})")
	public int insertUser(User u); 
	
	@Insert(" SELECT COUNT(*) FROM USER\n" + 
			"		WHERE CEMAIL LIKE #{cemail}")
	public int existEmail(String cemail);
	
	@Insert("INSERT INTO TRADE () \n" + 
			"VALUES (\n" +  
			"  #{}, #{}, #{}, #{})")
	public int insertTrade(Trade t); 
}
