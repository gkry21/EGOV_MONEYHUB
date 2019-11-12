package com.moneyhub.web.tx;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moneyhub.web.pxy.CrawlingProxy;
import com.moneyhub.web.pxy.PageProxy;
import com.moneyhub.web.usr.User;
import com.moneyhub.web.usr.UserMapper;

@Transactional
@Service
public class TXService { // 서비스라고 이름붙어있지만 포조이다.
	@Autowired TXMapper txmapper;
	@Autowired UserMapper userMapper;
	@Autowired CrawlingProxy cralwer;
//	@Autowired List<String> list;
	
	@SuppressWarnings("unchecked")
	public List<?> crawling(Map<?,?> paramMap){
		List<String> txServicelist = new ArrayList<>();
		txServicelist.clear();
//		txServicelist = (List<String>) cralwer.crawl(paramMap);
		return txServicelist;  
	}

	public int registerUsers() {
		List<User> list = new ArrayList<>();
		for(User u : list) {
			txmapper.insertUser(u);
		}
	return userMapper.countUsers();
	}
}
