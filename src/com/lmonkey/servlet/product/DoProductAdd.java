package com.lmonkey.servlet.product;




import java.io.File;
import java.io.IOException;


import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;








/*import com.jspsmart.upload.File;*/
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.lmonkey.entity.Lmonkey_product;
import com.lmonkey.service.LMonkeyProductDao;

/**
 * Servlet implementation class DoProductAdd
 */
@WebServlet("/manage/admin_doproductadd")
public class DoProductAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoProductAdd() {
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
		//创建SmartUpload对象
		SmartUpload su = new SmartUpload();
		//初始化
		su.initialize(getServletConfig(), request, response);
		//设置上传文件的最大值
	      su.setMaxFileSize(1024*1024*10);
	      //设置允许上传文件类型
	      su.setAllowedFilesList("jpg,gif,jpeg,png");
	    //指定文件存放位置
	   
	      String t=Thread.currentThread().getContextClassLoader().getResource("").getPath(); 
	      int num=t.indexOf(".metadata");
	      String filePath=t.substring(1,num).replace('/', '\\')+"MonkeyShop\\WebContent\\imagesUpload";
	    
	    //创建文件夹对象（未真正创建文件夹）
	      File file = new File(filePath);
	    //如果指定路径文件夹不存在就创建一个文件夹
	      if(!file.exists()) {
	          file.mkdirs();
	          /*file.createNewFile();//这里的文件对象创建时参数要加上file名*/     
	      }
	      //上传
	      Date d = new Date();
	      String ImgName = null;
	      try {
			su.upload();
			Files fs = su.getFiles();
			com.jspsmart.upload.File file1 = null;
	        for(int i=0;i<fs.getCount();i++ ) {
	            file1 = fs.getFile(i);}
	        long size = fs.getSize();
	        
	        System.out.println(size);
	      
	        file1.saveAs(filePath+"\\"+ d.getTime()+"."+file1.getFileExt());
	        String savePath = filePath+"\\"+ d.getTime()+"."+file1.getFileExt();
	       
	        String temp[] = savePath.split("\\\\");
	        String fileName1 = temp[temp.length - 1];
	        ImgName =fileName1;
			
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alter('添加失败')");
			
			out.write("</script>");
		}
	      Request req1 = su.getRequest();
	      String pname = req1.getParameter("productName");
	      String parentId = req1.getParameter("parentClass");
	 
	      String price = req1.getParameter("productPrice");
	      String desc = req1.getParameter("productDesc");
	      String stock = req1.getParameter("productStock");
	
	      Lmonkey_product prod = new Lmonkey_product(
	    		  0,pname,desc,
	    		  Integer.parseInt(price),
	    		  Integer.parseInt(stock),
	    		  Integer.parseInt(parentId.split("-")[0]),
	    		  Integer.parseInt(parentId.split("-")[1]),
	    		  ImgName);
	      int count = LMonkeyProductDao.insert(prod);
	      if(count>0){
				response.sendRedirect("admin_productselect ");
			}
			else{
				PrintWriter out = response.getWriter();
				out.write("<script>");
				out.write("alter('产品添加失败')");
				out.write("location.href = 'manage/admin_productadd.jsp'");
				out.write("</script>");
				
			}
	}

}
