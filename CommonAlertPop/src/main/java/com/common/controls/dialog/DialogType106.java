package com.common.controls.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.common.alertpop.R;

/**
 * 类型106 Dialog
 * 有标题，有文本内容，一个确定按钮
 */

public class DialogType106 extends DialogBase {
    private TextView mContentTv;
    private TextView mCancelTv;

    public DialogType106(Context context) {
        super(context);
    }

    @Override
    public void initDialog() {
        View rootView = LayoutInflater.from(mContext).inflate(R.layout.common_dialog_layout_type106, null);
        mTitleTv = (TextView) rootView.findViewById(R.id.common_dialog_title_text);
        mContentTv = (TextView) rootView.findViewById(R.id.common_dialog_content_text);
        mCancelTv = (TextView) rootView.findViewById(R.id.common_dialog_cancel_btn);
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
    public void setCancelBtn(int textId, View.OnClickListener cancelOnClickListener) {
        mCancelTv.setText(textId);
        setOnCancelClickListener(cancelOnClickListener);
    }

    @Override
    public void setCancelBtn(CharSequence text, View.OnClickListener cancelOnClickListener) {
        mCancelTv.setText(text);
        setOnCancelClickListener(cancelOnClickListener);
    }

    @Override
    public void bindAllListeners() {
        mCancelTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogType106.this.onCancelClick(v);
            }
        });
    }

}
