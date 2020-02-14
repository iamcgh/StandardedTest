package com.sttest.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sttest.beans.Student;
import com.sttest.service.StudentService;

/**
 * Servlet implementation class RegistStudentServlet
 */
@WebServlet("/RegistStudentServlet")
public class RegistStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistStudentServlet() {
		super();
		// TODO Auto-generated constructor stub
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
		// HttpSession session = request.getSession();
		// 获取前台提交的数据
		// 如果是学生登录
		String examNumber = request.getParameter("examNumber");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		/*******************************/
		Student student = new Student(examNumber, name, password, phone, gender);
		StudentService service = new StudentService();
		System.out.println(student);
		if(!service.checkNumber(examNumber)) {
			request.setAttribute("regist_info", "用户名已存在");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		} else {
			if (service.rigist(student)) {
				// 如果注册成功
				request.setAttribute("regist_info", "注册成功");
				//response.sendRedirect("message.jsp");
				request.getRequestDispatcher("/message.jsp").forward(request, response);
			} else {
				request.setAttribute("regist_info", "注册失败");
				request.getRequestDispatcher("/regist_student.jsp").forward(request, response);
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

}
