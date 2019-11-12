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

@Component("pager") @Data @Lazy //@Component는  부모에게 있으면 자식에게 자동으로 걸림
public class PageProxy extends Proxy{
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