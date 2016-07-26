package com.android.geolo.editdialog.lib;

/**
 * 日期或者时间选择器的回调函数
 * Created by jwb.geolo on 2016/7/25.
 */
public interface IEditDialogDataTimeCallBack {
    CharSequence onDateTimeChecked(int year, int month, int day, int hour, int minte, int second);
}
