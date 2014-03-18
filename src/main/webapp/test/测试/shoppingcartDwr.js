
// Provide a default path to dwr.engine
if (dwr == null) var dwr = {};
if (dwr.engine == null) dwr.engine = {};
if (DWREngine == null) var DWREngine = dwr.engine;

if (shoppingcartDwr == null) var shoppingcartDwr = {};
shoppingcartDwr._path = '/m/dwr';
shoppingcartDwr.useCoupon = function(p2, callback) {
  dwr.engine._execute(shoppingcartDwr._path, 'shoppingcartDwr', 'useCoupon', false, false, p2, callback);
}
shoppingcartDwr.setPromoRuleManager = function(p0, callback) {
  dwr.engine._execute(shoppingcartDwr._path, 'shoppingcartDwr', 'setPromoRuleManager', p0, callback);
}
shoppingcartDwr.setProductService = function(p0, callback) {
  dwr.engine._execute(shoppingcartDwr._path, 'shoppingcartDwr', 'setProductService', p0, callback);
}
shoppingcartDwr.setPromoService = function(p0, callback) {
  dwr.engine._execute(shoppingcartDwr._path, 'shoppingcartDwr', 'setPromoService', p0, callback);
}
shoppingcartDwr.setFditemManager = function(p0, callback) {
  dwr.engine._execute(shoppingcartDwr._path, 'shoppingcartDwr', 'setFditemManager', p0, callback);
}
shoppingcartDwr.addProductToCart = function(p2, p3, callback) {
  dwr.engine._execute(shoppingcartDwr._path, 'shoppingcartDwr', 'addProductToCart', false, false, p2, p3, callback);
}
shoppingcartDwr.addMultiFoodToCart = function(p2, p3, p4, callback) {
  dwr.engine._execute(shoppingcartDwr._path, 'shoppingcartDwr', 'addMultiFoodToCart', false, false, p2, p3, p4, callback);
}
shoppingcartDwr.addMultiProductToCart = function(p2, p3, p4, callback) {
  dwr.engine._execute(shoppingcartDwr._path, 'shoppingcartDwr', 'addMultiProductToCart', false, false, p2, p3, p4, callback);
}
shoppingcartDwr.addClientAcount = function(p2, callback) {
  dwr.engine._execute(shoppingcartDwr._path, 'shoppingcartDwr', 'addClientAcount', false, false, p2, callback);
}
shoppingcartDwr.changeQuantitys = function(p2, p3, callback) {
  dwr.engine._execute(shoppingcartDwr._path, 'shoppingcartDwr', 'changeQuantitys', false, false, p2, p3, callback);
}
shoppingcartDwr.changeQuantity = function(p2, p3, callback) {
  dwr.engine._execute(shoppingcartDwr._path, 'shoppingcartDwr', 'changeQuantity', false, false, p2, p3, callback);
}
shoppingcartDwr.addFavoriteProduct = function(p2, callback) {
  dwr.engine._execute(shoppingcartDwr._path, 'shoppingcartDwr', 'addFavoriteProduct', false, false, p2, callback);
}
shoppingcartDwr.deleteFavorite = function(p2, callback) {
  dwr.engine._execute(shoppingcartDwr._path, 'shoppingcartDwr', 'deleteFavorite', false, false, p2, callback);
}
shoppingcartDwr.setShoppingcartManager = function(p0, callback) {
  dwr.engine._execute(shoppingcartDwr._path, 'shoppingcartDwr', 'setShoppingcartManager', p0, callback);
}
shoppingcartDwr.getShoppingcartManager = function(callback) {
  dwr.engine._execute(shoppingcartDwr._path, 'shoppingcartDwr', 'getShoppingcartManager', callback);
}
shoppingcartDwr.delProductItem = function(p2, callback) {
  dwr.engine._execute(shoppingcartDwr._path, 'shoppingcartDwr', 'delProductItem', false, false, p2, callback);
}
shoppingcartDwr.delGiftCertificateItem = function(p2, callback) {
  dwr.engine._execute(shoppingcartDwr._path, 'shoppingcartDwr', 'delGiftCertificateItem', false, false, p2, callback);
}
shoppingcartDwr.clearShoppingcart = function(callback) {
  dwr.engine._execute(shoppingcartDwr._path, 'shoppingcartDwr', 'clearShoppingcart', false, false, callback);
}
shoppingcartDwr.unuseCoupon = function(callback) {
  dwr.engine._execute(shoppingcartDwr._path, 'shoppingcartDwr', 'unuseCoupon', false, false, callback);
}
shoppingcartDwr.getShoppingcartItemCount = function(callback) {
  dwr.engine._execute(shoppingcartDwr._path, 'shoppingcartDwr', 'getShoppingcartItemCount', false, false, callback);
}
shoppingcartDwr.setFavoriteManager = function(p0, callback) {
  dwr.engine._execute(shoppingcartDwr._path, 'shoppingcartDwr', 'setFavoriteManager', p0, callback);
}
shoppingcartDwr.setProductSkuManager = function(p0, callback) {
  dwr.engine._execute(shoppingcartDwr._path, 'shoppingcartDwr', 'setProductSkuManager', p0, callback);
}
shoppingcartDwr.setPromoRuleElementManager = function(p0, callback) {
  dwr.engine._execute(shoppingcartDwr._path, 'shoppingcartDwr', 'setPromoRuleElementManager', p0, callback);
}
shoppingcartDwr.setPromoRuleParameterManager = function(p0, callback) {
  dwr.engine._execute(shoppingcartDwr._path, 'shoppingcartDwr', 'setPromoRuleParameterManager', p0, callback);
}
shoppingcartDwr.getPromoValue = function(callback) {
  dwr.engine._execute(shoppingcartDwr._path, 'shoppingcartDwr', 'getPromoValue', false, false, callback);
}
