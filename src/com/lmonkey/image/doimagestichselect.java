package com.lmonkey.image;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmonkey.entity.IMAGESTICHING;
import com.lmonkey.entity.Lmonkey_product;
import com.lmonkey.service.IMAGESTICHINGDAO;
import com.lmonkey.service.LMonkeyProductDao;
import com.lmonkey.service.lmonkeyuserdao;

/**
 * Servlet implementation class doimagestichselect
 */
@WebServlet("/manage/admin_imagestichselect")
public class doimagestichselect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doimagestichselect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int cpage =1;
		int count = 5;
		//获取用户指定页面
		String cp = request.getParameter("cp");
		int arr[] = IMAGESTICHINGDAO.totalPage(count);
		ArrayList<IMAGESTICHING> imglist = IMAGESTICHINGDAO.selectAll();
		request.setAttribute("imglist", imglist);
		request.setAttribute("tsum", arr[0]);
		request.setAttribute("tpage", arr[1]);
		request.setAttribute("cpage", cpage);
		request.getRequestDispatcher("admin_imageList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
