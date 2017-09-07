package com.topcoder.innovate.innovate2017;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;


public class HomeActivity extends AppCompatActivity {

    private ImageView speakersView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        speakersView = (ImageView) findViewById(R.id.home_menuspeakers);
        speakersView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this,SpeakerListActivity.class);
                startActivity(i);
            }
        });


    }
}
