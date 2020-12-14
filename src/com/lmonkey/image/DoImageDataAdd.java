package com.lmonkey.image;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.lmonkey.entity.IMAGESTICHING;
import com.lmonkey.entity.Lmonkey_product;
import com.lmonkey.service.IMAGESTICHINGDAO;
import com.lmonkey.service.LMonkeyProductDao;

/**
 * Servlet implementation class DoImageDataAdd
 */
@WebServlet("/manage/admin_doimagedataadd")
public class DoImageDataAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoImageDataAdd() {
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
			      su.setAllowedFilesList("jpg,gif,jpeg,png,tif");
			    //指定文件存放位置
			   
			      String t=Thread.currentThread().getContextClassLoader().getResource("").getPath(); 
			      int num=t.indexOf(".metadata");
			      String filePath=t.substring(1,num).replace('/', '\\')+"MonkeyShop\\WebContent\\imagesUpload\\RSimages";
			      
			    
			    //创建文件夹对象（未真正创建文件夹）
			      File file = new File(filePath);
			    //如果指定路径文件夹不存在就创建一个文件夹
			      if(!file.exists()) {
			          file.mkdirs();
			          /*file.createNewFile();//这里的文件对象创建时参数要加上file名*/     
			      }
			    //上传
			      Date d = new Date();
			      String ImgName1 = null;
			      String ImgName2 = null;
			      String savePath1 =null;
			      String savePath2 =null;
			      String resulFiletName =null;
			      try {
					su.upload();
					Files fs = su.getFiles();
					com.jspsmart.upload.File file1 = null;
					com.jspsmart.upload.File file2 = null;
					 file1 = fs.getFile(0);
					 file2 = fs.getFile(1);
					 
			       
			      
			        file1.saveAs(filePath+"\\"+ d.getTime()+"_1."+file1.getFileExt());
			        savePath1 = filePath+"\\"+ d.getTime()+"_1."+file1.getFileExt();
			       
			        String temp1[] = savePath1.split("\\\\");
			        String fileName1 = temp1[temp1.length - 1];
			        ImgName1 =fileName1;
			        
			        file2.saveAs(filePath+"\\"+ d.getTime()+"_2."+file2.getFileExt());
			        
			        savePath2 = filePath+"\\"+ d.getTime()+"_2."+file2.getFileExt();
			       
			        String temp2[] = savePath2.split("\\\\");
			        String fileName2 = temp2[temp2.length - 1];
			        ImgName2 =fileName2;
			        //组织结果文件名
			        String resultName1 = ImgName1.substring(0,ImgName1.lastIndexOf("."));
			        String resultName2 = ImgName2.substring(0,ImgName2.lastIndexOf("."));
			        String[] strArray = ImgName2.split("\\.");
			        int resultEx = strArray.length -1;
			        
			        resulFiletName =resultName1+"_"+resultName2+"."+file2.getFileExt();
			        
			        System.out.println(resulFiletName);
			        
				} catch (SmartUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					PrintWriter out = response.getWriter();
					out.write("<script>");
					out.write("alter('上传失败')");
					
					out.write("</script>");
				}
			      
			     //传入参数
			      String TXTParm=t.substring(1,num).replace('/', '\\')+"MonkeyShop\\WebContent\\CParmars";
			     try {
			            PrintWriter pw=new PrintWriter(new FileWriter(TXTParm+"\\text.txt"),true);
			            pw.println(savePath1);
			            pw.println(savePath2);
			            pw.flush();
			            pw.close();
			          } 
			     catch (FileNotFoundException fileNotFoundException)
			     {
			            fileNotFoundException.printStackTrace();
			     }
			     //调用C++exe
			   
			     String exepath=t.substring(1,num).replace('/', '\\')+"MonkeyShop\\WebContent\\imagesUpload\\bin\\JAVAC.exe";
			    
			     
			     String[] cmd = {exepath};
			                 
			                 try {
			                	 Runtime.getRuntime().exec(cmd);
			                     System.out.println("done--------------------");
			                  
			                    
			      
			                 } catch (IOException ioException) {
			                     ioException.printStackTrace();
			                 }
			               
			                 
			     
			      Request req1 = su.getRequest();
			      String oneImgDesc = req1.getParameter("oneImgDesc");
			      String twoImgDesc = req1.getParameter("twoImgDesc");
			      String result = resulFiletName ;
			   
			
			      IMAGESTICHING myimg = new IMAGESTICHING(
			    		  0,
			    		  ImgName1,
			    		  oneImgDesc,
			    		  ImgName2,
			    		  twoImgDesc,
			    		  result);
			      
			      int count = IMAGESTICHINGDAO.insert(myimg);
			      
			      if(count>0){
						response.sendRedirect("admin_imagestichselect ");
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
