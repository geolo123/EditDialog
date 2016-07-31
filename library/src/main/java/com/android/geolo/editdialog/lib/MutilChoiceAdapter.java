package com.android.geolo.editdialog.lib;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;

public class MutilChoiceAdapter<T> extends ArrayAdapter<T> {
    DialogInterface.OnMultiChoiceClickListener listener;
    DialogInterface dialog;
    boolean[] booleans;

    public MutilChoiceAdapter(Context context, int resource, T[] objects,
        DialogInterface.OnMultiChoiceClickListener listener, DialogInterface dialog) {
        super(context, resource, objects);
        this.listener = listener;
        this.dialog = dialog;
    }

    public MutilChoiceAdapter(Context context, int resource, T[] objects, boolean[] booleans,
        DialogInterface.OnMultiChoiceClickListener listener, DialogInterface dialog) {
        super(context, resource, objects);
        this.listener = listener;
        this.dialog = dialog;
        this.booleans = booleans;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);
        if (view != null && view instanceof CheckBox) {
            view.setTag(position);
            if (booleans != null && booleans.length > 0 && booleans.length > position)
                ((CheckBox) view).setChecked(booleans[position]);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener == null) {
                        return;
                    }
                    if (booleans != null && booleans.length > 0 && booleans.length > position) {
                        booleans[position] = ((CheckBox) v).isChecked();
                    }
                    listener.onClick(dialog, (int) (v.getTag()), ((CheckBox) v).isChecked());
                }
            });
        }
        return view;
    }

}
