package com.lmonkey.image;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmonkey.entity.IMAGESTICHING;
import com.lmonkey.entity.LmonkeyCate;
import com.lmonkey.service.IMAGESTICHINGDAO;
import com.lmonkey.service.lmonkey_categorydao;

/**
 * Servlet implementation class ToImageDataAdd
 */
@WebServlet("/manage/admin_toimagedataadd")
public class ToImageDataAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToImageDataAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<IMAGESTICHING> imglist = IMAGESTICHINGDAO.selectAll();
		request.setAttribute("imglist", imglist);
		
		request.getRequestDispatcher("admin_imagedataadd.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
