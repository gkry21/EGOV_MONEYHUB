"use strict"
var adm = adm ||{}
adm = (()=>{
	const WHEN_ERR = 'adm호출하는 js를 찾을 수 없습니다'
	let _ , js , img , css , navi_vue_js;
	let init =()=>{
		_=$.ctx()
		js=$.js()
		img=$.img()
		css=$.css()
		navi_vue_js = js+'/vue/navi_vue.js'
	}
	let onCreate =()=>{
		init()
		$.when(
			$.getScript(navi_vue_js)
			)
		.done(()=>{
			setContentView()
		})
		.fail(()=>{WHEN_ERR})
	}
	let setContentView=()=>{
		$('body').empty()
		.css({'background-color': '#be7a7a'})
		$(navi_vue.nav())
		.appendTo('body')
		$('<table id="tab">'+
				'<tr>'+
				'</tr>'+
		'</table>')
		.css({border:'1px solid black',width: '100%',height:'80%', 'margin':'0 auto'})
		.appendTo('body')
		$.each([{id :'left',widgh: '20%'},
			{id : 'right',widgh:'80%'}],
			(i,j)=>{
			$('<td id="'+j.id+'"></td>')
			.css({border: '2px solid #ddd',width: j.widgh,'vertical-align': 'top'})
			.appendTo('#tab tr')
		})

		$.each([
			 {txt:'웹크롤링',name: 'web_crawl'},
			 {txt:'고객관리',name: 'cust_mgmt'},
			 {txt:'커뮤니티관리',name: 'comm_mgmt'},
			 {txt:'아티클관리',name: 'article_mgmt'},
			 {txt:'상품관리',name: 'item_mod'},
			 {txt:'상품삭제',name: 'item_del'}],
			(i,j)=>{
			$('<div name="'+j.name+'">'+j.txt+'</div>')
			.css({border: '1px solid #ddd', margin: '0 auto ', 'line-height': '50px'})
			.appendTo('#left')
			.click(function(){
				$(this).addClass('active')
				$(this).siblings().removeClass('active')
				switch($(this).attr('name')){
				case 'web_crawl': webCrawl()
				break;
				case 'cust_mgmt': cust_mgmt()
					break;
				case 'comm_mgmt': comm_mgmt()
					break;
				case 'article_mgmt': article_mgmt()
					break;
				case 'item_mod': itemMod()
					break;
				case 'item_del': itemDel()
					break;
				}
		})
		})
		
	}
	let webCrawl=()=>{
        $('#right').empty()
        $('</br></br></br></br></br><h2>Web Crawling</h2></br></br></br></br></br></br></br>'+
                '<form id="crawl_form" class="form-inline my-2 my-lg-0">'+
                '  <select name="site" size="2" multiple>'+
                '  </select>'+
                '<input class="form-control mr-sm-2" value="exratecheck" type="text" placeholder="insert URL for crawling" aria-label="Search">'+
                '</form>')
        .appendTo('#right')
        $('#crawl_form input[class="form-control mr-sm-2"]')
        .css({width:'80%'})
        $.each([{sub:'직접 입력'},{sub:'naver.com'},{sub:'daum.net'},{sub:'google.co.kr'},{sub:'youtube.com'}],(i,j)=>{
            $('<option value='+j.sub+'>'+j.sub+'</option>').appendTo('#crawl_form select')
        })
        $('<button class="btn btn-secondary my-2 my-sm-0" type="submit">go crawl</button>')
        .appendTo('#crawl_form')
        .click(e=>{
            alert(
            $.fn.nullChecker([$('#crawl_form select[name="site"]').val(),
                    $('#crawl_form input[type="text"]').val()])?'빈칸을 채우시오':'보낼준비 완료')
            let url = _+'/tx/crawling/'+$('#crawl_form select[name="site"]').val()
            +'/'+$('#crawl_form input[type="text"]').val()
            alert($('#crawl_form select[name="site"]').val())
            e.preventDefault() // /tx/crawling/google/spring
            $.getJSON(_
                    +'/tx/crawling/'+$('#crawl_form select[name="site"]').val()
                    +'/'+$('form#crawl_form input[type="text"]').val(),
                    d=>{
                alert(d.msg)
            })
        })
    }
	let cust_mgmt=()=>{
	     $('#right').empty()		
		$('<a>고객 테이블 생성</a></br>')
		.appendTo('#right')
		.click(e=>{
			e.preventDefault()
			$.getJSON(_+'/user/create/table',d=>{
				alert('테이블 생성 성공여부 :'+d.msg)
			})
		})
		$('<a>고객테이블 삭제</a></br>')
		.appendTo('#right')
		.click(e=>{
			e.preventDefault()
			$.getJSON(_+'/user/drop/table',d=>{
				alert('일괄등록된 유저의 수 :'+d.userCount)
			})
		})
		$('<a>고객명단 대량 생성</a></br>')
		.appendTo('#right')
		.click(e=>{
			e.preventDefault()
			$.getJSON(_+'/tx/register/users',d=>{
				alert('일괄등록된 유저의 수 :'+d.userCount)
			})
		})
		$('<a>데이터베이스 생성</a></br>')
		.appendTo('#right')
		.click(e=>{
			e.preventDefault()
			$.getJSON(_+'/cmm/create/db',d=>{
				alert('일괄등록된 유저의 수 :'+d.userCount)
			})
		})
		$('<a>거래 생성</a></br>')
		.appendTo('#right')
		.click(e=>{
			e.preventDefault()
			$.getJSON(_+'/trade/create/trade',d=>{
				alert('거래 생성 :'+d.userCount)
			})
		})
		$('<a>거래내역 생성</a></br>')
		.appendTo('#right')
		.click(e=>{
			e.preventDefault()
			$.getJSON(_+'/trhs/create/trhs',d=>{
				alert('거래내역테이블 생성 :'+d.userCount)
			})
		})
		$('<a>거래 삭제</a></br>')
		.appendTo('#right')
		.click(e=>{
			e.preventDefault()
			alert('adm_' +_)
			$.getJSON(_+'/trade/drop/trade',d=>{
				alert('거래내역테이블 삭제 :'+d.map)
			})
		})
	}
	let comm_mgmt=()=>{
		$('#right').empty()
		$('<a>커뮤니티 테이블 생성</a><br/>')
		.appendTo('#right')
		.click(e=>{
			e.preventDefault()
			$.getJSON(_+'/community/create/table',d=>{
				alert('테이블 생성 성공여부 :'+d.msg)
			})
		})
		$('<a>커뮤니티 테이블 삭제</a><br/>')
		.appendTo('#right')
		.click(e=>{
			e.preventDefault()
			$.getJSON(_+'/community/drop/table',d=>{
				alert('테이블 삭제 성공여부 :'+d.msg)
			})
		})
		$('<a>커뮤니티 대량정보 입력</a><br/>')
		.appendTo('#right')
		.click(e=>{
			e.preventDefault()
			$.getJSON(_+'/tx/write/communities',d=>{
				alert('커뮤니티 글 수 :'+d.userCount)
			})
		})
	}
	let article_mgmt=()=>{
		$('#right').empty()
		$('<a>아티클 테이블 생성</a><br/>')
		.appendTo('#right')
		.click(e=>{
			e.preventDefault()
			$.getJSON(_+'/article/create/table',d=>{
				alert('아티클 테이블 생성 성공여부 :'+d.msg)
			})
		})
		$('<a>아티클 테이블 삭제</a><br/>')
		.appendTo('#right')
		.click(e=>{
			e.preventDefault()
			$.getJSON(_+'/article/drop/table',d=>{
				alert('아티클 테이블 삭제 성공여부 :'+d.msg)
			})
		})
		$('<a>아티클 대량정보 입력</a><br/>')
		.appendTo('#right')
		.click(e=>{
			e.preventDefault()
			$.getJSON(_+'/tx/write/articles',d=>{
				alert('아티클 글 수 :'+d.userCount)
			})
		})
	}

	return {onCreate}
})();