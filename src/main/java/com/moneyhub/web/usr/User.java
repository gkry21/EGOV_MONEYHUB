package com.moneyhub.web.usr;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Lazy
@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class User {
//	private String aid,pwd,cname;
	private String  cno, cemail, cpwd, cname, cstcd, sdate, wdate, cmem, cdate, umem, udate;

}
