package com.glencconnect.leaderboard.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.glencconnect.leaderboard.R;
import com.glencconnect.leaderboard.adapters.LearnerAdapter;
import com.glencconnect.leaderboard.models.Learners;
import com.glencconnect.leaderboard.retro_interfaces.RetrieveLeaders;
import com.glencconnect.leaderboard.retro_interfaces.ServiceBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LearnersFragment extends Fragment {
    private RecyclerView recyclerView;
    private LearnerAdapter adapter;
    private List<Learners> learnersList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragments_learner_skill,container,false);

        recyclerView = view.findViewById(R.id.recycler_unified);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager lManager = new LinearLayoutManager(getContext());

//        lManager.setStackFromEnd(true);
//        lManager.setReverseLayout(true);
        recyclerView.setLayoutManager(lManager);
        learnersList = new ArrayList<>();
        adapter = new LearnerAdapter(getActivity(),learnersList);
        recyclerView.setAdapter(adapter);


        RetrieveLeaders retrieveLeaders = ServiceBuilder.buildService(RetrieveLeaders.class);
        Call<List<Learners>> call = retrieveLeaders.getHoursBoard();

        call.enqueue(new Callback<List<Learners>>() {
            @Override
            public void onResponse(Call<List<Learners>> call, Response<List<Learners>> response) {

                if (response.isSuccessful()) {
                    learnersList = response.body();
                    adapter.setDataList(learnersList);
                }

            }

            @Override
            public void onFailure(Call<List<Learners>> call, Throwable t) {

            }
        });



////        learnersList.addAll(retrieveLeaders.hoursList("hours"),retrieveLeaders.skillsList("skilliq"));
//        adapter = new LeaderBoardAdapter(getContext(),null);
//        recyclerView.setAdapter(adapter);

        return view;
    }


}

