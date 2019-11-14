package com.moneyhub.web.tx;


import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moneyhub.web.pxy.Trunk;
import com.moneyhub.web.utl.Printer;

@RestController
@Transactional
@RequestMapping("/tx")
public class TxController {
//	System.out.println(text);
	@Autowired Printer p;
	@Autowired TXService txService;
	@Autowired Trunk<Object> trunk;
	
	@GetMapping("/crawling/{site}/{srch}")
    public void bringUrl(@PathVariable String site, @PathVariable String srch) {
        p.accept(site+",srch"+srch);
        trunk.put(Arrays.asList("site","srch"),
                Arrays.asList(site, srch));
        txService.crawling(trunk.get());
    }
	@GetMapping("/register/users")
	public Map<?,?> registerUsers() {
		int userCount = txService.registerUsers();
		p.accept("서비스 카운팅 :"+ userCount);
		trunk.put(Arrays.asList("userCount"), Arrays.asList(userCount));
		return trunk.get();
	}
	@GetMapping("/register/trades")
	public Map<?,?> registerTrades() {
		int tradeCount = txService.registerTrades();
		p.accept("서비스 카운팅 :"+ tradeCount);
		trunk.put(Arrays.asList("tradeCount"), Arrays.asList(tradeCount));
		return trunk.get();
	}
}
