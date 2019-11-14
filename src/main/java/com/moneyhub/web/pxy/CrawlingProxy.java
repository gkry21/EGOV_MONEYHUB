package com.moneyhub.web.pxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.moneyhub.web.enums.Path;
import com.moneyhub.web.utl.Printer;

@Component("crawler")
public class CrawlingProxy extends Proxy{
	@Autowired Printer printer;
	@Autowired Box<String> box;
	
	public Box<String> choose(Map<?,?> paramMap){//정형화되있지 않은 데이터의 반환
		printer.accept("키 값: "+paramMap.get("site"));
		printer.accept("값: "+paramMap.get("srch"));
		switch (string(paramMap.get("srch"))) {
		case "exratecheck":
			crawling(Path.CRAWLING_TARGET.toString());
			break;
		default:
			crawling("http://"+paramMap.get("site")+"/");
			break;
		}
		return box;
	}
	private void crawling(String url) {
		printer.accept("넘어온 url \n"+url);
		box.clear(); //꼭해야되는거
		try {
			/*Connection.Response response = Jsoup.connect(url)
												.method(Connection.Method.GET)
												.execute();
			Document document = response.parse();
			//String text = document.text();
			String text = document.html();
			printer.accept("===================");
			printer.accept("크롤링한 텍스트\n"+text);
			box.add(text);*/
			Document rawData = Jsoup.connect(url).timeout(10*1000).get();
			Elements artist = rawData.select("tr[class=fx-dis] td");
			List<String> artist2 = new ArrayList<>();
			for(Element e : artist) {
				artist2.add(e.text());
			}
			System.out.println(artist2);
		}catch (Exception e2) {
			e2.printStackTrace();
		}
	}
}