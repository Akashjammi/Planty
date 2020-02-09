package com.planty.app.supportfiles;

import com.android.volley.Request;
import com.planty.app.Constants;
import com.planty.app.network.CustomJsonObjectRequest;
import com.planty.app.network.CustomResponseListener;
import com.planty.app.utils.DataUtils;

import org.json.JSONObject;

import java.util.HashMap;



/**
 * Not used
 */

public class CommonNetwork {

    public static void reportError(final HashMap<String, String> report_error_map) {

        String url = Constants.URL_REPORT_ERROR;
        JSONObject request_obj = DataUtils.convertMapToJsonObj(report_error_map);

        new CustomJsonObjectRequest(null, Request.Method.POST, url, request_obj, new CustomResponseListener() {
            @Override
            public void responseSuccess(JSONObject response) {
            }

            @Override
            public void responseFailure(JSONObject response) {
            }

            @Override
            public void responseError(String message) {
            }
        });

    }




}
