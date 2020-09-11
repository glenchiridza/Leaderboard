package com.glencconnect.leaderboard.fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.glencconnect.leaderboard.R;
import com.glencconnect.leaderboard.SubmitActivity;
import com.google.android.material.tabs.TabLayout;

public class ViewPagerFragment extends Fragment {

    private TextView optionSubmit;
    private Toolbar toolbar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_viewpager,container,false);
        toolbar = view.findViewById(R.id.toolbar);


        optionSubmit = toolbar.findViewById(R.id.go_submit);
        optionSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), SubmitActivity.class));
            }
        });

        final LearnersFragment learnersFragment = new LearnersFragment();
        final SkillFragment skillFragment = new SkillFragment();

        ViewPager viewPager = view.findViewById(R.id.viewpager);

        viewPager.setAdapter(new FragmentStatePagerAdapter(getChildFragmentManager(),FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return position==0?learnersFragment:skillFragment;
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return position==0?"Learning Leaders": "Skill IQ Leaders";
            }


            @Override
            public int getCount() {
                return 2;
            }
        });

        TabLayout tabLayout = view.findViewById(R.id.tab_layout);
        tabLayout.setTabTextColors(Color.GRAY,Color.WHITE);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }
}
