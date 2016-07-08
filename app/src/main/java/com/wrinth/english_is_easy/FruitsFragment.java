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

public class FruitsFragment extends Fragment {

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

    public FruitsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_fruits, container, false);

        // Create and setup the AudioManager to request audio focus
        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> fruitArray = new ArrayList<Word>();
        fruitArray.add(new Word("apple", "苹果", R.raw.bird_cob, R.drawable.fruit_fruit));
        fruitArray.add(new Word("apricot", "杏子", R.raw.bird_cob, R.drawable.fruit_fruit));
        fruitArray.add(new Word("banana", "香蕉", R.raw.bird_cob, R.drawable.fruit_fruit));
        fruitArray.add(new Word("blackberry", "黑莓", R.raw.bird_cob, R.drawable.fruit_fruit));
        fruitArray.add(new Word("blueberry", "蓝莓", R.raw.bird_cob, R.drawable.fruit_fruit));
        fruitArray.add(new Word("cherry", "樱桃", R.raw.bird_cob, R.drawable.fruit_fruit));
        fruitArray.add(new Word("coconut", "椰子", R.raw.bird_cob, R.drawable.fruit_fruit));
        fruitArray.add(new Word("currant", "紅加侖", R.raw.bird_cob, R.drawable.fruit_fruit));
        fruitArray.add(new Word("fig", "无花果", R.raw.bird_cob, R.drawable.fruit_fruit));
        fruitArray.add(new Word("grape", "葡萄", R.raw.bird_cob, R.drawable.fruit_fruit));
        fruitArray.add(new Word("grapefruit", "葡萄柚", R.raw.bird_cob, R.drawable.fruit_fruit));
        fruitArray.add(new Word("lemon", "柠檬", R.raw.bird_cob, R.drawable.fruit_fruit));
        fruitArray.add(new Word("mango", "芒果", R.raw.bird_cob, R.drawable.fruit_fruit));
        fruitArray.add(new Word("mulberry", "桑椹", R.raw.bird_cob, R.drawable.fruit_fruit));
        fruitArray.add(new Word("orange", "橙", R.raw.bird_cob, R.drawable.fruit_fruit));
        fruitArray.add(new Word("peach", "桃子", R.raw.bird_cob, R.drawable.fruit_fruit));
        fruitArray.add(new Word("pear", "梨子", R.raw.bird_cob, R.drawable.fruit_fruit));
        fruitArray.add(new Word("persimmon", "柿子", R.raw.bird_cob, R.drawable.fruit_fruit));
        fruitArray.add(new Word("pineapple", "菠萝", R.raw.bird_cob, R.drawable.fruit_fruit));
        fruitArray.add(new Word("plum", "梅子", R.raw.bird_cob, R.drawable.fruit_fruit));
        fruitArray.add(new Word("raspberry", "紅莓", R.raw.bird_cob, R.drawable.fruit_fruit));
        fruitArray.add(new Word("strawberry", "草莓", R.raw.bird_cob, R.drawable.fruit_fruit));
        fruitArray.add(new Word("tangerine", "橘子", R.raw.bird_cob, R.drawable.fruit_fruit));
        fruitArray.add(new Word("watermelon", "西瓜", R.raw.bird_cob, R.drawable.fruit_fruit));
        fruitArray.add(new Word("avocado", "鳄梨", R.raw.bird_cob, R.drawable.fruit_fruit));
        fruitArray.add(new Word("citron", "佛手柑", R.raw.bird_cob, R.drawable.fruit_fruit));
        fruitArray.add(new Word("damson", "西洋李子", R.raw.bird_cob, R.drawable.fruit_fruit));
        fruitArray.add(new Word("guava", "番石榴", R.raw.bird_cob, R.drawable.fruit_fruit));
        fruitArray.add(new Word("medlar", "枸杞", R.raw.bird_cob, R.drawable.fruit_fruit));
        fruitArray.add(new Word("nectarine", "蜜桃", R.raw.bird_cob, R.drawable.fruit_fruit));
        fruitArray.add(new Word("papaw", "番木瓜", R.raw.bird_cob, R.drawable.fruit_fruit));
        fruitArray.add(new Word("papaya", "木瓜", R.raw.bird_cob, R.drawable.fruit_fruit));
        fruitArray.add(new Word("pistachio", "开心果", R.raw.bird_cob, R.drawable.fruit_fruit));
        fruitArray.add(new Word("pomegranate", "石榴", R.raw.bird_cob, R.drawable.fruit_fruit));

        WordAdapter itemAdapter =
                new WordAdapter(getActivity(), fruitArray, R.color.category_fruit);

        ListView listView = (ListView) rootView.findViewById(R.id.fruitsView);

        listView.setAdapter(itemAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Word word = fruitArray.get(position);

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
