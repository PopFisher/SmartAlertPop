package com.common.controls.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.common.alertpop.R;

/**
 * 类型4 Dialog
 * 仅有标题，无内容，一个确定按钮
 */

public class DialogType4 extends DialogBase {
    private TextView mOkTv;

    public DialogType4(Context context) {
        super(context);
    }

    @Override
    public void initDialog() {
        View rootView = LayoutInflater.from(mContext).inflate(R.layout.common_dialog_layout_type4, null);
        mTitleTv = (TextView) rootView.findViewById(R.id.common_dialog_title_text);
        mOkTv = (TextView) rootView.findViewById(R.id.common_dialog_ok_btn);
        createDialog(rootView);
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
                DialogType4.this.onOkClick(v);
            }
        });
    }

}
