
/**
 * 
 */
function isCustomerBindCheck() {
	$import(["/dwr/interface/bindMobileDwr.js"]);
	var isBind = false;
	bindMobileDwr.getIsBindPhone({callback:function (data) {
		isBind = data
	}, async:false});
	
	return isBind;
}


