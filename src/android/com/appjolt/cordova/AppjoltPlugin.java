package com.appjolt.cordova;

import com.appjolt.sdk.Appjolt;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by hagaih on 8/19/15.
 */
public class AppjoltPlugin extends CordovaPlugin {
    public static final String ACTION_UPDATE_USER_SEGMENT = "updateUserSegment";
    public static final String ACTION_ADD_USER_SEGMENT = "addUserSegment";
    public static final String ACTION_REMOVE_USER_SEGMENT = "removeUserSegment";
    public static final String ACTION_CLEAR_USER_SEGMENT = "clearUserSegment";
    public static final String ACTION_IDENTIFY = "identify";
    public static final String ACTION_SHOW_EULA = "showEULA";
    public static final String ACTION_USE_CUSTOM_EULA = "useCustomEULA";
    public static final String ACTION_USER_ACCEPTED_CUSTOM_EULA = "userAcceptedCustomEULA";
    public static final String ACTION_IS_GOOGLE_PLAY_INSTALL = "isGooglePlayInstall";
    public static final String ACTION_SET_INCOGNITO = "setIncognito";


    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals(ACTION_UPDATE_USER_SEGMENT)) {
            Appjolt.updateUserSegment(cordova.getActivity(), args.getString(0));
        } else if (action.equals(ACTION_ADD_USER_SEGMENT)) {
            Appjolt.addUserSegment(cordova.getActivity(), args.getString(0));
        } else if (action.equals(ACTION_REMOVE_USER_SEGMENT)) {
            Appjolt.removeUserSegment(cordova.getActivity(), args.getString(0));
        } else if (action.equals(ACTION_CLEAR_USER_SEGMENT)) {
            Appjolt.clearUserSegment(cordova.getActivity());
        } else if (action.equals(ACTION_IDENTIFY)) {
            Appjolt.identify(cordova.getActivity(), args.getString(0));
        } else if (action.equals(ACTION_SHOW_EULA)) {
            Appjolt.showEULA(cordova.getActivity());
        } else if (action.equals(ACTION_USE_CUSTOM_EULA)) {
            Appjolt.useCustomEULA(cordova.getActivity());
        } else if (action.equals(ACTION_USER_ACCEPTED_CUSTOM_EULA)) {
            Appjolt.userAcceptedCustomEULA(cordova.getActivity());
        } else if (action.equals(ACTION_IS_GOOGLE_PLAY_INSTALL)) {
            return isGooglePlayInstall(callbackContext);
        } else if (action.equals(ACTION_SET_INCOGNITO)) {
            setIncognito(args.getBoolean(0));
        } else {
            callbackContext.error("AppjoltCordova: " + action + " is not supported");
            return false;
        }

        callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK));
        return true;
    }

    @Override
    protected void pluginInitialize() {
        Appjolt.init(cordova.getActivity());
    }

    private boolean isGooglePlayInstall(CallbackContext callbackContext) {
        boolean result = Appjolt.isGooglePlayInstall(cordova.getActivity());
        callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, result));
        return true;
    }

    private void setIncognito(boolean incognito) {
        Appjolt.setCollectIMEI(cordova.getActivity(), !incognito);
        Appjolt.setCollectMACAddress(cordova.getActivity(), !incognito);
        Appjolt.setCollectDeviceID(cordova.getActivity(), !incognito);
    }

}

