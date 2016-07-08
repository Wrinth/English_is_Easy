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

public class CrustaceansFragment extends Fragment {

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

    public CrustaceansFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_crustaceans, container, false);

        // Create and setup the AudioManager to request audio focus
        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> crustaceanArray = new ArrayList<Word>();
        crustaceanArray.add(new Word("clam", "捞蛤", R.raw.bird_cob, R.drawable.crustacean_crustacean));
        crustaceanArray.add(new Word("cockle", "海扇壳", R.raw.bird_cob, R.drawable.crustacean_crustacean));
        crustaceanArray.add(new Word("crab", "螃蟹", R.raw.bird_cob, R.drawable.crustacean_crustacean));
        crustaceanArray.add(new Word("crayfish", "小龙虾", R.raw.bird_cob, R.drawable.crustacean_crustacean));
        crustaceanArray.add(new Word("lobster", "龙虾", R.raw.bird_cob, R.drawable.crustacean_crustacean));
        crustaceanArray.add(new Word("mussel", "蚌", R.raw.bird_cob, R.drawable.crustacean_crustacean));
        crustaceanArray.add(new Word("octopus", "章鱼", R.raw.bird_cob, R.drawable.crustacean_crustacean));
        crustaceanArray.add(new Word("oyster", "牡蛎", R.raw.bird_cob, R.drawable.crustacean_crustacean));
        crustaceanArray.add(new Word("prawn", "对虾", R.raw.bird_cob, R.drawable.crustacean_crustacean));
        crustaceanArray.add(new Word("scallop", "扇贝", R.raw.bird_cob, R.drawable.crustacean_crustacean));
        crustaceanArray.add(new Word("shrimp", "虾", R.raw.bird_cob, R.drawable.crustacean_crustacean));
        crustaceanArray.add(new Word("snail", "蜗牛", R.raw.bird_cob, R.drawable.crustacean_crustacean));
        crustaceanArray.add(new Word("squid", "鱿鱼；乌贼", R.raw.bird_cob, R.drawable.crustacean_crustacean));

        WordAdapter itemAdapter =
                new WordAdapter(getActivity(), crustaceanArray, R.color.category_crustacean);

        ListView listView = (ListView) rootView.findViewById(R.id.crustaceansView);

        listView.setAdapter(itemAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Word word = crustaceanArray.get(position);

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
