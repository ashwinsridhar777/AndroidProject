package com.example.aiassist;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Log.d("StartActivity", "onCreate");

        VideoView videoView = findViewById(R.id.videoView);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.optimus;
        Uri uri = Uri.parse(videoPath);

        // Set the video URI
        videoView.setVideoURI(uri);

        // Start playing the video
        videoView.start();

        // Redirect to MainActivity after a delay
        redirectAfterDelay();
    }

    private void redirectAfterDelay() {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(StartActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 7000); // 2000 milliseconds (2 seconds) delay
    }
}
