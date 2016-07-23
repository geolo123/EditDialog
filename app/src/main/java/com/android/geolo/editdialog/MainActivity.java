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
import com.android.geolo.editdialog.lib.IEditDialogTextInitCallBack;

public class MainActivity extends AppCompatActivity {

    EditDialogLayout mOneEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setOneEdit();
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

}
