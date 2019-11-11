package com.moneyhub.web.exr;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

@Repository
public interface ExRateMapper {

	public void createExrate(HashMap<String, String> paramMap);
}
