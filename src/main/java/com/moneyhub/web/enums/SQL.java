package com.moneyhub.web.enums;

public enum SQL {
	CREATE_DB, CREATE_CUSTOMER, DROP_CUSTOMER, CREATE_EXRATE, CREATE_RECEIVER, CREATE_FEE;
	@Override
	public String toString() {
		String result = "";
		switch(this){
		case CREATE_DB :
			result = "CREATE DATABASE MONEYHUB";
			break;
		
		case CREATE_CUSTOMER :
			result = "CREATE TABLE CUSTOMER\r\n" + 
					"(\r\n" + 
					"  CNO       INT            NOT NULL AUTO_INCREMENT ,\r\n" + 
					"  CEMAIL    VARCHAR(25)    NOT NULL                ,\r\n" + 
					"  CPWD      VARCHAR(15)    NOT NULL                ,\r\n" + 
					"  CNAME     VARCHAR(15)    NULL                    ,\r\n" + 
					"  CSTCD     VARCHAR(10)    NULL                    ,\r\n" + 
					"  SDATE     VARCHAR(11)    NULL                    ,\r\n" + 
					"  WDATE     VARCHAR(11)    NULL                    ,\r\n" + 
					"  CMEM      VARCHAR(15)    NULL                    ,\r\n" + 
					"  CDATE     VARCHAR(11)    NULL                    ,\r\n" + 
					"  UMEM      VARCHAR(15)    NULL                    ,\r\n" + 
					"  UDATE     VARCHAR(11)    NULL                    ,\r\n" + 
					"  PRIMARY KEY (CNO))";
			break;
		case DROP_CUSTOMER :
			result = "DROP TABLE MONEYHUB.CUSTOMER";
			break;
		
		case CREATE_EXRATE :
		result = "create table exrate(\r\n" + 
				"    CCODE int not null auto_increment,\r\n" + 
				"    BSDATE 	VARCHAR(15),\r\n" + 
				"    MBUY 		VARCHAR(10),\r\n" + 
				"    MSELL 		VARCHAR(10),\r\n" + 
				"    REMSEND	VARCHAR(10),\r\n" + 
				"    REMRECEIVE VARCHAR(10),\r\n" + 
				"    TCBUY 		VARCHAR(10),\r\n" + 
				"    FCBSELL	VARCHAR(10),\r\n" + 
				"    BSRATE 	VARCHAR(10),\r\n" + 
				"    BEFCON		 VARCHAR(10),\r\n" + 
				"    EXCOMMISSION VARCHAR(10),\r\n" + 
				"    DOLLARRATE VARCHAR(10),\r\n" + 
				"    PRIMARY KEY (CCODE)\r\n" + 
				")";
		break;
		case CREATE_RECEIVER :
			result = "create table receiver(\r\n" + 
					"    CCODE int not null auto_increment,\r\n" + 
					"    BSDATE 	VARCHAR(15),\r\n" + 
					"    MBUY 		VARCHAR(10),\r\n" + 
					"    MSELL 		VARCHAR(10),\r\n" + 
					"    REMSEND	VARCHAR(10),\r\n" + 
					"    REMRECEIVE VARCHAR(10),\r\n" + 
					"    TCBUY 		VARCHAR(10),\r\n" + 
					"    FCBSELL	VARCHAR(10),\r\n" + 
					"    BSRATE 	VARCHAR(10),\r\n" + 
					"    BEFCON		 VARCHAR(10),\r\n" + 
					"    EXCOMMISSION VARCHAR(10),\r\n" + 
					"    DOLLARRATE VARCHAR(10),\r\n" + 
					"    PRIMARY KEY (CCODE)\r\n" + 
					")";
			break;
		case CREATE_FEE :
			result = "create table fee(\r\n" + 
					"    CCODE int not null auto_increment,\r\n" + 
					"    BSDATE 	VARCHAR(15),\r\n" + 
					"    MBUY 		VARCHAR(10),\r\n" + 
					"    MSELL 		VARCHAR(10),\r\n" + 
					"    REMSEND	VARCHAR(10),\r\n" + 
					"    REMRECEIVE VARCHAR(10),\r\n" + 
					"    TCBUY 		VARCHAR(10),\r\n" + 
					"    FCBSELL	VARCHAR(10),\r\n" + 
					"    BSRATE 	VARCHAR(10),\r\n" + 
					"    BEFCON		 VARCHAR(10),\r\n" + 
					"    EXCOMMISSION VARCHAR(10),\r\n" + 
					"    DOLLARRATE VARCHAR(10),\r\n" + 
					"    PRIMARY KEY (CCODE)\r\n" + 
					")";
			break;
		}
		return result;
	}
}
