<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c"  uri= "http://java.sun.com/jsp/jstl/core" %>  
<%@include file = "admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="index.html">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">分类管理</span></div>
        </div>

        <div class="result-wrap">
            <form action="/MonkeyShop/manage/admin_douserdel" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="/MonkeyShop/manage/admin_tocateadd"><i class="icon-font"></i>新增分类</a>
                        <a id="batchDel" href="javascript:delmore('你确定要删除这些用户吗','myform')"><i class="icon-font"></i>批量删除</a>
                       <!--  <a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a> -->
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                          <th>ID</th>
                            <th>分类名称</th>
                            <th>操作</th>
                        </tr>
                        <c:forEach var="cate" items = "${catelist }">
              			<c:if test="${cate.CATE_PARENT_ID==0}">
              				<tr>
              					<td>${cate.CATE_ID }</td>
              					<td>${cate.CATE_NAME }</td>
              					<td><a href="admin_tocateupdate?id=${cate.CATE_ID}">修改</a><a href="javascript:catedel(${cate.CATE_ID})">删除</a></td>	
              				</tr>
              				 <c:forEach var="soncate" items = "${catelist }">
              					<c:if test="${soncate.CATE_PARENT_ID==cate.CATE_ID }">
              				<tr>
              					<td>${soncate.CATE_ID }</td>
              					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;| -${soncate.CATE_NAME }</td>
              					<td><a href="admin_tocateupdate?id=${soncate.CATE_ID}">修改</a><a href="javascript:catedel(${soncate.CATE_ID})">删除</a></td>	
              				</tr>
              					</c:if>
                        </c:forEach>
              			</c:if>
                        </c:forEach>
                        <script>
                        function catedel(id){
                        	if(confirm("确定删除吗?")){
                        		location.href = "admin_docatedel?id="+id;
                        	}
                        }
                       
                        </script>
                    </table>
                    <div class="list-page"> 
                                        共 ${tsum} 条记录，当前 ${cpage}/ ${tpage}页
                    <a href="admin_DoUserSelect?cp=1${SearchParmas}">首页</a>
                    <a href="admin_DoUserSelect?cp=${cpage-1<1?1:cpage-1}${SearchParmas}">上页</a>
                    <a href="admin_DoUserSelect?cp=${cpage+1>tpage?tpage:cpage+1}${SearchParmas}">下页</a>
                    <a href="admin_DoUserSelect?cp=${tpage}${SearchParmas}">尾页</a>
                    
                    </div>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>