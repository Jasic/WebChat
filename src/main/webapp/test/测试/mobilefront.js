function getCurrentUserId(){
	return getCookie("UID")||-2;
}
/**不太严格的简单判断用户是否登录的方法，服务器ActionFilter每次会更新UID cookie*/
function isLogined() {
	return getCurrentUserId()>0;
}
function getCurrentUserName(loginRequired) {
	return (!loginRequired||isLogined())&&getCookie("UNAME")||"";
}
  
//填充用户登陆栏
function fillLoginPrompt() {
	var _str = __FMT.store_hello ;
	if (!isLogined()) {
		_str=_str+__FMT.store_welcome+__FMT.store_title+'!<a href="'+__ctxPath+'/login.html?continue='+location.href+'">'+__FMT.customer_login+'</a>&nbsp;';
		_str=_str+'<a href="'+__ctxPath+'/customer/register.html">'+__FMT.customer_signup+'</a>';
	} else {
		_str+= '<a href="'+__ctxPath+'/customer/index.html">'+getCookie("UNAME")+'</a>!';
		_str=_str+__FMT.store_welcome+__FMT.store_title+"!";
		_str=_str+'<a href="'+__ctxPath+'/j_acegi_logout">'+__FMT.customer_logout+'</a>';
	}
	if($("loginPromptHolder")!=undefined&&$("loginPromptHolder")!=null)
	$("loginPromptHolder").innerHTML =_str;
}

/*
 * 重置form表单里的元素
 * @param formWrapId 要清里的表单元素外层元素ID，如from的id或div的id（div里面包含有表单元素）
 * @since V3.5
 */
function fnResetForm(formWrapId){
	$j('#'+formWrapId+' :input').each(function() {
			var type = this.type, tag = this.tagName.toLowerCase();
			if (type == 'text' || type == 'password' || tag == 'textarea'){
				this.value = '';
			}else if (type == 'checkbox' || type == 'radio'){
		       this.checked = false;
		    }else if (tag == 'select'){
		        if(this.size && this.size>=2)
		        	this.selectedIndex = -1;
		        else
		        	this.selectedIndex = 0;
		    }
	});
}

/**
 * 返回上一页 
 */
function goBack(){
	var len = history.length;
	if ($j.browser.msie && ($j.browser.version == "6.0")) { 
	    if(len == 0){
			window.location.href = __ctxPath+"/index.html";
		}else{
			history.go(-1);
		}
	}else{
		if(len == 1){
			window.location.href = __ctxPath+"/index.html";
		}else{
			history.go(-1);
		}
	}
} 

//信息提示停留时间
var msgTimeout = 3000;
//错误信息提示停留时间
var errorMsgTimeout = 5000;

//显示提示信息,V3.0及以前版本，isErrMsg参数对应persist, persist代表是否加入最近“浏览历史”
var sysMsgTimeOutHandler;
function sysMsg(sMsg/*String*/,isErrMsg/*Boolean*/) {
	clearTimeout(sysMsgTimeOutHandler);
	$j('#errorMsgBar,#successMsgBar').hide().css('left','40%');
	if(!isErrMsg){
		$j('#errorMsgBar').hide();
		$j('#successMsgBar').empty().append("<p class='cont'>"+sMsg+"</p>").show();
		msgTimeOutHandler = setTimeout(sysMsgFadeOut,msgTimeout);
	}else{
		$j('#successMsgBar').hide();
		$j('#errorMsgBar').empty().append("<p class='cont'>"+sMsg+"</p>").show();
		msgTimeOutHandler = setTimeout(sysMsgFadeOut,errorMsgTimeout);
	}
	
}
function sysMsgFadeOut(){
	$j('#errorMsgBar,#successMsgBar').animate({left: 0, opacity: "hide"},1000);
}
