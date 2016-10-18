package com.common.controls.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;


public class CoreDialog extends Dialog {
	private Window mWindow = null;
	private View mView = null;
	private boolean isTouchToDismiss = true;
	private Context mContext = null;
    private boolean mNonActivityLevelDialog = false;
	private int mDialogHeight;

	public CoreDialog(Context context, int theme, View view) {
		super(context, theme);
		mView = view;
		mWindow = getWindow();
		mContext = context;
	}

	public void setDialogSize(int width, int height) {
		if (mWindow != null) {
			WindowManager.LayoutParams lp = mWindow.getAttributes();
			if (width > 0) {
				lp.width = width;
			}
			if (height > 0) {
				lp.height = height;
			}
			mWindow.setAttributes(lp);
		}
	}

	public CoreDialog(Context context, int theme, View view, boolean isDismiss) {
		super(context, theme);
		mView = view;
		mWindow = getWindow();
		mContext = context;
		isTouchToDismiss = isDismiss;
	}

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(mView);
		mView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
			@Override
			public void onGlobalLayout() {
				autoAdjustHeight();
			}
		});
		try {
			int contentWidth = DialogUtil.getContentWidth(getContext());
			setDialogSize(contentWidth, 0);
		} catch (Exception e) {

		}
		if (!isTouchToDismiss) {
			setCanceledOnTouchOutside(false);
		}
	}

	// 设置显示位置
	public void setPosition(int gravity, int x, int y) {
		WindowManager.LayoutParams lp = mWindow.getAttributes();
		lp.x = x;
		lp.y = y;
		lp.gravity = gravity;
		mWindow.setAttributes(lp);
	}

	// 设置动画效果
	public void setAnimation(int resId) {
		mWindow.setWindowAnimations(resId);
	}

	@Override
	public void show() {
		if (!mNonActivityLevelDialog && !isActivityValid()) {
			return;
		}

		try {
			super.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void autoAdjustHeight() {
		// 高度不超过屏幕高度的80%
		int maxHeight = (int) (DialogUtil.getScreenHeight(mContext) * 0.8);
		int height = mView.getHeight();
		if (height > maxHeight) {
			height = maxHeight;
			if (mDialogHeight != height) {
				mDialogHeight = height;
				setDialogSize(0, mDialogHeight);
			}
		}
	}

	@Override
	public void dismiss() {
		try {
			super.dismiss();
		} catch (Exception e) {
		}
	}

	// ///////////////////////////////////
	// /< private
	private boolean isActivityValid() {
		if (null != mContext && mContext instanceof Activity) {
			Activity at = (Activity) mContext;
			if (at.isFinishing()) {
				// /< 是 activity，但已finish
				return false;
			} else {
				// /< 是activity，还在运行中...
				return true;
			}
		} else {
			// /< context无效 或 context不是有效的activity
			return false;
		}
	}
}
