package com.android.geolo.editdialog.lib;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;

/**
 * Created by jwb.geolo on 2016/1/15.
 */
public class CustomAlertDialogUtils {
    // ---------------- start ��ͨ�Ի��� start -----------------------//
    /**
     * ������ֻ��û�а�ť�ĶԻ���
     *
     * @param title                  ����
     * @param msg                    ����
     * @param onDismissListener      �Ի�����ʧ�ļ�����
     * @param canceledOnTouchOutside �Ƿ����ⲿȡ������Ϊfalse��ͬʱ���÷��ؼ�
     */
    public static Dialog createCustomAlertDialog(Context context, String title, String msg,
        DialogInterface.OnDismissListener onDismissListener, boolean canceledOnTouchOutside) {
        CommonAlertDialog.Builder customBuilder = new CommonAlertDialog.Builder(context);
        customBuilder.setTitle(title)
            .setMessage(msg)
            .setOnDismissListener(onDismissListener)
            .setCanceledOnTouchOutside(canceledOnTouchOutside);
        return customBuilder.create();
    }

    /**
     * ������ֻ��һ����ť�ĶԻ���
     *
     * @param title                  ����
     * @param msg                    ����
     * @param positiveButtonText     ��ť���İ�
     * @param positiveButtonListener ��ť����Ӧ�¼�
     * @param onDismissListener      �Ի�����ʧ�ļ�����
     * @param canceledOnTouchOutside �Ƿ����ⲿȡ������Ϊfalse��ͬʱ���÷��ؼ�
     */
    public static Dialog createCustomAlertDialog(Context context, String title, String msg, String positiveButtonText,
        DialogInterface.OnClickListener positiveButtonListener, DialogInterface.OnDismissListener onDismissListener,
        boolean canceledOnTouchOutside) {
        CommonAlertDialog.Builder customBuilder = new CommonAlertDialog.Builder(context);
        customBuilder.setTitle(title)
            .setMessage(msg)
            .setPositiveButton(positiveButtonText, positiveButtonListener)
            .setOnDismissListener(onDismissListener)
            .setCanceledOnTouchOutside(canceledOnTouchOutside);
        return customBuilder.create();
    }

    /**
     * ������������ť�ĶԻ���
     *
     * @param title                  ����
     * @param msg                    ����
     * @param positiveButtonText     �϶���ť���İ�
     * @param positiveButtonListener �϶���ť����Ӧ�¼�
     * @param negativeButtonText     �񶨰�ť���İ�
     * @param negativeButtonListener �񶨰�ť���İ�
     * @param onDismissListener      �Ի�����ʧ�ļ�����
     * @param canceledOnTouchOutside �Ƿ����ⲿȡ������Ϊfalse��ͬʱ���÷��ؼ�
     */
    public static Dialog createCustomAlertDialog(Context context, String title, String msg, String positiveButtonText,
        DialogInterface.OnClickListener positiveButtonListener, String negativeButtonText,
        DialogInterface.OnClickListener negativeButtonListener, DialogInterface.OnDismissListener onDismissListener,
        boolean canceledOnTouchOutside) {
        CommonAlertDialog.Builder customBuilder = new CommonAlertDialog.Builder(context);
        customBuilder.setTitle(title)
            .setMessage(msg)
            .setNegativeButton(negativeButtonText, negativeButtonListener)
            .setPositiveButton(positiveButtonText, positiveButtonListener)
            .setOnDismissListener(onDismissListener)
            .setCanceledOnTouchOutside(canceledOnTouchOutside);
        return customBuilder.create();
    }

    // ---------------- end ��ͨ�Ի��� end -----------------------//

    // ---------------- start �Զ��岼�ֶԻ��� start -----------------------//
    /**
     * ������������ť���Զ��岼�ֶԻ���
     *
     * @param title                  ����
     * @param view                   ����
     * @param positiveButtonText     �϶���ť���İ�
     * @param positiveButtonListener �϶���ť����Ӧ�¼�
     * @param negativeButtonText     �񶨰�ť���İ�
     * @param negativeButtonListener �񶨰�ť���İ�
     * @param onDismissListener      �Ի�����ʧ�ļ�����
     * @param canceledOnTouchOutside �Ƿ����ⲿȡ������Ϊfalse��ͬʱ���÷��ؼ�
     */
    public static Dialog createCustomAlertDialog(Context context, String title, View view, String positiveButtonText,
        DialogInterface.OnClickListener positiveButtonListener, String negativeButtonText,
        DialogInterface.OnClickListener negativeButtonListener, DialogInterface.OnDismissListener onDismissListener,
        boolean canceledOnTouchOutside) {
        CommonAlertDialog.Builder customBuilder = new CommonAlertDialog.Builder(context);
        customBuilder.setTitle(title)
            .setContentView(view)
            .setNegativeButton(negativeButtonText, negativeButtonListener)
            .setPositiveButton(positiveButtonText, positiveButtonListener)
            .setOnDismissListener(onDismissListener)
            .setCanceledOnTouchOutside(canceledOnTouchOutside);
        return customBuilder.create();
    }

    /**
     * ������һ����ť���Զ��岼�ֶԻ���
     *
     * @param title                  ����
     * @param view                   ����
     * @param positiveButtonText     �϶���ť���İ�
     * @param positiveButtonListener �϶���ť����Ӧ�¼�
     * @param onDismissListener      �Ի�����ʧ�ļ�����
     * @param canceledOnTouchOutside �Ƿ����ⲿȡ������Ϊfalse��ͬʱ���÷��ؼ�
     */
    public static Dialog createCustomAlertDialog(Context context, String title, View view, String positiveButtonText,
        DialogInterface.OnClickListener positiveButtonListener, DialogInterface.OnDismissListener onDismissListener,
        boolean canceledOnTouchOutside) {
        CommonAlertDialog.Builder customBuilder = new CommonAlertDialog.Builder(context);
        customBuilder.setTitle(title)
            .setContentView(view)
            .setPositiveButton(positiveButtonText, positiveButtonListener)
            .setOnDismissListener(onDismissListener)
            .setCanceledOnTouchOutside(canceledOnTouchOutside);
        return customBuilder.create();
    }

    /**
     * ����û�а�ť���Զ��岼�ֶԻ���
     *
     * @param title                  ����
     * @param view                  ����
     * @param onDismissListener      �Ի�����ʧ�ļ�����
     * @param canceledOnTouchOutside �Ƿ����ⲿȡ������Ϊfalse��ͬʱ���÷��ؼ�
     */
    public static Dialog createCustomAlertDialog(Context context, String title, View view,
        DialogInterface.OnDismissListener onDismissListener, boolean canceledOnTouchOutside) {
        CommonAlertDialog.Builder customBuilder = new CommonAlertDialog.Builder(context);
        customBuilder.setTitle(title)
            .setContentView(view)
            .setOnDismissListener(onDismissListener)
            .setCanceledOnTouchOutside(canceledOnTouchOutside);
        return customBuilder.create();
    }

    // ---------------- end �Զ��岼�ֶԻ��� end -----------------------//

    // ---------------- start �б�Ի��� start -----------------------//
    /**
     * ����û�а�ť���б�Ի���
     *
     * @param title                  ����
     * @param items                  ����
     * @param listItemClickListener  �����Ԫ��
     * @param onDismissListener      �Ի�����ʧ�ļ�����
     * @param canceledOnTouchOutside �Ƿ����ⲿȡ������Ϊfalse��ͬʱ���÷��ؼ�
     */
    public static Dialog createCustomAlertDialog(Context context, String title, CharSequence[] items,
        DialogInterface.OnClickListener listItemClickListener, DialogInterface.OnDismissListener onDismissListener,
        boolean canceledOnTouchOutside) {
        CommonAlertDialog.Builder customBuilder = new CommonAlertDialog.Builder(context);
        customBuilder.setTitle(title)
            .setItems(items, listItemClickListener)
            .setOnDismissListener(onDismissListener)
            .setCanceledOnTouchOutside(canceledOnTouchOutside);
        return customBuilder.create();
    }

    /**
     * ����ֻ��һ����ť���б�Ի���
     *
     * @param title                        ����
     * @param items                        ����
     * @param listItemClickListener      �����Ԫ��
     * @param onDismissListener            �Ի�����ʧ�ļ�����
     * @param canceledOnTouchOutside       �Ƿ����ⲿȡ������Ϊfalse��ͬʱ���÷��ؼ�
     */
    public static Dialog createCustomAlertDialog(Context context, String title, CharSequence[] items,
        String negativeButtonText, DialogInterface.OnClickListener negativeButtonListener,
        DialogInterface.OnClickListener listItemClickListener, DialogInterface.OnDismissListener onDismissListener,
        boolean canceledOnTouchOutside) {
        CommonAlertDialog.Builder customBuilder = new CommonAlertDialog.Builder(context);
        customBuilder.setTitle(title)
            .setNegativeButton(negativeButtonText, negativeButtonListener)
            .setItems(items, listItemClickListener)
            .setOnDismissListener(onDismissListener)
            .setCanceledOnTouchOutside(canceledOnTouchOutside);
        return customBuilder.create();
    }

    // ---------------- end �б�Ի��� end -----------------------//
    /**
     * ����û�а�ť���б��ѡ�Ի���
     *
     * @param title                        ����
     * @param items                        ����
     * @param listMultiChoiceClickListener �����CheckBoxԪ��
     * @param onDismissListener            �Ի�����ʧ�ļ�����
     * @param canceledOnTouchOutside       �Ƿ����ⲿȡ������Ϊfalse��ͬʱ���÷��ؼ�
     */
    public static Dialog createCustomAlertDialog(Context context, String title, CharSequence[] items,
        DialogInterface.OnMultiChoiceClickListener listMultiChoiceClickListener,
        DialogInterface.OnDismissListener onDismissListener, boolean canceledOnTouchOutside) {
        CommonAlertDialog.Builder customBuilder = new CommonAlertDialog.Builder(context);
        customBuilder.setTitle(title)
            .setMultiChoiceItems(items, listMultiChoiceClickListener)
            .setOnDismissListener(onDismissListener)
            .setCanceledOnTouchOutside(canceledOnTouchOutside);
        return customBuilder.create();
    }

    /**
     * ����û�а�ť�Ķ�ѡ��Ի��򣬿��������Ƿ��Ѿ�ѡ����
     * @param context
     * @param title
     * @param items
     * @param booleans
     * @param listMultiChoiceClickListener �����CheckBoxԪ��
     * @param onDismissListener �Ի�����ʧ�ļ�����
     * @param canceledOnTouchOutside   �Ƿ����ⲿȡ������Ϊfalse��ͬʱ���÷��ؼ�
     * @return
     */
    public static Dialog createCustomAlertDialog(Context context, String title, CharSequence[] items,
        boolean[] booleans, DialogInterface.OnMultiChoiceClickListener listMultiChoiceClickListener,
        DialogInterface.OnDismissListener onDismissListener, boolean canceledOnTouchOutside) {
        CommonAlertDialog.Builder customBuilder = new CommonAlertDialog.Builder(context);
        customBuilder.setTitle(title)
            .setMultiChoiceItems(items, booleans, listMultiChoiceClickListener)
            .setOnDismissListener(onDismissListener)
            .setCanceledOnTouchOutside(canceledOnTouchOutside);
        return customBuilder.create();
    }

}
