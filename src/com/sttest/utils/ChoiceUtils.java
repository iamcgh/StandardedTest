package com.sttest.utils;

public class ChoiceUtils {
	
	public static String changeFromNumber(String i) {
		char[] c = i.toCharArray();
		if(c != null && c.length>0 ) {
			char res = (char) (c[0]+17);
			System.out.println(res);
			return new String(res+"");
		}
		return "";
		
	}
	
	/*public static void main(String[] args) {
		String i = "1";
		System.out.println(changeFromNumber(i));
	}*/

}
