package com.common.controls.window;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.common.alertpop.R;


/**
 * 类型2 WindowManager
 * 有标题，有自定义布局内容，两个按钮
 */

public class WindowPopType2 extends WindowPopBase {
    private View mTitleRoot;
    private FrameLayout mContentContainer;
    private TextView mCancelTv;
    private TextView mOkTv;

    public WindowPopType2(Context context) {
        super(context);
    }

    @Override
    public void initView() {
        View rootView = LayoutInflater.from(mContext).inflate(R.layout.common_windowpop_layout_type2, null);
        mView = rootView;
        mTitleRoot = rootView.findViewById(R.id.common_dialog_title_root);
        mTitleTv = (TextView) rootView.findViewById(R.id.common_dialog_title_text);
        mContentContainer = (FrameLayout) rootView.findViewById(R.id.common_dialog_content_container);
        mCancelTv = (TextView) rootView.findViewById(R.id.common_dialog_cancel_btn);
        mOkTv = (TextView) rootView.findViewById(R.id.common_dialog_ok_btn);
    }

    @Override
    public void setTitleBgType(int titleBgType) {
        mTitleRoot.setBackgroundResource(WindowPopUtil.getTitleBgResId(titleBgType));
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
    public void clearContentMargin() {
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) mContentContainer.getLayoutParams();
        params.leftMargin = 0;
        params.rightMargin = 0;
        params.topMargin = 0;
        params.bottomMargin = 0;
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
                WindowPopType2.this.onCancelClick(v);
            }
        });
        mOkTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WindowPopType2.this.onOkClick(v);
            }
        });
    }

}
