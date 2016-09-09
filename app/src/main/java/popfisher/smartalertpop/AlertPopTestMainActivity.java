package popfisher.smartalertpop;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.common.controls.dialog.CommonDialogFactory;
import com.common.controls.dialog.DialogUtil;
import com.common.controls.dialog.ICommonDialog;
import com.common.controls.window.ICommonWindowPop;

public class AlertPopTestMainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_pop_test_main);
        findViewById(R.id.alert_pop_type1).setOnClickListener(this);
        findViewById(R.id.alert_pop_type2).setOnClickListener(this);
        findViewById(R.id.alert_pop_type3).setOnClickListener(this);
        findViewById(R.id.alert_pop_type4).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final int id = v.getId();
        ICommonDialog dialog;
        switch (id) {
            case R.id.alert_pop_type1:
                dialog = CommonDialogFactory.createDialogByType(this, DialogUtil.DIALOG_TYPE_1);
                dialog.setTitleText("类型1对话框标题");
                dialog.show();
                break;
            case R.id.alert_pop_type2:
                dialog = CommonDialogFactory.createDialogByType(this, DialogUtil.DIALOG_TYPE_2);
                dialog.setTitleText("类型2对话框标题");
                dialog.show();
                break;
            case R.id.alert_pop_type3:
                dialog = CommonDialogFactory.createDialogByType(this, DialogUtil.DIALOG_TYPE_3);
                dialog.setTitleText("类型3对话框标题");
                dialog.show();
                break;
            case R.id.alert_pop_type4:
                dialog = CommonDialogFactory.createDialogByType(this, DialogUtil.DIALOG_TYPE_4);
                dialog.setTitleText("类型4对话框标题");
                dialog.show();
                break;

        }
    }
}
