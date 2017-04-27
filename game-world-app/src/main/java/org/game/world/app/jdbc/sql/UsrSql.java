package org.game.world.app.jdbc.sql;

public class UsrSql {

	public final static String USR_TABLE = "tellyou.yys_usr";
	public final static String GET_USR_ALL = "select * from tellyou.yys_usr;";

	public static String loginSQL(String Usrname, String Password) {
		StringBuffer sql = new StringBuffer();
		sql.append(" select id ,`name` ");
		sql.append(" from " + USR_TABLE);
		sql.append(" where username='" + Usrname);
		sql.append("'and `password`='" + Password + "'");
		return sql.toString();
	}

	public static String getUsrInfo(String UsrId) {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT i.id ,i.`name`,d.`name` as designationnm , c.careernm ");
		sql.append(" FROM tellyou.usr_info i ");
		sql.append(" LEFT JOIN bas_designation d on d.id=i.designationid and d.delfg='0' ");
		sql.append(" LEFT JOIN bas_career c on c.id=i.career and c.`level`=i.careerlvl ");
		sql.append(" WHERE i.id = '" + UsrId + "'");
		return sql.toString();
	}

}
