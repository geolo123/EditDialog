package com.android.geolo.editdialog.lib;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;

/**
 * Created by jwb.geolo on 2016/1/15.
 */
public class CustomAlertDialogUtils {
    // ---------------- start 普通对话框 start -----------------------//
    /**
     * 弹出有只有没有按钮的对话框
     *
     * @param title                  标题
     * @param msg                    内容
     * @param onDismissListener      对话框消失的监听器
     * @param canceledOnTouchOutside 是否点击外部取消，若为false，同时禁用返回键
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
     * 弹出有只有一个按钮的对话框
     *
     * @param title                  标题
     * @param msg                    内容
     * @param positiveButtonText     按钮的文案
     * @param positiveButtonListener 按钮的相应事件
     * @param onDismissListener      对话框消失的监听器
     * @param canceledOnTouchOutside 是否点击外部取消，若为false，同时禁用返回键
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
     * 弹出有两个按钮的对话框
     *
     * @param title                  标题
     * @param msg                    内容
     * @param positiveButtonText     肯定按钮的文案
     * @param positiveButtonListener 肯定按钮的相应事件
     * @param negativeButtonText     否定按钮的文案
     * @param negativeButtonListener 否定按钮的文案
     * @param onDismissListener      对话框消失的监听器
     * @param canceledOnTouchOutside 是否点击外部取消，若为false，同时禁用返回键
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

    // ---------------- end 普通对话框 end -----------------------//

    // ---------------- start 自定义布局对话框 start -----------------------//
    /**
     * 弹出有两个按钮的自定义布局对话框
     *
     * @param title                  标题
     * @param view                   内容
     * @param positiveButtonText     肯定按钮的文案
     * @param positiveButtonListener 肯定按钮的相应事件
     * @param negativeButtonText     否定按钮的文案
     * @param negativeButtonListener 否定按钮的文案
     * @param onDismissListener      对话框消失的监听器
     * @param canceledOnTouchOutside 是否点击外部取消，若为false，同时禁用返回键
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
     * 弹出有一个按钮的自定义布局对话框
     *
     * @param title                  标题
     * @param view                   内容
     * @param positiveButtonText     肯定按钮的文案
     * @param positiveButtonListener 肯定按钮的相应事件
     * @param onDismissListener      对话框消失的监听器
     * @param canceledOnTouchOutside 是否点击外部取消，若为false，同时禁用返回键
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
     * 弹出没有按钮的自定义布局对话框
     *
     * @param title                  标题
     * @param view                  内容
     * @param onDismissListener      对话框消失的监听器
     * @param canceledOnTouchOutside 是否点击外部取消，若为false，同时禁用返回键
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

    // ---------------- end 自定义布局对话框 end -----------------------//

    // ---------------- start 列表对话框 start -----------------------//
    /**
     * 弹出没有按钮的列表对话框
     *
     * @param title                  标题
     * @param items                  内容
     * @param listItemClickListener  点击的元素
     * @param onDismissListener      对话框消失的监听器
     * @param canceledOnTouchOutside 是否点击外部取消，若为false，同时禁用返回键
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
     * 弹出只有一个按钮的列表对话框
     *
     * @param title                        标题
     * @param items                        内容
     * @param listItemClickListener      点击的元素
     * @param onDismissListener            对话框消失的监听器
     * @param canceledOnTouchOutside       是否点击外部取消，若为false，同时禁用返回键
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

    // ---------------- end 列表对话框 end -----------------------//
    /**
     * 弹出没有按钮的列表多选对话框
     *
     * @param title                        标题
     * @param items                        内容
     * @param listMultiChoiceClickListener 点击的CheckBox元素
     * @param onDismissListener            对话框消失的监听器
     * @param canceledOnTouchOutside       是否点击外部取消，若为false，同时禁用返回键
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
     * 创建没有按钮的多选择对话框，可以设置是否已经选择项
     * @param context
     * @param title
     * @param items
     * @param booleans
     * @param listMultiChoiceClickListener 点击的CheckBox元素
     * @param onDismissListener 对话框消失的监听器
     * @param canceledOnTouchOutside   是否点击外部取消，若为false，同时禁用返回键
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
