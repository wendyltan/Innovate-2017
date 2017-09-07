package com.topcoder.innovate.innovate2017;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        Speaker speaker = speakerList.get(position);
        holder.speakerName.setText(speaker.getName());
        holder.speakerDetail.setText(speaker.getDetails());

        int imageId = getResourdIdByResourdName(context,"String",speaker.getPicture());

        holder.speakerIcon.setImageResource(imageId);
    }

    @Override
    public int getItemCount() {
        return speakerList.size();
    }

    public static int getResourdIdByResourdName(Context context, String defType, String ResName){
        Resources res = context.getResources();
        int resourceId = res.getIdentifier(ResName,defType,context.getPackageName());

        return resourceId;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView speakerName;
        private TextView speakerDetail;
        private ImageView speakerIcon;
        public ViewHolder(View itemView) {
            super(itemView);
            speakerName = (TextView) itemView.findViewById(R.id.speaker_name);
            speakerDetail = (TextView) itemView.findViewById(R.id.speaker_detail);
            speakerIcon = (ImageView) itemView.findViewById(R.id.speaker_icon);
        }
    }

    public SpeakerAdapter(List<Speaker> spList ,Context con){
        speakerList = spList;
        context = con;

    }
}
