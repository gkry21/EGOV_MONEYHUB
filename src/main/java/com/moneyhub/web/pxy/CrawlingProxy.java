package com.moneyhub.web.pxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.moneyhub.web.utl.Printer;

@Component("crawler")
public class CrawlingProxy {
	@Autowired Printer p;
	public List<?> crawl(Map<?,?> paramMap){  //정형화되있지 않은 데이터의 반환
		String url = "http://"+paramMap.get("site")+"/";
		p.accept("넘어온 url \n"+url);
		List<String> proxyList = new ArrayList<>();
		proxyList.clear(); //꼭해야되는거
		try {
			Connection.Response response = Jsoup.connect(url)
												.method(Connection.Method.GET)
												.execute();
			Document document = response.parse();
			String text = document.text();
//			String text = document.html();
			p.accept("크롤링한 텍스트\n"+text);
			proxyList.add(text);  //꼭해야되는거
		}catch (Exception e2) {
			e2.printStackTrace();
		}
		return proxyList;  
	}
}
