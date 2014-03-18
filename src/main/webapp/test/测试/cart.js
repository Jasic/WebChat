/**
 * 添加商品进购物车
 * @skuCode			商品的sku code
 * @pSkuCodes		商品相关配件的sku code，每个code用逗号隔开
 * @quantity		加入购物车的数量
 * @callback		操作成功后的回调函数。如果为空即弹出提示框
 */
function addToCart(skuCode, pSkuCodes, quantity, callback) {
	var sourceEvent = getEventSourceObject();	//ajax会改变event对像，所以暂时把它保存起来
	//DWREngine.setAsync(false);
	mask();
	$importDwr(function(){
		shoppingcartDwr.addMultiFoodToCart(skuCode, pSkuCodes, quantity, function(jsonText) {
			var json = eval("(" + jsonText + ")");
			if (json.error != null) {
				if (json.errorMore == "Y") {
					jAlert(json.errorStr);
				} else {
					jAlert(json.error);
					if(json.errorType == "outOfStock"){
						/*if(confirm(__FMT.stockNotify_sign_confirm)){
							window.location = __ctxPath+'/stock-notify/item'+json.productId+'.html?doAction=sign';
						}*/
						//$j("#quantity").focus();
						//$j("#quantity").select();
					}
				}
				unmask();
			} else {
				if ($j.isFunction(callback)) {
					callback(json, sourceEvent);
				} else {
					//window.location = __ctxPath+"/cart/shoppingcart.html"
					//promptCartMessage(json, sourceEvent);
				}
				refreshMinicart();
    		}
			
		})
	})
}

/**
 * 添加商品进购物车
 * @acount			就餐人数
 * @callback		操作成功后的回调函数。如果为空即弹出提示框
 */
function addClientAcount(acount, callback) {
	var sourceEvent = getEventSourceObject();	//ajax会改变event对像，所以暂时把它保存起来
	$importDwr(function(){
		shoppingcartDwr.addClientAcount(acount, function(jsonText) {
			var json = eval("(" + jsonText + ")");
			if (json.error != null){
				if (json.error){
					jAlert(json.error);
				}
			}else{
			    if( callback instanceof Function){
			    	callback();
			    }  
			}
		})
	})
}


/**
 * 添加普通商品进收藏夹
 * @productId		商品的id
 * @callback		操作成功后的回调函数。如果为空即弹出提示框
 */
function addFavoriteProduct(productId, callback) {
	var sourceEvent = getEventSourceObject();	//ajax会改变event对像，所以暂时把它保存起来
	//DWREngine.setAsync(false);
	if(!confirm("你确定要加入收藏夹吗？")){
		return false;
	}
	$importDwr(function(){
		shoppingcartDwr.addFavoriteProduct(productId, null, function(jsonText) {
			var json = eval("(" + jsonText + ")");
			if (json.error != null) {
				jAlert(json.error);
			} else {
				if ($j.isFunction(callback)) {
					callback(json, sourceEvent);
				} else {
					jAlert("收藏成功");
					//promptFavoriteMessage(json, sourceEvent);
    			}
			}
		})
	})
}

/**
 * 删除收藏夹中的商品
 * @productId		商品的id
 * @callback		操作成功后的回调函数。如果为空即弹出提示框
 */
function deleteFavorite(favoriteId, callback) {
	var sourceEvent = getEventSourceObject();	//ajax会改变event对像，所以暂时把它保存起来
	//DWREngine.setAsync(false);
	$importDwr(function(){
		shoppingcartDwr.deleteFavorite(favoriteId, function(jsonText) {
			if ($j.isFunction(callback)) {
				callback();
			} else {
				goToCart();
			}
		})
	})
}

/**
 * 批量更新购物车商品项的购物数量
 * @productSkuCodes	商品的代码数组
 * @quantitys		数量数组
 * @callback		操作成功后的回调函数。
 * @errorCallback	操作失败后的回调函数。
 */
function changeQuantitys(productSkuCodes, quantitys, callback, errorCallback) {
	var sourceEvent = getEventSourceObject();	//ajax会改变event对像，所以暂时把它保存起来
	DWREngine.setAsync(true);
	$importDwr(function(){
		shoppingcartDwr.changeQuantitys(productSkuCodes, quantitys, function(jsonText) {
			var json = eval("(" + jsonText + ")");
			if (json.error != null) {
				jAlert(json.error);
				if(json.errorType == "outOfStock"){
					/*if (json.productId) {
						if(confirm(__FMT.stockNotify_sign_confirm)){
							window.location = __ctxPath+'/stock-notify/item'+json.productId+'.html?doAction=sign';
						}
					}*/
					$j("#"+json.productSkuCode).focus();
					$j("#"+json.productSkuCode).select();
				}
				if(json.errorType == "anonymousException"){
					if(confirm(__FMT.customer_login_prompt)){
						window.location = __ctxPath+'/login.html';
					}
				}
				if ($j.isFunction(errorCallback)) {
					errorCallback();
				}
			} else {
				//succ
				if ($j.isFunction(callback)) {
					callback();
				} 
    		}
		})
	})
}

/**
 * 更新某个购物车Item
 * @param skuCode	更新的skuCode，假如产品没变，则为更新之前的那个sku
 * @param quantity	数量
 */
function changeQuantity(skuCode, quantity, callback){
	var sourceEvent = getEventSourceObject();	//ajax会改变event对像，所以暂时把它保存起来
	mask();
	$importDwr(function(){
	 	shoppingcartDwr.changeQuantity(skuCode, quantity, function(jsonText){
	 		var json = eval("(" + jsonText + ")");
			if (json.error != null) {
				jAlert(json.error);
				if(json.errorType == "outOfStock"){
					/*if(confirm(__FMT.stockNotify_sign_confirm)){
						window.location = __ctxPath+'/stock-notify/item'+json.productId+'.html?doAction=sign';
					}*/
					$j("#"+json.productSkuCode).focus();
					$j("#"+json.productSkuCode).select();
				}
				//$j(sourceEvent).focus();
				//$j(sourceEvent).select();
			} else {
				if ($j.isFunction(callback)) {
					callback(json);
				} else {
					goToCart();
				}
			}
			unmask();
		})
	})
}

/**
 * 删除普通商品项
 * @param skuCode	要删除的商品的sku code
 * @callback		操作成功后的回调函数。
 */
function delProductItem(skuCode, callback) {
	mask();
	$importDwr(function() {
		shoppingcartDwr.delProductItem(skuCode, function(jsonText){
			if ($j.isFunction(callback)) {
				callback();
   			} else {
				goToCart();
			}
			refreshMinicart();
		})
	})
}

/**
 * 删除礼品券项
 * @param shoppingcartItemGcId	要删除礼品券的ID
 * @callback					操作成功后的回调函数。
 */
function delGiftCertificateItem(shoppingcartItemGcId, callback) {
	$importDwr(function(){
		shoppingcartDwr.delGiftCertificateItem(shoppingcartItemGcId, function(jsonText){
			if ($j.isFunction(callback)) {
   				callback();
			} else {
				goToCart();
			}
			refreshMinicart();
		})
	})
}

/**
 * 清空收藏夹
 * @callback		操作成功后的回调函数。
 */
function clearShoppingcart(callback) {
	$importDwr(function() {
		shoppingcartDwr.clearShoppingcart(function(jsonText){
			if ($j.isFunction(callback)) {
				callback();
			} else {
				goToCart();
			}
			refreshMinicart();
   		})
	})
}

//使用优惠券
function useCoupon(couponNo){
	$importDwr(function(){
	    shoppingcartDwr.useCoupon(couponNo, function(jsonText){
			var json = eval("(" + jsonText + ")");
			if (json.error != null) {
				jAlert(json.error);
			} else {
				goToCart();
			}
	    })
	})
}

//撤销优惠券的使用
function unuseCoupon() {
	$importDwr(function(){
		shoppingcartDwr.unuseCoupon(function(jsonText){
			goToCart();
		})
	})
}


function goToCart() {
	window.location.href=__ctxPath+"/cart/shoppingcart.html";
}

/**
 * 添加商品进购物车成功后弹出提示框
 * @jsonMessage		提示信息
 * @event			触发事件。弹出框需要从event对像中取得鼠标的坐标
 */
promptCartMessage = function(jsonMessage, event) {
	$j("#cartMsgDiv").remove();			//先删除元素再创建
	$j("#favoriteMsgDiv").remove();		//删除加入收藏元素
	
	var total = jsonMessage.total == null?
					__defaultCurrencySymbol + '0.00': 
					__defaultCurrencySymbol + jsonMessage.total;
	var itemCount = jsonMessage.itemCount ;
					
	html =	'<div id="cartMsgDiv" style="display:block; position:absolute;">'
		+	'	<div style="display:block" class="zindex_wrap">'
		+	'		<a href="javascript:void(0);" onclick="$j(\'#cartMsgDiv\').hide(\'slow\');" class="close" style="text-decoration:none" title="' + __FMT.button_close + '">&nbsp;&nbsp;&nbsp;&nbsp;</a>'
		+	'		<div id="messageDlgContent" style="display:block">'
		+	'			<h4>' + jsonMessage.message + '</h4>'
		+	'			<p><span>' + __FMT.minicart_cart + __FMT.minicart_totalQuantity + '<b class="price_mini">' + itemCount + '</b>' + __FMT.minicart_unit + __FMT.minicart_product + '</span><span>' + __FMT.minicart_subtotal + '<b class="price_mini">' + total + '</b></span></p>'
		+	'			<a href="javascript:void(0);" onclick="$j(\'#cartMsgDiv\').hide(\'slow\');" class="btn_03" title="' + __FMT.shoppingcart_continueShopping + '">' + __FMT.shoppingcart_continueShopping + '</a>'
		+	'			<a href="' + __ctxPath + '/cart/shoppingcart.html" class="btn_04" title="' +  __FMT.shoppingcart_goToShoppingcart + '">' + __FMT.shoppingcart_goToShoppingcart + '</a>'
		+	'		</div>'
		+	'	</div>'
		+	'</div>';
			     
	var cartMsgDiv = document.createElement("div");	
	cartMsgDiv.innerHTML = html;
	
	if (event == null) {
		event = getEventSourceObject();
	}
	var p = getElementPos(event)
	cartMsgDiv.style.position = "absolute";
	cartMsgDiv.style.top = event.offsetHeight + p.y+5 + 'px';
	var jPopWidth = 353;
	if (document.documentElement.clientWidth - p.x > jPopWidth) {
		cartMsgDiv.style.left = p.x - event.offsetWidth/2 + 'px';
	}else{
		//右边宽度不够
		cartMsgDiv.style.left = p.x - event.offsetWidth/2 - 200 + 'px';
	}
			   
	document.body.appendChild(cartMsgDiv);
	setTimeout(function(){$j("#cartMsgDiv").hide('slow');},10000);
}

/**
 * 添加商品进收藏夹成功后弹出提示框
 * @jsonMessage		提示信息
 * @event			触发事件。弹出框需要从event对像中取得鼠标的坐标
 */
promptFavoriteMessage = function(jsonMessage, event) {
	$j("#favoriteMsgDiv").remove();		//先删除元素再创建
	$j("#cartMsgDiv").remove();			//删除加入购物车元素
	
	html =	'<div id="favoriteMsgDiv" style="display:block; position:absolute;">'
		+	'	<div style="display:block" class="zindex_wrap">'
		+	'		<a href="javascript:void(0);" onclick="$j(\'#favoriteMsgDiv\').hide(\'slow\');" class="close" style="text-decoration:none" title="' + __FMT.button_close + '">&nbsp;&nbsp;&nbsp;&nbsp;</a>'
		+	'		<div id="messageDlgContent" style="display:block">'
		+	'			<h4>' + jsonMessage.message + '</h4>'
		+	'			<p><span>&nbsp;</span></p>'
		+	'			<a href="javascript:void(0);" onclick="$j(\'#favoriteMsgDiv\').hide(\'slow\');" class="btn_03" title="' + __FMT.shoppingcart_continueShopping + '">' + __FMT.shoppingcart_continueShopping + '</a>'
		+	'			<a href="' + __ctxPath + '/customer/csFavorites.html" class="btn_04" title="' + __FMT.shoppingcart_viewFavorite + '">' +  __FMT.shoppingcart_viewFavorite + '</a>'
		+	'		</div>'
		+	'	</div>'
		+	'</div>';
			     
	var favoriteMsgDiv = document.createElement("div");	
	favoriteMsgDiv.innerHTML = html;
	
	if (event == null) {
		event = getEventSourceObject();
	}
	var p = getElementPos(event)
	favoriteMsgDiv.style.position = "absolute";
	favoriteMsgDiv.style.top = event.offsetHeight + p.y+5 + 'px';
	var jPopWidth = 353;
	if (document.documentElement.clientWidth - p.x > jPopWidth) {
		favoriteMsgDiv.style.left = p.x - event.offsetWidth/2 + 'px';
	}else{
		//右边宽度不够
		favoriteMsgDiv.style.left = p.x - event.offsetWidth/2 - 200 + 'px';
	}
			   
	document.body.appendChild(favoriteMsgDiv);
	setTimeout(function(){$j("#favoriteMsgDiv").hide('slow');}, 8000);
}

function refreshMinicart() {
	//$j('#minicartDiv').load(__ctxPath+"/cart/refreshMini/blank.html?doAction=refreshMinicart");
	
	//刷新购物车里商品的总数量
	$importDwr(function() {
		shoppingcartDwr.getShoppingcartItemCount(function(jsonText) {
			var json = eval("(" + jsonText + ")");
			$j("span[name='shoppingcartItemCount']").each(function(){
				$j(this).html(json["shoppingcartItemCount"]+"");
			});
			$j("span[name='shoppingcartTotal']").each(function(){
				$j(this).html(json["shoppingcartTotal"]+"");
			});
			unmask();
		})
	})
}