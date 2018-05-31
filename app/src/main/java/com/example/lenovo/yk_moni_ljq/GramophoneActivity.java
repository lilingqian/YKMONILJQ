package com.example.lenovo.yk_moni_ljq;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GramophoneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gramophone);

        final GramophoneView gramophoneView = (GramophoneView)findViewById(R.id.gramophone_view);
        final Button button = (Button)findViewById(R.id.btn_play_pause);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(gramophoneView.getPlaying()){
                    button.setText("点击播放");
                }else{
                    button.setText("点击暂停");
                }
                gramophoneView.setPlaying(!gramophoneView.getPlaying());
            }

        });

    }

}
