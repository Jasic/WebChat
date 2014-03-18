bCancel=false;
var isNeedSuccess = false; //是否需要提示验证成功信息。
/**
 * 支持的验证规则请参考validator-rules.xml。
 * 输入类型：主要是text,textarea,select,radio,checkbox(与radio相同)；后3种都只是支持简单的required检查。
 * 致开发者：支持新的类型，需要一个validateFoo方法，一个__vaMsg.foo信息
 * 致使用者，用法：在需要验证的输入框的validConf字段，设置检查的类型，可用逗号分隔多个，需要参数的用=号，举例validConf="required,integer,maxValue=100,intRange=[0-100],twofield=xxid"；
 * 一般都是由onblur和onsubmit事件自动调用
 * 注意：考虑到排版，输入框等需要有外层的DIV/TD等。
 */

/**为某输入框添加验证，*/
function applyValidate(oField, confs) {
	if (oField == null)
		return;
	if (oField.type=="radio" || oField.type=="checkbox") {
		var radios = document.getElementsByName(oField.name);
		for (var i = 0; i < radios.length; i++) {
			radios[i].onclick = validateEventHandler;
			if (confs) {
				radios[i].setAttribute("validConf", confs || "required");
			}	
		}
	} else {
		oField.onblur = validateEventHandler;
		if (confs) {
			oField.setAttribute("validConf", confs || "required");
		}
	}
}
/**对radio等还未支持*/
function removeValidate(oField) {
	oField.onblur = null;
	oField.removeAttribute("validConf");
}
/**事件处理比较麻烦所以和直接传dom/id的分开处理*/
function validateEventHandler() {
	var eventObj = getEventSourceObject();
	if (eventObj.type=="radio" || eventObj.type=="checkbox") {
		return validateRadio(eventObj);
	}
	return validateField(eventObj);
}
/**本框架最重要的部分，主要是框架用（通过事件触发），对input/select/textarea进行各种验证，同时支持多种类型，支持参数，最后处理错误信息并返回*/
function validateField(field) {
	var errMsg = "";
	var strConfs = field.getAttribute("validConf");
	if (!field || field.disabled || !strConfs) {
		return errMsg;
	}
	var confs = strConfs.split(",");
	var value = field.value;
	for (var i = 0; i < confs.length; i++) {
		var params = "";
		var idx = confs[i].indexOf("=");
		var valType;
		if (idx > 0) {
			valType = confs[i].substring(0, idx);
			params = confs[i].substring(idx + 1, confs[i].length);
		} else {
			valType = confs[i];
		}
		var methodName = "validate" + valType.substring(0, 1).toUpperCase() + valType.substring(1, valType.length);
		if (!eval(methodName).call(this, value, params)) {
			if(errMsg==""){
				//特别注意，和后台框架不一样，由于是在界面显示，故只显示第一种错误提示。
				errMsg += eval("__vaMsg." + valType);
				//mask的校验,不要添加参数到msg中,一般的用户都无法理解正则表达式.
				if (params.length > 0 && methodName != "validateMask" && methodName != "validateTwofields") {
					errMsg += params;
				}
			}	
		}
	}
	return __handleVaErrMsg(field, errMsg);
}
/**验证radio有选择（非空），考虑到性能，应尽量只是在第一个item设置激活验证；验证信息添加在组的最后一个后面；同时也用在checkbox；*/
function validateRadio(radio) {
	var radios = document.getElementsByName(radio.name);
	if (radios && radios.length > 0) {
		var errMsg = __vaMsg.radio;
		for (var i = 0; i < radios.length; i++) {
			if (radios[i].checked) {
				errMsg = "";
			}
		}
		return __handleVaErrMsg(radios[radios.length - 1], errMsg);
	}
	return "";
}
var inputFilter = {button:0, submit:0, reset:0, image:0, file:0};
/**验证form/div里面的所有有效输入框；如果都通过才返回true*/
function validateForm(theForm) {
	if (bCancel) {
		return true;
	}
	var oForm=theForm||document.forms[0];
	var elems = oForm.getElementsByTagName('*');
	var invalidCount = 0;
	var   i=-1;
	for(var elem in elems){
		i++;
		if (!elems[i]||!elems[i].type || elems[i].type in inputFilter||elems[i].disabled) {
			continue;
		}
		//start:前台所有验证field(text or textarea)增加noHtml的验证规则
		var validConf = elems[i].getAttribute("validConf");
		if(elems[i].type == "text" || elems[i].type == "textarea"){
			if(validConf!=null && validConf.trim()!=""){
				elems[i].setAttribute("validConf",validConf+",noHtml");
			}else{
				elems[i].setAttribute("validConf","noHtml");
			}
		}
		//end:前台所有验证field增加noHtml的验证规则
		if (elems[i].type == "radio" || elems[i].type == "checkbox") {
			if (elems[i].getAttribute("validConf") && validateRadio(elems[i]).length > 0) {
				invalidCount++;
			}
		} else {
			if (validateField(elems[i]).length > 0) {
				invalidCount++;
			}
		}
	}   
	return (invalidCount == 0);
}

/**验证form并提示**/
function validateFormWithMsg(theForm){
	if(!validateForm(theForm)){
		alert(__vaMsg.notPass);
		return false;
	}else{
		return true;
	}
}
/**一般由框架调用，自动注册form/div里面的有效的输入框，应该在任何applyValidate前调用*/
function autoApplyValidate(theForm) {
	var oForm = theForm || document.forms[0];
	var elems = oForm.getElementsByTagName('*');
	var   i=-1;
	for(var elem in elems){
		i++;
		if (!elems[i]||!elems[i].type || elems[i].type in inputFilter) {
			continue;
		}
		if (elems[i].getAttribute("validConf")) {
			applyValidate(elems[i]);
		}
	}
}
if(typeof $j =="undefined")
  $j=jQuery.noConflict();
function __handleVaErrMsg(dom, errMsg) {
	var uuid = dom.id==""?dom.name:dom.id;
	var errorObj = $j(dom);
	if (errMsg && errMsg.length > 0){
	    errorObj.addClass("x-form-invalid");
	    $j("#validate_"+uuid).remove();
	    errorObj.parent().append("<div id='validate_"+uuid+"' class='error_txt'>&nbsp;"+errMsg+"</div>");
	}
	else{
	   errorObj.removeClass("x-form-invalid");
	   $j("#validate_"+uuid).remove();
	   if(isNeedSuccess){
	   		var validConf = errorObj.attr("validConf");
			/*if(validConf!=null && validConf.indexOf("required")!=-1){
				//必填项才有验证成功
		   		errorObj.parent().append("<div id='validate_"+uuid+"' class='success_txt'>&nbsp;"+__vaMsg.pass+"</div>");
			}*/
	   }	
	}
	return errMsg;
}

/**defined regular expressions*/
var reNumber = new RegExp("^[\\d]*$");
var reDouble = new RegExp("^[\\d]*(\\.\\d{1,2})?$");
var reDouble4 = new RegExp("^[\\d]*(\\.\\d{1,4})?$");
var rePrice = new RegExp("^[\\d]{1,10}(\\.\\d{1,2})?$");
var reMoney = new RegExp("^[\\d,-]?[\\d]{1,10}(\\.\\d{1,2})?$");


var reEmail = /^([\w-]+)(.[\w-]+)*@([\w-]+\.){1,5}([A-Za-z]){2,4}$/;
//严格匹配 com和cn后缀的邮箱
//var reEmail = /^([\w-]+)(.[\w-]+)*@([\w-]+\.){1,5}(com|cn)$/;
var reCode = new RegExp("^[\\w-\\d]+$");
var reChineseCode = new RegExp("^[\\w-\\d\u4E00-\u9FA5]+$");
var rePhone =/^(([0\+]\d{2,3}-)?(0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/;
var reMobile=/^(13[0-9]|15[0|3|6|7|8|9]|18[0-9])\d{8}$/;
var reUrlRegex = "^((https|http|ftp|rtsp|mms)?://)?" 
     	   + "(([0-9a-zA-Z_!~*'().&=+$%-]+: )?[0-9a-zA-Z_!~*'().&=+$%-]+@)?" //ftp的user@ 
           + "(([0-9]{1,3}\.){3}[0-9]{1,3}" // IP形式的URL- 199.194.52.184 
           + "|" // 允许IP和DOMAIN（域名）
           + "([0-9a-zA-Z_!~*'()-]+\.)*" // 域名- www. 
           + "([0-9a-zA-Z][0-9a-zA-Z-]{0,61})?[0-9a-zA-Z]\." // 二级域名 
           + "[a-zA-Z]{2,6})" // first level domain- .com or .museum 
           + "(:[0-9]{1,5})?" // 端口- :80 
           + "((/?)|" // a slash isn't required if there is no file name 
           + "(/[0-9a-zA-Z_!~*'().;?:@&=+$,%#-]+)+/?)$"; 
var reUrl= new RegExp(reUrlRegex);   

function skipIfEmpty(str) {
	return str == null || str.trim().length == 0;
}
function testRegExp(re, str) {
	return re.test(str);
}
/**defined validation functions*/
function validateRequired(str) {
	return !(str == null || str.trim().length == 0);
}
function validateMinlength(str, minLen) {
	return skipIfEmpty(str) || str.length >= minLen;
}
function validateMaxlength(str, maxLen) {
	return skipIfEmpty(str) || str.length <= maxLen;
}

function validateNumber(str) {
	return skipIfEmpty(str) || testRegExp(reNumber, str);
}
function validateInteger(str) {
	if (skipIfEmpty(str)) return true;
	return validateNumber(str) && validateMaxValue(str, 2147483647);
}
function validatePositiveInteger(str) {
	if (skipIfEmpty(str)) return true;
	return validateNumber(str) && validateMaxValue(str, 2147483647) && validateMinValue(str, 1);
}
function validateShort(str) {
	if (skipIfEmpty(str)) return true;
	return validateNumber(str) && validateMaxValue(str, 32767);
}
function validateDouble(str) {
	return skipIfEmpty(str) || testRegExp(reDouble, str);
}
function validateDouble4(str) {
	return skipIfEmpty(str) || testRegExp(reDouble4, str);
}
function validateMinValue(str, minValue) {
	return skipIfEmpty(str) || (parseFloat(str) >= parseFloat(minValue));
}
function validateMaxValue(str, maxValue) {
	return skipIfEmpty(str) || (parseFloat(str) <= parseFloat(maxValue));
}
function validateIntRange(str, range) {
	if (skipIfEmpty(str)) return true;
	var i_range_min = parseInt(range.substring(1, range.indexOf("-")));
	var i_range_max = parseInt(range.substring(range.indexOf("-")+1,range.indexOf("]")));
	return validateNumber(str) && parseInt(str)>=i_range_min && parseInt(str) <= i_range_max;
}
function validateFloatRange(str, range) {
	if (skipIfEmpty(str)) return true;
	var f_range_min = parseFloat(range.substring(1, range.indexOf("-")));
	var f_range_max = parseFloat(range.substring(range.indexOf("-")+1,range.indexOf("]")));
	return parseFloat(str) >= f_range_min && parseFloat(str) <= f_range_max;
}
function validatePrice(str) {
	return skipIfEmpty(str) || testRegExp(rePrice, str);
}
function validateMoney(str) {
	return skipIfEmpty(str) || testRegExp(reMoney, str);
}


function validateCode(str) {
	return skipIfEmpty(str) || testRegExp(reCode, str);
}
function validateChineseCode(str) {
	return skipIfEmpty(str) || testRegExp(reChineseCode, str);
}
function validateNoHtml(str) {
	return (str.indexOf("<")==-1 && str.indexOf("<")==-1);
}
function validatePhone(str) {
	return skipIfEmpty(str) || testRegExp(rePhone, str);
}
function validateMobile(str) {
	return skipIfEmpty(str) || testRegExp(reMobile, str);
}
function validateEmail(str) {
	if (skipIfEmpty(str)) return true;
	return testRegExp(reEmail, str) && validateMaxlength(str, 128);
}
function validateUrl(str){
	return skipIfEmpty(str) || testRegExp(reUrl,str);
}
function validateDate(str) {
	if (skipIfEmpty(str)) return true;
	if (str.length != __defDatePattern.length) return false;	
	var validateDate_yyyy = str.substr(__defDatePattern.indexOf("yyyy"), 4);
	var validateDate_MM = str.substr(__defDatePattern.indexOf("MM"), 2);
	var validateDate_dd = str.substr(__defDatePattern.indexOf("dd"), 2);
	var validateDate_date = new Date(validateDate_yyyy,validateDate_MM-1,validateDate_dd);
	if ((new Number(validateDate_dd)).valueOf() == validateDate_date.getDate() 
	 && (new Number(validateDate_MM)).valueOf() == (validateDate_date.getMonth()+1) 
	 && validateDate_yyyy == validateDate_date.getFullYear())
	{
		return true;
	}
	return false;
}
function validateMask(str, mask){
	return skipIfEmpty(str) || testRegExp(new RegExp(mask),str);
}
function validateTwofields(value, comparedFieldId) {
	return (value == $j("#" + comparedFieldId).val());
}
function validateUserName(str){
	return testRegExp(reCode, str) || testRegExp(reEmail, str);
}