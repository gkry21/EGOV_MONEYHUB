package com.moneyhub.web.trade;


import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/trns")
public class TradeController {
	private static final Logger logger = LoggerFactory.getLogger(TradeController.class);
	
	@GetMapping("/create/trns")
	public Map<?,?> createTrns(){
		HashMap<String, String> paramMap = new HashMap<>();
		return null;
	}
}
