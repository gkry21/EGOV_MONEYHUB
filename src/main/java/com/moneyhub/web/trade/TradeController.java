package com.moneyhub.web.trade;


import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moneyhub.web.cmm.IConsumer;
import com.moneyhub.web.enums.SQL;
import com.moneyhub.web.utl.Printer;



@RestController
@RequestMapping("/trade")
public class TradeController {
	private static final Logger logger = LoggerFactory.getLogger(TradeController.class);
	@Autowired Printer p;
	@Autowired TradeMapper tradeMapper;
	
	@GetMapping("/create/trade")
	public Map<?,?> createTrade(){
		HashMap<String, String> paramMap = new HashMap<>();
		paramMap.put("CREATE_TRADE", SQL.CREATE_TRADE.toString());
		p.accept("테이블 생성 쿼리 : \n" +paramMap.get("CREATE_TRADE"));
		IConsumer<HashMap<String, String>> c = o->tradeMapper.createTrade(o);
		c.accept(paramMap);
		paramMap.clear();
		paramMap.put("map", "SUCCESS");
		return paramMap;
	}
	@GetMapping("/drop/trade")
	public Map<?,?> dropTrade(){
		HashMap<String, String> paramMap = new HashMap<>();
		paramMap.put("DROP_TRADE", SQL.DROP_TRADE.toString());
		p.accept("테이블 삭제 쿼리 : \n" +paramMap.get("DROP_TRADE"));
		IConsumer<HashMap<String, String>> c = o->tradeMapper.dropTrade(o);
		c.accept(paramMap);
		paramMap.clear();
		paramMap.put("map", "SUCCESS");
		return paramMap;
	}
}
