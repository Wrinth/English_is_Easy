package com.wrinth.english_is_easy;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PoultriesFragment extends Fragment {

    /** Handles playback of all the sound files */
    private MediaPlayer mMediaPlayer;

    /** Handles audio focus when playing a sound file */
    private AudioManager mAudioManager;

    AudioManager.OnAudioFocusChangeListener afChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK ||
                            focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT) {
                        // Pause playback
                        mMediaPlayer.pause();
                        mMediaPlayer.seekTo(0);
                    } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                        // Resume playback
                        mMediaPlayer.start();
                    } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                        releaseMediaPlayer();
                    }
                }
            };

    private MediaPlayer.OnCompletionListener mCompleteListener = new MediaPlayer.OnCompletionListener() {

        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }

    };

    public PoultriesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_poultries, container, false);

        // Create and setup the AudioManager to request audio focus
        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> poultryArray = new ArrayList<Word>();
        poultryArray.add(new Word("bitch", "母狗；母狼", R.raw.bird_cob, R.drawable.poultry_poultry));
        poultryArray.add(new Word("boar", "野猪；（未阉的）公猪", R.raw.bird_cob, R.drawable.poultry_poultry));
        poultryArray.add(new Word("buck", "雄鹿", R.raw.bird_cob, R.drawable.poultry_poultry));
        poultryArray.add(new Word("bull", "公牛", R.raw.bird_cob, R.drawable.poultry_poultry));
        poultryArray.add(new Word("cat", "猫", R.raw.bird_cob, R.drawable.poultry_poultry));
        poultryArray.add(new Word("cattle", "牛", R.raw.bird_cob, R.drawable.poultry_poultry));
        poultryArray.add(new Word("chick", "小鸡", R.raw.bird_cob, R.drawable.poultry_poultry));
        poultryArray.add(new Word("chicken", "鸡", R.raw.bird_cob, R.drawable.poultry_poultry));
        poultryArray.add(new Word("cock", "公鸡", R.raw.bird_cob, R.drawable.poultry_poultry));
        poultryArray.add(new Word("colt", "小马", R.raw.bird_cob, R.drawable.poultry_poultry));
        poultryArray.add(new Word("cow", "奶牛", R.raw.bird_cob, R.drawable.poultry_poultry));
        poultryArray.add(new Word("dog", "狗", R.raw.bird_cob, R.drawable.poultry_poultry));
        poultryArray.add(new Word("donkey", "驴子", R.raw.bird_cob, R.drawable.poultry_poultry));
        poultryArray.add(new Word("duck", "鸭子", R.raw.bird_cob, R.drawable.poultry_poultry));
        poultryArray.add(new Word("ewe", "母羊", R.raw.bird_cob, R.drawable.poultry_poultry));
        poultryArray.add(new Word("filly", "小母马", R.raw.bird_cob, R.drawable.poultry_poultry));
        poultryArray.add(new Word("flock", "公牛", R.raw.bird_cob, R.drawable.poultry_poultry));
        poultryArray.add(new Word("gaggle", "鹅群", R.raw.bird_cob, R.drawable.poultry_poultry));
        poultryArray.add(new Word("gander", "雄鹅", R.raw.bird_cob, R.drawable.poultry_poultry));
        poultryArray.add(new Word("goat", "山羊", R.raw.bird_cob, R.drawable.poultry_poultry));
        poultryArray.add(new Word("goose", "鹅", R.raw.bird_cob, R.drawable.poultry_poultry));
        poultryArray.add(new Word("gosling", "小鹅", R.raw.bird_cob, R.drawable.poultry_poultry));
        poultryArray.add(new Word("hen", "母鸡", R.raw.bird_cob, R.drawable.poultry_poultry));
        poultryArray.add(new Word("horse", "马", R.raw.bird_cob, R.drawable.poultry_poultry));
        poultryArray.add(new Word("kitten", "小猫", R.raw.bird_cob, R.drawable.poultry_poultry));
        poultryArray.add(new Word("lamb", "羔羊", R.raw.bird_cob, R.drawable.poultry_poultry));
        poultryArray.add(new Word("mare", "母马；母驴", R.raw.bird_cob, R.drawable.poultry_poultry));
        poultryArray.add(new Word("mule", "骡", R.raw.bird_cob, R.drawable.poultry_poultry));
        poultryArray.add(new Word("ox ", "公牛", R.raw.bird_cob, R.drawable.poultry_poultry));
        poultryArray.add(new Word("pig", "猪", R.raw.bird_cob, R.drawable.poultry_poultry));
        poultryArray.add(new Word("pup", "小狗", R.raw.bird_cob, R.drawable.poultry_poultry));
        poultryArray.add(new Word("rabbit", "兔子", R.raw.bird_cob, R.drawable.poultry_poultry));
        poultryArray.add(new Word("ram", "公羊", R.raw.bird_cob, R.drawable.poultry_poultry));
        poultryArray.add(new Word("rooster", "公鸡", R.raw.bird_cob, R.drawable.poultry_poultry));
        poultryArray.add(new Word("sheep", "绵羊", R.raw.bird_cob, R.drawable.poultry_poultry));
        poultryArray.add(new Word("sow", "公母猪牛", R.raw.bird_cob, R.drawable.poultry_poultry));
        poultryArray.add(new Word("stallion", "成年公马", R.raw.bird_cob, R.drawable.poultry_poultry));
        poultryArray.add(new Word("turkey", "火鸡", R.raw.bird_cob, R.drawable.poultry_poultry));
        poultryArray.add(new Word("yak", " 牦牛", R.raw.bird_cob, R.drawable.poultry_poultry));
        poultryArray.add(new Word("foal", "一岁以下的马、驴、骡", R.raw.bird_cob, R.drawable.poultry_poultry));
        poultryArray.add(new Word("gelding", "阉割的马", R.raw.bird_cob, R.drawable.poultry_poultry));
        poultryArray.add(new Word("hinny ", "公马和母驴所生的骡子", R.raw.bird_cob, R.drawable.poultry_poultry));
        poultryArray.add(new Word("nanny", "母山羊", R.raw.bird_cob, R.drawable.poultry_poultry));
        poultryArray.add(new Word("piglet", "小猪", R.raw.bird_cob, R.drawable.poultry_poultry));
        poultryArray.add(new Word("shoat", "小猪", R.raw.bird_cob, R.drawable.poultry_poultry));
        poultryArray.add(new Word("tomcat", "公猫", R.raw.bird_cob, R.drawable.poultry_poultry));

        WordAdapter itemAdapter =
                new WordAdapter(getActivity(), poultryArray, R.color.category_poultry);

        ListView listView = (ListView) rootView.findViewById(R.id.poultriesView);

        listView.setAdapter(itemAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Word word = poultryArray.get(position);

                // Release the media player if it currently exist
                releaseMediaPlayer();

                // Request audio focus for playback
                int result = mAudioManager.requestAudioFocus(afChangeListener,
                        // Use the music stream.
                        AudioManager.STREAM_MUSIC,
                        // Request permanent focus.
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // We have the focus now
                    mMediaPlayer = MediaPlayer.create(getActivity(), word.getSoundResourseId());
                    mMediaPlayer.start();

                    mMediaPlayer.setOnCompletionListener(mCompleteListener);

                }
            }
        });

        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();

        // When the activity is stopped, release the media player resource
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources
     */
    private void releaseMediaPlayer() {
        // if media player is not null, then it may be currently playing a sound
        if(mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resourses
            mMediaPlayer.release();

            // Set the media player to null
            mMediaPlayer = null;

            // Abandon audio focus when playback complete
            mAudioManager.abandonAudioFocus(afChangeListener);
        }

    }
}
