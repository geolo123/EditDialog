package com.android.geolo.editdialog;

import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;

import com.android.geolo.editdialog.lib.EditDialogText;

public class MyEdittext extends EditDialogText {
    public MyEdittext(Context context) {
        super(context);
    }

    @Override
    public Editable getEditDialogText() {
        Editable editable = super.getText();
        String content = editable.toString();
        editable.clear();
        editable.append(getColorText(content));
        return editable;
    }

    SpannableString getColorText(String orgString) {
        SpannableString msp = new SpannableString(orgString);
        msp.setSpan(new ForegroundColorSpan(Color.parseColor("#67d470")), 0, orgString.length(),
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // 设置前景色为洋红色
        return msp;
    }

}
