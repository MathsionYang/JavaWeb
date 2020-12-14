<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>

      <script src="js/jquery-1.12.4.min.js"></script>
      <script src="js/function.js"></script>
      <style>
      /* 不能为空 */
      .reg p .error{
      	display:inline-block;
      	border:1px soild #ff855a;
      	background-color: #ffe8e0;
      	line-height:25px;
      	padding:0px 20px;
      	margin-left:20px;
      	
      }
      </style>
</head>
<body><!--------------------------------------------->
<div class="reg">
    <form action="register" method="post" onsubmit="return CheckForm(this)"><h1><a href="index.html"><img src="img/temp/logo.png"></a></h1>
       
        <p>用户名：<input type="text" name="userName" value="" onfocus="Focusitem(this)" onblur="CheckItem(this)" placeholder="请输入用户名"><span></span></p>
        <p>姓名：<input type="text" name="name" value="" onfocus="Focusitem(this)" onblur="CheckItem(this)" placeholder="请输入姓名"><span></span></p>
        <p>密码：<input type="text" name="passWord" value="" onfocus="Focusitem(this)" onblur="CheckItem(this)" placeholder="请输入密码"><span></span></p>
           <p>确认密码：<input type="text" name="repassWord" value="" onfocus="Focusitem(this)" onblur="CheckItem(this)" placeholder="请确认密码"><span></span></p>
        <p>
        	<input style="width:15px;height:15px" type="radio" name="sex" value="T" checked="checked" >男 
        	<input style="width:15px;height:15px" type="radio" name="sex" value="F" >女 
        </p>
        <p>出生年月：<input type="text" name="birthday" value=""  placeholder="请输入生日"><span></span></p>
           <p>邮箱：<input type="text" name="email" value="" onfocus="Focusitem(this)" onblur="CheckItem(this)" placeholder="请输入邮箱"><span></span></p>
        <p>电话号码：<input type="text" name="phonenumber" value="" placeholder="请输入电话"><span></span></p>
        <p>收件地址:<input type="text" name="address" value="" onfocus="Focusitem(this)" onblur="CheckItem(this)" placeholder="请输入地址"><span></span></p>
   
        <p>验证码：<input class="code" type="text" name="veryCode" value="" onfocus="Focusitem(this)" onblur="CheckItem(this)" placeholder="验证码">
        <img src="getCode" alt="看不清?" onclick="change(this)"><span></span></p>
        <p><input type="submit" name="" value="注册"></p>
        <p class="txtL txt">完成此注册，即表明您同意了我们的<a href="#">
            <使用条款和隐私策略>
        </a></p>
        <p class="txt"><a href="login.jsp"><span></span>已有账号登录</a></p>
        <!--<a href="#" class="off"><img src="img/temp/off.png"></a>--></form>
</div>
</body>
</html>