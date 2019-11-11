package com.moneyhub.web.pxy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.moneyhub.web.brd.ArticleMapper;
import com.moneyhub.web.cmm.IFunction;
import com.moneyhub.web.cmm.ISupplier;
import com.moneyhub.web.utl.Printer;

import lombok.Data;

@Data @Component @Lazy
public class Proxy {
	private int totalCount,startRow,endRow,
				pageCount,pageNum, pageSize,startPage,endPage,
				blockCount,blockNum,nextBlock, prevBlock;
	
	private boolean existPrev, existNext;
	private String search;
	private final int BLOCK_SIZE = 5;
	private List<Integer> pages;
	@Autowired Printer p;
	@Autowired ArticleMapper articleMapper;
	@SuppressWarnings("unused")
	public void paging() {
		ISupplier<String> s = ()-> articleMapper.countArticle();
		totalCount = Integer.parseInt(s.get());
		pageCount = (totalCount % pageSize !=0)? totalCount/pageSize+1:totalCount/pageSize;
		startRow = (pageNum-1)*pageSize;
		endRow = (pageNum==pageCount)?totalCount-1:startRow+pageSize-1;
		blockCount = (pageCount % BLOCK_SIZE !=0)? pageCount/BLOCK_SIZE+1:pageCount/BLOCK_SIZE;
		blockNum = (pageNum-1)/BLOCK_SIZE;
		startPage = blockNum * BLOCK_SIZE + 1; //(startRow-1)*pageSize+1;
		endPage = ((blockNum + 1) != blockCount) ? startPage + (BLOCK_SIZE - 1) : pageCount;//startRow*pageSize;
		existPrev = (blockNum!=0); // 불린타입에서는 ?이후를 생략가능 맞으면 true, 틀리면 false 
		existNext = (blockNum+1)!=blockCount;
		pages = new ArrayList<>();
		for(int i=startPage;i<=endPage;i++){
			pages.add(i);
		}
		nextBlock = startPage + pageSize;
		prevBlock = startPage - pageSize;
		
//		nextBlock = 0;
		//pageSize*blockSize+1 = blocksize+1
		/**startRow 찾기
		 * 0 =1*5 
		 * 5=2*5
		 * 10=3*5
		 * 15 =4*5 
		 * 20 =5*5  */
//		if() {}else {}
//		for(int i=0;i%5==0;i++) {
//			if(i%5==0){
//				i += startRow;
//			}
//		}
		}
	public int parseInt(String param) {
		Function<String, Integer> f = s -> Integer.parseInt(s);
		return f.apply(param);
	}
	
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
	 public String makeBirthday() {
		 String birthday = "";
	        int[] maxDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	        
	        int iMinMonth = 1;
	        int iMaxMonth = 12;
	        
	        int iRandomMonth = (int)(Math.random() * iMaxMonth - iMinMonth + 1) + iMinMonth;
	        int iRandomDay = (int)(Math.random() * (maxDays[iRandomMonth-1] -2) + 1);
	        
	       return birthday;
	    }
	 public String makeUsername() {
		 List<String> fname = Arrays.asList("김", "이", "박", "최", "정", "강", "조", "윤", "장", "임", "한", "오", "서", "신", "권", "황", "안",
			        "송", "류", "전", "홍", "고", "문", "양", "손", "배", "조", "백", "허", "유", "남", "심", "노", "정", "하", "곽", "성", "차", "주",
			        "우", "구", "신", "임", "나", "전", "민", "유", "진", "지", "엄", "채", "원", "천", "방", "공", "강", "현", "함", "변", "염", "양",
			        "변", "여", "추", "노", "도", "소", "신", "석", "선", "설", "마", "길", "주", "연", "방", "위", "표", "명", "기", "반", "왕", "금",
			        "옥", "육", "인", "맹", "제", "모", "장", "남", "탁", "국", "여", "진", "어", "은", "편", "구", "용");
			    List<String> name = Arrays.asList("가", "강", "건", "경", "고", "관", "광", "구", "규", "근", "기", "길", "나", "남", "노", "누", "다",
			        "단", "달", "담", "대", "덕", "도", "동", "두", "라", "래", "로", "루", "리", "마", "만", "명", "무", "문", "미", "민", "바", "박",
			        "백", "범", "별", "병", "보", "빛", "사", "산", "상", "새", "서", "석", "선", "설", "섭", "성", "세", "소", "솔", "수", "숙", "순",
			        "숭", "슬", "승", "시", "신", "아", "안", "애", "엄", "여", "연", "영", "예", "오", "옥", "완", "요", "용", "우", "원", "월", "위",
			        "유", "윤", "율", "으", "은", "의", "이", "익", "인", "일", "잎", "자", "잔", "장", "재", "전", "정", "제", "조", "종", "주", "준",
			        "중", "지", "진", "찬", "창", "채", "천", "철", "초", "춘", "충", "치", "탐", "태", "택", "판", "하", "한", "해", "혁", "현", "형",
			        "혜", "호", "홍", "화", "환", "회", "효", "훈", "휘", "희", "운", "모", "배", "부", "림", "봉", "혼", "황", "량", "린", "을", "비",
			        "솜", "공", "면", "탁", "온", "디", "항", "후", "려", "균", "묵", "송", "욱", "휴", "언", "령", "섬", "들", "견", "추", "걸", "삼",
			        "열", "웅", "분", "변", "양", "출", "타", "흥", "겸", "곤", "번", "식", "란", "더", "손", "술", "훔", "반", "빈", "실", "직", "흠",
			        "흔", "악", "람", "뜸", "권", "복", "심", "헌", "엽", "학", "개", "롱", "평", "늘", "늬", "랑", "얀", "향", "울", "련");
			    Collections.shuffle(fname);
			    Collections.shuffle(name);
			    String fullname = fname.get(0) + name.get(0) + name.get(1);
			    return fullname;
	 }
	 
	public int random(int a, int b){
		BiFunction<Integer, Integer, Integer> f = (t,u)->(int)(Math.random()*(u-t))+t;
		return f.apply(a, b);
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getEndRow() {
		return endRow;
	}
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getBlockCount() {
		return blockCount;
	}
	public void setBlockCount(int blockCount) {
		this.blockCount = blockCount;
	}
	public int getBlockNum() {
		return blockNum;
	}
	public void setBlockNum(int blockNum) {
		this.blockNum = blockNum;
	}
	public int getNextBlock() {
		return nextBlock;
	}
	public void setNextBlock(int nextBlock) {
		this.nextBlock = nextBlock;
	}
	public int getPrevBlock() {
		return prevBlock;
	}
	public void setPrevBlock(int prevBlock) {
		this.prevBlock = prevBlock;
	}
	public boolean isExistPrev() {
		return existPrev;
	}
	public void setExistPrev(boolean existPrev) {
		this.existPrev = existPrev;
	}
	public boolean isExistNext() {
		return existNext;
	}
	public void setExistNext(boolean existNext) {
		this.existNext = existNext;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public List<Integer> getPages() {
		return pages;
	}
	public void setPages(List<Integer> pages) {
		this.pages = pages;
	}
	public int getBLOCK_SIZE() {
		return BLOCK_SIZE;
	}

	
	
}

//int pageCount = (totalCount % pageSize !=0) ? (totalCount/pageSize)+1 : totalCount/pageSize;