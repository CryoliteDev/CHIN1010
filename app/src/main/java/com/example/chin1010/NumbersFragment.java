package com.example.chin1010;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersFragment extends Fragment {

    private MediaPlayer mMediaPlayer;   // for playback
    private AudioManager mAudioManager; // for audio focus

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        //Creates an array list that contains words
        final ArrayList<Words> words = new ArrayList<Words>();

        // to request audio focus
        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        //adds words to the arraylist
        words.add(new Words("ONE", "Yi - 一", R.drawable.number_one, R.raw.number_one));
        words.add(new Words("TWO", "Er - 二", R.drawable.number_two, R.raw.number_two));
        words.add(new Words("THREE", "San - 三", R.drawable.number_three, R.raw.number_three));
        words.add(new Words("FOUR", "Si - 四", R.drawable.number_four, R.raw.number_four));
        words.add(new Words ("FIVE", "Wu - 五", R.drawable.number_five, R.raw.number_five));
        words.add(new Words("SIX", "Liu - 六", R.drawable.number_six, R.raw.number_six));
        words.add(new Words("SEVEN", "Qi - 七", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Words ("EIGHT", "Ba - 八", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Words("NINE", "Jiu - 九", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Words ("TEN", "Shi - 十", R.drawable.number_ten, R.raw.number_ten));

        Wordsadapter adapter = new Wordsadapter(getActivity(), words, R.color.category_numbers);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        //displays items in list
        listView.setAdapter(adapter);

        //play audio when a item is clicked on
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
                    mMediaPlayer = MediaPlayer.create(getActivity(), word.getmAudioResourceID());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });

        return rootView;
    }

    /**
     * Triggered when audio focus changes
     */
    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT // lost audio for short time
                    || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) { // cont. playin (lower vol.)

                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) { // regained focus > resume playback
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) { // lost audio > stop playback
                releaseMediaPlayer();
            }
        }
    };

    public NumbersFragment() {
        //Required constructor . . .
    }

    /**
     * When activity is stopped
     */
    @Override
    public void onStop() {
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
     * When MediaPlayer finishes playing the audio file.
     */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };
}