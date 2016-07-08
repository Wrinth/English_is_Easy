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
import android.widget.Toast;

import java.util.ArrayList;

public class AmphibiansFragment extends Fragment {

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

    public AmphibiansFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_amphibians, container, false);

        // Create and setup the AudioManager to request audio focus
        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> amphibianArray = new ArrayList<Word>();
        amphibianArray.add(new Word("adder", "蝰蛇（欧洲产的小毒蛇）", R.raw.amphibian_adder, R.drawable.amphibian_amphibian));
        amphibianArray.add(new Word("alligator", "短吻鳄", R.raw.amphibian_alligator, R.drawable.amphibian_amphibian));
        amphibianArray.add(new Word("chameleon", "变色龙", R.raw.amphibian_chameleon, R.drawable.amphibian_amphibian));
        amphibianArray.add(new Word("cobra", "眼镜蛇", R.raw.amphibian_cobra, R.drawable.amphibian_amphibian));
        amphibianArray.add(new Word("crocodile", "鳄鱼", R.raw.amphibian_crocodile, R.drawable.amphibian_amphibian));
        amphibianArray.add(new Word("frog", "青蛙", R.raw.amphibian_frog, R.drawable.amphibian_amphibian));
        amphibianArray.add(new Word("iguana", "鬣蜥蜴", R.raw.amphibian_iguana, R.drawable.amphibian_amphibian));
        amphibianArray.add(new Word("lizard", "蜥蜴", R.raw.amphibian_lizard, R.drawable.amphibian_amphibian));
        amphibianArray.add(new Word("moccasin", "一种生长在北美的大毒蛇", R.raw.amphibian_moccasin, R.drawable.amphibian_amphibian));
        amphibianArray.add(new Word("python", "巨蟒", R.raw.amphibian_python, R.drawable.amphibian_amphibian));
        amphibianArray.add(new Word("rattlesnake", "响尾蛇", R.raw.amphibian_rattlesnake, R.drawable.amphibian_amphibian));
        amphibianArray.add(new Word("snake", "蛇", R.raw.amphibian_snake, R.drawable.amphibian_amphibian));
        amphibianArray.add(new Word("toad", "蟾蜍", R.raw.amphibian_toad, R.drawable.amphibian_amphibian));
        amphibianArray.add(new Word("tortoise", "乌龟", R.raw.amphibian_tortoise, R.drawable.amphibian_amphibian));
        amphibianArray.add(new Word("turtle", "海龟", R.raw.amphibian_turtle, R.drawable.amphibian_amphibian));
        amphibianArray.add(new Word("viper", "毒蛇", R.raw.amphibian_viper, R.drawable.amphibian_amphibian));
        amphibianArray.add(new Word("boa", "蟒蛇", R.raw.amphibian_boa, R.drawable.amphibian_amphibian));
        amphibianArray.add(new Word("bullfrog", "牛蛙", R.raw.amphibian_bullfrog, R.drawable.amphibian_amphibian));
        amphibianArray.add(new Word("caiman", "凯门鳄", R.raw.amphibian_caiman, R.drawable.amphibian_amphibian));
        amphibianArray.add(new Word("copperhead", "铜头蛇", R.raw.amphibian_copperhead, R.drawable.amphibian_amphibian));
        amphibianArray.add(new Word("newt", "蝾螈", R.raw.amphibian_newt, R.drawable.amphibian_amphibian));
        amphibianArray.add(new Word("salamander", "火蜥蜴", R.raw.amphibian_salamander, R.drawable.amphibian_amphibian));
        amphibianArray.add(new Word("tuatara", "大蜥蜴", R.raw.amphibian_tuatara, R.drawable.amphibian_amphibian));

        WordAdapter itemAdapter =
                new WordAdapter(getActivity(), amphibianArray, R.color.category_amphibian);

        ListView listView = (ListView) rootView.findViewById(R.id.amphibiansView);

        listView.setAdapter(itemAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Word word = amphibianArray.get(position);

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
