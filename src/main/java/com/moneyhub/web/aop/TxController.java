package com.moneyhub.web.aop;


import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moneyhub.web.pxy.ProxyMap;
import com.moneyhub.web.utl.Printer;

@RestController
@Transactional
@RequestMapping("/tx")
public class TxController {
//	System.out.println(text);
	@Autowired Printer p;
	@Autowired TXService txService;
	@Autowired ProxyMap map;
	
	@GetMapping("/crawling/{site}/{srch}")
    public void bringUrl(@PathVariable String site, @PathVariable String srch) {
        p.accept(site+",srch"+srch);
        map.accept(Arrays.asList("site","srch"),
                Arrays.asList(site, srch));
        txService.crawling(map.get());
    }
	
	@GetMapping("/register/users")
	public Map<?,?> registerUsers() {
		int userCount = txService.registerUsers();
		p.accept("서비스 카운팅 :"+ userCount);
		map.accept(Arrays.asList("userCount"), Arrays.asList(userCount));
		return map.get();
	}
}
