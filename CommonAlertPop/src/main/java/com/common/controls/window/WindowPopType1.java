package com.common.controls.window;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.common.alertpop.R;

/**
 * 类型1 WindowManager
 * 有标题，标题有背景，有文本内容，两个按钮
 */

public class WindowPopType1 extends WindowPopBase {
    private View mTitleRoot;
    private TextView mContentTv;
    private TextView mCancelTv;
    private TextView mOkTv;

    public WindowPopType1(Context context) {
        super(context);
    }

    @Override
    public void initView() {
        View rootView = LayoutInflater.from(mContext).inflate(R.layout.common_windowpop_layout_type1, null);
        mView = rootView;
        mTitleRoot = rootView.findViewById(R.id.common_dialog_title_root);
        mTitleTv = (TextView) rootView.findViewById(R.id.common_dialog_title_text);
        mContentTv = (TextView) rootView.findViewById(R.id.common_dialog_content_text);
        mCancelTv = (TextView) rootView.findViewById(R.id.common_dialog_cancel_btn);
        mOkTv = (TextView) rootView.findViewById(R.id.common_dialog_ok_btn);
    }

    @Override
    public void setTitleBgType(int titleBgType) {
        mTitleRoot.setBackgroundResource(WindowPopUtil.getTitleBgResId(titleBgType));
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
    public void bindAllListeners() {
        mCancelTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WindowPopType1.this.onCancelClick(v);
            }
        });
        mOkTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WindowPopType1.this.onOkClick(v);
            }
        });
    }

}
