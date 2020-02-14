
package com.sttest.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sttest.beans.Student;
import com.sttest.beans.Teacher;
import com.sttest.service.StudentService;
import com.sttest.service.TeacherService;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
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
		// 2.��ȡ���ύ������
		String type = request.getParameter("type");
		System.out.println(type);
		// �ж��û�����
		if (type.equals("student")) {
			String examNumber = request.getParameter("number");
			System.out.println(examNumber);
			String name = request.getParameter("name");
			System.out.println(name);
			String password = request.getParameter("password");
			System.out.println(password);
			// �������ݿ���֤
			StudentService service = new StudentService();
			if (service.login(examNumber, name, password)) {
				// ��¼�ɹ�
				Student student = service.getInfosByExamNumber(examNumber);
				session.setAttribute("user", student);
				response.sendRedirect(request.getContextPath() + "/system_student.jsp");
			} else {
				// ��¼ʧ��
				request.setAttribute("loginError", "�û������������");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}

		} else if (type.equals("teacher")) {
			String userName = request.getParameter("userName");
			System.out.println(userName);
			String password = request.getParameter("teacher_password");
			System.out.println(password);
			//�������ݿ���֤
			TeacherService service = new TeacherService();
			if(service.login(userName,password)) {
				//��¼�ɹ�
				Teacher teacher = service.getTeacherInfosByUserName(userName);
				session.setAttribute("user", teacher);
				response.sendRedirect(request.getContextPath() + "/system_teacher.jsp");
			} else {
				// ��¼ʧ��
				request.setAttribute("loginError", "�û������������");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
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

	// ѧ����¼����
	private boolean studentLogin() {
		return false;
	}

	private boolean teacherLogin() {
		return false;
	}

}
