package com.topcoder.innovate.innovate2017;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageButton;

import com.topcoder.innovate.innovate2017.model.Speaker;
import com.topcoder.innovate.innovate2017.util.DataRetriever;

import java.util.ArrayList;
import java.util.List;

public class SpeakerListActivity extends AppCompatActivity {

    private List<Speaker> speakerList = new ArrayList<>();
    private RecyclerView skRecyclerView;
    private SpeakerAdapter adapter;
    private ImageButton speakerBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speaker_list);
        initSpeakers();
        speakerBtn = (ImageButton) findViewById(R.id.speaker_btn);
        skRecyclerView = (RecyclerView) findViewById(R.id.speakers_recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        skRecyclerView.setLayoutManager(layoutManager);
        adapter = new SpeakerAdapter(speakerList,this);
        skRecyclerView.setAdapter(adapter);

    }

    private void initSpeakers() {
        DataRetriever skRetriever = new DataRetriever();
        speakerList = skRetriever.retrieveAllSpeakers(this);

    }
}
