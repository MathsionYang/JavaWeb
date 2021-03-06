package com.lmonkey.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmonkey.entity.LMONKEYUSER;
import com.lmonkey.service.lmonkeyuserdao;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset =utf-8");
		
		String username = request.getParameter("userName");
		
		String name = request.getParameter("name");
	
		String psd = request.getParameter("passWord");
		String sex = request.getParameter("sex");
		String year = request.getParameter("birthday");
		String email = request.getParameter("email");
		String phone = request.getParameter("phonenumber");
		String useraddress = request.getParameter("address");
		
		LMONKEYUSER u = new LMONKEYUSER(username,name,psd,sex,year,null,email,phone,useraddress,1);
		
		 int count = lmonkeyuserdao.insert(u);
		 

		if(count>0){
			response.sendRedirect("login.jsp");
		}
		else{
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('注册失败');");
			out.write("location.href = 'reg.jsp';");
			out.write("</script>");
			
		}
	}
	
}
