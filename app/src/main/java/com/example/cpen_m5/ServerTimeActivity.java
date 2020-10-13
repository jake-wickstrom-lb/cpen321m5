package com.example.cpen_m5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServerTimeActivity extends AppCompatActivity {

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://cpen321m5.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private M5_api api = retrofit.create(M5_api.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server_time);

        Call<ServerTime> call = api.getTime();
        TextView serverTimeText = findViewById(R.id.server_time_text);

        call.enqueue(new Callback<ServerTime>() {

            @Override
            public void onResponse(Call<ServerTime> call, Response<ServerTime> response) {
                serverTimeText.setText(response.body().getTime());
            }

            @Override
            public void onFailure(Call<ServerTime> call, Throwable t) {
                Log.d("Error", t.toString());
                serverTimeText.setText("Could not retrieve server time...");
            }
        });
    }
}