package com.lmonkey.servlet.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmonkey.entity.LMONKEYUSER;
import com.lmonkey.service.lmonkeyuserdao;

/**
 * Servlet implementation class DoUserSelect
 */
@WebServlet("/manage/admin_DoUserSelect")
public class DoUserSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoUserSelect() {
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
		//接受用户搜索的关键字
		String keyword = request.getParameter("keywords");
		
		if(cp!=null){
			cpage = Integer.parseInt(cp);
		}
		int arr[] = lmonkeyuserdao.totalPage(count,keyword);
		
		//获取用户记录
	ArrayList<LMONKEYUSER> list=	lmonkeyuserdao.selectAll(cpage,count,keyword); 
	//放到请求对象里面
	request.setAttribute("userList", list);
	request.setAttribute("tsum", arr[0]);
	request.setAttribute("tpage", arr[1]);
	request.setAttribute("cpage", cpage);
	if(keyword!=null){
		request.setAttribute("SearchParmas", "%keywords="+keyword);
	}
	request.getRequestDispatcher("admin_user.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
