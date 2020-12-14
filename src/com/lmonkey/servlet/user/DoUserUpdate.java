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
 * Servlet implementation class DoUserUpdate
 */
@WebServlet("/manage/admin_douserupdate")
public class DoUserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoUserUpdate() {
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
		String name = request.getParameter("Name");
		String psd = request.getParameter("password");
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birthday");
		String email = request.getParameter("email");
		String phone = request.getParameter("phonenumber");
		String useraddress = request.getParameter("address");
		String userStatus = request.getParameter("userStatus");
		int status = 1;
		
		if(userStatus !=null){
			status = Integer.parseInt(userStatus);
		}
		
		LMONKEYUSER user = new LMONKEYUSER(username,name,psd,sex,birthday,null,email,phone,useraddress,status);
		
		 int count = lmonkeyuserdao.update(user);
		

		if(count>0){
			response.sendRedirect("admin_DoUserSelect?cp="+request.getParameter("cpage"));
		}
		else{
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alter('修改失败')");
			out.write("location.href = 'manage/admin_touserupdate.jsp?id="+username+"'");
			out.write("</script>");
			
		}
	}

}
