package com.games.world.util;

import freemarker.template.Configuration;  
import freemarker.template.Template;
import java.io.BufferedWriter;
import java.io.Writer;
import java.util.Map;

public  class FreemarkerUtil {
	private  Configuration configuration = null;

	/**
	 * 构造方法
	 */
	public FreemarkerUtil() {
		configuration = new Configuration(Configuration.VERSION_2_3_23); // 这里Configurantion对象不能有两个，否则多线程访问会报错
		configuration.setDefaultEncoding("utf-8");
	}
	
	public  synchronized void process(String path, String template, Map<String, Object> dataMap, Writer out) {
		
		try {
			configuration.setClassForTemplateLoading(FreemarkerUtil.class, path);
			Template t = configuration.getTemplate(template);
			Writer w = new BufferedWriter(out);
			t.process(dataMap, out);
			w.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
