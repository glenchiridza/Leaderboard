package com.glencconnect.leaderboard.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.glencconnect.leaderboard.R;
import com.glencconnect.leaderboard.adapters.LearnerAdapter;
import com.glencconnect.leaderboard.adapters.SkillAdapter;
import com.glencconnect.leaderboard.models.Learners;
import com.glencconnect.leaderboard.models.Skills;
import com.glencconnect.leaderboard.retro_interfaces.RetrieveLeaders;
import com.glencconnect.leaderboard.retro_interfaces.ServiceBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SkillFragment extends Fragment {

    private RecyclerView recyclerView;
    private SkillAdapter adapter;
    private List<Skills> skillsList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragments_learner_skill,container,false);

        recyclerView = view.findViewById(R.id.recycler_unified);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager lManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(lManager);

        skillsList = new ArrayList<>();
        adapter = new SkillAdapter(getContext(),skillsList);
        recyclerView.setAdapter(adapter);

        RetrieveLeaders skills = ServiceBuilder.buildService(RetrieveLeaders.class);
        Call<List<Skills>> call = skills.getIQBoard();

        call.enqueue(new Callback<List<Skills>>() {
            @Override
            public void onResponse(Call<List<Skills>> call, Response<List<Skills>> response) {
                if (response.isSuccessful()){
                    skillsList = response.body();
                    adapter.setDataList(skillsList);
                }
            }

            @Override
            public void onFailure(Call<List<Skills>> call, Throwable t) {

            }
        });

        return view;
    }
}
