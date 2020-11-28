package com.example.chin1010;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;   // for playback
    private AudioManager mAudioManager; // for audio focus

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //to request audio focus
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        //Creates an array list that contains words
        final ArrayList<Words> words = new ArrayList<Words>();

        //adds words to the arraylist
        words.add(new Words("Red", "Hóng - 红", R.drawable.color_red, R.raw.color_red));
        words.add(new Words("Yellow", "Huángsè - 黄色",  R.drawable.color_yellow, R.raw.color_yellow));
        words.add(new Words("Beige", "Mǐsè -  米色", R.drawable.color_beige, R.raw.color_beige));
        words.add(new Words ("Green", "Lǜsè - 绿色", R.drawable.color_green, R.raw.color_green));
        words.add(new Words ("Brown", "Zōngsè - 棕色", R.drawable.color_brown, R.raw.color_brown));
        words.add(new Words("Gray", "Huīsè - 灰色", R.drawable.color_gray, R.raw.color_gray));
        words.add(new Words("Black", "Hēisè - 黑色", R.drawable.color_black, R.raw.color_black));
        words.add(new Words("White", "Báisè - 白色", R.drawable.color_white, R.raw.color_white));

        Wordsadapter adapter = new Wordsadapter(this, words, R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.list);

        //displays items in list
        listView.setAdapter(adapter);

        //plays audio when a item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                releaseMediaPlayer();
                Words word = words.get(position);

                int result = mAudioManager.requestAudioFocus(
                        mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC,
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mMediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getmAudioResourceID());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });
    }

    /**
     * Triggered when audio focus changes
     */
    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT   // lost audio for short time
                    || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {    // cont. playing (@ lower vol.)

                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {   // regained focus > resume playback
                mMediaPlayer.start();
            } else  if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {  // lost audio > stop playback
                releaseMediaPlayer();
            }
        }
    };

    /**
     * When the activity is stopped
     */
    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }

    /**
     * When audio finishes playing
     */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

}
