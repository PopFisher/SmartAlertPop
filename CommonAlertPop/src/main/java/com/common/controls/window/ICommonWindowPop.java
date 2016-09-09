package com.common.controls.window;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public interface ICommonWindowPop {
    void setTitleText(int titleStrId);
    void setTitleText(CharSequence titleStr);
    void setTitleBgType(int titleBgType);
    void setContentText(int contentStrId);
    void setContentText(CharSequence contentStr);
    void setContentView(int contentLayoutId);
    void setContentView(View contentView);
    void setContentView(View contentView, ViewGroup.LayoutParams params);
    void clearContentMargin();
    void setCancelBtnText(int textId);
    void setCancelBtnText(CharSequence text);
    void setOkBtnText(int textId);
    void setOkBtnText(CharSequence text);
    void setOnCancelClickListener(OnClickListener cancelClickListener);
    void setOnOkClickListener(OnClickListener okClickListener);
    void setCanceledOnTouchOutside(boolean canceledOnTouchOutside);

    boolean isShow();

    void show();
    void remove();
}