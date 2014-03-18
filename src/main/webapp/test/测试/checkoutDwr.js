
// Provide a default path to dwr.engine
if (dwr == null) var dwr = {};
if (dwr.engine == null) dwr.engine = {};
if (DWREngine == null) var DWREngine = dwr.engine;

if (checkoutDwr == null) var checkoutDwr = {};
checkoutDwr._path = '/m/dwr';
checkoutDwr.cancelOrder = function(p0, callback) {
  dwr.engine._execute(checkoutDwr._path, 'checkoutDwr', 'cancelOrder', p0, false, false, callback);
}
checkoutDwr.setCustomerId = function(p2, callback) {
  dwr.engine._execute(checkoutDwr._path, 'checkoutDwr', 'setCustomerId', false, false, p2, callback);
}
checkoutDwr.setCustomerService = function(p0, callback) {
  dwr.engine._execute(checkoutDwr._path, 'checkoutDwr', 'setCustomerService', p0, callback);
}
checkoutDwr.setSyclientManager = function(p0, callback) {
  dwr.engine._execute(checkoutDwr._path, 'checkoutDwr', 'setSyclientManager', p0, callback);
}
checkoutDwr.setCheckoutService = function(p0, callback) {
  dwr.engine._execute(checkoutDwr._path, 'checkoutDwr', 'setCheckoutService', p0, callback);
}
checkoutDwr.setOritemManager = function(p0, callback) {
  dwr.engine._execute(checkoutDwr._path, 'checkoutDwr', 'setOritemManager', p0, callback);
}
checkoutDwr.setAddressManager = function(p0, callback) {
  dwr.engine._execute(checkoutDwr._path, 'checkoutDwr', 'setAddressManager', p0, callback);
}
checkoutDwr.getConsigneeData = function(callback) {
  dwr.engine._execute(checkoutDwr._path, 'checkoutDwr', 'getConsigneeData', false, false, callback);
}
checkoutDwr.saveConsigneeData = function(p2, callback) {
  dwr.engine._execute(checkoutDwr._path, 'checkoutDwr', 'saveConsigneeData', false, false, p2, callback);
}
checkoutDwr.getVirtualConsigneeData = function(callback) {
  dwr.engine._execute(checkoutDwr._path, 'checkoutDwr', 'getVirtualConsigneeData', false, false, callback);
}
checkoutDwr.saveVirtualConsigneeData = function(p2, callback) {
  dwr.engine._execute(checkoutDwr._path, 'checkoutDwr', 'saveVirtualConsigneeData', false, false, p2, callback);
}
checkoutDwr.applyFavoriteAddress = function(p2, callback) {
  dwr.engine._execute(checkoutDwr._path, 'checkoutDwr', 'applyFavoriteAddress', false, false, p2, callback);
}
checkoutDwr.getPaymentMethodData = function(callback) {
  dwr.engine._execute(checkoutDwr._path, 'checkoutDwr', 'getPaymentMethodData', false, false, callback);
}
checkoutDwr.savePaymentMethodData = function(p2, callback) {
  dwr.engine._execute(checkoutDwr._path, 'checkoutDwr', 'savePaymentMethodData', false, false, p2, callback);
}
checkoutDwr.getRemarkData = function(callback) {
  dwr.engine._execute(checkoutDwr._path, 'checkoutDwr', 'getRemarkData', false, false, callback);
}
checkoutDwr.saveRemarkData = function(p2, callback) {
  dwr.engine._execute(checkoutDwr._path, 'checkoutDwr', 'saveRemarkData', false, false, p2, callback);
}
checkoutDwr.getInvoiceData = function(callback) {
  dwr.engine._execute(checkoutDwr._path, 'checkoutDwr', 'getInvoiceData', false, false, callback);
}
checkoutDwr.saveInvoiceData = function(p2, callback) {
  dwr.engine._execute(checkoutDwr._path, 'checkoutDwr', 'saveInvoiceData', false, false, p2, callback);
}
checkoutDwr.getGiftWrapData = function(callback) {
  dwr.engine._execute(checkoutDwr._path, 'checkoutDwr', 'getGiftWrapData', false, false, callback);
}
checkoutDwr.saveGiftWrapData = function(p2, callback) {
  dwr.engine._execute(checkoutDwr._path, 'checkoutDwr', 'saveGiftWrapData', false, false, p2, callback);
}
checkoutDwr.getGiftCertificatePaymentData = function(callback) {
  dwr.engine._execute(checkoutDwr._path, 'checkoutDwr', 'getGiftCertificatePaymentData', false, false, callback);
}
checkoutDwr.saveGiftCertificatePaymnentData = function(p2, callback) {
  dwr.engine._execute(checkoutDwr._path, 'checkoutDwr', 'saveGiftCertificatePaymnentData', false, false, p2, callback);
}
checkoutDwr.removeGiftCertificate = function(p2, callback) {
  dwr.engine._execute(checkoutDwr._path, 'checkoutDwr', 'removeGiftCertificate', false, false, p2, callback);
}
checkoutDwr.getShopPointPaymentData = function(callback) {
  dwr.engine._execute(checkoutDwr._path, 'checkoutDwr', 'getShopPointPaymentData', false, false, callback);
}
checkoutDwr.saveShopPointPaymentData = function(p2, callback) {
  dwr.engine._execute(checkoutDwr._path, 'checkoutDwr', 'saveShopPointPaymentData', false, false, p2, callback);
}
checkoutDwr.getBillData = function(callback) {
  dwr.engine._execute(checkoutDwr._path, 'checkoutDwr', 'getBillData', false, false, callback);
}
checkoutDwr.saveAllData = function(p2, callback) {
  dwr.engine._execute(checkoutDwr._path, 'checkoutDwr', 'saveAllData', false, false, p2, callback);
}
checkoutDwr.retrieveSelfCollectionCentreList = function(p2, callback) {
  dwr.engine._execute(checkoutDwr._path, 'checkoutDwr', 'retrieveSelfCollectionCentreList', false, false, p2, callback);
}
checkoutDwr.placeOrder = function(callback) {
  dwr.engine._execute(checkoutDwr._path, 'checkoutDwr', 'placeOrder', false, false, callback);
}
checkoutDwr.getMinisterData = function(callback) {
  dwr.engine._execute(checkoutDwr._path, 'checkoutDwr', 'getMinisterData', false, false, callback);
}
checkoutDwr.getFastFoodData = function(callback) {
  dwr.engine._execute(checkoutDwr._path, 'checkoutDwr', 'getFastFoodData', false, false, callback);
}
checkoutDwr.checkValidationCode = function(callback) {
  dwr.engine._execute(checkoutDwr._path, 'checkoutDwr', 'checkValidationCode', callback);
}
checkoutDwr.setGiftCertificateService = function(p0, callback) {
  dwr.engine._execute(checkoutDwr._path, 'checkoutDwr', 'setGiftCertificateService', p0, callback);
}
checkoutDwr.setProductService = function(p0, callback) {
  dwr.engine._execute(checkoutDwr._path, 'checkoutDwr', 'setProductService', p0, callback);
}
checkoutDwr.saveMinisterData = function(p2, callback) {
  dwr.engine._execute(checkoutDwr._path, 'checkoutDwr', 'saveMinisterData', false, false, p2, callback);
}
checkoutDwr.saveFastFoodData = function(p2, callback) {
  dwr.engine._execute(checkoutDwr._path, 'checkoutDwr', 'saveFastFoodData', false, false, p2, callback);
}
