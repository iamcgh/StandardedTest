package com.sttest.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.sttest.beans.Problem;
import com.sttest.beans.TestPaper;
import com.sttest.service.TestPaperService;
import com.sttest.utils.ReadFileUtils;

/**
 * Servlet implementation class GetProblemServlet
 */
@WebServlet("/GetProblemServlet")
public class GetProblemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetProblemServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//用于计算分数
		// 1.设置编码，用于解决中文乱码问题
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		// 2.获取表单提交的数据
		String fileID = request.getParameter("fileID");
		// 调用读取文件
		TestPaperService service = new TestPaperService();
		TestPaper paper = service.getTestPaperByID(fileID);
		session.setAttribute("file", fileID);//name - id
		// String txtContent = ReadFileUtils.readTxt(paper.getPaperName());
		// System.out.println(txtContent);
		List<Problem> res = new ArrayList<>();
		// 获取答案集
		List<String> ansList = ReadFileUtils.getAnswer(paper.getPaperName());
		System.out.println(ansList);
		session.setAttribute("pro_num", ansList.size()); 
		// 获取问题集和选项集
		List<String> contentList = ReadFileUtils.getProblemsAndChoice(paper.getPaperName());
		System.out.println("题目集：" + contentList);
		// 获取问题集
		List<String> proList = new ArrayList<>();
		for (int i = 1; i < contentList.size(); i++) {
			String pro = ReadFileUtils.getProblem(contentList.get(i));
			proList.add(pro);
		}
		System.out.println(proList);
		// List<String> choiceList = new
		ArrayList<ArrayList<String>> choices = new ArrayList<>();
		for (int j = 1; j <= proList.size(); j++) {
			ArrayList<String> choiceList = new ArrayList<>();
			choiceList = (ArrayList<String>) ReadFileUtils.getChoice(contentList.get(j));
			//problem.setChoice(choiceList);
			System.out.println("选项集：" + choiceList);
			choices.add(choiceList);
		}
		
		for (int i = 0; i < ansList.size(); i++) {
			Problem problem = new Problem();
			problem.setAns(ansList.get(i));
			if(proList.size()>=i+1)
				problem.setContext(proList.get(i));
			if(choices.size()>=i+1)
				problem.setChoice(choices.get(i));
			//将对象放置链表中
			res.add(problem);
		}
		
		System.out.println(JSON.toJSON(res));
		PrintWriter out = response.getWriter();
		out.print(JSON.toJSON(res));

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
