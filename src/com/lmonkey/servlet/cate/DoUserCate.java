package com.lmonkey.servlet.cate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmonkey.entity.LMONKEYUSER;
import com.lmonkey.entity.LmonkeyCate;
import com.lmonkey.service.lmonkey_categorydao;
import com.lmonkey.service.lmonkeyuserdao;

/**
 * Servlet implementation class DoUserCate
 */
@WebServlet("/manage/admin_docateadd")
public class DoUserCate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoUserCate() {
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
		String name = request.getParameter("className");
		
		
		
		LmonkeyCate cate = new LmonkeyCate(0,name,fid);
		
		 int count = lmonkey_categorydao.insert(cate);
		

		if(count>0){
			response.sendRedirect("admin_cateservlet");
		}
		else{
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alter('添加失败')");
			out.write("location.href = 'manage/admin_useradd.jsp'");
			out.write("</script>");
			
		}
	}

}
