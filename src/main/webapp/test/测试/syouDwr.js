
// Provide a default path to dwr.engine
if (dwr == null) var dwr = {};
if (dwr.engine == null) dwr.engine = {};
if (DWREngine == null) var DWREngine = dwr.engine;

if (syouDwr == null) var syouDwr = {};
syouDwr._path = '/m/dwr';
syouDwr.getShareArgs = function(callback) {
  dwr.engine._execute(syouDwr._path, 'syouDwr', 'getShareArgs', false, false, callback);
}
