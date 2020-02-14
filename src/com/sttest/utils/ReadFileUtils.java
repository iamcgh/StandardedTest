package com.sttest.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ReadFileUtils {

	// 获取答案
	public static List<String> getAnswer(String file) {
		String content = readTxt(file);
		List<String> res = new ArrayList<String>();
		if (content != null) {
			String[] ansAndPro = content.split("\\$\\$\\$\\$\\$");// 获取到答案集跟问题集
			String[] ansSet = ansAndPro[0].split("\\%\\%");
			for (int i = 0; i < ansSet.length; i++) {
				if (i == 0)
					res.add(ansSet[i].substring(1));
				else
					res.add(ansSet[i]);
			}
		}
		return res;
	}

	// 获取题目（包括题目和选项）
	public static List<String> getProblemsAndChoice(String file) {
		String content = readTxt(file);
		List<String> res = new ArrayList<String>();
		if (content != null) {
			String[] ansAndPro = content.split("\\$\\$\\$\\$\\$");// 获取到答案集跟问题集
			String[] proSet = null;
			System.out.println(ansAndPro);// test
			if (ansAndPro != null && ansAndPro.length >= 2)
				proSet = ansAndPro[1].split("\\*\\*\\*\\*\\*");
			System.out.println(proSet);// test
			for (String pro : proSet) {
				res.add(pro);
			}
		}
		return res;
	}

	// 获取题目
	public static String getProblem(String pro) {
		String[] res = pro.split("\\$");
		return res == null ? "" : res[0];
		// return res[0];
	}

	// 获取题目选项
	public static List<String> getChoice(String pro) {
		String[] str = pro.split("\\$");
		List<String> res = new ArrayList<>();
		String[] choices = null;
		if (str != null && str.length >= 2)
			choices = str[1].split("\\;");
		for (String choice : choices) {
			res.add(choice);
		}
		return res;
	}

	public static String readTxt(String fileName) {
		try {
			File file = new File(fileName);
			String fileContent = "";
			if (file.isFile() && file.exists()) {
				InputStreamReader reader = new InputStreamReader(new FileInputStream(file), "utf-8");
				BufferedReader br = new BufferedReader(reader);
				String readLine = null;
				while ((readLine = br.readLine()) != null) {
					fileContent += readLine;
				}
			}
			return fileContent;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
