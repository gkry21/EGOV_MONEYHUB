package com.moneyhub.web.trade;

import java.util.HashMap;

public interface TradeMapper {
	public void createTrade(HashMap<String,String> paramMap);
	public void dropTrade(HashMap<String,String> paramMap);
	public int countTrades();
}
