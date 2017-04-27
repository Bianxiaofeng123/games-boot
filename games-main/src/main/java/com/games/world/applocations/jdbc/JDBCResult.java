package com.games.world.applocations.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.games.world.util.JDBCUtils;

public class JDBCResult {
	/**
	 * 结果集List
	 * 
	 * @param sql
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<Map<String, Object>> jdbcList(String sql) {
		System.out.println(sql);
		DBHelper db1 = new DBHelper(sql);// 创建DBHelper对象
		try {
			ResultSet ret = db1.pst.executeQuery();// 执行语句，得到结果集
			List<Map<String, Object>> list =JDBCUtils.resultSetToList(ret);
			ret.close();
			db1.close();// 关闭连接
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 结果集List
	 * 
	 * @param sql
	 * @return
	 */
	public static Map<String, Object> jdbcMap(String sql) {
		DBHelper db1 = new DBHelper(sql);// 创建DBHelper对象
		try {
			ResultSet ret = db1.pst.executeQuery();// 执行语句，得到结果集
			Map<String, Object> map = JDBCUtils.resultSetToMap(ret);
			ret.close();
			db1.close();// 关闭连接
			return map;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
