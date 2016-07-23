package com.android.geolo.editdialog.lib;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Calendar;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

/**
 * 编辑条布局元素，点击都是对话框
 * Created by geolo on 2016/7/19.
 */
public class EditDialogLayout extends LinearLayout implements View.OnClickListener {

    private static final int TYPE_TEXT = 0;
    private static final int TYPE_EDIT = 1;
    private static final int TYPE_LIST_ITEM = 2;
    private static final int TYPE_ARRAY_ITEM = 3;
    private static final int TYPE_TIME = 4;
    private static final int TYPE_DATE = 5;
    private static final int TYPE_DATE_TIME = 6;

    private static final int STYLE_DIALOG_NONE = 0;
    private static final int STYLE_DIALOG_SINGLE = 1;
    private static final int STYLE_DIALOG_TWO = 2;

    private int mCurrentType = TYPE_TEXT;
    private int mKeyTextColor = Color.BLACK;
    private int mKeyTextSize = 0;
    private int mValueTextSize = 0;
    private int mKeyHintColor = Color.GRAY;
    private int mValueTextColor = Color.BLACK;
    private int mValueHintColor = Color.GRAY;
    private int mDialogButtonStyle = STYLE_DIALOG_TWO;
    private String mKeyTextStr = "key";
    private String mValueTextStr = "value";
    private String mValueHint = "hint";
    private String mDialogTitle = "title";
    private String mDialogMsg = "msg";
    private String mDialogBtnOk = "Ok";
    private String mDialogBtnNo = "No";
    private int mDialogEditInputType = 0;
    private CharSequence[] mDialogArray = null;
    private ArrayList<CharSequence> mDialogList = null;
    private Drawable mDrawableLeft = null;
    private Drawable mDrawableRight = null;
    private int mDrawablePadding = 0;
    private boolean isKeyVisibility = true;
    private boolean isValueVisibility = true;
    // 文本格式化资源
    private int mValueFormatResID;
    private TextView mKeyTV;
    private TextView mValueTV;
    private Class<? extends EditDialogText> mUserEditTextClass;
    private EditDialogText mUserEditText;
    private IEditDialogTextInitCallBack mIEditDialogTextInitCallBack;

    private void init() {
        inflate(getContext(), R.layout.edit_dialog_layout, this);
        mKeyTV = (TextView) findViewById(R.id.edit_dialog_layout_key_tv);
        mValueTV = (TextView) findViewById(R.id.edit_dialog_layout_value_tv);
        mKeyTV.setTextSize(mKeyTextSize);
        mKeyTV.setTextColor(mKeyTextColor);
        mKeyTV.setHintTextColor(mKeyHintColor);
        mValueTV.setTextSize(mValueTextSize);
        mValueTV.setTextColor(mValueTextColor);
        mValueTV.setHintTextColor(mValueHintColor);
        mKeyTV.setText(mKeyTextStr);
        mValueTV.setText(mValueTextStr);
        mValueTV.setHint(mValueHint);
        this.setOnClickListener(this);
        mKeyTV.setCompoundDrawablePadding(mDrawablePadding);
        mValueTV.setCompoundDrawablePadding(mDrawablePadding);
        mKeyTV.setVisibility(isKeyVisibility ? View.VISIBLE : View.GONE);
        mValueTV.setVisibility(isValueVisibility ? View.VISIBLE : View.GONE);
        if (isKeyVisibility && isValueVisibility) {
            mKeyTV.setCompoundDrawablesWithIntrinsicBounds(mDrawableLeft, null, null, null);
            mValueTV.setCompoundDrawablesWithIntrinsicBounds(null, null, mDrawableRight, null);
        } else if (!isKeyVisibility && isValueVisibility) {
            mValueTV.setCompoundDrawablesWithIntrinsicBounds(mDrawableLeft, null, mDrawableRight, null);
        } else if (isKeyVisibility && !isValueVisibility) {
            mKeyTV.setCompoundDrawablesWithIntrinsicBounds(mDrawableLeft, null, mDrawableRight, null);
        }
    }

    private void initAttr(AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        final TypedArray aType =
            getContext().obtainStyledAttributes(attrs, R.styleable.edit_dialog_layout, defStyleAttr, defStyleRes);
        try {
            mCurrentType = aType.getInt(R.styleable.edit_dialog_layout_geo_style, TYPE_TEXT);
            mKeyTextSize = aType.getDimensionPixelSize(R.styleable.edit_dialog_layout_geo_key_text_size, 15);
            mKeyTextColor = aType.getColor(R.styleable.edit_dialog_layout_geo_key_text_color, 0);
            mKeyHintColor = aType.getColor(R.styleable.edit_dialog_layout_geo_key_hint_color, 0);
            mValueTextSize = aType.getDimensionPixelSize(R.styleable.edit_dialog_layout_geo_value_text_size, 15);
            mValueTextColor = aType.getColor(R.styleable.edit_dialog_layout_geo_value_text_color, 0);
            mValueHintColor = aType.getColor(R.styleable.edit_dialog_layout_geo_value_hint_color, 0);
            mKeyTextStr = aType.getString(R.styleable.edit_dialog_layout_geo_key_txt);
            mValueTextStr = aType.getString(R.styleable.edit_dialog_layout_geo_value_txt);
            mValueHint = aType.getString(R.styleable.edit_dialog_layout_geo_value_hint);
            mDialogTitle = aType.getString(R.styleable.edit_dialog_layout_geo_dialog_title);
            mDialogMsg = aType.getString(R.styleable.edit_dialog_layout_geo_dialog_msg);
            mDialogBtnOk = aType.getString(R.styleable.edit_dialog_layout_geo_dialog_ok);
            mDialogBtnNo = aType.getString(R.styleable.edit_dialog_layout_geo_dialog_no);
            mDialogArray = aType.getTextArray(R.styleable.edit_dialog_layout_geo_dialog_array);
            mDialogButtonStyle = aType.getInt(R.styleable.edit_dialog_layout_geo_dialog_button_style, STYLE_DIALOG_TWO);
            mDrawableLeft = aType.getDrawable(R.styleable.edit_dialog_layout_geo_drawableLeft);
            mDrawableRight = aType.getDrawable(R.styleable.edit_dialog_layout_geo_drawableRight);
            mDrawablePadding = aType.getDimensionPixelSize(R.styleable.edit_dialog_layout_geo_drawablePadding, 0);
            isKeyVisibility = aType.getBoolean(R.styleable.edit_dialog_layout_geo_key_visibility, true);
            isValueVisibility = aType.getBoolean(R.styleable.edit_dialog_layout_geo_value_visibility, true);
            mDialogEditInputType =
                aType.getInt(R.styleable.edit_dialog_layout_geo_dialog_edit_inputType, EditorInfo.TYPE_CLASS_TEXT);
        } finally {
            aType.recycle();
        }
    }

    @Override
    public void onClick(View v) {
        switch (mCurrentType) {
            default:
            case TYPE_TEXT:
                showTextDialog();
                break;
            case TYPE_EDIT:
                showEditDialog();
                break;
            case TYPE_LIST_ITEM:
                showListItemDialog();
                break;
            case TYPE_ARRAY_ITEM:
                showArrayItemDialog();
                break;
            case TYPE_TIME:
                showTimeDialog();
                break;
            case TYPE_DATE:
                showDateDialog();
                break;
            case TYPE_DATE_TIME:
                showTextDialog();
                break;
        }
    }

    private void showTextDialog() {
        if (mDialogButtonStyle == STYLE_DIALOG_TWO) {
            CustomAlertDialogUtils.createCustomAlertDialog(getContext(), mDialogTitle, mDialogMsg, mDialogBtnOk, null,
                mDialogBtnNo, null, null, false).show();
        } else if (mDialogButtonStyle == STYLE_DIALOG_SINGLE) {
            CustomAlertDialogUtils.createCustomAlertDialog(getContext(), mDialogTitle, mDialogMsg, mDialogBtnOk, null,
                null, false);
        } else if (mDialogButtonStyle == STYLE_DIALOG_NONE) {
            CustomAlertDialogUtils.createCustomAlertDialog(getContext(), mDialogTitle, mDialogMsg, null, false);
        }
    }

    private void showEditDialog() {
        if (mUserEditTextClass != null) {
            try {
                Constructor constructor = mUserEditTextClass.getConstructor(Context.class);
                mUserEditText = (EditDialogText) constructor.newInstance(getContext());
            } catch (InstantiationException e) {
                e.printStackTrace();
                mUserEditText = null;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                mUserEditText = null;
            } catch (InvocationTargetException e) {
                e.printStackTrace();
                mUserEditText = null;
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
                mUserEditText = null;
            } catch (Exception e) {
                e.printStackTrace();
                mUserEditText = null;
            }
        } else {
            mUserEditText = new EditDialogText(getContext());
        }
        if (mUserEditText == null) {
            mUserEditText = new EditDialogText(getContext());
        }
        mUserEditText.setInputType(mDialogEditInputType);
        if (mIEditDialogTextInitCallBack != null) {
            mIEditDialogTextInitCallBack.onEditTextInit(mUserEditText);
        }
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (mValueTV != null) {
                    if (mValueFormatResID > 0) {
                        mValueTV.setText(getResources().getString(mValueFormatResID, mUserEditText.getEditDialogText()));
                    } else {
                        mValueTV.setText(mUserEditText.getEditDialogText());
                    }
                }
            }
        };
        if (mDialogButtonStyle == STYLE_DIALOG_TWO) {
            CustomAlertDialogUtils.createCustomAlertDialog(getContext(), mDialogTitle, mUserEditText, mDialogBtnOk,
                listener, mDialogBtnNo, null, null, false).show();
        } else if (mDialogButtonStyle == STYLE_DIALOG_SINGLE) {
            CustomAlertDialogUtils.createCustomAlertDialog(getContext(), mDialogTitle, mUserEditText, mDialogBtnOk,
                listener, null, false).show();
        } else if (mDialogButtonStyle == STYLE_DIALOG_NONE) {
            CustomAlertDialogUtils.createCustomAlertDialog(getContext(), mDialogTitle, mUserEditText,
                new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        if (mValueTV != null) {
                            mValueTV.setText(mUserEditText.getEditDialogText());
                        }
                    }
                }, false).show();
        }
    }

    private void showListItemDialog() {
        if (mDialogList == null || mDialogList.isEmpty()) {
            return;
        }
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (mValueTV != null) {
                    mValueTV.setText(mDialogList.get(which));
                }
            }
        };
        if (mDialogButtonStyle == STYLE_DIALOG_TWO) {

        } else if (mDialogButtonStyle == STYLE_DIALOG_SINGLE) {
            CustomAlertDialogUtils.createCustomAlertDialog(getContext(), mDialogTitle,
                (String[]) mDialogList.toArray(), mDialogBtnOk, null, listener, null, false).show();
        } else if (mDialogButtonStyle == STYLE_DIALOG_NONE) {
            CustomAlertDialogUtils.createCustomAlertDialog(getContext(), mDialogTitle,
                (String[]) mDialogList.toArray(), listener, null, false).show();
        }
    }

    private void showArrayItemDialog() {
        if (mDialogArray == null) {
            return;
        }
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (mValueTV != null) {
                    mValueTV.setText(mDialogArray[which]);
                }
            }
        };

        if (mDialogButtonStyle == STYLE_DIALOG_TWO) {

        } else if (mDialogButtonStyle == STYLE_DIALOG_SINGLE) {
            CustomAlertDialogUtils.createCustomAlertDialog(getContext(), mDialogTitle, mDialogArray, mDialogBtnOk,
                null, listener, null, false).show();
        } else if (mDialogButtonStyle == STYLE_DIALOG_NONE) {
            CustomAlertDialogUtils.createCustomAlertDialog(getContext(), mDialogTitle, mDialogArray, listener, null,
                false).show();
        }
    }

    private void showTimeDialog() {
        final TimePicker picker = new TimePicker((getContext()));
        String content = mValueTV.getText().toString();
        picker.setIs24HourView(true);
        int hour = 0;
        int minute = 0;
        if (!TextUtils.isEmpty(content) && content.length() >= 10) {
            hour = Integer.valueOf(content.substring(0, 2));
            minute = Integer.valueOf(content.substring(3, 5)) - 1;
        } else {
            Calendar calendar = Calendar.getInstance();
            hour = calendar.get(Calendar.HOUR);
            minute = calendar.get(Calendar.MINUTE);
        }
        picker.setCurrentHour(hour);
        picker.setCurrentMinute(minute);
        CustomAlertDialogUtils.createCustomAlertDialog(getContext(), mDialogTitle, picker, mDialogBtnOk, null,
            new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    String currentTime = getTimeFormat(picker.getCurrentHour(), picker.getCurrentMinute());
                    mValueTV.setText(currentTime);
                }
            }, true).show();
    }

    private void showDateDialog() {
        final DatePicker picker = new DatePicker(getContext());
        picker.setCalendarViewShown(false);// 不显示日历部分,只显示日期转盘部分
        String content = mValueTV.getText().toString();
        if (!TextUtils.isEmpty(content) && content.length() >= 10) {
            int year = Integer.valueOf(content.substring(0, 4));
            int month = Integer.valueOf(content.substring(5, 7)) - 1;
            int day = Integer.valueOf(content.substring(8, 10));
            picker.init(year, month, day, null);
        } else {
            Calendar calendar = Calendar.getInstance();
            int mTodayYear = calendar.get(Calendar.YEAR);
            int mTodayMonthOfYear = calendar.get(Calendar.MONTH);
            int mTodayDayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
            picker.init(mTodayYear, mTodayMonthOfYear, mTodayDayOfMonth, null);
        }

        CustomAlertDialogUtils.createCustomAlertDialog(getContext(), mDialogTitle, picker, mDialogBtnOk, null,

        new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                String currentDate = getDateFormat(picker.getYear(), picker.getMonth(), picker.getDayOfMonth());
                mValueTV.setText(currentDate);
            }
        }, true).show();
    }

    private String getTimeFormat(int hour, int minute) {
        return hour + "-" + minute;
    }

    private String getDateFormat(int year, int month, int day) {
        return year + "-" + ((month + 1) > 9 ? String.valueOf(month + 1) : "0" + (month + 1)) + "-"
            + (day > 9 ? String.valueOf(day) : "0" + day);
    }

    /**
     * 设置列表元素，在 {@link #TYPE_LIST_ITEM} 类型下
     */
    public void setList(@NonNull ArrayList<CharSequence> stringList) {
        if (mCurrentType != TYPE_LIST_ITEM) {
            throw new RuntimeException("当前类型不是 TYPE_LIST_ITEM");
        }
        mDialogList = stringList;
    }

    /**
     * 设置列表元素，在 {@link #TYPE_ARRAY_ITEM} 类型下
     */
    public void setList(@NonNull CharSequence[] stringArray) {
        if (mCurrentType != TYPE_ARRAY_ITEM) {
            throw new RuntimeException("当前类型不是 TYPE_ARRAY_ITEM");
        }
        mDialogArray = stringArray;
    }

    public void setKeyText(CharSequence text) {
        mKeyTV.setText(text);
    }

    public void setValueText(CharSequence text) {
        mValueTV.setText(text);
    }

    public CharSequence getKeyText() {
        return mKeyTV.getText();
    }

    public CharSequence getValueText() {
        return mValueTV.getText();
    }

    /**
     * 设置文本格式化，在 {@link #TYPE_EDIT} 类型下
     */
    public void setValueFormatRes(@StringRes int formatRes) {
        if (mCurrentType != TYPE_EDIT) {
            throw new RuntimeException("当前类型不是 TYPE_EDIT");
        }
        mValueFormatResID = formatRes;
    }

    public <T extends EditDialogText> void setDefaultEdittext(Class<T> defaultClass,
        IEditDialogTextInitCallBack<T> callBack) {
        if (mCurrentType != TYPE_EDIT) {
            throw new RuntimeException("当前类型不是 TYPE_EDIT");
        }
        mUserEditTextClass = defaultClass;
        mIEditDialogTextInitCallBack = callBack;
    }

    /*********************************************************************************/
    public EditDialogLayout(Context context) {
        super(context);
        init();
        initAttr(null, 0, 0);
    }

    public EditDialogLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttr(attrs, 0, 0);
        init();
    }

    public EditDialogLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttr(attrs, defStyleAttr, 0);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public EditDialogLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initAttr(attrs, defStyleAttr, defStyleRes);
        init();
    }
}
