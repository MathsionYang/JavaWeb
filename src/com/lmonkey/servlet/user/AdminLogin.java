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
 * Servlet implementation class AdminLogin
 */
@WebServlet("/manage/adminlogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
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
		System.out.println("ok");
		String username = request.getParameter("userName");
		System.out.println(username);
		String password = request.getParameter("passWord");
		System.out.println(password);
		int count = lmonkeyuserdao.selectByNMandPass(username,password);
		HttpSession session = request.getSession();
		LMONKEYUSER user =  lmonkeyuserdao.selectAdmin(username,password);
		session.setAttribute("isLogin", "1");
		if(count>0){
			if(user.getUSER_STATUS()==2){
				
				
				session.setAttribute("isAdminLogin", "1");
				response.sendRedirect("/MonkeyShop/manage/index.jsp");
			}else{
				response.sendRedirect("/MonkeyShop/index.jsp");
			}
		
			
			
		}else{
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('用户未注册');");
			out.write("location.href = 'admin_login.jsp';");
			out.write("</script>");
			out.close();
			
		}
	}

}
