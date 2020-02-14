package com.sttest.beans;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem {
	
	private String ans;//答案
	
	private String context;	//问题描述
	
	private ArrayList<String> choice;//问题选项

	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	

	public ArrayList<String> getChoice() {
		return choice;
	}

	public void setChoice(ArrayList<String> choice) {
		this.choice = choice;
	}

	public Problem(String ans, String context, ArrayList<String> choice) {
		super();
		this.ans = ans;
		this.context = context;
		this.choice = choice;
	}

	public Problem() {
		super();
	}

	@Override
	public String toString() {
		return "Problem [ans=" + ans + ", context=" + context + ", choice=" + choice + "]";
	}

	
	

}
