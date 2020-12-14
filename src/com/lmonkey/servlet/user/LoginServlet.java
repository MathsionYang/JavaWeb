package com.lmonkey.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lmonkey.entity.LMONKEYUSER;
import com.lmonkey.service.lmonkeyuserdao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset =utf-8");
		
		String username = request.getParameter("userName");
		String password = request.getParameter("passWord");
		
		int count = lmonkeyuserdao.selectByNMandPass(username,password);
		if(count>0){
			HttpSession session = request.getSession();
			LMONKEYUSER user =  lmonkeyuserdao.selectAdmin(username,password);
			session.setAttribute("name", user);
			session.setAttribute("isLogin", "1");
			response.sendRedirect("index.jsp");
		}else{
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('用户未注册');");
			out.write("location.href = 'login.jsp';");
			out.write("</script>");
			
		}
		
	}

}
