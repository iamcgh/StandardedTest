package com.sttest.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sttest.beans.Score;
import com.sttest.beans.Student;
import com.sttest.beans.TestPaper;
import com.sttest.service.ScoreService;
import com.sttest.service.TestPaperService;
import com.sttest.utils.ChoiceUtils;
import com.sttest.utils.ReadFileUtils;

/**
 * Servlet implementation class PostAnsServlet
 */
@WebServlet("/PostAnsServlet")
public class PostAnsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostAnsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.���ñ��룬���ڽ��������������
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		int score = 0;
		Object proNum = session.getAttribute("pro_num");
		System.out.println(proNum);
		if (proNum != null) {
			Integer proNumInt = (Integer) proNum;
			double perScore = 100.0 / proNumInt;// ÿ�����
			// 2.��ȡ���ύ������
			List<String> userChoices = new ArrayList<>();
			for (int i = 1; i <= proNumInt; i++) {
				String choice = request.getParameter(i + "");
				if (choice == null)
					choice = "";
				userChoices.add(choice);
				// System.out.println(choice);
			}
			// ��ȡ�����������
			Student student = (Student) session.getAttribute("user");
			String checkFile = (String) session.getAttribute("file");
			
			TestPaper paper = new TestPaperService().getTestPaperByID(checkFile);//
			List<String> realChoice = ReadFileUtils.getAnswer(paper.getPaperName());
			score = GetScore(userChoices, realChoice, perScore);

			// ��ȡ��ǰϵͳʱ��
			Date date = new Date();
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateStr = format.format(date);
			// ��װ����
			Score scoreObj = new Score(student.getExamNumber(), checkFile, dateStr, score + "");

			// �������ݿ�
			ScoreService service = new ScoreService();
			service.addScore(scoreObj);
			System.out.println("��ӳɹ���");
			request.setAttribute("score", score);
			request.getRequestDispatcher("/test_score.jsp").forward(request, response);
		} else {
			Student student = (Student) session.getAttribute("user");
			String checkFile = (String) session.getAttribute("file");
			List<String> realChoice = ReadFileUtils.getAnswer(checkFile);
			score = 0;

			// ��ȡ��ǰϵͳʱ��
			Date date = new Date();
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateStr = format.format(date);
			// ��װ����
			Score scoreObj = new Score(student.getExamNumber(), checkFile, dateStr, score + "");

			// �������ݿ�
			ScoreService service = new ScoreService();
			service.addScore(scoreObj);
			System.out.println("��ӳɹ���");
			request.setAttribute("score", score);
			request.getRequestDispatcher("/test_score.jsp").forward(request, response);
		}

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

	public static int GetScore(List<String> choice, List<String> realChoice, double perScore) {
		int score = 0;
		for (int i = 0; i < choice.size(); i++) {
			if (ChoiceUtils.changeFromNumber(choice.get(i)).equals(realChoice.get(i))) {
				score += perScore;
			}
		}
		return score;
	}

}
