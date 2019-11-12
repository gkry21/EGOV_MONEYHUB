package com.moneyhub.web.brd;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moneyhub.web.cmm.IConsumer;
import com.moneyhub.web.cmm.ISupplier;
import com.moneyhub.web.pxy.Box;
import com.moneyhub.web.pxy.PageProxy;
import com.moneyhub.web.pxy.Trunk;
import com.moneyhub.web.utl.Printer;


@RestController
@RequestMapping("/articles")
public class ArticleCtrl {
	private static final Logger logger = LoggerFactory.getLogger(ArticleCtrl.class);
	@Autowired Article art;
	@Autowired Printer printer;
	@Autowired ArticleMapper articleMapper;
	@Autowired List<Article> list;
	@Qualifier PageProxy pager;
	@Autowired Trunk<Object> trunk;
	@Autowired Box box;
	
	@PostMapping("/write")
	public Map<?,?> write(@RequestBody Article param){
		param.setBoardType("게시판");
		printer.accept(param.toString());
		IConsumer<Article> c = t -> articleMapper.insertArticle(param);
		c.accept(param);
		ISupplier<String> s=()-> articleMapper.countArticle();
		trunk.put(Arrays.asList("msg", "count"),
				Arrays.asList("SUCCESS",s.get()));
		return trunk.get();
	}
	@GetMapping("/page/{pageNo}/size/{pageSize}")
    public Map<?,?> list(@PathVariable String pageNo,
            @PathVariable String pageSize){
        System.out.println("넘어온 페이지 넘버: "+pageNo);
        pager.setPageNum(pager.integer(pageNo));
        pager.setPageSize(pager.integer(pageSize));
        pager.paging();
        box.clear();
        ISupplier<List<Article>> s =()-> articleMapper.selectAll(pager); 
        printer.accept("해당 페이지 글 목록 \n"+s.get());
        trunk.put(Arrays.asList("articles","pxy"),
        		Arrays.asList(s.get(), pager));
        return trunk.get();
    }
	
	@PutMapping("/update")
	public void update(@RequestBody Article param) {
		IConsumer<Article> c = t-> articleMapper.updateArticle(param);
		c.accept(param);
	}
	@DeleteMapping("/{artseq}")
	public Map<?,?> delete(@PathVariable String artseq, @RequestBody Article param){
		return null;
	}
	@GetMapping("/count")
	public Map<?,?> countArticle(){
		ISupplier<String> s=()-> articleMapper.countArticle();
		printer.accept("카운팅 :" +s.get());
		trunk.put(Arrays.asList("count"), Arrays.asList(s.get()));
		return trunk.get();
	}
	@GetMapping("/")
	public List<Article> list(){
		list.clear();
		ISupplier<List<Article>> s = ()-> articleMapper.selectAll();
		printer.accept("전체 글 목록 \n" +s.get());
		return s.get();
	}
	@GetMapping("/fileupload")
	public void fileUpload() {
		
	}
}