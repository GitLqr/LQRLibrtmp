package com.lqr.librtmp;

/**
 * @创建者 LQR
 * @时间 19-10-16
 * @描述 rtmp连接状态监听
 */
public interface OnConnectionListener {
    void onConnecting();

    void onConnectSuccess();

    void onConnectFail(String msg);
}
