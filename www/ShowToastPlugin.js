var exec = require('cordova/exec');

var showToastPlugin = {};

var showToast_api = function (arg0, success, error) {
    exec(success, error, 'ShowToastPlugin', 'showToast', [arg0]);
};

showToastPlugin.showToast = function(arg){
	showToast_api(arg,function(success){
		console.log("success:" + success);
	},function(error){
		console.log("error:" + error);
	})
};

module.exports = showToastPlugin;