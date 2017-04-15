package com.games.world.util;

public class Numb2CHN {

	static String[] units = { "", "十", "百", "千", "万", "十万", "百万", "千万", "亿", "十亿", "百亿", "千亿", "万亿" };
	static char[] numArray = { '零', '一', '二', '三', '四', '五', '六', '七', '八', '九' };
	static final int max = 90909;
	public static String trans(int d) {
		if (d > max) {
			return "";
		}
		char[] val = String.valueOf(d).toCharArray();
		int len = val.length;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < len; i++) {
			String m = val[i] + "";
			int n = Integer.valueOf(m);
			boolean isZero = n == 0;
			String unit = units[(len - 1) - i];
			if (isZero) {
//				if ('0' == val[i - 1]) {
//					// not need process if the last digital bits is 0
//					continue;
//				} else {
					// no unit for 0
					sb.append(numArray[n]);
//				}
			} else {
				sb.append(numArray[n]);
				sb.append(unit);
			}
		}
		if (sb.indexOf("十") == 1 && sb.toString().startsWith("一")) {
			sb = new StringBuffer(sb.substring(1));
		}
		if(sb.toString().endsWith("零")) {
			sb = new StringBuffer(sb.substring(0, sb.length()-1));
		}
			
//		if (sb.indexOf("T") > 0) {
//			sb = new StringBuffer(sb.toString().replaceAll("T", ""));
//		}
		if (sb.toString().equals("")){
			return "零";
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(trans(1));
		System.out.println(trans(9));
		System.out.println(trans(10));
		System.out.println(trans(11));
		System.out.println(trans(20));
		System.out.println(trans(51));
		System.out.println(trans(99));
		System.out.println(trans(100));
		System.out.println(trans(105));
		System.out.println(trans(90909));
	}

}
