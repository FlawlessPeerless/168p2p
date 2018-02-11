package com.magic.szh.cnf_168p2p.util;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * project: CNF_168p2p
 * package: com.magic.szh.cnf_168p2p.util
 * file: NetWork
 * author: admin
 * date: 2018/2/11
 * description: 网络请求
 */

public class NetWork {
    private static RequestQueue mQueue;

    public static RequestQueue getQueue(Context context) {
        if (mQueue == null) mQueue = Volley.newRequestQueue(context);
        return mQueue;
    }

    public static void GET(Context context, String url) {
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("123", response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("123", error.getMessage());
            }
        });
        queue.add(request);
    }
}
