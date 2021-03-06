package com.moneyhub.web.usr;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.moneyhub.web.cmm.IConsumer;
import com.moneyhub.web.cmm.IFunction;
import com.moneyhub.web.enums.SQL;
import com.moneyhub.web.utl.Printer;

@RestController
@RequestMapping("/user")
public class UserCtrl {
	private static final Logger logger = LoggerFactory.getLogger(UserCtrl.class);
	@Autowired Map<String, Object>map;
	@Autowired User user;
	@Autowired Printer printer;
	@Autowired UserMapper userMapper;
	
	@GetMapping("/{cemail}/exist")
	public Map<?,?> exist(@PathVariable String cemail){
		System.out.println(cemail);
		IFunction<String, Integer> p = o -> userMapper.existEmail(cemail);
		map.clear();
		map.put("msg", (p.apply(cemail)==0) ? "SUCCESS" : "FAIL");
		System.out.println(map.get("msg"));
		return map;
	}
	@PostMapping("/")
	public Map<?,?> join(@RequestBody User param) {
		printer.accept("join 들어옴 : "+param.toString());
		IConsumer<User> c = o -> userMapper.insertUser(param);
		c.accept(param);
		map.clear();
		map.put("msg", "SUCCESS");
		return map;	
	}
	
	@PostMapping("/{cemail}/login")
	public User login(@PathVariable String cemail, @RequestBody User param) {
		System.out.println(param.toString());
		IFunction<User,User> f = t-> userMapper.selectUserById(param);
		System.out.println(f.apply(param).toString());
		return f.apply(param);
	}
	@GetMapping("/{cemail}")
	public User serachUserById(@PathVariable String cemail, @RequestBody User param) {
		IFunction<User,User> f = t-> userMapper.selectUserById(param);
		return f.apply(param);
	}
	@PutMapping("/{cemail}")
	public String updateUser(@PathVariable String cemail, @RequestBody User param) {
		IConsumer<User> c = o -> userMapper.insertUser(param);
		c.accept(param);
		return "SUCCESS";
	}
	@DeleteMapping("/{cemail}")
	public String deleteUser(@PathVariable String cemail, @RequestBody User param) {
		IConsumer<User> c = o -> userMapper.insertUser(param);
		c.accept(param);
		return "SUCCESS";
	}
	@GetMapping("/create/table")
	public Map<?,?> createUser(){
		HashMap<String, String> paramMap = new HashMap<>();
		paramMap.put("CREATE_USER", SQL.CREATE_USER.toString());
		printer.accept("테이블 생성 쿼리 : \n" +paramMap.get("CREATE_USER"));
		IConsumer<HashMap<String, String>> c = o->userMapper.createUser(o);
		c.accept(paramMap);
		paramMap.clear();
		paramMap.put("map", "SUCCESS");
		return paramMap;
	}
	@GetMapping("/drop/table")
	public Map<?,?> dropUser(){
		HashMap<String, String> paramMap = new HashMap<>();
		paramMap.put("DROP_USER", SQL.DROP_USER.toString());
		printer.accept("테이블 삭제 쿼리 : \n" +paramMap.get("DROP_USER"));
		IConsumer<HashMap<String, String>> c = o->userMapper.createUser(o);
		c.accept(paramMap);
		paramMap.clear();
		paramMap.put("map", "SUCCESS");
		return paramMap;
	}
}