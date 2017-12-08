package com.neo.baidumap.themecustdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * Created by Neo on 2017\12\8 0008.
 */

public class CustomActionbar extends RelativeLayout {

    private ImageView button_back;
    private ImageView button_option;
    private ImageView button_else;
    private TextView title;

    private ActionbarClickedListener actionbarClickedListener;

    public CustomActionbar(Context context) {
        this(context, null);
    }

    public CustomActionbar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomActionbar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        LayoutInflater.from(context).inflate(R.layout.custom_action_bar, this, true);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        button_back = (ImageView) findViewById(R.id.button_back);
        button_back.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                if (actionbarClickedListener != null) {
                    actionbarClickedListener.onActionbarCancelClicked();
                }
            }
        });
        button_option = (ImageView) findViewById(R.id.button_option);
        button_option.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                if (actionbarClickedListener != null) {
                    actionbarClickedListener.onActionbarOKClicked();
                }
            }
        });

        button_else = (ImageView) findViewById(R.id.button_else);
        button_else.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                if (actionbarClickedListener != null) {
                    actionbarClickedListener.onActionbarElseClicked();
                }
            }
        });

        title = (TextView) findViewById(R.id.title);
    }

    //设置标题
    public void setTitle(int resId){
        title.setText(resId);
        title.setVisibility(View.VISIBLE);
    }

    //设置左边图片
    public void setBackImage(int resId){
        button_back.setImageResource(resId);
    }

    //设置右边图片
    public void setOptionImage(int resId){
        button_option.setImageResource(resId);
    }

    //设置备用图片
    public void setElseImage(int resId){
        button_else.setImageResource(resId);
    }

    public void setActionbarClickedListener(ActionbarClickedListener actionbarClickedListener){
        this.actionbarClickedListener = actionbarClickedListener;
    }

    public interface ActionbarClickedListener {
        public void onActionbarOKClicked();
        public void onActionbarCancelClicked();
        public void onActionbarElseClicked();
    }
}