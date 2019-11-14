package com.moneyhub.web.trade;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Trade {
	private String bsDate,
	tdSeq,
	cusNum,
	seq,
	tdTypCD,
	tdstCD,
	chngCD,
	accNum,
	cntCD,
	excRate,
	cMem,
	cDate,
	uMem,
	uDate;
}
