package com.moneyhub.web.cmm;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moneyhub.web.enums.SQL;
import com.moneyhub.web.usr.UserMapper;
import com.moneyhub.web.utl.Printer;

@Controller
public class CommonCtrl {
	
	private static final Logger logger = LoggerFactory.getLogger(CommonCtrl.class);
	@Autowired Printer p;
	@Autowired UserMapper userMapper;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping(value="/cmm/create/db", method = RequestMethod.GET)
	public @ResponseBody Map<?,?> createDB(){
		HashMap<String, String> map = new HashMap<>();
		map.put("CREATE_DB", SQL.CREATE_DB.toString());
		Consumer<HashMap<String, String>> c = t-> userMapper.createDB(t);
		c.accept(map);
		map.clear();
		map.put("msg", "SUCCESS");
		return map;
	}
}
