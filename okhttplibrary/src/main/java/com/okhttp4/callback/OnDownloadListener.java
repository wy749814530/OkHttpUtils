package com.okhttp4.callback;

import java.io.File;

/**
 * Created by Administrator on 2018/7/11 0011.
 */

public interface OnDownloadListener {
    /**
     * 下载成功
     */
    void onDownloadSuccess(File file);

    /**
     * @param progress
     * 下载进度
     */
    void onDownloading(int progress);

    /**
     * 下载失败
     */
    void onDownloadFailed();
}
