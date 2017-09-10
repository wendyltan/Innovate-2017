package com.topcoder.innovate.innovate2017;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.app.ProgressDialog;

import static java.lang.Thread.sleep;

public class HomeActivity extends BaseActivity {

    private ImageView speakersView;
    private ImageView BaiduMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        speakersView = (ImageView) findViewById(R.id.home_menuspeakers);
        speakersView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final ProgressDialog dialog = new ProgressDialog(view.getContext());
                dialog.setTitle("Loading speakers' data");
                dialog.setMessage("Please wait while loading...");
                dialog.setIndeterminate(true);
                dialog.setCancelable(false);
                dialog.show();

                dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialogInterface) {
                        Intent i = new Intent(HomeActivity.this,SpeakerListActivity.class);
                        startActivity(i);
                    }
                });
                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        try {
                            Thread.sleep(5000);
                            // cancel和dismiss方法本质都是一样的，都是从屏幕中删除Dialog,唯一的区别是
                            // 调用cancel方法会回调DialogInterface.OnCancelListener如果注册的话,dismiss方法不会回掉
                            dialog.cancel();
                            // dialog.dismiss();
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }

                    }
                }).start();


            }
        });


        BaiduMap = (ImageView) findViewById(R.id.home_menumap);
        BaiduMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this,MapActivity.class);
                startActivity(i);
            }
        });



    }
}
