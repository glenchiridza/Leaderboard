package com.glencconnect.leaderboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.glencconnect.leaderboard.fragments.ViewPagerFragment;

public class MainActivity extends AppCompatActivity {

    private static final String LEADERBOARD_FRAGMNET = "LEADERBOARD_FRAGMENT";
    private TextView optionSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ViewPagerFragment savedFragment = (ViewPagerFragment)getSupportFragmentManager().findFragmentByTag(LEADERBOARD_FRAGMNET);

        if (savedFragment == null){

            Fragment fragment = new ViewPagerFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.main_fragment_holder, fragment,LEADERBOARD_FRAGMNET);
            fragmentTransaction.commit();

        }
    }

}
