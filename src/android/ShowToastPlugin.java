package com.jamingx.ionicshowtoastplugin;

import android.util.Log;
import android.widget.Toast;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;

public class ShowToastPlugin extends CordovaPlugin {
    private static final String SHOWTOAST = "showToast";

    /**
     * 执行函数，对应js的 cordova.exec() 方法
     * @param action          The action to execute.
     * @param args            The exec() arguments.
     * @param callbackContext The callback context used when calling back into JavaScript.
     * @return
     * @throws JSONException
     */
    @Override
    public boolean execute(final String action, final JSONArray args, CallbackContext callbackContext) throws JSONException {
        Log.e("ShowToastPlugin","ionic 插件");
        if (action.equals(SHOWTOAST)){
            showToast(args.getString(0));
        }
        return super.execute(action, args, callbackContext);
    }
    /**
     * 初始化
     * @param cordova
     * @param webView
     */
    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
    }
    private void showToast(final String text){
        cordova.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(cordova.getContext(),text,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
