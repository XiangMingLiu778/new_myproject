package com.example.sxr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
       final OkHttpClient client = new OkHttpClient();
// 我在这里加了注释
//    jiajiaasdadwd a
//    qewqe
       TextView  textView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.myText);


        getData();
    }

    private void getData() {
        Request.Builder builder = new Request.Builder();
        builder.url("https://open.douyin.com/discovery/ent/rank/item/");
        final Request request = builder.build();

        Call call = client.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.isSuccessful()){
                    final String s = response.body().string();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText(s);
                        }
                    });
                }
            }
        });

    }
}
