package com.example.mediaplayersample;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Create a MediaPlayer object
    public MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Store in the mediaPlayer object the song you want to play
        mediaPlayer = MediaPlayer.create(this, R.raw.nightwish);

        // Find the play Button
        Button playButton = findViewById(R.id.play_button);

        // Set a click listener on that Button
        playButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the play Button is clicked on.
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Play", Toast.LENGTH_SHORT).show();
                mediaPlayer.start();

                // Get notified when the song came to an end
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
                    @Override
                    public void onCompletion(MediaPlayer arg0){
                        Toast.makeText(MainActivity.this, "Done", Toast.LENGTH_SHORT).show();
                    }
                });
            }

        });

        // Find the pause Button
        Button pauseButton = findViewById(R.id.pause_button);

        // Set a click listener on that Button
        pauseButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the pause Button is clicked on.
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Pause", Toast.LENGTH_SHORT).show();
                mediaPlayer.pause();
            }

        });


    }
}