package com.common.controls.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.common.alertpop.R;

/**
 * 类型105 Dialog
 * 有标题，有自定义布局内容，一个取消按钮
 */

public class DialogType105 extends DialogBase {
    private FrameLayout mContentContainer;
    private TextView mCancelTv;

    public DialogType105(Context context) {
        super(context);
    }

    @Override
    public void initDialog() {
        View rootView = LayoutInflater.from(mContext).inflate(R.layout.common_dialog_layout_type105, null);
        mTitleTv = (TextView) rootView.findViewById(R.id.common_dialog_title_text);
        mContentContainer = (FrameLayout) rootView.findViewById(R.id.common_dialog_content_container);
        mCancelTv = (TextView) rootView.findViewById(R.id.common_dialog_cancel_btn);
        createDialog(rootView);
    }

    @Override
    public void setContentView(int contentLayoutId) {
        LayoutInflater.from(mContext).inflate(contentLayoutId, mContentContainer, true);
    }

    @Override
    public void setContentView(View contentView) {
        mContentContainer.addView(contentView);
    }

    @Override
    public void setContentView(View contentView, ViewGroup.LayoutParams params) {
        mContentContainer.addView(contentView, params);
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
                DialogType105.this.onCancelClick(v);
            }
        });
    }

}
