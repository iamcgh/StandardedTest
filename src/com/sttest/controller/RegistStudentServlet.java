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

		// 1.���ñ��룬���ڽ��������������
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		// HttpSession session = request.getSession();
		// ��ȡǰ̨�ύ������
		// �����ѧ����¼
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
			request.setAttribute("regist_info", "�û����Ѵ���");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		} else {
			if (service.rigist(student)) {
				// ���ע��ɹ�
				request.setAttribute("regist_info", "ע��ɹ�");
				//response.sendRedirect("message.jsp");
				request.getRequestDispatcher("/message.jsp").forward(request, response);
			} else {
				request.setAttribute("regist_info", "ע��ʧ��");
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
