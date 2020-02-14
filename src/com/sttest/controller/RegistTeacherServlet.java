package com.sttest.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sttest.beans.Teacher;
import com.sttest.service.TeacherService;

/**
 * Servlet implementation class RegistTeacherServlet
 */
@WebServlet("/RegistTeacherServlet")
public class RegistTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistTeacherServlet() {
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
		// 获取属性值
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String dept = request.getParameter("dept");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		/*************************************/
		Teacher teacher = new Teacher(userName, password, name, dept, gender, phone);
		TeacherService service = new TeacherService();
		if (!service.checkUserName(userName)) {
			request.setAttribute("regist_info", "用户名已存在");
			response.sendRedirect("message.jsp");
		} else {
			if (service.regist(teacher)) {
				// 如果注册成功
				request.setAttribute("regist_info", "注册成功");
				response.sendRedirect("message.jsp");
			} else {
				// 如果注册失败
				request.setAttribute("regist_info", "fail");
				request.getRequestDispatcher("/regist_teacher.jsp").forward(request, response);
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
