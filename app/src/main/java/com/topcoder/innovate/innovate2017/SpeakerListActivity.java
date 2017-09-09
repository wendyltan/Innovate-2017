package com.topcoder.innovate.innovate2017;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import com.topcoder.innovate.innovate2017.model.Speaker;
import com.topcoder.innovate.innovate2017.util.DataRetriever;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class SpeakerListActivity extends AppCompatActivity {

    private List<Speaker> speakerList = new ArrayList<>();
    private RecyclerView skRecyclerView;
    private SpeakerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speaker_list);
        initSpeakers();
        skRecyclerView = (RecyclerView) findViewById(R.id.speakers_recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        skRecyclerView.setLayoutManager(layoutManager);
        adapter = new SpeakerAdapter(speakerList);
        skRecyclerView.setAdapter(adapter);


    }

    private void initSpeakers() {
        speakerList = new DataRetriever().retrieveAllSpeakers(this);

        for (int i=0;i<speakerList.size();++i){
            Speaker speaker = speakerList.get(i);
            ApplicationInfo appInfo = getApplicationInfo();
            int picID = getResources().getIdentifier(speaker.getPicture(),"drawable",appInfo.packageName);
            if (picID==0){
                speaker.setPicture("default_speaker");
                picID = getResources().getIdentifier("default_speaker","drawable",appInfo.packageName);
            }
            speaker.setPicID(picID);
        }

    }
}
