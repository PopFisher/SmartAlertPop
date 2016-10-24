package com.common.controls.window;

import android.content.Context;
import android.graphics.PixelFormat;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.TextView;

import com.common.controls.dialog.DialogUtil;


/**
 * 使用WindowManager弹窗的基类
 * 这个类会实现ICommonWindowPop的所有接口，这样任何一种类型的弹窗调用都不会出错
 * 不支持的部分调用相应的方法时无效，不会导致崩溃
 */

public abstract class WindowPopBase implements ICommonWindowPop {
    protected WindowManager mWindowManager;
    protected WindowManager.LayoutParams mLayoutParams;
    protected Context mContext;
    protected View mView;
    protected View mContentView;
    protected TextView mTitleTv;

    protected boolean mIsShow = false;
    protected boolean isCanceledOnTouchOutside = false;
    private int mWindowHeight = 0;
    protected View.OnClickListener mCancelOnClickListener;
    protected View.OnClickListener mOkOnClickListener;

    private int mCurWindowType = WindowManager.LayoutParams.TYPE_TOAST;

    public abstract void initView();
    public abstract void bindAllListeners();

    public WindowPopBase(Context context) {
        mContext = context;
        mLayoutParams = new WindowManager.LayoutParams();
        mLayoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        mLayoutParams.height = WindowManager.LayoutParams.MATCH_PARENT;
        mLayoutParams.format = PixelFormat.RGBA_8888;
        mLayoutParams.flags = WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN;
        mLayoutParams.gravity = Gravity.TOP | Gravity.CENTER_HORIZONTAL;
        initView();
        bindAllListeners();
        bindWindowListeners();
        // mView必须获取焦点才能接受OnKeyListener
        mView.setFocusableInTouchMode(true);
        ViewGroup group = (ViewGroup) mView;
        mContentView = group.getChildAt(0);
        mContentView.getLayoutParams().width = DialogUtil.getContentWidth(mContext);
        mContentView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;    // 拦击所有事件
            }
        });
        mContentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                autoAdjustHeight();
            }
        });
    }

    private void bindWindowListeners() {
        mView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN && isCanceledOnTouchOutside) {
                    dismiss();
                    return true;
                }
                return false;
            }
        });
        mView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((keyCode == KeyEvent.KEYCODE_MENU || keyCode == KeyEvent.KEYCODE_BACK) && event.getAction() == KeyEvent.ACTION_DOWN) {
                    dismiss();
                    return true;
                }
                return false;
            }
        });
    }

    private void init(Context context) {
        mWindowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        mCurWindowType = WindowManager.LayoutParams.TYPE_TOAST;
        mLayoutParams.type = mCurWindowType;
    }

    public void onCancelClick(View v) {
        dismiss();
        if (mCancelOnClickListener != null) mCancelOnClickListener.onClick(v);
    }

    public void onOkClick(View v) {
        if (mOkOnClickListener != null) mOkOnClickListener.onClick(v);
    }

    @Override
    public void dismiss() {
        if (mWindowManager != null) {
            try {
                if (null != mView) {
                    mWindowManager.removeView(mView);
                    mView = null;
                }
                mIsShow = false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void show() {
        init(mContext);

        if (!mIsShow) {
            if (null != mWindowManager && null != mView) {
                try {
                    mWindowManager.addView(mView, mLayoutParams);
                    mIsShow = true;
                } catch (WindowManager.BadTokenException e) {
                    tryShowAgain();
                } catch (Exception e) {

                }
            }
        }
    }

    private void tryShowAgain() {
        if (mCurWindowType == WindowManager.LayoutParams.TYPE_TOAST) {
            mLayoutParams.type = WindowManager.LayoutParams.TYPE_PHONE;
            try {
                mWindowManager.addView(mView, mLayoutParams);
                mIsShow = true;
            } catch (Exception e) {

            }
        } else if (mCurWindowType == WindowManager.LayoutParams.TYPE_PHONE) {
            mLayoutParams.type = WindowManager.LayoutParams.TYPE_TOAST;
            try {
                mWindowManager.addView(mView, mLayoutParams);
                mIsShow = true;
            } catch (Exception e) {

            }
        }
    }

    private void autoAdjustHeight() {
        // 高度不超过屏幕高度的80%
        int maxHeight = (int) (DialogUtil.getScreenHeight(mContext) * 0.8);
        int height = mContentView.getHeight();
        if (height > maxHeight) {
            height = maxHeight;
            if (mWindowHeight != height) {
                mWindowHeight = height;
                mContentView.getLayoutParams().height = mWindowHeight;
                mContentView.requestFocus();
            }
        }
    }

    public final View findViewById(int id) {
        if (id < 0) {
            return null;
        }
        return mView.findViewById(id);
    }

    protected boolean initViewFailed() {
        return null == mView;
    }

    @Override
    public void setTitleText(int titleStrId) {
        mTitleTv.setText(titleStrId);
    }

    @Override
    public void setTitleText(CharSequence titleStr) {
        mTitleTv.setText(titleStr);
    }

    @Override
    public void setTitleBgType(int titleBgType) { }

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
    public void clearContentMargin() { }

    @Override
    public void setCancelBtn(int textId, View.OnClickListener cancelOnClickListener) { }

    @Override
    public void setCancelBtn(CharSequence text, View.OnClickListener cancelOnClickListener) { }

    @Override
    public void setOkBtn(int textId, View.OnClickListener okOnClickListener) { }

    @Override
    public void setOkBtn(CharSequence text, View.OnClickListener okOnClickListener) { }

    public void setOnCancelClickListener(View.OnClickListener cancelClickListener) {
        mCancelOnClickListener = cancelClickListener;
    }

    public void setOnOkClickListener(View.OnClickListener okClickListener) {
        mOkOnClickListener = okClickListener;
    }

    @Override
    public void setCanceledOnTouchOutside(boolean canceledOnTouchOutside) {
        isCanceledOnTouchOutside = canceledOnTouchOutside;
    }

    @Override
    public boolean isShow() {
        return mIsShow;
    }
}
