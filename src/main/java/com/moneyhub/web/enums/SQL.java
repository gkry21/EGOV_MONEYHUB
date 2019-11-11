package com.moneyhub.web.enums;

public enum SQL {
	CREATE_USER,DROP_USER,CREATE_DB,CREATE_TRADE,CREATE_TRHS;
	@Override
	public String toString() {
		String result= "";
		switch (this) {
		case DROP_USER:
			result = "DROP TABLE USER";
			break;
		case CREATE_DB:
			result = "CREATE DATABASE MONEYHUBDB";
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
