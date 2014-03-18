
/* =====================================================================
 * 方法名: mask() 
 * 描述: 显出数据加载中的图标 并且遮住主 窗体  
 * =====================================================================
 */
function mask(msg){
	$j.blockUI(setMaskHTML(msg));
}

/* =====================================================================
 * 方法名: unmask() 
 * 描述: 去除数据加载中的图标  
 * =====================================================================
 */
function unmask(){
	$j.unblockUI();
}

function setMaskHTML(msg){
	var html = '<img style="vertical-align:middle;" src="'+ __ctxPath +'/scripts/plugins/blockUI/themes/loading.gif">';
	return html;
}