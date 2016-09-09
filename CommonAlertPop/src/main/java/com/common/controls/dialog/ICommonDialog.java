package com.common.controls.dialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public interface ICommonDialog {
    void setTitleText(int titleStrId);
    void setTitleText(CharSequence titleStr);
    void setTitleColorType(int titleColorType);
    void setTitleBgType(int titleBgType);
    void setContentText(int contentStrId);
    void setContentText(CharSequence contentStr);
    void setContentView(int contentLayoutId);
    void setContentView(View contentView);
    void setContentView(View contentView, ViewGroup.LayoutParams params);
    void setCancelBtnText(int textId);
    void setCancelBtnText(CharSequence text);
    void setOkBtnText(int textId);
    void setOkBtnText(CharSequence text);
    void setOkBtnStyleType(int okBtnStyleType);
    void setOnCancelClickListener(OnClickListener cancelClickListener);
    void setOnOkClickListener(OnClickListener okClickListener);
    void setCanceledOnTouchOutside(boolean canceledOnTouchOutside);
    void setOnDismissListener(DialogInterface.OnDismissListener listener);
    void setOnShowListener(DialogInterface.OnShowListener listener);
    void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener);
    void setCancelable(boolean b);

    CoreDialog getCoreDialog();

    boolean isShow();

    void show();
    void dismiss();
    void cancel();
}