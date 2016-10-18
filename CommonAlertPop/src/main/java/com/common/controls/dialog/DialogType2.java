package com.common.controls.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.common.alertpop.R;

/**
 * 类型2 Dialog
 * 仅有标题，无内容，一个取消按钮
 */

public class DialogType2 extends DialogBase {
    private TextView mCancelTv;

    public DialogType2(Context context) {
        super(context);
    }

    @Override
    public void initDialog() {
        View rootView = LayoutInflater.from(mContext).inflate(R.layout.common_dialog_layout_type2, null);
        mTitleTv = (TextView) rootView.findViewById(R.id.common_dialog_title_text);
        mCancelTv = (TextView) rootView.findViewById(R.id.common_dialog_cancel_btn);
        createDialog(rootView);
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
                DialogType2.this.onCancelClick(v);
            }
        });
    }

}
