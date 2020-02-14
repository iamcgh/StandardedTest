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
		// 1.���ñ��룬���ڽ��������������
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		// ��ȡ����ֵ
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
			request.setAttribute("regist_info", "�û����Ѵ���");
			response.sendRedirect("message.jsp");
		} else {
			if (service.regist(teacher)) {
				// ���ע��ɹ�
				request.setAttribute("regist_info", "ע��ɹ�");
				response.sendRedirect("message.jsp");
			} else {
				// ���ע��ʧ��
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
