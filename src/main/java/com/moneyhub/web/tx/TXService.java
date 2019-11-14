package com.moneyhub.web.tx;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moneyhub.web.pxy.Box;
import com.moneyhub.web.pxy.CrawlingProxy;
import com.moneyhub.web.pxy.TradeProxy;
import com.moneyhub.web.pxy.UserProxy;
import com.moneyhub.web.trade.TradeMapper;
import com.moneyhub.web.usr.UserMapper;

@Transactional
@Service
public class TXService { // 서비스라고 이름붙어있지만 포조이다.
	@Autowired TXMapper txmapper;
	@Autowired UserMapper userMapper;
	@Autowired TradeMapper tradeMapper;
	@Autowired CrawlingProxy crawler;
	@Autowired UserProxy manager;
	@Autowired TradeProxy tradeProxy;
	
	
	@SuppressWarnings("unchecked")
	public Box<String> crawling(Map<?,?> paramMap){
		return crawler.choose(paramMap);  
	}
	@Transactional
	public int registerUsers() {
		manager.insertCustomers();
	return userMapper.countUsers();
	}
	@Transactional
	public int truncateCustomers() {
		manager.truncateCustomers();
	return userMapper.countUsers();
	}
	@Transactional
	public int registerTrades() {
		tradeProxy.insertTrades();
	return tradeMapper.countTrades();
	}
}
