package com.topcoder.innovate.innovate2017.util;

/**
 * Created by Wendy on 2017/9/6.
 */
import android.app.Activity;
import android.util.Log;

import com.topcoder.innovate.innovate2017.model.Speaker;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DataRetriever {
    private Speaker speaker;
    private List<Speaker> speakerArrayList;

    public List<Speaker> retrieveAllSpeakers(Activity activity) {
        speakerArrayList = new ArrayList<>();
        try {

            InputStream isr = activity.getAssets().open("speakers.txt");
            InputStreamReader streamReader = new InputStreamReader(isr,"utf-8");
            BufferedReader reader = new BufferedReader(streamReader);
            String line;
            StringBuilder builder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                builder.append(line);

            }
            streamReader.close();
            reader.close();

            JSONObject speakerjson = new JSONObject(builder.toString());//读取了JSON中的数据。
            JSONArray array = speakerjson.getJSONArray("inf");         //从JSONObject中取出数组对象



            for (int i = 0; i < array.length(); i++) {
                String inf_string= array.getJSONObject(i).getString("fields");
                JSONObject inf_array = new JSONObject(inf_string);
                speaker = new Speaker();
                speaker.setName(inf_array.getString("name"));
                speaker.setTitle(inf_array.getString("title"));
                speaker.setPicture(inf_array.getString("picture"));

                JSONArray sessionArray = inf_array.getJSONArray("sessions");
                List<String> list = new ArrayList<>();
                for (int j = 0; j < sessionArray.length(); j++) {
                    String session_id = sessionArray.getString(j);
                    list.add(session_id);
                }
                speaker.setSessionIds(list);
                speaker.setDetails(inf_array.getString("details"));

                speakerArrayList.add(speaker);

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return speakerArrayList;
    }

}