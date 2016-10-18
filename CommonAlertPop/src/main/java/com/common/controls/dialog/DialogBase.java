package com.common.controls.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.common.alertpop.R;

/**
 * 这个类会实现ICommonFlatDialog的所有接口，这样任何一种类型的对话框调用都不会出错
 * 不支持的部分调用相应的方法时无效，不会导致崩溃
 */
public abstract class DialogBase implements ICommonDialog {

    protected CoreDialog mDialog = null;
    protected Context mContext;
    protected TextView mTitleTv;
    protected View.OnClickListener mCancelOnClickListener;
    protected View.OnClickListener mOkOnClickListener;

    public abstract void initDialog();
    public abstract void bindAllListeners();

    public DialogBase(Context context) {
        mContext = context;
        initDialog();
        bindAllListeners();
    }

    protected void createDialog(View rootView) {
        if (mDialog == null) {
            mDialog = new CoreDialog(mContext, R.style.dialog, rootView, true);
            mDialog.setPosition(Gravity.CENTER, 0, 0);
            mDialog.setCanceledOnTouchOutside(false);
        }
    }

    public void onCancelClick(View v) {
        dismiss();
        if (mCancelOnClickListener != null) mCancelOnClickListener.onClick(v);
    }

    public void onOkClick(View v) {
        if (mOkOnClickListener != null) mOkOnClickListener.onClick(v);
    }

    @Override
    public void setTitleText(int titleStrId) {
       if (mTitleTv != null) mTitleTv.setText(titleStrId);
    }

    @Override
    public void setTitleText(CharSequence titleStr) {
        if (mTitleTv != null) mTitleTv.setText(titleStr);
    }

    @Override
    public void setTitleBgType(int titleBgType) { }

    @Override
    public void setTitleColorType(int titleColorType) {
        if (mTitleTv != null) mTitleTv.setTextColor(DialogUtil.getTitleColorResId(titleColorType, mTitleTv.getContext()));
    }

    @Override
    public void setContentText(int contentStrId) { }

    @Override
    public void setContentText(CharSequence contentStr) { }

    @Override
    public void setContentView(int contentLayoutId) { }

    @Override
    public void setContentView(View contentView) { }

    @Override
    public void setContentView(View contentView, ViewGroup.LayoutParams params) { }

    @Override
    public void setCancelBtn(int textId, View.OnClickListener cancelOnClickListener) { }

    @Override
    public void setCancelBtn(CharSequence text, View.OnClickListener cancelOnClickListener) { }

    @Override
    public void setOkBtn(int textId, View.OnClickListener okOnClickListener) { }

    @Override
    public void setOkBtn(CharSequence text, View.OnClickListener okOnClickListener) { }

    @Override
    public void setOkBtnStyleType(int okBtnStyleType) { }

    public void setOnCancelClickListener(View.OnClickListener cancelClickListener) {
        mCancelOnClickListener = cancelClickListener;
    }

    public void setOnOkClickListener(View.OnClickListener okClickListener) {
        mOkOnClickListener = okClickListener;
    }

    @Override
    public void setCanceledOnTouchOutside(boolean canceledOnTouchOutside) {
        if (mDialog != null) mDialog.setCanceledOnTouchOutside(canceledOnTouchOutside);
    }

    @Override
    public void setOnDismissListener(DialogInterface.OnDismissListener listener) {
        if (mDialog != null) mDialog.setOnDismissListener(listener);
    }

    @Override
    public void setOnShowListener(DialogInterface.OnShowListener listener) {
        if (mDialog != null) mDialog.setOnShowListener(listener);
    }

    @Override
    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        if (mDialog != null) mDialog.setOnKeyListener(onKeyListener);
    }

    @Override
    public void setCancelable(boolean b) {
        if (mDialog != null) mDialog.setCancelable(b);
    }

    @Override
    public boolean isShow() {
        if (mDialog == null)
            return false;
        return mDialog.isShowing();
    }

    @Override
    public void show() {
        if (mDialog != null) {
            if (mContext instanceof Activity) {
                Activity activity = (Activity) mContext;
                if (!activity.isFinishing()) {
                    mDialog.show();
                }
            } else {
                mDialog.show();
            }
        }
    }

    @Override
    public void dismiss() {
        if (mDialog != null) mDialog.dismiss();
    }

    @Override
    public void cancel() {
        if (mDialog != null) mDialog.cancel();
    }

    @Override
    public CoreDialog getCoreDialog() {
        return mDialog;
    }
}