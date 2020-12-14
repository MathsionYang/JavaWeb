package com.lmonkey.servlet.home;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmonkey.entity.LmonkeyCate;
import com.lmonkey.service.lmonkey_categorydao;

/**
 * Servlet implementation class SelectProductList
 */
@WebServlet("/selectproductlist")
public class SelectProductList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectProductList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 ArrayList<LmonkeyCate>	flist =lmonkey_categorydao.selectCate("father");
		 request.setAttribute("flist", flist);
		    
		 ArrayList<LmonkeyCate>	clist =lmonkey_categorydao.selectCate("child");
		 request.setAttribute("clist", clist);
		 
		 String fid =request.getParameter("fid");
		 String cid =request.getParameter("cid");
		 int id =0;
		 if(fid!=null){
			 id = Integer.parseInt(fid);
		 }
		 if(cid!=null){
			 id = Integer.parseInt(cid);
		 }
		request.setAttribute("title", lmonkey_categorydao.selectById(id).getCATE_NAME()); 
	     request.getRequestDispatcher("product.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
