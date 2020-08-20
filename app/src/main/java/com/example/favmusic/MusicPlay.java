
package com.example.favmusic;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

public class MusicPlay extends AppCompatActivity {
    MediaPlayer music;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_play);

        //adding music files
        music = MediaPlayer.create(this,R.raw.gunjukunna);
        ImageView musicimg= (ImageView) findViewById(R.id.musicimg);
        musicimg.setImageResource(R.drawable.gunjukunna);

        SeekBar seekbarlisen = findViewById(R.id.changeTracker);
        seekBar.setMax(music.getDuration());
        final Handler mHandler=new Handler();
        MusicPlay.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (music!=null){
                    int mcurrentPostion=music.getCurrentPosition();
                    seekBar.setProgress(mcurrentPostion);

                }
                mHandler.postDelayed(this,1000);
            }
        });


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int lastProgress;
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                lastProgress=i;


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (music!=null ){
                    music.seekTo(lastProgress*1000);
                }

            }
        });


    }
        public  void mplay(View v)
        {
            music.start();
        }
        public  void mpause(View v)
        {
            if (music.isPlaying())
                music.pause();
        }
        public void looping(View v)
        {
            if (music.isLooping()) {
                music.setLooping(false);
            }
            else {
                music.setLooping(true);
            }




        }





    }











