package com.glencconnect.leaderboard.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.glencconnect.leaderboard.R;
import com.glencconnect.leaderboard.models.Skills;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SkillAdapter extends RecyclerView.Adapter<SkillAdapter.MyViewHolder> {

    private Context context;
    private List<Skills> skillList;
    public SkillAdapter(Context context, List<Skills> skillList) {
        this.context = context;
        this.skillList = skillList;

    }

    public  void setDataList(List<Skills> skillsList){
        this.skillList = skillsList;
        notifyDataSetChanged();
    };

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(context).inflate(R.layout.list_items,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.bind(position);

    }

    @Override
    public int getItemCount() {
        return skillList == null? 0 : skillList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView bannerImage;
        private TextView full_name;
        private TextView achievement;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            bannerImage = itemView.findViewById(R.id.leaner_image);
            full_name = itemView.findViewById(R.id.learner_name);
            achievement = itemView.findViewById(R.id.leaner_content_hours);

        }

        public void bind(int position){


            Picasso.get().load(skillList.get(position).getImage()).into(bannerImage);
            full_name.setText(skillList.get(position).getName());

            StringBuilder builder = new StringBuilder();
            builder.append(skillList.get(position).getSkilliq());
            builder.append(" Skill IQ Score, ");
            builder.append(skillList.get(position).getCountry());
            achievement.setText(builder);
        }
    }
}
