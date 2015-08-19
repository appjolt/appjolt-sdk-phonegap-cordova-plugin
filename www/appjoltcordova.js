var cordova = require('cordova');

function AppjoltCordova() {
}


AppjoltCordova.prototype.updateUserSegment = function(userSegment, successCallback, errorCallback) {
	cordova.exec(successCallback, this._getErrorCallback(errorCallback, "updateUserSegment"), "AppjoltPlugin", "updateUserSegment", [userSegment]); 
};

AppjoltCordova.prototype.addUserSegment = function(userSegment, successCallback, errorCallback) {
	cordova.exec(successCallback, this._getErrorCallback(errorCallback, "addUserSegment"), "AppjoltPlugin", "addUserSegment", [userSegment]); 
};

AppjoltCordova.prototype.removeUserSegment = function(userSegment, successCallback, errorCallback) {
	cordova.exec(successCallback, this._getErrorCallback(errorCallback, "removeUserSegment"), "AppjoltPlugin", "removeUserSegment", [userSegment]); 
};

AppjoltCordova.prototype.clearUserSegment = function(successCallback, errorCallback) {
	cordova.exec(successCallback, this._getErrorCallback(errorCallback, "clearUserSegment"), "AppjoltPlugin", "clearUserSegment", []); 
};

AppjoltCordova.prototype.identify = function(identify, successCallback, errorCallback) {
	cordova.exec(successCallback, this._getErrorCallback(errorCallback, "identify"), "AppjoltPlugin", "identify", [identify]); 
};

AppjoltCordova.prototype.showEULA = function(successCallback, errorCallback) {
	cordova.exec(successCallback, this._getErrorCallback(errorCallback, "showEULA"), "AppjoltPlugin", "showEULA", []); 
};

AppjoltCordova.prototype.useCustomEULA = function(successCallback, errorCallback) {
	cordova.exec(successCallback, this._getErrorCallback(errorCallback, "useCustomEULA"), "AppjoltPlugin", "useCustomEULA", []); 
};

AppjoltCordova.prototype.userAcceptedCustomEULA = function(successCallback, errorCallback) {
	cordova.exec(successCallback, this._getErrorCallback(errorCallback, "userAcceptedCustomEULA"), "AppjoltPlugin", "userAcceptedCustomEULA", []); 
};

AppjoltCordova.prototype.isGooglePlayInstall = function(successCallback, errorCallback) {
	cordova.exec(successCallback, this._getErrorCallback(errorCallback, "isGooglePlayInstall"), "AppjoltPlugin", "isGooglePlayInstall", []); 
};

AppjoltCordova.prototype.setIncognito = function(incognito, successCallback, errorCallback) {
	cordova.exec(successCallback, this._getErrorCallback(errorCallback, "setIncognito"), "AppjoltPlugin", "setIncognito", [incognito]); 
};


AppjoltCordova.prototype._getErrorCallback = function (errorCallback, functionName) {
	if (typeof errorCallback === 'function') {
		return errorCallback;
	}
	else {
		return function(result) {
			console.log("AppjoltCordova Error Callback: function " + functionName + " returned: " + JSON.stringify(result));
		}
	}
};

AppjoltCordova.install = function() {
	if (!window.plugins) {
		window.plugins = {};
	}
	
	window.plugins.appjoltcordova = new AppjoltCordova();
	return window.plugins.appjoltcordova;
};

cordova.addConstructor(AppjoltCordova.install);
