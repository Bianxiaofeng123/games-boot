package com.games.world.applocations.sql;

public  class UsrSql {
	
	public final static String USR_TABLE ="tellyou.yys_usr";
	public final static String GET_USR_ALL ="select * from tellyou.yys_usr;";
	
	public static String loginSQL(String Usrname,String Password) {
		return "select `name` from " + USR_TABLE + " where username='" + Usrname + "' and `password`='" + Password + "'";

	}
}
