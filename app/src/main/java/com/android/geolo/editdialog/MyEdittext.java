package com.android.geolo.editdialog;

import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;

import com.android.geolo.editdialog.lib.EditDialogText;

public class MyEdittext extends EditDialogText {
    private String mSuffix;

    public MyEdittext(Context context) {
        super(context);
    }

    public void setSuffix(String suffix) {
        mSuffix = suffix;
    }

    @Override
    public CharSequence getEditDialogText() {
        String content = super.getText().toString() + mSuffix;
        return getColorText(content);
    }

    SpannableString getColorText(String orgString) {
        SpannableString msp = new SpannableString(orgString);
        msp.setSpan(new ForegroundColorSpan(Color.parseColor("#67d470")), 0, orgString.indexOf(mSuffix),
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // 设置前景色为洋红色
        return msp;
    }

}
