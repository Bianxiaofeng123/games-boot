package com.games.world.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.ResultSetMetaData;

public class JDBCUtils {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List resultSetToList(ResultSet rs) throws java.sql.SQLException {
		List list = new ArrayList();
		do {
			ResultSetMetaData md = (ResultSetMetaData) rs.getMetaData(); // 得到结果集(rs)的结构信息，比如字段数、字段名等
			int columnCount = md.getColumnCount(); // 返回此 ResultSet 对象中的列数
			Map rowData = new HashMap();
			while (rs.next()) {
				rowData = new HashMap(columnCount);
				for (int i = 1; i <= columnCount; i++) {
					rowData.put(md.getColumnName(i), rs.getObject(i));
				}
				list.add(rowData);
				System.out.println("list:" + list.toString());
			}
		} while (rs.next());
		return list;
	}

	public static Map<String, Object> resultSetToMap(ResultSet rs) throws java.sql.SQLException {
		Map<String, Object> hm = new HashMap<String, Object>();
		do {
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				String key = rsmd.getColumnLabel(i);
				String value = rs.getString(i);
				hm.put(key, value);
			}
		} while (rs.next());
		return hm;
	}

}
