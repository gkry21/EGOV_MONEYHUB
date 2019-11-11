package com.moneyhub.web.trhs;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moneyhub.web.cmm.IConsumer;
import com.moneyhub.web.enums.SQL;
import com.moneyhub.web.utl.Printer;

@RestController
@RequestMapping("/trhs")
public class TrhsController {
	private static final Logger logger = LoggerFactory.getLogger(TrhsController.class);
	@Autowired Printer p;
	@Autowired TrhsMapper trhsMapper;
	
	@GetMapping("/create/trhs")
	public Map<?,?> createTrhs(){
		HashMap<String, String> paramMap = new HashMap<>();
		paramMap.put("CREATE_TRHS", SQL.CREATE_TRHS.toString());
		p.accept("테이블 생성 쿼리 : \n" +paramMap.get("CREATE_TRHS"));
		IConsumer<HashMap<String, String>> c = o->trhsMapper.createTrhs(o);
		c.accept(paramMap);
		paramMap.clear();
		paramMap.put("map", "SUCCESS");
		return paramMap;
	}
}
