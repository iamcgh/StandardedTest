package com.sttest.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sttest.beans.Student;
import com.sttest.beans.Teacher;
import com.sttest.service.StudentService;
import com.sttest.service.TeacherService;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ѧ��ע��
		// 1.���ñ��룬���ڽ��������������
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		//HttpSession session = request.getSession();
		//��ȡǰ̨�ύ������
		String type = request.getParameter("type");//��ȡ��¼���ͣ������ж����������͵��û���¼
		if(type.equals("student")) {
			//�����ѧ����¼
			String examNumber = request.getParameter("examNumber");
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String phone = request.getParameter("phone");
			String gender = request.getParameter("gender") == "male"? "��":"Ů";
			/*******************************/
			Student student = new Student(examNumber, name, password, phone, gender);
			StudentService service = new StudentService();
			if(service.rigist(student)) {
				//���ע��ɹ�
				request.setAttribute("regist_info", "success");
			} else {
				request.setAttribute("regist_info", "fail");
				request.getRequestDispatcher("/regist_student.jsp").forward(request, response);
			}
			
		} else if(type.equals("teacher")) {
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			String name = request.getParameter("name");
			String dept = request.getParameter("dept");
			String gender = request.getParameter("gender");
			String phone = request.getParameter("phone");
			/*************************************/
			Teacher teacher = new Teacher(userName, password, name, dept, gender, phone);
			TeacherService service = new TeacherService();
			if(service.regist(teacher)) {
				//���ע��ɹ�
				request.setAttribute("regist_info", "success");
			} else {
				//���ע��ʧ��
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
