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
import com.glencconnect.leaderboard.models.Learners;
import com.squareup.picasso.Picasso;

import java.util.List;

public class LearnerAdapter extends RecyclerView.Adapter<LearnerAdapter.MyViewHolder> {

    private Context context;
    private List<Learners> learnersList;
    public LearnerAdapter(Context context, List<Learners> learnersList) {
        this.context = context;
        this.learnersList = learnersList;

    }

    public  void setDataList(List<Learners> learnersList){
        this.learnersList = learnersList;
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
        return learnersList == null? 0 :learnersList.size();
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
            bannerImage.setImageResource(R.drawable.top_learner);
            Picasso.get().load(learnersList.get(position).getImage()).into(bannerImage);
            full_name.setText(learnersList.get(position).getName());


            StringBuilder builder = new StringBuilder();
            builder.append(learnersList.get(position).getHours());
            builder.append(" learning hours, ");
            builder.append(learnersList.get(position).getCountry());
            achievement.setText(builder);
        }
    }
}
