package com.common.controls.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.common.alertpop.R;

/**
 * 类型104 Dialog
 * 有标题，有自定义布局内容，两个按钮
 */

public class DialogType104 extends DialogBase {
    private FrameLayout mContentContainer;
    private TextView mCancelTv;
    private TextView mOkTv;
    private View mMiddleDivider;

    public DialogType104(Context context) {
        super(context);
    }

    @Override
    public void initDialog() {
        View rootView = LayoutInflater.from(mContext).inflate(R.layout.common_dialog_layout_type104, null);
        mTitleTv = (TextView) rootView.findViewById(R.id.common_dialog_title_text);
        mContentContainer = (FrameLayout) rootView.findViewById(R.id.common_dialog_content_container);
        mCancelTv = (TextView) rootView.findViewById(R.id.common_dialog_cancel_btn);
        mOkTv = (TextView) rootView.findViewById(R.id.common_dialog_ok_btn);
        mMiddleDivider = rootView.findViewById(R.id.common_dialog_btn_middle_divider);
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
        mMiddleDivider.setVisibility(DialogUtil.isBtnMiddleDividerVisible(okBtnStyleType) ? View.VISIBLE : View.GONE);
    }

    @Override
    public void bindAllListeners() {
        mCancelTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogType104.this.onCancelClick(v);
            }
        });
        mOkTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogType104.this.onOkClick(v);
            }
        });
    }

}
