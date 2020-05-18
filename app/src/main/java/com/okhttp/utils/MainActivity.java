package com.okhttp.utils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.fastjson.JSONObject;
import com.okhttp4.JsonGenericsSerializator;
import com.okhttp4.OkHttpUtils;
import com.okhttp4.callback.GenericsCallback;
import com.okhttp4.callback.OnDownloadListener;

import java.io.File;

import okhttp3.Call;
import okhttp3.MediaType;

public class MainActivity extends AppCompatActivity {
    public static MediaType jsonType = MediaType.parse("application/json; charset=utf-8");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void getOkHttp() {
        OkHttpUtils.get().url("")
                .addHeader("app_key", "APP_KEY")
                .addHeader("app_secret", "APP_SECRET")
                .build()
                .execute(new GenericsCallback<String>(new JsonGenericsSerializator()) {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {

                    }
                });
    }

    public void postOkHttp() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", "");
        jsonObject.put("refresh_id", "");
        String jsonData = jsonObject.toJSONString();

        OkHttpUtils.postString().mediaType(jsonType)
                .url("")
                .addHeader("app_key", "APP_KEY")
                .addHeader("app_secret", "APP_SECRET")
                .addHeader("access_token", "access_token")
                .content(jsonData)
                .build()
                .execute(new GenericsCallback<String>(new JsonGenericsSerializator()) {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {

                    }
                });
    }

    public void postOkHttp2() {
        File file = new File("sdcard/d0c/风景.jpg");
        OkHttpUtils.post().url("")
                .addHeader("app_key", "APP_KEY")
                .addHeader("app_secret", "APP_SECRET")
                .addHeader("access_token", "access_token")
                .addParams("name", "name")//数组
                .addParams("position_id", "position_id")
                .addParams("device_id", "device_id")
                .addFile("image", file.getName(), file)
                .build().execute(
                new GenericsCallback<String>(new JsonGenericsSerializator()) {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String regBean, int id) {

                    }
                });
    }

    public void download() {
        String savePath = "sdcard/doc/";
        File saveDir = new File(savePath);
        if (!saveDir.exists()) {
            saveDir.mkdirs();
        }

        OkHttpUtils.getInstance().download("https://p2.ssl.qhimgs1.com/sdr/400__/t016f54160c5c81c652.jpg", new File(savePath + "风景.jpg"), new OnDownloadListener() {
            @Override
            public void onDownloadSuccess(File file) {
            }

            @Override
            public void onDownloading(int progress) {

            }

            @Override
            public void onDownloadFailed() {
            }
        });
    }
}
