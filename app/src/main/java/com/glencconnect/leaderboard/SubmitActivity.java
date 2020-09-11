package com.glencconnect.leaderboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.glencconnect.leaderboard.models.Post;
import com.glencconnect.leaderboard.retro_interfaces.PostBuilder;
import com.glencconnect.leaderboard.retro_interfaces.SendRetrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubmitActivity extends AppCompatActivity {


    //form data
    private EditText name;
    private EditText surname;
    private EditText email;
    private EditText git_link;
    private Button submit;
    private Toolbar toolbar;
    private SendRetrofit apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        toolbar = findViewById(R.id.toolbar);
        //setting toolsbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //initializing views
        init();

        apiService = PostBuilder.buildService(SendRetrofit.class);

        //on submisson handling
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateInfo();
            }
        };
        submit.setOnClickListener(listener);

    }

    private void validateInfo() {
        String myName = name.getText().toString();
        String mySurname = surname.getText().toString();
        String myEmail = email.getText().toString();
        String git = git_link.getText().toString();

        if (TextUtils.isEmpty(myName)){
            name.setError("Required Field");
        }
        else if (TextUtils.isEmpty(mySurname)){
            surname.setError("Required Field");
        }
        else if (TextUtils.isEmpty(myEmail)){
            email.setError("Required Field");
        }
        else if (TextUtils.isEmpty(git)){
            git_link.setError("Required Field");
        }
        else{
            submitProject(myName,mySurname,myEmail,git);
        }

    }
    private void submitProject(String myName, String mySurname, String myEmail, String git) {
        //handle the sending of data here

        //in the enque of retrofit success do the dialog setting

        final Dialog dialog;
        ImageView cancelBtn;
        final TextView responseText;
        final ImageView responseIcon;
        final Button btnYes;
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_confirmation);
        cancelBtn = dialog.findViewById(R.id.popup_close);
        responseText = dialog.findViewById(R.id.submission_success);
        responseIcon = dialog.findViewById(R.id.submission_icon);
        btnYes = dialog.findViewById(R.id.btn_yes);

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<Post> call = apiService.sendDetails(myEmail, myName, mySurname, git);
                call.enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(Call<Post> call, Response<Post> response) {
                        if (response.isSuccessful()){

                            //btn popup settings
                            btnYes.setVisibility(View.GONE);
                            dialog.findViewById(R.id.sure_text).setVisibility(View.GONE);
                            responseIcon.setVisibility(View.VISIBLE);
                            responseText.setVisibility(View.VISIBLE);
                        }
                    }

                    @Override
                    public void onFailure(Call<Post> call, Throwable t) {


//                        //btn popup settings
                        btnYes.setVisibility(View.GONE);
                        dialog.findViewById(R.id.sure_text).setVisibility(View.GONE);
                        responseIcon.setImageResource(R.drawable.ic_fail);
                        responseText.setText(getString(R.string.no_success));
                        responseIcon.setVisibility(View.VISIBLE);
                        responseText.setVisibility(View.VISIBLE);


                    }

                });
            }
        });
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();






    }

    private void  showPopUP(){

    }

    private void init(){
        name = findViewById(R.id.firstname);
        surname = findViewById(R.id.lastname);
        email =findViewById(R.id.email);
        git_link =findViewById(R.id.git_project);
        submit = findViewById(R.id.btn_submit);
    }
}
