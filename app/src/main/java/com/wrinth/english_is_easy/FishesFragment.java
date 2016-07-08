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

public class FishesFragment extends Fragment {

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

    public FishesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_fishes, container, false);

        // Create and setup the AudioManager to request audio focus
        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> fishArray = new ArrayList<Word>();
        fishArray.add(new Word("anchovy", "凤尾鱼；鳀鱼", R.raw.bird_cob, R.drawable.fish_fish));
        fishArray.add(new Word("anglerfish", "琵琶鱼", R.raw.bird_cob, R.drawable.fish_fish));
        fishArray.add(new Word("carp", "鲤鱼", R.raw.bird_cob, R.drawable.fish_fish));
        fishArray.add(new Word("cod", "鳕鱼", R.raw.bird_cob, R.drawable.fish_fish));
        fishArray.add(new Word("eel", "鳗鱼", R.raw.bird_cob, R.drawable.fish_fish));
        fishArray.add(new Word("herring", "鲱（又称青鱼）", R.raw.bird_cob, R.drawable.fish_fish));
        fishArray.add(new Word("mackerel", "鲭（产于北大西洋）；马鲛鱼", R.raw.bird_cob, R.drawable.fish_fish));
        fishArray.add(new Word("mullet", "胭脂鱼", R.raw.bird_cob, R.drawable.fish_fish));
        fishArray.add(new Word("perch", "鲈鱼", R.raw.bird_cob, R.drawable.fish_fish));
        fishArray.add(new Word("pike", "梭子鱼", R.raw.bird_cob, R.drawable.fish_fish));
        fishArray.add(new Word("plaice", "鲽鱼；比目鱼", R.raw.bird_cob, R.drawable.fish_fish));
        fishArray.add(new Word("ray", "鳐形目鱼", R.raw.bird_cob, R.drawable.fish_fish));
        fishArray.add(new Word("salmon", "鲑鱼", R.raw.bird_cob, R.drawable.fish_fish));
        fishArray.add(new Word("sardine", "沙丁鱼", R.raw.bird_cob, R.drawable.fish_fish));
        fishArray.add(new Word("shark", "鲨鱼", R.raw.bird_cob, R.drawable.fish_fish));
        fishArray.add(new Word("sole", "鳎目鱼", R.raw.bird_cob, R.drawable.fish_fish));
        fishArray.add(new Word("trout", "鲑鱼", R.raw.bird_cob, R.drawable.fish_fish));
        fishArray.add(new Word("tuna", "金枪鱼", R.raw.bird_cob, R.drawable.fish_fish));
        fishArray.add(new Word("turbot", "大比目鱼", R.raw.bird_cob, R.drawable.fish_fish));
        fishArray.add(new Word("chub", "白鲑", R.raw.bird_cob, R.drawable.fish_fish));
        fishArray.add(new Word("hake", "狗鳕", R.raw.bird_cob, R.drawable.fish_fish));
        fishArray.add(new Word("skipjack", "飞鱼", R.raw.bird_cob, R.drawable.fish_fish));
        fishArray.add(new Word("sturgeon", "鲟鱼", R.raw.bird_cob, R.drawable.fish_fish));
        fishArray.add(new Word("sunfish", "翻车鱼", R.raw.bird_cob, R.drawable.fish_fish));
        fishArray.add(new Word("swordfish", "箭鱼", R.raw.bird_cob, R.drawable.fish_fish));
        fishArray.add(new Word("tarpon", "大海鲢", R.raw.bird_cob, R.drawable.fish_fish));
        fishArray.add(new Word("tunny", "金枪鱼", R.raw.bird_cob, R.drawable.fish_fish));

        WordAdapter itemAdapter =
                new WordAdapter(getActivity(), fishArray, R.color.category_fish);

        ListView listView = (ListView) rootView.findViewById(R.id.fishesView);

        listView.setAdapter(itemAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Word word = fishArray.get(position);

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
