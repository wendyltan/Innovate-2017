package com.topcoder.innovate.innovate2017;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class SpeakerDetailActivity extends AppCompatActivity {

    private ImageButton detail_back_btn;
    private ImageView speaker_image;
    private TextView speaker_name;
    private TextView speaker_holder;
    private TextView speaker_detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speaker_detail);
        Intent i = getIntent();
        speaker_image = (ImageView) findViewById(R.id.speaker_detail_icon);
        speaker_name = (TextView) findViewById(R.id.speaker_detail_name);
        speaker_holder = (TextView) findViewById(R.id.speaker_detail_placeholder);
        speaker_detail = (TextView) findViewById(R.id.speaker_detail_detail);
        detail_back_btn = (ImageButton) findViewById(R.id.speaker_detail_back_btn);
        speaker_image.setImageResource(i.getIntExtra("picID",R.drawable.default_speaker));
        speaker_name.setText(i.getStringExtra("name"));
        speaker_holder.setText(i.getStringExtra("placeholder"));
        speaker_detail.setText(i.getStringExtra("detail"));
        detail_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }

    public static void actionStart(Context context, String name,int picID,String placeholder,String detail){
        Intent intent = new Intent(context,SpeakerDetailActivity.class);
        intent.putExtra("name",name);
        intent.putExtra("picID",picID);
        intent.putExtra("placeholder",placeholder);
        intent.putExtra("detail",detail);
        context.startActivity(intent);
    }
}
