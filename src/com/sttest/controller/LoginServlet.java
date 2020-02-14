
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
		// 1.设置编码，用于解决中文乱码问题
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		// 2.获取表单提交的数据
		String type = request.getParameter("type");
		System.out.println(type);
		// 判断用户类型
		if (type.equals("student")) {
			String examNumber = request.getParameter("number");
			System.out.println(examNumber);
			String name = request.getParameter("name");
			System.out.println(name);
			String password = request.getParameter("password");
			System.out.println(password);
			// 进行数据库验证
			StudentService service = new StudentService();
			if (service.login(examNumber, name, password)) {
				// 登录成功
				Student student = service.getInfosByExamNumber(examNumber);
				session.setAttribute("user", student);
				response.sendRedirect(request.getContextPath() + "/system_student.jsp");
			} else {
				// 登录失败
				request.setAttribute("loginError", "用户名或密码错误");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}

		} else if (type.equals("teacher")) {
			String userName = request.getParameter("userName");
			System.out.println(userName);
			String password = request.getParameter("teacher_password");
			System.out.println(password);
			//进行数据库验证
			TeacherService service = new TeacherService();
			if(service.login(userName,password)) {
				//登录成功
				Teacher teacher = service.getTeacherInfosByUserName(userName);
				session.setAttribute("user", teacher);
				response.sendRedirect(request.getContextPath() + "/system_teacher.jsp");
			} else {
				// 登录失败
				request.setAttribute("loginError", "用户名或密码错误");
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

	// 学生登录函数
	private boolean studentLogin() {
		return false;
	}

	private boolean teacherLogin() {
		return false;
	}

}
