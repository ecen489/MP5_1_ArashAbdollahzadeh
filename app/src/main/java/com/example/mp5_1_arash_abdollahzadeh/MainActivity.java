package com.example.mp5_1_arash_abdollahzadeh;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    MediaPlayer energy;
    MediaPlayer tomorrow;
    MediaPlayer littleplanet;
    boolean playing = false;
    int id;
    String dur = "0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        energy = MediaPlayer.create(this, R.raw.energy);
        littleplanet = MediaPlayer.create(this, R.raw.littleplanet);
        tomorrow = MediaPlayer.create(this, R.raw.tomorrow);
    }

    public void radioClick(View view){
        ImageView image = (ImageView) findViewById(R.id.myPic);
        id = view.getId();
        TextView txt = (TextView) findViewById(R.id.txt);

        if (energy.isPlaying() || tomorrow.isPlaying() || littleplanet.isPlaying()){
            playing = false;
        }
        if (id == R.id.energy){
            image.setImageResource(R.drawable.energy);
            if (!playing){
                energy.start();
                txt.setText("Duration of the song in milliseconds: ");
            }
            if (tomorrow.isPlaying()){
                tomorrow.stop();
                tomorrow.release();
                tomorrow = null;
                tomorrow = MediaPlayer.create(this, R.raw.tomorrow);
            }
            if (littleplanet.isPlaying()){
                littleplanet.stop();
                littleplanet.release();
                littleplanet = null;
                littleplanet = MediaPlayer.create(this, R.raw.littleplanet);
            }
            dur = Integer.toString(energy.getDuration());
            txt.setText(txt.getText() + dur);
        }
        else if(id == R.id.tomorrow){
            image.setImageResource(R.drawable.tomorrow);
//            tomorrow.start();
            if (!playing){
                tomorrow.start();
                txt.setText("Duration of the song in milliseconds: ");
            }
            if (energy.isPlaying()){
                energy.stop();
                energy.release();
                energy = null;
                energy = MediaPlayer.create(this, R.raw.energy);
            }
            if (littleplanet.isPlaying()){
                littleplanet.stop();
                littleplanet.release();
                littleplanet = null;
                littleplanet = MediaPlayer.create(this, R.raw.littleplanet);
            }
            dur = Integer.toString(tomorrow.getDuration());
            txt.setText(txt.getText() + dur);
        }
        else if(id == R.id.littleplanet){
            image.setImageResource(R.drawable.littleplanet);
//            littleplanet.start();
            if (!playing){
                littleplanet.start();
                txt.setText("Duration of the song in milliseconds: ");
            }
            if (energy.isPlaying()){
                energy.stop();
                energy.release();
                energy = null;
                energy = MediaPlayer.create(this, R.raw.energy);
            }
            if (tomorrow.isPlaying()){
                tomorrow.stop();
                tomorrow.release();
                tomorrow = null;
                tomorrow = MediaPlayer.create(this, R.raw.tomorrow);
            }
            dur = Integer.toString(littleplanet.getDuration());
            txt.setText(txt.getText() + dur);
        }
    }
    public void Play(View view){
        if (id == R.id.energy){
            energy.start();
            playing = true;
        }
        else if(id == R.id.tomorrow){
            tomorrow.start();
            playing = true;
        }
        else if(id == R.id.littleplanet){
            littleplanet.start();
            playing = true;
        }
    }
    public void Pause(View view){
        if (id == R.id.energy){
            energy.stop();
            energy.release();
            energy = null;
            energy = MediaPlayer.create(this, R.raw.energy);
        }
        else if(id == R.id.tomorrow){
            tomorrow.stop();
            tomorrow.release();
            tomorrow = null;
            tomorrow = MediaPlayer.create(this, R.raw.tomorrow);
        }
        else if(id == R.id.littleplanet){
            littleplanet.stop();
            littleplanet.release();
            littleplanet = null;
            littleplanet = MediaPlayer.create(this, R.raw.littleplanet);
        }
    }
    public void Ten(View view){
        if (id == R.id.energy){
            energy.seekTo(energy.getCurrentPosition() + 10000);
        }
        else if(id == R.id.tomorrow){
            tomorrow.seekTo(tomorrow.getCurrentPosition() + 10000);
        }
        else if(id == R.id.littleplanet){
            littleplanet.seekTo(littleplanet.getCurrentPosition() + 10000);
        }
    }


}
