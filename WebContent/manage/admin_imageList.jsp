<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c"  uri= "http://java.sun.com/jsp/jstl/core" %>  
<%@include file = "admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="index.html">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">数据管理</span></div>
        </div>

        <div class="result-wrap">
            <form action="/MonkeyShop/manage/admin_douserdel" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="/MonkeyShop/manage/admin_toimagedataadd"><i class="icon-font"></i>新增数据</a>
                       
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                       
                            <th>影像1</th>
                             <th>影像描述</th>
                              <th>影像2</th>
                               <th>影像描述</th>
                                <th>匹配结果</th>
                            <th>操作</th>
                      
                        </tr>
                        <c:forEach var="imagetInfo" items = "${imglist }">
                        <tr>
                        	<td><img src="../imagesUpload/RSimages/${imagetInfo.IMAGE_ONE_FILE}" width="150" height= "150"></td>
                        	<td>${imagetInfo.IMAGE_ONE_DESCRIPTION }</td>
                        	<td><img src="../imagesUpload/RSimages/${imagetInfo.IMAGE_TWO_FILE}" width="150" height= "150"></td>
                        	<td>${imagetInfo.IMAGE_TWO_DESCRIPTION }</td>
                        	<td><img src="../imagesUpload/RSimages/${imagetInfo.IMAGE_RESULT}" width="300" height= "150"></td>
                        	<td>
                        	
                        	<a href="javascript:catedel(${imagetInfo.IMAGE_ID})">删除</a>
                        	</td>
                        </tr>
              			
                        </c:forEach>
                        <script>
                        function catedel(id){
                        	alert(id);
                        	if(confirm("确定删除吗?")){
                        		location.href = "admin_doimagedel?id="+id;
                        	}
                        }
                       
                        </script>
                    </table>
                  <div class="list-page"> 
                                        共 ${tsum_img} 条记录，当前 ${cpage_img}/ ${tpage_img}页
                    <a href="admin_imagestichselect?cp=1${SearchParmas}">首页</a>
                    <a href="admin_imagestichselect?cp=${cpage-1<1?1:cpage-1}${SearchParmas}">上页</a>
                    <a href="admin_imagestichselect?cp=${cpage+1>tpage?tpage:cpage+1}${SearchParmas}">下页</a>
                    <a href="admin_imagestichselect?cp=${tpage}${SearchParmas}">尾页</a>
                    
                    </div>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>