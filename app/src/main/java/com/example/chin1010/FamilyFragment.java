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

public class FamilyFragment extends Fragment {

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
        words.add(new Words("Father", "Fùqīn - 父亲", R.drawable.family_father, R.raw.family_father));
        words.add(new Words("Mom", "Māmā - 妈妈", R.drawable.family_mother, R.raw.family_mom));
        words.add(new Words("Son", "Érzi - 儿子", R.drawable.family_son, R.raw.family_son));
        words.add(new Words("Daughter", "Nǚ'ér - 女儿", R.drawable.family_daughter, R.raw.family_daughter));
        words.add(new Words ("Brother", "Gēgē - 哥哥", R.drawable.family_older_brother, R.raw.family_brother));
        words.add(new Words("Sister", "Mèimei - 妹妹", R.drawable.family_older_sister, R.raw.family_sister));
        words.add(new Words("Grandfather", "Zǔfù - 祖父", R.drawable.family_grandfather, R.raw.family_grand_father));
        words.add(new Words ("Grandmother", "Zǔmǔ - 祖母", R.drawable.family_grandmother, R.raw.family_grand_mother));

        Wordsadapter adapter = new Wordsadapter(getActivity(), words, R.color.category_family);

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

    public FamilyFragment() {
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