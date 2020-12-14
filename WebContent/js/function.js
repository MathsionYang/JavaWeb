function change(img){

	img.src="getCode?"+new Date().getTime();

}
var flag =true;
function Focusitem(obj){
	if($(obj).attr('name')=='veryCode'){
		$(obj).next().next().html('').removeClass('error');
	}
	else{
		$(obj).next('span').html('').removeClass('error');
	}
	
}
function CheckItem(obj){
	var msgBox = $(obj).next('span');
	switch($(obj).attr('name'))
	{
	case "userName":
		if(obj.value == ""){
			msgBox.html('用户名不能为空');
			msgBox.addClass('error');
			flag = false;
		}else{
			
			var url ="userNameChecked?name="+encodeURI($(obj).val())+"&"+new Date().getTime();
			
			$.get(url,function(data){
				if(data =="false"){
					msgBox.html('用户名已经存在');
					msgBox.addClass('error');
					flag = false;
				}
				else{
					msgBox.html('').removeClass('error');
					flag = true;
				}
			});
		}
		
		break;
	case "name":
		if(obj.value == ""){
			msgBox.html('姓名不能为空');
			msgBox.addClass('error');
			flag = false;
		}
		break;
	case "passWord":
		if(obj.value == ""){
			msgBox.html('密码不能为空');
			msgBox.addClass('error');
			flag = false;
		}else{
			flag = true;
		}
		break;
	case "repassWord":
		if(obj.value == ""){
			msgBox.html('请再次输入密码');
			msgBox.addClass('error');
		}else if($(obj).val() !=$('input[name="passWord"]').val()){
			msgBox.html('两次输入密码不一致');
			msgBox.addClass('error');
			flag = false;
			
		}else{flag = true;}
		break;
	case "email":
		if(obj.value == ""){
			msgBox.html('邮箱不能为空');
			msgBox.addClass('error');
			flag = false;
		}
		break;
	case "address":
		if(obj.value == ""){
			msgBox.html('地址不能为空');
			msgBox.addClass('error');
			flag = false;
		}
		break;
	case "veryCode":
		var msgBox1 = $(obj).next().next();
		if(obj.value == ""){
			msgBox1.html('验证码不能为空');
			msgBox1.addClass('error');
			flag = false;
		}
		else{
			var url ="checkuserCodeNum?num="+encodeURI($(obj).val())+"&"+new Date().getTime();
			
			$.get(url,function(datanum){
				if(datanum =="false"){
					msgBox1.html('验证码输入错误');
					msgBox1.addClass('error');
					flag = false;
				}
				else{
					msgBox1.html('').removeClass('error');
					flag = true;
				}
			});
		}
		break;
		}
}

function CheckForm(frm){

	var els = frm.getElementsByTagName('input');
	
	 for(var i=0;i<els.length;i++){
		 
		 if(els[i]!=null){
			 if(els[i].getAttribute("onblur")){
				 CheckItem(els[i]);
			 }
		 }
	 }
	 return flag;
}





