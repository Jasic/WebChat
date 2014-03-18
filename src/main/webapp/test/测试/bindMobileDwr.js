
// Provide a default path to dwr.engine
if (dwr == null) var dwr = {};
if (dwr.engine == null) dwr.engine = {};
if (DWREngine == null) var DWREngine = dwr.engine;

if (bindMobileDwr == null) var bindMobileDwr = {};
bindMobileDwr._path = '/m/dwr';
bindMobileDwr.setSyclientManager = function(p0, callback) {
  dwr.engine._execute(bindMobileDwr._path, 'bindMobileDwr', 'setSyclientManager', p0, callback);
}
bindMobileDwr.getIsBindPhone = function(callback) {
  dwr.engine._execute(bindMobileDwr._path, 'bindMobileDwr', 'getIsBindPhone', false, false, callback);
}
