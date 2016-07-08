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

public class BirdsFragment extends Fragment {

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

    public BirdsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_birds, container, false);

        // Create and setup the AudioManager to request audio focus
        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> birdArray = new ArrayList<Word>();
        birdArray.add(new Word("albatross", "信天翁", R.raw.bird_albatross, R.drawable.bird_bird));
        birdArray.add(new Word("blackbird", "画眉鸟", R.raw.bird_blackbird, R.drawable.bird_bird));
        birdArray.add(new Word("canary", "金丝雀", R.raw.bird_canary, R.drawable.bird_bird));
        birdArray.add(new Word("cob", "雄天鹅", R.raw.bird_cob, R.drawable.bird_bird));
        birdArray.add(new Word("condor", "秃鹫", R.raw.bird_cob, R.drawable.bird_bird));
        birdArray.add(new Word("cormorant", "鸬鹚", R.raw.bird_cob, R.drawable.bird_bird));
        birdArray.add(new Word("crow", "乌鸦", R.raw.bird_cob, R.drawable.bird_bird));
        birdArray.add(new Word("cuckoo", "布谷鸟；杜鹃鸟", R.raw.bird_cob, R.drawable.bird_bird));
        birdArray.add(new Word("cygnet", "小天鹅", R.raw.bird_cob, R.drawable.bird_bird));
        birdArray.add(new Word("dove", "鸽子", R.raw.bird_cob, R.drawable.bird_bird));
        birdArray.add(new Word("eagle", "鹰", R.raw.bird_cob, R.drawable.bird_bird));
        birdArray.add(new Word("falcon", "猎鹰", R.raw.bird_cob, R.drawable.bird_bird));
        birdArray.add(new Word("grouse", "松鸡", R.raw.bird_cob, R.drawable.bird_bird));
        birdArray.add(new Word("gull", "鸥", R.raw.bird_cob, R.drawable.bird_bird));
        birdArray.add(new Word("hawk", "鹰", R.raw.bird_cob, R.drawable.bird_bird));
        birdArray.add(new Word("heron ", "鹭", R.raw.bird_cob, R.drawable.bird_bird));
        birdArray.add(new Word("hummingbird", "蜂鸟", R.raw.bird_cob, R.drawable.bird_bird));
        birdArray.add(new Word("lark", "云雀；百灵鸟", R.raw.bird_cob, R.drawable.bird_bird));
        birdArray.add(new Word("macaw ", "金刚鹦鹉", R.raw.bird_cob, R.drawable.bird_bird));
        birdArray.add(new Word("magpie", "喜鹊", R.raw.bird_cob, R.drawable.bird_bird));
        birdArray.add(new Word("mallard", "野鸭", R.raw.bird_cob, R.drawable.bird_bird));
        birdArray.add(new Word("nightingale", "夜莺", R.raw.bird_cob, R.drawable.bird_bird));
        birdArray.add(new Word("ostrich", "鸵鸟", R.raw.bird_cob, R.drawable.bird_bird));
        birdArray.add(new Word("owl", "猫头鹰", R.raw.bird_cob, R.drawable.bird_bird));
        birdArray.add(new Word("parakeet", "长尾小鹦鹉", R.raw.bird_cob, R.drawable.bird_bird));
        birdArray.add(new Word("parrot", "鹦鹉", R.raw.bird_cob, R.drawable.bird_bird));
        birdArray.add(new Word("partridge", "鹧鸪", R.raw.bird_cob, R.drawable.bird_bird));
        birdArray.add(new Word("peacock", "孔雀", R.raw.bird_cob, R.drawable.bird_bird));
        birdArray.add(new Word("pelican", "鹈鹕", R.raw.bird_cob, R.drawable.bird_bird));
        birdArray.add(new Word("penguin", "企鹅", R.raw.bird_cob, R.drawable.bird_bird));
        birdArray.add(new Word("pheasant", "雉科鸟", R.raw.bird_cob, R.drawable.bird_bird));
        birdArray.add(new Word("pigeon", "鸽子", R.raw.bird_cob, R.drawable.bird_bird));
        birdArray.add(new Word("plover", "千鸟", R.raw.bird_cob, R.drawable.bird_bird));
        birdArray.add(new Word("ptarmigan", "雷鸟", R.raw.bird_cob, R.drawable.bird_bird));
        birdArray.add(new Word("quail", "鹌鹑", R.raw.bird_cob, R.drawable.bird_bird));
        birdArray.add(new Word("robin", "知更鸟", R.raw.bird_cob, R.drawable.bird_bird));
        birdArray.add(new Word("seagull", "海鸥", R.raw.bird_cob, R.drawable.bird_bird));
        birdArray.add(new Word("snipe", "鹬", R.raw.bird_cob, R.drawable.bird_bird));
        birdArray.add(new Word("sparrow", "麻雀", R.raw.bird_cob, R.drawable.bird_bird));
        birdArray.add(new Word("stork", "鹳", R.raw.bird_cob, R.drawable.bird_bird));
        birdArray.add(new Word("swallow", "燕子", R.raw.bird_cob, R.drawable.bird_bird));
        birdArray.add(new Word("swan", "天鹅", R.raw.bird_cob, R.drawable.bird_bird));
        birdArray.add(new Word("swift", "褐雨燕", R.raw.bird_cob, R.drawable.bird_bird));
        birdArray.add(new Word("teal", "水鸭", R.raw.bird_cob, R.drawable.bird_bird));
        birdArray.add(new Word("cockatoo", "风头鹦鹉", R.raw.bird_cob, R.drawable.bird_bird));
        birdArray.add(new Word("gannet", "塘鹅", R.raw.bird_cob, R.drawable.bird_bird));
        birdArray.add(new Word("goldfinch", "金翅雀", R.raw.bird_cob, R.drawable.bird_bird));
        birdArray.add(new Word("kingfisher", "翠鸟", R.raw.bird_cob, R.drawable.bird_bird));
        birdArray.add(new Word("starling", "燕八哥", R.raw.bird_cob, R.drawable.bird_bird));
        birdArray.add(new Word("woodcock", "丘鹬", R.raw.bird_cob, R.drawable.bird_bird));

        WordAdapter itemAdapter =
                new WordAdapter(getActivity(), birdArray, R.color.category_bird);

        ListView listView = (ListView) rootView.findViewById(R.id.birdsView);

        listView.setAdapter(itemAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Word word = birdArray.get(position);

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
