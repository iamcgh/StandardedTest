package com.sttest.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sttest.beans.Teacher;
import com.sttest.service.TeacherService;

/**
 * Servlet implementation class UpdateTeacherInfoServlet
 */
@WebServlet("/UpdateTeacherInfoServlet")
public class UpdateTeacherInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateTeacherInfoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.设置编码，用于解决中文乱码问题
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		//2.获取提交数据
		String userName = request.getParameter("userName");
		System.out.println(userName);
		String name = request.getParameter("name");
		System.out.println(name);
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		String dept = request.getParameter("dept");
		//获取要更新的教师对象
		TeacherService service = new TeacherService();
		Teacher teacher = service.getTeacherInfosByUserName(userName);
		System.out.println(teacher);
		//进行封装
		teacher.setName(name);
		teacher.setPhone(phone);
		teacher.setGender(gender);
		teacher.setDept(dept);
		//进行更新
		service.updateTeacherInfo(teacher);
		session.setAttribute("user", teacher);
		request.setAttribute("update_info", "更新成功");
		request.getRequestDispatcher("/system_teacher.jsp").forward(request, response);
		
		doGet(request, response);
	}

}
