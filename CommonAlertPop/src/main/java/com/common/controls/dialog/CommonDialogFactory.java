package com.common.controls.dialog;

import android.content.Context;

/**
 * 公共对话框创建工厂
 * 创建对象的时候就会初始化对话框布局了，请在需要弹对话框的地方才执行创建操作
 */

public class CommonDialogFactory {

    public static ICommonDialog createDialogByType(Context context, int dialogType) {
        ICommonDialog dialog = null;
        switch (dialogType) {
            case DialogUtil.DIALOG_TYPE_1:
                dialog = new DialogType1(context);
                break;
            case DialogUtil.DIALOG_TYPE_2:
                dialog = new DialogType2(context);
                break;
            case DialogUtil.DIALOG_TYPE_3:
                dialog = new DialogType3(context);
                break;
            case DialogUtil.DIALOG_TYPE_4:
                dialog = new DialogType4(context);
                break;
            case DialogUtil.DIALOG_TYPE_101:
                dialog = new DialogType101(context);
                break;
            case DialogUtil.DIALOG_TYPE_102:
                dialog = new DialogType102(context);
                break;
            case DialogUtil.DIALOG_TYPE_103:
                dialog = new DialogType103(context);
                break;
            case DialogUtil.DIALOG_TYPE_104:
                dialog = new DialogType104(context);
                break;
            case DialogUtil.DIALOG_TYPE_105:
                dialog = new DialogType105(context);
                break;
            case DialogUtil.DIALOG_TYPE_106:
                dialog = new DialogType106(context);
                break;
            case DialogUtil.DIALOG_TYPE_201:
                dialog = new DialogType201(context);
                break;
            case DialogUtil.DIALOG_TYPE_202:
                dialog = new DialogType202(context);
                break;
            case DialogUtil.DIALOG_TYPE_203:
                dialog = new DialogType203(context);
                break;
            default:
                dialog = new DialogType1(context);
                break;
        }
        return dialog;
    }
}
