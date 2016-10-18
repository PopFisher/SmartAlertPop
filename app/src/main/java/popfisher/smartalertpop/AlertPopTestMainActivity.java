package popfisher.smartalertpop;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.common.controls.dialog.CommonDialogFactory;
import com.common.controls.dialog.DialogUtil;
import com.common.controls.dialog.ICommonDialog;
import com.common.controls.window.ICommonWindowPop;

public class AlertPopTestMainActivity extends Activity implements View.OnClickListener {

    private Button mButton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_pop_test_main);
        findViewById(R.id.alert_pop_type1).setOnClickListener(this);
        findViewById(R.id.alert_pop_type2).setOnClickListener(this);
        findViewById(R.id.alert_pop_type3).setOnClickListener(this);
        findViewById(R.id.alert_pop_type4).setOnClickListener(this);
        findViewById(R.id.alert_pop_type101).setOnClickListener(this);
        findViewById(R.id.alert_pop_type102).setOnClickListener(this);
        findViewById(R.id.alert_pop_type103).setOnClickListener(this);
        findViewById(R.id.alert_pop_type104).setOnClickListener(this);
        findViewById(R.id.alert_pop_type105).setOnClickListener(this);
        findViewById(R.id.alert_pop_type106).setOnClickListener(this);
        findViewById(R.id.alert_pop_type201).setOnClickListener(this);
        findViewById(R.id.alert_pop_type202).setOnClickListener(this);
        findViewById(R.id.alert_pop_type203).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        mButton1 = (Button) findViewById(R.id.alert_pop_type1);
        final int id = v.getId();
        final ICommonDialog dialog;
        switch (id) {
            case R.id.alert_pop_type1:
                dialog = CommonDialogFactory.createDialogByType(this, DialogUtil.DIALOG_TYPE_1);
                dialog.setTitleText("DIALOG_TYPE_1");
                dialog.setCancelBtn(R.string.cancel, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                dialog.setOkBtn(R.string.ok, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.setCanceledOnTouchOutside(true);
                dialog.show();
                break;
            case R.id.alert_pop_type2:
                dialog = CommonDialogFactory.createDialogByType(this, DialogUtil.DIALOG_TYPE_2);
                dialog.setTitleText("DIALOG_TYPE_2");
                dialog.setCancelBtn(R.string.cancel, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                dialog.show();
                break;
            case R.id.alert_pop_type3:
                dialog = CommonDialogFactory.createDialogByType(this, DialogUtil.DIALOG_TYPE_3);
                dialog.setTitleText("DIALOG_TYPE_3");
                dialog.setCancelBtn(R.string.cancel, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                dialog.show();
                break;
            case R.id.alert_pop_type4:
                dialog = CommonDialogFactory.createDialogByType(this, DialogUtil.DIALOG_TYPE_4);
                dialog.setTitleText("DIALOG_TYPE_4");
                dialog.setOkBtn(R.string.ok, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
                break;
            case R.id.alert_pop_type101:
                dialog = CommonDialogFactory.createDialogByType(this, DialogUtil.DIALOG_TYPE_101);
                dialog.setTitleText("DIALOG_TYPE_101");
                dialog.setContentText(R.string.dialog_content);
                dialog.setOkBtn(R.string.ok, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
                break;
            case R.id.alert_pop_type102:
                dialog = CommonDialogFactory.createDialogByType(this, DialogUtil.DIALOG_TYPE_102);
                dialog.setTitleText("DIALOG_TYPE_102");
                dialog.setContentView(R.layout.dialog_custom_content_test_layout);
                dialog.setOkBtn(R.string.ok, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
                break;
            case R.id.alert_pop_type103:
                dialog = CommonDialogFactory.createDialogByType(this, DialogUtil.DIALOG_TYPE_103);
                dialog.setTitleText("DIALOG_TYPE_103");
                dialog.setContentText(R.string.dialog_content);
                dialog.setOkBtn(R.string.ok, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.setCancelBtn(R.string.cancel, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                dialog.show();
                break;
            case R.id.alert_pop_type104:
                dialog = CommonDialogFactory.createDialogByType(this, DialogUtil.DIALOG_TYPE_104);
                dialog.setTitleText("DIALOG_TYPE_104");
                dialog.setContentView(R.layout.dialog_custom_content_test_layout);
                dialog.setOkBtn(R.string.ok, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.setCancelBtn(R.string.cancel, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                dialog.show();
                break;
            case R.id.alert_pop_type105:
                dialog = CommonDialogFactory.createDialogByType(this, DialogUtil.DIALOG_TYPE_105);
                dialog.setTitleText("DIALOG_TYPE_105");
                dialog.setContentView(R.layout.dialog_custom_content_test_layout);
                dialog.setCancelBtn(R.string.cancel, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                dialog.show();
                break;
            case R.id.alert_pop_type106:
                dialog = CommonDialogFactory.createDialogByType(this, DialogUtil.DIALOG_TYPE_106);
                dialog.setTitleText("DIALOG_TYPE_106");
                dialog.setContentText(R.string.dialog_content);
                dialog.setCancelBtn(R.string.cancel, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                dialog.show();
                break;
            case R.id.alert_pop_type201:
                dialog = CommonDialogFactory.createDialogByType(this, DialogUtil.DIALOG_TYPE_201);
                dialog.setTitleText("DIALOG_TYPE_201");
                dialog.setContentText(R.string.dialog_content);
                dialog.setCancelBtn(R.string.cancel, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                dialog.setOkBtn(R.string.ok, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
                break;
            case R.id.alert_pop_type202:
                dialog = CommonDialogFactory.createDialogByType(this, DialogUtil.DIALOG_TYPE_202);
                dialog.setTitleText("DIALOG_TYPE_202");
                dialog.setTitleBgType(DialogUtil.TITLE_DANGER_RED);
                dialog.setContentView(R.layout.dialog_custom_content_test_layout);
                dialog.setCancelBtn(R.string.cancel, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                dialog.setOkBtn(R.string.ok, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
                break;
            case R.id.alert_pop_type203:
                dialog = CommonDialogFactory.createDialogByType(this, DialogUtil.DIALOG_TYPE_203);
                dialog.setTitleText("DIALOG_TYPE_203");
                dialog.setTitleBgType(DialogUtil.TITLE_RISK_YELLOW);
                dialog.setContentView(R.layout.dialog_custom_content_test_layout);
                dialog.setOkBtn(R.string.ok, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
                break;
            default:
                break;
        }
    }
}
