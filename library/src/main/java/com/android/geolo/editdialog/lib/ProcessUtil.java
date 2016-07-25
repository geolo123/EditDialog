package com.android.geolo.editdialog.lib;

import java.util.Timer;
import java.util.TimerTask;

public class ProcessUtil {

    private static boolean processing = false;

    /**
     * 当前是否正在处理，防止重复点击，默认500ms
     * @return 是否正在处理
     */
    public static synchronized boolean isProcessing() {
        return isProcessing(500);
    }

    /**
     * 当前是否正在处理，防止重复点击
     * @param minProcessingTime 所需最短处理事件
     * @return 是否正在处理
     */
    public static synchronized boolean isProcessing(final long minProcessingTime) {
        if (!processing) {
            processing = true;
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    processing = false;
                }
            }, minProcessingTime);
            return false;
        }
        return true;
    }
}
