package com.lqr.librtmp;

import android.text.TextUtils;

/**
 * @创建者 LQR
 * @时间 19-10-16
 * @描述 rtmp帮助类
 */
public class RtmpHelper {

    private OnConnectionListener mOnConnectionListener;

    public void initLivePush(String url) {
        if (TextUtils.isEmpty(url)) return;
        n_init(url);
    }

    public void pushSPSPPS(byte[] sps, byte[] pps) {
        if (sps == null || pps == null) return;
        n_pushSPSPPS(sps, sps.length, pps, pps.length);
    }

    public void pushVideoData(byte[] data, boolean keyFrame) {
        if (data == null) return;
        n_pushVideoData(data, data.length, keyFrame);
    }

    public void pushAudioData(byte[] data) {
        if (data == null) return;
        n_pushAudioData(data, data.length);
    }

    public void stop() {
        n_stop();
    }

    private void onConnecting() {
        if (mOnConnectionListener != null) {
            mOnConnectionListener.onConnecting();
        }
    }

    private void onConnectSuccess() {
        if (mOnConnectionListener != null) {
            mOnConnectionListener.onConnectSuccess();
        }
    }

    private void onConnectFail(String msg) {
        if (mOnConnectionListener != null) {
            mOnConnectionListener.onConnectFail(msg);
        }
    }

    public void setOnConnectionListener(OnConnectionListener onConnectionListener) {
        this.mOnConnectionListener = onConnectionListener;
    }

    private native void n_init(String url);

    private native void n_pushSPSPPS(byte[] sps, int spsLen, byte[] pps, int ppsLen);

    private native void n_pushVideoData(byte[] data, int dataLen, boolean keyFrame);

    private native void n_pushAudioData(byte[] data, int dataLen);

    private native void n_stop();

    static {
        System.loadLibrary("rtmppush");
    }
}
