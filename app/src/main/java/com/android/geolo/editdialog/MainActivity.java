package com.android.geolo.editdialog;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.EditText;

import com.android.geolo.editdialog.lib.EditDialogLayout;
import com.android.geolo.editdialog.lib.EditDialogText;
import com.android.geolo.editdialog.lib.IEditDialogDataTimeCallBack;
import com.android.geolo.editdialog.lib.IEditDialogTextInitCallBack;

public class MainActivity extends AppCompatActivity {

    EditDialogLayout mOneEdit;
    EditDialogLayout mOneDate;
    EditDialogLayout mOneTime;
    EditDialogLayout mOneArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setOneEdit();
        setOneDate();
        setOneTime();
        setOneArray();
    }

    private void setOneEdit() {
        mOneEdit = (EditDialogLayout) findViewById(R.id.one_edittext);
        if (mOneEdit != null) {
            mOneEdit.setDefaultEdittext(MyEdittext.class, new IEditDialogTextInitCallBack<MyEdittext>() {
                @Override
                public void onEditTextInit(MyEdittext editDialogText) {
                    if (editDialogText != null) {
                        editDialogText.setSuffix("abcdefg");
                    }
                }
            });
        }
    }

    private void setOneDate() {
        mOneDate = (EditDialogLayout) findViewById(R.id.one_datetext);
        mOneDate.setIEditDialogDataTimeCallBack(new IEditDialogDataTimeCallBack() {
            @Override
            public CharSequence onDateTimeChecked(int year, int month, int day, int hour, int minte, int second) {
                return year + ":" + month + ":" + day;
            }
        });
    }

    private void setOneTime() {
        mOneTime = (EditDialogLayout) findViewById(R.id.one_timetext);
        mOneTime.setIEditDialogDataTimeCallBack(new IEditDialogDataTimeCallBack() {
            @Override
            public CharSequence onDateTimeChecked(int year, int month, int day, int hour, int minte, int second) {
                return hour + ":" + minte + ":" + second;
            }
        });
    }

    private void setOneArray() {
        mOneArray = (EditDialogLayout) findViewById(R.id.one_arraytext);

    }

}
