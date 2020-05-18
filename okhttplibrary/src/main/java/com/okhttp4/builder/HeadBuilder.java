package com.okhttp4.builder;


import com.okhttp4.OkHttpUtils;
import com.okhttp4.request.OtherRequest;
import com.okhttp4.request.RequestCall;

/**
 * Created by wyu on 16/3/2.
 */
public class HeadBuilder extends GetBuilder
{
    @Override
    public RequestCall build()
    {
        return new OtherRequest(null, null, OkHttpUtils.METHOD.HEAD, url, tag, params, headers,id).build();
    }
}
