package com.common.controls.dialog;

import android.content.Context;

import com.common.alertpop.R;

/**
 * 对话框类型整理
 */

public class DialogUtil {
    /** 仅有标题，无内容，两个按钮 */
    public static final int DIALOG_TYPE_1 = 1;
    /** 仅有标题，无内容，一个取消按钮 */
    public static final int DIALOG_TYPE_2 = 2;
    /** 仅有标题（标题前有进度条），无内容，一个取消按钮 */
    public static final int DIALOG_TYPE_3 = 3;
    /** 仅有标题，无内容，一个确定按钮 */
    public static final int DIALOG_TYPE_4 = 4;

    /** 有标题，有文本内容，一个确定按钮 */
    public static final int DIALOG_TYPE_101 = 101;
    /** 有标题，有自定义布局内容，一个确定按钮 */
    public static final int DIALOG_TYPE_102 = 102;
    /** 有标题，有文本内容，两个按钮 */
    public static final int DIALOG_TYPE_103 = 103;
    /** 有标题，有自定义布局内容，两个按钮 */
    public static final int DIALOG_TYPE_104 = 104;
    /** 有标题，有自定义布局内容，一个取消按钮 */
    public static final int DIALOG_TYPE_105 = 105;
    /** 有标题，有文本内容，一个取消按钮 */
    public static final int DIALOG_TYPE_106 = 106;

    /** 有标题，标题有背景，有文本内容，两个按钮 */
    public static final int DIALOG_TYPE_201 = 201;
    /** 有标题，标题有背景，有自定义布局内容，两个按钮 */
    public static final int DIALOG_TYPE_202 = 202;
    /** 有标题，标题有背景，有自定义布局内容，一个确定按钮 */
    public static final int DIALOG_TYPE_203 = 203;

    // 对话框标题背景类型
    /** 安全蓝色背景 */
    public static final int TITLE_SAFE_BLUE = 1;
    /** 风险黄色背景 */
    public static final int TITLE_RISK_YELLOW = 2;
    /** 危险红色背景 */
    public static final int TITLE_DANGER_RED = 3;

    /** 标题文本颜色--红色 */
    public static final int TITLE_TEXT_COLOR_RED = 1;

    /** OK Large 按钮样式（默认）：蓝色背景白色文本 */
    public static final int OK_BTN_LARGE_BLUE_BG_WHITE_TEXT = 1;
    /** OK Small按钮样式（默认）：蓝色背景白色文本 */
    public static final int OK_BTN_SMALL_BLUE_BG_WHITE_TEXT = 2;
    /** OK Large 按钮样式：白色背景蓝色文本 */
    public static final int OK_BTN_LARGE_WHITE_BG_BLUE_TEXT = 3;
    /** OK Small 按钮样式：白色背景蓝色文本 */
    public static final int OK_BTN_SMALL_WHITE_BG_BLUE_TEXT = 4;


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

    public static int getTitleColorResId(int titleColorType, Context context) {
        if (context == null) {
            return 0xff000000;
        }
        int colorResId = -1;
        switch (titleColorType) {
            case TITLE_TEXT_COLOR_RED:
                colorResId = R.color.common_dialog_text_danger_red;
                break;
            default:
                colorResId = R.color.common_dialog_text_normal_black;
                break;
        }
        return context.getResources().getColor(colorResId);
    }

    public static int getOkBtnBgResId(int okBtnStyleType) {
        int bgResId = -1;
        switch (okBtnStyleType) {
            case OK_BTN_LARGE_BLUE_BG_WHITE_TEXT:
                bgResId = R.drawable.common_dialog_ok_large_btn_selector;
                break;
            case OK_BTN_SMALL_BLUE_BG_WHITE_TEXT:
                bgResId = R.drawable.common_dialog_ok_small_btn_blue_selector;
                break;
            case OK_BTN_LARGE_WHITE_BG_BLUE_TEXT:
                bgResId = R.drawable.common_dialog_ok_large_btn_white_selector;
                break;
            case OK_BTN_SMALL_WHITE_BG_BLUE_TEXT:
                bgResId = R.drawable.common_dialog_ok_small_btn_white_selector;
                break;
            default:
                bgResId = R.drawable.common_dialog_ok_small_btn_blue_selector;
                break;
        }
        return bgResId;
    }

    public static int getOkBtnTextColorValue(int okBtnStyleType, Context context) {
        int colorResId = -1;
        if (context == null) return colorResId;
        switch (okBtnStyleType) {
            case OK_BTN_LARGE_BLUE_BG_WHITE_TEXT:
            case OK_BTN_SMALL_BLUE_BG_WHITE_TEXT:
                colorResId = android.R.color.white;
                break;
            case OK_BTN_LARGE_WHITE_BG_BLUE_TEXT:
            case OK_BTN_SMALL_WHITE_BG_BLUE_TEXT:
                colorResId = R.color.common_dialog_text_blue;
                break;
            default:
                colorResId = android.R.color.white;
                break;
        }
        return context.getResources().getColor(colorResId);
    }

    public static boolean isBtnMiddleDividerVisible(int okBtnStyleType) {
        switch (okBtnStyleType) {
            case OK_BTN_SMALL_WHITE_BG_BLUE_TEXT:
                return true;
            default:
                return false;
        }
    }

    /**
     * 获取内容应该显示的宽度(px)
     */
    public static int getContentWidth(Context context) {
        if (context == null || context.getResources() == null || context.getResources().getDisplayMetrics() == null) {
            return 480;
        }
        int width = context.getResources().getDisplayMetrics().widthPixels;
        if (width > 720) {      // 屏幕宽度大于720px则取屏幕宽度的95%作为内容的宽度
            width = width * 95 / 100;
        }
        return width;
    }

    /**
     * 获取屏幕宽度(px)
     */
    public static int getScreenWidth(Context context) {
        if (context == null || context.getResources() == null || context.getResources().getDisplayMetrics() == null) {
            return 480;
        }
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    /**
     * 获取屏幕高度(px)
     */
    public static int getScreenHeight(Context context) {
        if (context == null || context.getResources() == null || context.getResources().getDisplayMetrics() == null) {
            return 800;
        }
        return context.getResources().getDisplayMetrics().heightPixels;
    }
    /**
     * dip 转 px
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
