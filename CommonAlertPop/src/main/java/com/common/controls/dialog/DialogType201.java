package com.common.controls.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.common.alertpop.R;


/**
 * 类型201 Dialog
 * 有标题，标题有背景，有文本内容，两个按钮
 */

public class DialogType201 extends DialogBase {
    private View mTitleRoot;
    private TextView mContentTv;
    private TextView mCancelTv;
    private TextView mOkTv;
    private View mMiddleDivider;

    public DialogType201(Context context) {
        super(context);
    }

    @Override
    public void initDialog() {
        View rootView = LayoutInflater.from(mContext).inflate(R.layout.common_dialog_layout_type201, null);
        mTitleRoot = rootView.findViewById(R.id.common_dialog_title_root);
        mTitleTv = (TextView) rootView.findViewById(R.id.common_dialog_title_text);
        mContentTv = (TextView) rootView.findViewById(R.id.common_dialog_content_text);
        mCancelTv = (TextView) rootView.findViewById(R.id.common_dialog_cancel_btn);
        mOkTv = (TextView) rootView.findViewById(R.id.common_dialog_ok_btn);
        mMiddleDivider = rootView.findViewById(R.id.common_dialog_btn_middle_divider);
        createDialog(rootView);
    }

    @Override
    public void setTitleBgType(int titleBgType) {
        mTitleRoot.setBackgroundResource(DialogUtil.getTitleBgResId(titleBgType));
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
                DialogType201.this.onCancelClick(v);
            }
        });
        mOkTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogType201.this.onOkClick(v);
            }
        });
    }

}
