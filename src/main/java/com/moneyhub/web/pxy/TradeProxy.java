package com.moneyhub.web.pxy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.moneyhub.web.trade.Trade;
import com.moneyhub.web.trade.TradeMapper;
import com.moneyhub.web.tx.TXMapper;

@Component("tradeProxy")
public class TradeProxy extends Proxy{
    @Autowired TradeMapper tradeMapper;
    @Autowired TXMapper txMapper;
    @Autowired Trade trade;
    
    public String makeAccount() {
        String accountTemp = String.valueOf(Math.random()).substring(2,14);
        String accountNum = accountTemp.substring(0,4)+"-"+accountTemp.substring(4,8)+"-"+accountTemp.substring(8,12);
        return accountNum;
    }
    public String makeNationCod() {
        List<String> Nations = Arrays.asList("01미국", "02중국", "03싱가포르", "04호주", "05영국", "06네팔","07독일", "08프랑스", "09이탈리아", 
        									"10네덜란드", "11포르투갈", "12스페인", "13벨기에");
        Collections.shuffle(Nations);
        String Nation = Nations.get(0);
        return Nation;
    }
    public String AccountCod() {
        List<String> banks = Arrays.asList("01정상", "02정지", "03해지");
        Collections.shuffle(banks);
        String bank = banks.get(0);
        return bank;
    }
    public String makeTdate() {
        int yearFirst = 2010, yearLast = 2019;
        int monthFirst = 1, monthLast = 12;
        int dayFirst = 1;
        yearLast++;
        monthLast++;
        int[] dayLastArray = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int month = (int)(Math.random()*(monthLast - monthFirst))+monthFirst;
        int dayLast = 0;
        for(int i=0; i<dayLastArray.length; i++) {
            if( month == i+1 ) {
                dayLast = dayLastArray[i];
                dayLast++;
            }    
        }
        String date = String.format("%d-%02d-%02d", (int)(Math.random()*(yearLast - yearFirst))+yearFirst,
                                                    month,
                                                    (int)(Math.random()*(dayLast - dayFirst))+dayFirst);
        System.out.println(date);
        return date;
    }
    @Transactional
	public void makeTrades() {
//		String cemail = makeEmail();
//		 
//		if(!existEmail(cemail)) {
//			user.setCemail(cemail);
//			user.setCpwd(makePwd());
//			user.setCname(makeName());
//			user.setCdate(makedate());
//			txMapper.insertUser(user);
//			System.out.println("join 성공");
//		}else {
//			System.out.println("이메일 중복 - join 실패");
//		}
	}
    @Transactional
	public void insertTrades() {
		for(int i = 0; i<500; i++)
			makeTrades();
	}
}
