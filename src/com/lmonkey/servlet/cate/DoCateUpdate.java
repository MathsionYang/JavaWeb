package com.lmonkey.servlet.cate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmonkey.entity.LmonkeyCate;
import com.lmonkey.service.lmonkey_categorydao;

/**
 * Servlet implementation class DoCateUpdate
 */
@WebServlet("/manage/admin_docateupdate")
public class DoCateUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoCateUpdate() {
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
		int fid = Integer.parseInt(request.getParameter("parentClass"));
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("className");
		
		
		
		LmonkeyCate cate = new LmonkeyCate(id,name,fid);
		
		 int count = lmonkey_categorydao.update(cate);
		

		if(count>0){
			response.sendRedirect("admin_cateservlet");
		}
		else{
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alter('添加失败')");
			out.write("location.href = 'manage/admin_usermodify.jsp'");
			out.write("</script>");
			
		}
	}

}
