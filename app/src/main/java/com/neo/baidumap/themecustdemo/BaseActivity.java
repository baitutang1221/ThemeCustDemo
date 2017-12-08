package com.neo.baidumap.themecustdemo;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity implements CustomActionbar.ActionbarClickedListener {

    private TextView textView3;
    private CustomActionbar customActionbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }

        textView3 = (TextView) findViewById(R.id.textView3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BaseActivity.this, "click_text", Toast.LENGTH_SHORT).show();
            }
        });

        customActionbar = (CustomActionbar) findViewById(R.id.customActionbar);
        customActionbar.setActionbarClickedListener(this);
        customActionbar.setTitle(R.string.app_name);

    }

    @Override
    public void onActionbarOKClicked() {
        Toast.makeText(BaseActivity.this, "click_ok", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onActionbarCancelClicked() {
        Toast.makeText(BaseActivity.this, "click_cancel", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onActionbarElseClicked() {
        Toast.makeText(BaseActivity.this, "click_else", Toast.LENGTH_SHORT).show();
    }
}
