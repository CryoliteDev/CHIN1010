package com.example.chin1010;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity{

    MediaPlayer mMediaPlayer;   // for playback
    AudioManager mAudioManager; // for audio focus

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //to request audio focus
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        //Creates an array list that contains words
        final ArrayList<Words> words = new ArrayList<Words>();

        //adds words to the array list
        words.add(new Words("Where are you going?", "Nǐ yào qù nǎlǐ? - 你要去哪里？", R.raw.phrase_where_are_you_going));
        words.add(new Words("What is your name?", "Nǐ jiào shénme míngzì? - 你叫什么名字?", R.raw.phrase_what_is_your_name));
        words.add(new Words("My name is ...", "Wǒ de míngzì shì.. - 我的名字是 ...", R.raw.phrase_my_name_is));
        words.add(new Words("How are you feeling?", "Nǐ gǎnjué zěnme yàng? - 你感觉怎么样?", R.raw.phrase_how_are_you_feeling));
        words.add(new Words ("I'm feeling good.", "Wǒ gǎnjué hěn hǎo. - 我感觉很好.", R.raw.phrase_im_feeling_good));
        words.add(new Words("Are you coming?", "Nǐ lái ma - 你来吗?", R.raw.phrase_are_you_coming));
        words.add(new Words("Where we going?", "Nǐ yào qù nǎlǐ?- 你要去哪里", R.raw.phrase_where_we_going));
        words.add(new Words ("Yes, I'm coming.", "Shì de, wǒ láile - 是的，我来了", R.raw.phrase_yes_im_coming));
        words.add(new Words("Let's go.", "Wǒmen zǒu ba. - 我们走吧", R.raw. phrase_lets_go));
        words.add(new Words ("Come here", "Guòlái. - 过来", R.raw.phrase_come_here));

        Wordsadapter adapter = new Wordsadapter(this, words, R.color.category_phrases);

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
                    mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getmAudioResourceID());
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
     * When MediaPlayer finishes playing audio.
     */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };
}
