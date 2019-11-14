package com.moneyhub.web.enums;

public enum Path {
	UPLOAD_PATH,CRAWLING_TARGET;
	@Override
	public String toString() {
		String result= "";
		switch (this) {
		case UPLOAD_PATH:
			result = "C:\\Users\\user\\eGovFrameDev-3.8.0-64bit\\workspace\\egovmoneyhub\\src\\main\\webapp\\resources\\upload\\temp";
			break;
		case CRAWLING_TARGET:
			result = "https://kr.fxexchangerate.com/";
			break;
		}
		return result;
	}
	
}
