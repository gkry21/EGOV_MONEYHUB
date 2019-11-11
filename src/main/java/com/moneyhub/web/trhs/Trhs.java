package com.moneyhub.web.trhs;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Trhs {
	private String bsDate,
	tdSeq,
	cusNum,
	seq,
	tdtypCD,
	tdstCD,
	chngCD,
	accNum,
	cntCD,
	excRate;

}
