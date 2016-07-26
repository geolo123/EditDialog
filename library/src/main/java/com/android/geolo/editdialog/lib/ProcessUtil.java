package com.android.geolo.editdialog.lib;

import java.util.Timer;
import java.util.TimerTask;

public class ProcessUtil {

    private static boolean processing = false;

    /**
     * ��ǰ�Ƿ����ڴ�����ֹ�ظ������Ĭ��500ms
     * @return �Ƿ����ڴ���
     */
    public static synchronized boolean isProcessing() {
        return isProcessing(500);
    }

    /**
     * ��ǰ�Ƿ����ڴ�����ֹ�ظ����
     * @param minProcessingTime ������̴����¼�
     * @return �Ƿ����ڴ���
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
