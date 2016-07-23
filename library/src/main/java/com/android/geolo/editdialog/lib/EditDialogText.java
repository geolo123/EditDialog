package com.android.geolo.editdialog.lib;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.util.AttributeSet;
import android.widget.EditText;

public class EditDialogText extends EditText {

    @Override
    public final Editable getText() {
        return super.getText();
    }

    public CharSequence getEditDialogText() {
        return getText();
    }

    /*********************************************************************************/
    public EditDialogText(Context context) {
        super(context);
    }

    public EditDialogText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EditDialogText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public EditDialogText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
