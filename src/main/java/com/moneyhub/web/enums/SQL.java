package com.moneyhub.web.enums;

public enum SQL {
	CREATE_USER,DROP_USER,CREATE_DB;
	@Override
	public String toString() {
		String result= "";
		switch (this) {
		case CREATE_USER:
			result = "CREATE TABLE USER()";
			break;
		case DROP_USER:
			result = "DROP TABLE USER";
			break;
		case CREATE_DB:
			result = "CREATE DATABASE MONEYHUBDB";
			break;
		}
		return result;
	}
}
