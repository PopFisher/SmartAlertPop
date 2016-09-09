package com.common.controls.window;


import com.common.alertpop.R;

/**
 * WindowManager弹窗工具类
 */

public class WindowPopUtil {

    /** 有标题，标题有背景，有文本内容，两个按钮 */
    public static final int WINDOW_POP_TYPE_1 = 1;
    /** 有标题，标题有背景，有自定义布局内容，两个按钮 */
    public static final int WINDOW_POP_TYPE_2 = 2;

    // Window弹窗标题背景类型
    /** 安全蓝色背景 */
    public static final int TITLE_SAFE_BLUE = 1;
    /** 风险黄色背景 */
    public static final int TITLE_RISK_YELLOW = 2;
    /** 危险红色背景 */
    public static final int TITLE_DANGER_RED = 3;

    public static int getTitleBgResId(int titleBgType) {
        int bgResId = -1;
        switch (titleBgType) {
            case TITLE_SAFE_BLUE:
                bgResId = R.drawable.common_dialog_title_safe_blue_bg;
                break;
            case TITLE_RISK_YELLOW:
                bgResId = R.drawable.common_dialog_title_risk_yellow_bg;
                break;
            case TITLE_DANGER_RED:
                bgResId = R.drawable.common_dialog_title_danger_red_bg;
                break;
            default:
                bgResId = R.drawable.common_dialog_title_safe_blue_bg;
                break;
        }
        return bgResId;
    }
}
