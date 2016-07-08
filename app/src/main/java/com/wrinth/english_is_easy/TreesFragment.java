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

public class TreesFragment extends Fragment {

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

    public TreesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_trees, container, false);

        // Create and setup the AudioManager to request audio focus
        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> treeArray = new ArrayList<Word>();
        treeArray.add(new Word("acorn", "橡子", R.raw.bird_cob, R.drawable.tree_tree));
        treeArray.add(new Word("bamboo", "竹子", R.raw.bird_cob, R.drawable.tree_tree));
        treeArray.add(new Word("baobab", "猴面包树", R.raw.bird_cob, R.drawable.tree_tree));
        treeArray.add(new Word("beech", "山毛榉", R.raw.bird_cob, R.drawable.tree_tree));
        treeArray.add(new Word("birch", "桦木", R.raw.bird_cob, R.drawable.tree_tree));
        treeArray.add(new Word("bough", "大树枝", R.raw.bird_cob, R.drawable.tree_tree));
        treeArray.add(new Word("cambium", "新生组织", R.raw.bird_cob, R.drawable.tree_tree));
        treeArray.add(new Word("cottonwood", "杨木", R.raw.bird_cob, R.drawable.tree_tree));
        treeArray.add(new Word("cypress", "柏树", R.raw.bird_cob, R.drawable.tree_tree));
        treeArray.add(new Word("date", "枣椰子", R.raw.bird_cob, R.drawable.tree_tree));
        treeArray.add(new Word("ebony", "乌木", R.raw.bird_cob, R.drawable.tree_tree));
        treeArray.add(new Word("elm", "榆树", R.raw.bird_cob, R.drawable.tree_tree));
        treeArray.add(new Word("fir", "冷杉；枞木", R.raw.bird_cob, R.drawable.tree_tree));
        treeArray.add(new Word("hickory", "山核桃木", R.raw.bird_cob, R.drawable.tree_tree));
        treeArray.add(new Word("holly", "冬青树", R.raw.bird_cob, R.drawable.tree_tree));
        treeArray.add(new Word("juniper", "杜松", R.raw.bird_cob, R.drawable.tree_tree));
        treeArray.add(new Word("larch", "落叶松木", R.raw.bird_cob, R.drawable.tree_tree));
        treeArray.add(new Word("leaf", "叶子", R.raw.bird_cob, R.drawable.tree_tree));
        treeArray.add(new Word("linden", "菩提树", R.raw.bird_cob, R.drawable.tree_tree));
        treeArray.add(new Word("maple", "枫树", R.raw.bird_cob, R.drawable.tree_tree));
        treeArray.add(new Word("myrtle", "桃金娘", R.raw.bird_cob, R.drawable.tree_tree));
        treeArray.add(new Word("oak", "橡树", R.raw.bird_cob, R.drawable.tree_tree));
        treeArray.add(new Word("pine", "松树", R.raw.bird_cob, R.drawable.tree_tree));
        treeArray.add(new Word("poplar", "白杨", R.raw.bird_cob, R.drawable.tree_tree));
        treeArray.add(new Word("resin", "树脂", R.raw.bird_cob, R.drawable.tree_tree));
        treeArray.add(new Word("root", "根", R.raw.bird_cob, R.drawable.tree_tree));
        treeArray.add(new Word("sapling", "树苗", R.raw.bird_cob, R.drawable.tree_tree));
        treeArray.add(new Word("sequoia", "红杉", R.raw.bird_cob, R.drawable.tree_tree));
        treeArray.add(new Word("sprout", "发芽", R.raw.bird_cob, R.drawable.tree_tree));
        treeArray.add(new Word("spruce", "云杉", R.raw.bird_cob, R.drawable.tree_tree));
        treeArray.add(new Word("stump", "树桩", R.raw.bird_cob, R.drawable.tree_tree));
        treeArray.add(new Word("sycamore", "美国梧桐；西克莫无花果树", R.raw.bird_cob, R.drawable.tree_tree));
        treeArray.add(new Word("taproot", "主根", R.raw.bird_cob, R.drawable.tree_tree));
        treeArray.add(new Word("teak", "柚木", R.raw.bird_cob, R.drawable.tree_tree));
        treeArray.add(new Word("treetop", "树顶；树稍", R.raw.bird_cob, R.drawable.tree_tree));
        treeArray.add(new Word("trunk", "树干", R.raw.bird_cob, R.drawable.tree_tree));
        treeArray.add(new Word("twig", "树枝", R.raw.bird_cob, R.drawable.tree_tree));
        treeArray.add(new Word("willow", "柳树", R.raw.bird_cob, R.drawable.tree_tree));
        treeArray.add(new Word("yew", "紫杉", R.raw.bird_cob, R.drawable.tree_tree));
        treeArray.add(new Word("wood", "木材", R.raw.bird_cob, R.drawable.tree_tree));
        treeArray.add(new Word("coco", "椰子树", R.raw.bird_cob, R.drawable.tree_tree));
        treeArray.add(new Word("cycad", "铁树", R.raw.bird_cob, R.drawable.tree_tree));
        treeArray.add(new Word("ginkgo", "银杏", R.raw.bird_cob, R.drawable.tree_tree));
        treeArray.add(new Word("osier", "柳树", R.raw.bird_cob, R.drawable.tree_tree));
        treeArray.add(new Word("rosewood", "花梨木；黄檀木", R.raw.bird_cob, R.drawable.tree_tree));
        treeArray.add(new Word("rowan", "花楸", R.raw.bird_cob, R.drawable.tree_tree));
        treeArray.add(new Word("sandalwood", "白檀", R.raw.bird_cob, R.drawable.tree_tree));
        treeArray.add(new Word("wattle", "金合欢树", R.raw.bird_cob, R.drawable.tree_tree));

        WordAdapter itemAdapter =
                new WordAdapter(getActivity(), treeArray, R.color.category_tree);

        ListView listView = (ListView) rootView.findViewById(R.id.treesView);

        listView.setAdapter(itemAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Word word = treeArray.get(position);

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
