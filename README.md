# OkHttpUtils
 基于OkHttp4.2.0的封装类


# Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:
```java
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

# Step 2. Add the dependency
```java
	dependencies {
	        implementation 'com.github.wy749814530:OkHttpUtils:Tag'
	}
```

# Step 3 How to use?

## GET Method
```java
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
```
## POST Method
```java
MediaType jsonType = MediaType.parse("application/json; charset=utf-8");
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
```

```java 

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
```

## Download file
```java
String savePath = "sdcard/doc/";
File saveDir = new File(savePath);
if (!saveDir.exists()) {
     saveDir.mkdirs();
}

OkHttpUtils.getInstance().download("https://p2.ssl.qhimgs1.com/sdr/400__/t016f54160c5c81c652.jpg", new File(savePath + "风景.jpg"), new OnDownloadListener({
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
```