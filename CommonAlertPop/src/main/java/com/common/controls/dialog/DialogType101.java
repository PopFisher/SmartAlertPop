package com.common.controls.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.common.alertpop.R;

/**
 * 类型101 Dialog
 * 有标题，有文本内容，一个确定按钮
 */

public class DialogType101 extends DialogBase {
    private TextView mContentTv;
    private TextView mOkTv;

    public DialogType101(Context context) {
        super(context);
    }

    @Override
    public void initDialog() {
        View rootView = LayoutInflater.from(mContext).inflate(R.layout.common_dialog_layout_type101, null);
        mTitleTv = (TextView) rootView.findViewById(R.id.common_dialog_title_text);
        mContentTv = (TextView) rootView.findViewById(R.id.common_dialog_content_text);
        mOkTv = (TextView) rootView.findViewById(R.id.common_dialog_ok_btn);
        createDialog(rootView);
    }

    @Override
    public void setContentText(int contentStrId) {
        mContentTv.setText(contentStrId);
    }

    @Override
    public void setContentText(CharSequence contentStr) {
        mContentTv.setText(contentStr);
    }

    @Override
    public void setOkBtn(int textId, View.OnClickListener okOnClickListener) {
        mOkTv.setText(textId);
        setOnOkClickListener(okOnClickListener);
    }

    @Override
    public void setOkBtn(CharSequence text, View.OnClickListener okOnClickListener) {
        mOkTv.setText(text);
        setOnOkClickListener(okOnClickListener);
    }

    @Override
    public void setOkBtnStyleType(int okBtnStyleType) {
        mOkTv.setBackgroundResource(DialogUtil.getOkBtnBgResId(okBtnStyleType));
        mOkTv.setTextColor(DialogUtil.getOkBtnTextColorValue(okBtnStyleType, mOkTv.getContext()));
    }

    @Override
    public void bindAllListeners() {
        mOkTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogType101.this.onOkClick(v);
            }
        });
    }

}
