package com.common.controls.window;

import android.content.Context;

/**
 * 公共WindowManager弹窗创建工厂
 * 创建对象的时候就会初始化弹窗布局了，请在需要弹对话框的地方才执行创建操作
 */

public class CommonWindowPopFactory {

    public static ICommonWindowPop createWindowPopByType(Context context, int windowPopType) {
        ICommonWindowPop windowPop = null;
        switch (windowPopType) {
            case WindowPopUtil.WINDOW_POP_TYPE_1:
                windowPop = new WindowPopType1(context);
                break;
            case WindowPopUtil.WINDOW_POP_TYPE_2:
                windowPop = new WindowPopType2(context);
                break;
            default:
                windowPop = new WindowPopType1(context);
                break;
        }
        return windowPop;
    }
}
