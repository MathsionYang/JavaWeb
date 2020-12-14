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
 * Servlet implementation class DoUserDel
 */
@WebServlet("/manage/admin_douserdel")
public class DoUserDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoUserDel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset =utf-8");
		String id = request.getParameter("id");
		
		
		 int count = lmonkeyuserdao.del(id);
		

		if(count>0){
			response.sendRedirect("admin_DoUserSelect?cp="+request.getParameter("cpage"));
		}
		else{
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alter('删除失败')");
			out.write("location.href = 'manage/admin_DoUserSelect?cp="+request.getParameter("cpage")+"'");
			out.write("</script>");
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset =utf-8");
		String ids[]  = request.getParameterValues("id[]");
		
		for(int i=0;i<ids.length;i++){
			lmonkeyuserdao.del(ids[i]);
		}
		
		 
		 
		 response.sendRedirect("/MonkeyShop/manage/admin_DoUserSelect");

	}

}
