package com.moneyhub.web.usr;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private String aid,pwd,cname,cemail,cpwd,cdate,customer;

}
