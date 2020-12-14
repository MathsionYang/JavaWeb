<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri= "http://java.sun.com/jsp/jstl/core" %> 
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="head">
    <div class="wrapper clearfix">
        <div class="clearfix" id="top"><h1 class="fl"><a href="index.html"><img src="img/logo.png"/></a></h1>
            <div class="fr clearfix" id="top1">
            <p class="fl">
            <c:if test="${isLogin!=1}" >
            	<a href="login.jsp" id="login">登录</a><a href="reg.jsp" id="reg">注册</a>
            	 </c:if>
            	    <c:if test="${isLogin ==1}" >
            	你好：<a href="login.jsp" id="login">${name.USER_NAME }</a>
            	 </c:if>
            </p>
                <form action="#" method="get" class="fl"><input type="text" placeholder="热门搜索：干花花瓶"/><input
                        type="button"/></form>
                <div class="btn fl clearfix"><a href="mygxin.jsp"><img src="img/grzx.png"/></a><a href="#" class="er1"><img
                        src="img/ewm.png"/></a>
                        <c:if test="${isLogin ==1}" >
                        <a href="cart.html"><img src="img/gwc.png"/></a>
                         </c:if>
                    <p><a href="#"><img src="img/smewm.png"/></a></p></div>
            </div>
        </div>
        <ul class="clearfix" id="bott">
            <li><a href="indexselect">首页</a></li>
           
            <c:forEach var="fatherClass" items="${flist}">
            	
              <li><a href="selectproductlist?fid=${fatherClass.CATE_ID}">${fatherClass.CATE_NAME}</a>
                <div class="sList2">
                    <div class="clearfix">
                    <c:forEach var ="childClass" items="${clist }">
                    <c:if test="${fatherClass.CATE_ID == childClass.CATE_PARENT_ID }">  
                    <a href="selectproductList?id=${childClass.CATE_ID}">${childClass.CATE_NAME}</a>
                 	</c:if>
                    </c:forEach>
                    </div>
                </div>
            </li>
            </c:forEach>

    
           
        </ul>
    </div>
</div>