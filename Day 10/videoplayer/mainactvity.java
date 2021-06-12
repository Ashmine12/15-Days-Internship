package com.example.videoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    VideoView vd1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vd1=findViewById(R.id.vd1);
        MediaController mediaController=new MediaController(this);
        mediaController.setAnchorView(vd1);

        Uri uri= Uri.parse("android.resource://" + getPackageName() + "/"+R.raw.r);
        vd1.setMediaController(mediaController);
        vd1.setVideoURI(uri);
        vd1.requestFocus();
        vd1.start();

        vd1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(MainActivity.this, "Thank you...", Toast.LENGTH_SHORT).show();
            }
        });
    vd1.setOnErrorListener(new MediaPlayer.OnErrorListener() {
        @Override
        public boolean onError(MediaPlayer mp, int what, int extra) {
            return false;
        }
    });
    }


}
