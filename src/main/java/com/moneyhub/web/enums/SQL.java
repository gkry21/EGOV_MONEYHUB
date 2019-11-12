package com.moneyhub.web.enums;

public enum SQL {
	CREATE_USER,DROP_USER,CREATE_DB,CREATE_TRADE,CREATE_TRHS;
	@Override
	public String toString() {
		String result= "";
		switch (this) {
		case CREATE_USER :
            result = "CREATE TABLE USER(" +
                    "  CNO       INT            NOT NULL AUTO_INCREMENT ," +
                    "  CEMAIL    VARCHAR(25)    NOT NULL                ," +
                    "  CPWD      VARCHAR(15)    NOT NULL                ," +
                    "  CNAME     VARCHAR(15)    NULL                    ," +
                    "  CSTCD     VARCHAR(10)    NULL                    ," +
                    "  SDATE     VARCHAR(11)    NULL                    ," +
                    "  WDATE     VARCHAR(11)    NULL                    ," +
                    "  CMEM      VARCHAR(15)    NULL                    ," +
                    "  CDATE     VARCHAR(11)    NULL                    ," +
                    "  UMEM      VARCHAR(15)    NULL                    ," +
                    "  UDATE     VARCHAR(11)    NULL                    ," +
                    "  PRIMARY KEY (CNO))";
			break;
		case CREATE_DB:
			result = "CREATE DATABASE EUNJIDB";
			break;
		case CREATE_TRADE:
			result = "CREATE TABLE TRADE(" + 
					"BSDATE VARCHAR(20) PRIMARY KEY," + 
					"TDSEQ VARCHAR(20)," + 
					"CUSNUM VARCHAR(20)," + 
					"SEQ VARCHAR(20)," + 
					"TDTYPCD VARCHAR(20)," + 
					"TDSTCD VARCHAR(20)," + 
					"CHNGCD VARCHAR(20)," + 
					"ACCNUM VARCHAR(20)," + 
					"CNTCD VARCHAR(20)," + 
					"EXCRATE VARCHAR(20))";
			break;
		case CREATE_TRHS:
			result = "CREATE TABLE TRHS(" + 
					"BSDATE VARCHAR(20) PRIMARY KEY," + 
					"TDSEQ VARCHAR(20)," + 
					"CUSNUM VARCHAR(20)," + 
					"SEQ VARCHAR(20)," + 
					"TDTYPCD VARCHAR(20)," + 
					"TDSTCD VARCHAR(20)," + 
					"CHNGCD VARCHAR(20)," + 
					"ACCNUM VARCHAR(20)," + 
					"CNTCD VARCHAR(20)," + 
					"EXCRATE VARCHAR(20))";
			break;

		}
		return result;
	}
}
