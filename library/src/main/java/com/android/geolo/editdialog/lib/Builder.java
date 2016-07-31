package com.android.geolo.editdialog.lib;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class Builder {
    private Context context;
    private String title;
    private String message;
    private CharSequence[] items;
    private int simpleListItemLayoutRes = 0;
    private boolean[] booleans;
    private String positiveButtonText;
    private String negativeButtonText;
    private boolean cancelable = true;
    private View contentView;
    private View mDialogLayout;
    private SpannableStringBuilder messageBuilder;
    private DialogInterface.OnClickListener listItemClickListener, positiveButtonClickListener,
        negativeButtonClickListener;
    private DialogInterface.OnMultiChoiceClickListener listMultiChoiceClickListener;
    private boolean canceledOnTouchOutside;
    private DialogInterface.OnDismissListener onDismissListener;
    private LayoutInflater inflater;

    public Builder(Context context) {
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public Builder setMessage(String message) {
        this.message = message;
        return this;
    }

    public Builder setMessage(int message) {
        this.message = (String) context.getText(message);
        return this;
    }

    public Builder setItems(CharSequence[] items, final DialogInterface.OnClickListener listener) {
        this.items = items;
        this.listItemClickListener = listener;
        return this;
    }

    public Builder setMultiChoiceItems(CharSequence[] items, final DialogInterface.OnMultiChoiceClickListener listener) {
        this.items = items;
        listMultiChoiceClickListener = listener;
        return this;
    }

    public Builder setMultiChoiceItems(CharSequence[] items, boolean[] booleans,
        final DialogInterface.OnMultiChoiceClickListener listener) {
        this.items = items;
        this.booleans = booleans;
        listMultiChoiceClickListener = listener;
        return this;
    }

    public Builder setSimpleListItemLayout(@LayoutRes int simpleListItemLayoutRes) {
        this.simpleListItemLayoutRes = simpleListItemLayoutRes;
        return this;
    }

    public Builder setMessageBuilder(SpannableStringBuilder messageBuilder) {
        this.messageBuilder = messageBuilder;
        return this;
    }

    public Builder setTitle(int title) {
        this.title = (String) context.getText(title);
        return this;
    }

    public Builder setTitle(String title) {
        this.title = title;
        return this;
    }

    public Builder setContentView(View v) {
        this.contentView = v;
        return this;
    }

    public Builder setDialogLayout(@LayoutRes int dialogLayoutRes) {
        if (dialogLayoutRes > 0) {
            mDialogLayout = inflater.inflate(dialogLayoutRes, null);
        }
        return this;
    }

    public Builder setPositiveButton(@StringRes int positiveButtonText, DialogInterface.OnClickListener listener) {
        this.positiveButtonText = (String) context.getText(positiveButtonText);
        this.positiveButtonClickListener = listener;
        return this;
    }

    public Builder setPositiveButton(String positiveButtonText, DialogInterface.OnClickListener listener) {
        this.positiveButtonText = positiveButtonText;
        this.positiveButtonClickListener = listener;
        return this;
    }

    public Builder setNegativeButton(@StringRes int negativeButtonText, DialogInterface.OnClickListener listener) {
        this.negativeButtonText = (String) context.getText(negativeButtonText);
        this.negativeButtonClickListener = listener;
        return this;
    }

    public Builder setNegativeButton(String negativeButtonText, DialogInterface.OnClickListener listener) {
        this.negativeButtonText = negativeButtonText;
        this.negativeButtonClickListener = listener;
        return this;
    }

    public Builder setCanceledOnTouchOutside(boolean canceledOnTouchOutside) {
        this.canceledOnTouchOutside = canceledOnTouchOutside;
        return this;
    }

    public Builder setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.onDismissListener = onDismissListener;
        return this;
    }

    public Builder setCancelable(boolean cancelable) {
        this.cancelable = cancelable;
        return this;
    }

    /**
     * Create the custom dialog
     */
    public Dialog create() {
        final Dialog dialog = new Dialog(context, R.style.alertDialog);
        dialog.setCancelable(cancelable);
        dialog.setCanceledOnTouchOutside(canceledOnTouchOutside);
        View layout = null;
        if (mDialogLayout != null) {
            layout = mDialogLayout;
        } else {
            layout = inflater.inflate(R.layout.common_dialog_alert, null);
        }
        layout.findViewById(R.id.geo_dialog_btn_layout).setVisibility(View.GONE);
        if (!TextUtils.isEmpty(title)) {
            ((TextView) layout.findViewById(R.id.geo_dialog_title)).setText(title);
            layout.findViewById(R.id.geo_dialog_title_divider).setVisibility(View.VISIBLE);
        } else {
            layout.findViewById(R.id.geo_dialog_title).setVisibility(View.GONE);
            layout.findViewById(R.id.geo_dialog_title_divider).setVisibility(View.GONE);
        }
        if (!TextUtils.isEmpty(positiveButtonText)) {
            layout.findViewById(R.id.geo_dialog_btn_layout).setVisibility(View.VISIBLE);
            ((Button) layout.findViewById(R.id.geo_dialog_btn_positive)).setText(positiveButtonText);
            layout.findViewById(R.id.geo_dialog_btn_positive).setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (positiveButtonClickListener != null) {
                        positiveButtonClickListener.onClick(dialog, DialogInterface.BUTTON_POSITIVE);
                    }
                    dialog.dismiss();
                }
            });
        } else {
            layout.findViewById(R.id.geo_dialog_btn_positive).setVisibility(View.GONE);
        }

        if (!TextUtils.isEmpty(negativeButtonText)) {
            layout.findViewById(R.id.geo_dialog_btn_layout).setVisibility(View.VISIBLE);
            ((Button) layout.findViewById(R.id.geo_dialog_btn_negative)).setText(negativeButtonText);
            layout.findViewById(R.id.geo_dialog_btn_negative).setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (negativeButtonClickListener != null) {
                        negativeButtonClickListener.onClick(dialog, DialogInterface.BUTTON_NEGATIVE);
                    }
                    dialog.dismiss();
                }
            });
        } else {
            layout.findViewById(R.id.geo_dialog_btn_negative).setVisibility(View.GONE);
        }

        if (message != null) {
            layout.findViewById(R.id.geo_dialog_message).setVisibility(View.VISIBLE);
            layout.findViewById(R.id.geo_dialog_listView).setVisibility(View.GONE);
            ((TextView) layout.findViewById(R.id.geo_dialog_message)).setText(message);
        } else if (messageBuilder != null) {
            ((TextView) layout.findViewById(R.id.geo_dialog_message)).setText(messageBuilder);
        }

        if (items != null) {
            layout.findViewById(R.id.geo_dialog_listView).setVisibility(View.VISIBLE);
            layout.findViewById(R.id.geo_dialog_message).setVisibility(View.GONE);
            ListView listView = (ListView) layout.findViewById(R.id.geo_dialog_listView);
            ArrayAdapter<CharSequence> adapter = null;
            if (listItemClickListener != null) {
                adapter =
                    new ArrayAdapter<>(context, simpleListItemLayoutRes > 0 ? simpleListItemLayoutRes
                        : R.layout.simple_list_item_default, items);
            } else if (listMultiChoiceClickListener != null) {
                if (booleans != null && booleans.length > 0) {
                    adapter =
                        new MutilChoiceAdapter<>(context, simpleListItemLayoutRes > 0 ? simpleListItemLayoutRes
                            : R.layout.simple_list_item_default_check_btn, items, booleans,
                            listMultiChoiceClickListener, dialog);
                } else {
                    adapter =
                        new MutilChoiceAdapter<>(context, simpleListItemLayoutRes > 0 ? simpleListItemLayoutRes
                            : R.layout.simple_list_item_default_check_btn, items, listMultiChoiceClickListener, dialog);
                }
            }
            if (adapter != null) {
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        if (listItemClickListener != null) {
                            listItemClickListener.onClick(dialog, position);
                            dialog.dismiss();
                        }
                    }
                });
            }
        } else {
            layout.findViewById(R.id.geo_dialog_listView).setVisibility(View.GONE);
        }
        if (onDismissListener != null) {
            dialog.setOnDismissListener(onDismissListener);
            dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    if (onDismissListener != null) {
                        onDismissListener.onDismiss(dialog);
                    }
                }
            });
        }
        if (contentView != null) {
            layout.findViewById(R.id.geo_dialog_message).setVisibility(View.GONE);
            layout.findViewById(R.id.geo_dialog_listView).setVisibility(View.GONE);
            ((LinearLayout) layout.findViewById(R.id.geo_dialog_content)).addView(contentView,
                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
        }
        dialog.setContentView(layout, new ViewGroup.LayoutParams(new LinearLayout.LayoutParams(dip2px(context, 300),
            LinearLayout.LayoutParams.WRAP_CONTENT)));

        return dialog;
    }

    public static int dip2px(Context context, float dipValue) { // #0001-
        final float scale = context.getApplicationContext().getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }
}
