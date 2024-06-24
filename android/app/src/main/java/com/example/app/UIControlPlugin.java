package com.example.app;

import android.os.Handler;
import android.util.Log;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "UIControl")
public class UIControlPlugin extends Plugin {

    @PluginMethod()
    public void echo(PluginCall call) {
        String value = call.getString("value");
        Log.d("PLUGIN", value);
        JSObject ret = new JSObject();
        ret.put("value", value);

        MainActivity activity = (MainActivity) getActivity();
        Handler mainHandler = new Handler(getContext().getMainLooper());

        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {
                activity.startOtherMode();

            } // This is your code
        };
        mainHandler.post(myRunnable);

        call.resolve(ret);
    }

}