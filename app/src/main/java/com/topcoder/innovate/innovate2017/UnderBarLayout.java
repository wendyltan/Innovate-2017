package com.topcoder.innovate.innovate2017;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by Wendy on 2017/9/5.
 */

public class UnderBarLayout extends LinearLayout implements View.OnClickListener {

    private ImageView homeicon;
    private ImageView infoicon;
    public static final String web_view = "com.topcoder.innovate.innovate2017.WEB_VIEW";


    public UnderBarLayout(Context context, AttributeSet attrs) {
        super(context,attrs);
        LayoutInflater.from(context).inflate(R.layout.underbar,this);
        homeicon = (ImageView) findViewById(R.id.home_icon);
        infoicon = (ImageView) findViewById(R.id.info_icon);
        homeicon.setOnClickListener(this);
        infoicon.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.home_icon:
                ((Activity)getContext()).finish();
                break;

            case R.id.info_icon:
                Intent j = new Intent(web_view);
                getContext().startActivity(j);
                break;
            default:
        }

    }
}
