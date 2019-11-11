package com.moneyhub.web.exr;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moneyhub.web.enums.SQL;
import com.moneyhub.web.pxy.Proxy;
import com.moneyhub.web.pxy.ProxyMap;
import com.moneyhub.web.utl.Printer;

@RestController
@RequestMapping("/exrates")
public class ExRateCtrl {
	@Autowired ExRate exr;
	@Autowired Printer p;
	@Autowired Proxy pxy;
	@Autowired ProxyMap map;
	@Autowired ExRateMapper exMapper;
	
/*	@GetMapping("/")
	public Map<?, ?> exRateRW(){
		p.accept("exRateRW 진입");

		pxy.rwTXT();
		map.accept(Arrays.asList("msg"), Arrays.asList("success"));
		return map.get();
	}*/
	@GetMapping("/create/table")
	public Map<?, ?> createExrate(){
		HashMap<String, String> paramMap = new HashMap<>();
		paramMap.put("CREATE_EXRATE", SQL.CREATE_EXRATE.toString());
		p.accept("테이블 쿼리 생성 : \n" + paramMap.get("CREATE_EXRATE"));
		Consumer<HashMap<String, String>> c = t -> exMapper.createExrate(t);
		c.accept(paramMap);
		paramMap.clear();
		paramMap.put("msg", "SUCCESS");
		return paramMap;
	}
}
