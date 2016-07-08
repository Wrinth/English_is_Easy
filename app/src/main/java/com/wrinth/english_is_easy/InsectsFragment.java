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

public class InsectsFragment extends Fragment {

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

    public InsectsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_insects, container, false);

        // Create and setup the AudioManager to request audio focus
        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> insectArray = new ArrayList<Word>();
        insectArray.add(new Word("anopheles", "疟蚊", R.raw.bird_cob, R.drawable.insect_insect));
        insectArray.add(new Word("ant", "蚂蚁", R.raw.bird_cob, R.drawable.insect_insect));
        insectArray.add(new Word("bee", "蜜蜂", R.raw.bird_cob, R.drawable.insect_insect));
        insectArray.add(new Word("beetle", "甲虫", R.raw.bird_cob, R.drawable.insect_insect));
        insectArray.add(new Word("bug", "小虫", R.raw.bird_cob, R.drawable.insect_insect));
        insectArray.add(new Word("butterfly", "蝴蝶", R.raw.bird_cob, R.drawable.insect_insect));
        insectArray.add(new Word("caterpillar", "[无脊椎] 毛虫", R.raw.bird_cob, R.drawable.insect_insect));
        insectArray.add(new Word("cicada", "蝉", R.raw.bird_cob, R.drawable.insect_insect));
        insectArray.add(new Word("cockroach", "蟑螂", R.raw.bird_cob, R.drawable.insect_insect));
        insectArray.add(new Word("cricket", "蟋蟀", R.raw.bird_cob, R.drawable.insect_insect));
        insectArray.add(new Word("dragonfly", "蜻蜓", R.raw.bird_cob, R.drawable.insect_insect));
        insectArray.add(new Word("drone", "雄蜂", R.raw.bird_cob, R.drawable.insect_insect));
        insectArray.add(new Word("firefly", "萤火虫", R.raw.bird_cob, R.drawable.insect_insect));
        insectArray.add(new Word("flea", "跳蚤", R.raw.bird_cob, R.drawable.insect_insect));
        insectArray.add(new Word("fly", "苍蝇", R.raw.bird_cob, R.drawable.insect_insect));
        insectArray.add(new Word("gadfly", "牛虻", R.raw.bird_cob, R.drawable.insect_insect));
        insectArray.add(new Word("grasshopper", "蚱蜢", R.raw.bird_cob, R.drawable.insect_insect));
        insectArray.add(new Word("horsefly", "马蝇", R.raw.bird_cob, R.drawable.insect_insect));
        insectArray.add(new Word("ladybird", "瓢虫", R.raw.bird_cob, R.drawable.insect_insect));
        insectArray.add(new Word("lice", "虱子[复数]", R.raw.bird_cob, R.drawable.insect_insect));
        insectArray.add(new Word("locust", "蝗虫", R.raw.bird_cob, R.drawable.insect_insect));
        insectArray.add(new Word("louse", "虱子", R.raw.bird_cob, R.drawable.insect_insect));
        insectArray.add(new Word("mosquito", "蚊子", R.raw.bird_cob, R.drawable.insect_insect));
        insectArray.add(new Word("moth", "蛾", R.raw.bird_cob, R.drawable.insect_insect));
        insectArray.add(new Word("scorpion", "蝎子", R.raw.bird_cob, R.drawable.insect_insect));
        insectArray.add(new Word("spider", "蜘蛛", R.raw.bird_cob, R.drawable.insect_insect));
        insectArray.add(new Word("tarantula", "狼蛛", R.raw.bird_cob, R.drawable.insect_insect));
        insectArray.add(new Word("termite", "白蚁", R.raw.bird_cob, R.drawable.insect_insect));
        insectArray.add(new Word("wasp", "黄蜂", R.raw.bird_cob, R.drawable.insect_insect));
        insectArray.add(new Word("bedbug", "臭虫", R.raw.bird_cob, R.drawable.insect_insect));
        insectArray.add(new Word("centipede", "蜈蚣", R.raw.bird_cob, R.drawable.insect_insect));
        insectArray.add(new Word("silverfish", "蠹虫", R.raw.bird_cob, R.drawable.insect_insect));
        insectArray.add(new Word("swallowtail", "鳳蝶", R.raw.bird_cob, R.drawable.insect_insect));



        WordAdapter itemAdapter =
                new WordAdapter(getActivity(), insectArray, R.color.category_insect);

        ListView listView = (ListView) rootView.findViewById(R.id.insectsView);

        listView.setAdapter(itemAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Word word = insectArray.get(position);

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
