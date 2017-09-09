package com.topcoder.innovate.innovate2017;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.topcoder.innovate.innovate2017.model.Speaker;

import java.util.List;

/**
 * Created by Wendy on 2017/9/7.
 */

public class SpeakerAdapter extends RecyclerView.Adapter<SpeakerAdapter.ViewHolder> {

    private List<Speaker> speakerList;
    private Context context;
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.speaker_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Speaker speaker = speakerList.get(position);
        holder.speakerName.setText(speaker.getName());
        holder.speakerDetail.setText(speaker.getDetails());
        final int imageId =speaker.getPicID();
        holder.speakerIcon.setImageResource(imageId);
        holder.speakerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context = view.getContext();
                SpeakerDetailActivity.actionStart(context,speaker.getName(),imageId,"placeholder",speaker.getDetails());

            }
        });

    }

    @Override
    public int getItemCount() {
        return speakerList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView speakerName;
        private TextView speakerDetail;
        private ImageView speakerIcon;
        private ImageButton speakerButton;
        public ViewHolder(View itemView) {
            super(itemView);
            speakerName = (TextView) itemView.findViewById(R.id.speaker_name);
            speakerDetail = (TextView) itemView.findViewById(R.id.speaker_detail);
            speakerIcon = (ImageView) itemView.findViewById(R.id.speaker_icon);
            speakerButton = (ImageButton) itemView.findViewById(R.id.speaker_btn);
        }
    }

    public SpeakerAdapter(List<Speaker> spList){
        this.speakerList = spList;

    }
}
