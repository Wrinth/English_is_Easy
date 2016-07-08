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

public class VegetablesFragment extends Fragment {

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

    public VegetablesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_vegetables, container, false);

        // Create and setup the AudioManager to request audio focus
        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> vegetableArray = new ArrayList<Word>();
        vegetableArray.add(new Word("artichoke", "朝鲜蓟", R.raw.bird_cob, R.drawable.vegetable_vegetable));
        vegetableArray.add(new Word("asparagus", "芦笋", R.raw.bird_cob, R.drawable.vegetable_vegetable));
        vegetableArray.add(new Word("bean", "豆", R.raw.bird_cob, R.drawable.vegetable_vegetable));
        vegetableArray.add(new Word("beet", "甜菜", R.raw.bird_cob, R.drawable.vegetable_vegetable));
        vegetableArray.add(new Word("beetroot", "甜菜根", R.raw.bird_cob, R.drawable.vegetable_vegetable));
        vegetableArray.add(new Word("broccoli", "花椰菜；西兰花", R.raw.bird_cob, R.drawable.vegetable_vegetable));
        vegetableArray.add(new Word("cabbage", "卷心菜", R.raw.bird_cob, R.drawable.vegetable_vegetable));
        vegetableArray.add(new Word("caper", "刺山柑", R.raw.bird_cob, R.drawable.vegetable_vegetable));
        vegetableArray.add(new Word("carrot", "胡萝卜", R.raw.bird_cob, R.drawable.vegetable_vegetable));
        vegetableArray.add(new Word("cauliflower", "菜花", R.raw.bird_cob, R.drawable.vegetable_vegetable));
        vegetableArray.add(new Word("celery", "芹菜", R.raw.bird_cob, R.drawable.vegetable_vegetable));
        vegetableArray.add(new Word("chilli", "红辣椒", R.raw.bird_cob, R.drawable.vegetable_vegetable));
        vegetableArray.add(new Word("cucumber", "黄瓜；胡瓜", R.raw.bird_cob, R.drawable.vegetable_vegetable));
        vegetableArray.add(new Word("eggplant", "茄子", R.raw.bird_cob, R.drawable.vegetable_vegetable));
        vegetableArray.add(new Word("garlic", "大蒜；蒜头", R.raw.bird_cob, R.drawable.vegetable_vegetable));
        vegetableArray.add(new Word("leek", "韭葱", R.raw.bird_cob, R.drawable.vegetable_vegetable));
        vegetableArray.add(new Word("lentil", "小扁豆", R.raw.bird_cob, R.drawable.vegetable_vegetable));
        vegetableArray.add(new Word("lettuce", "生菜", R.raw.bird_cob, R.drawable.vegetable_vegetable));
        vegetableArray.add(new Word("melon", "蜜瓜", R.raw.bird_cob, R.drawable.vegetable_vegetable));
        vegetableArray.add(new Word("mushroom", "蘑菇", R.raw.bird_cob, R.drawable.vegetable_vegetable));
        vegetableArray.add(new Word("onion", "洋葱", R.raw.bird_cob, R.drawable.vegetable_vegetable));
        vegetableArray.add(new Word("parsley", "香芹", R.raw.bird_cob, R.drawable.vegetable_vegetable));
        vegetableArray.add(new Word("pea", "豌豆", R.raw.bird_cob, R.drawable.vegetable_vegetable));
        vegetableArray.add(new Word("pepper", "胡椒；辣椒", R.raw.bird_cob, R.drawable.vegetable_vegetable));
        vegetableArray.add(new Word("potato", "土豆；马铃薯", R.raw.bird_cob, R.drawable.vegetable_vegetable));
        vegetableArray.add(new Word("pumpkin", "南瓜", R.raw.bird_cob, R.drawable.vegetable_vegetable));
        vegetableArray.add(new Word("radish", "小萝卜", R.raw.bird_cob, R.drawable.vegetable_vegetable));
        vegetableArray.add(new Word("rhubarb", "大黄", R.raw.bird_cob, R.drawable.vegetable_vegetable));
        vegetableArray.add(new Word("thyme", "百里香", R.raw.bird_cob, R.drawable.vegetable_vegetable));
        vegetableArray.add(new Word("tomato", "番茄；西红柿", R.raw.bird_cob, R.drawable.vegetable_vegetable));
        vegetableArray.add(new Word("turnip", "萝卜", R.raw.bird_cob, R.drawable.vegetable_vegetable));
        vegetableArray.add(new Word("aubergine", "茄子", R.raw.bird_cob, R.drawable.vegetable_vegetable));
        vegetableArray.add(new Word("cardoon", "刺棘蓟", R.raw.bird_cob, R.drawable.vegetable_vegetable));
        vegetableArray.add(new Word("chervil", "山萝卜", R.raw.bird_cob, R.drawable.vegetable_vegetable));
        vegetableArray.add(new Word("chick-pea", "鹰嘴豆", R.raw.bird_cob, R.drawable.vegetable_vegetable));
        vegetableArray.add(new Word("chive", "细香葱", R.raw.bird_cob, R.drawable.vegetable_vegetable));
        vegetableArray.add(new Word("cress", "水芹", R.raw.bird_cob, R.drawable.vegetable_vegetable));
        vegetableArray.add(new Word("cumin", "小茴香", R.raw.bird_cob, R.drawable.vegetable_vegetable));
        vegetableArray.add(new Word("cummin", "孜然芹", R.raw.bird_cob, R.drawable.vegetable_vegetable));
        vegetableArray.add(new Word("fennel", "茴香", R.raw.bird_cob, R.drawable.vegetable_vegetable));
        vegetableArray.add(new Word("gherkin", "小黄瓜", R.raw.bird_cob, R.drawable.vegetable_vegetable));
        vegetableArray.add(new Word("horseradish", "山葵", R.raw.bird_cob, R.drawable.vegetable_vegetable));
        vegetableArray.add(new Word("kale", "羽衣甘蓝", R.raw.bird_cob, R.drawable.vegetable_vegetable));
        vegetableArray.add(new Word("kohlrabi", "大头菜", R.raw.bird_cob, R.drawable.vegetable_vegetable));
        vegetableArray.add(new Word("lupin", "羽扇豆", R.raw.bird_cob, R.drawable.vegetable_vegetable));
        vegetableArray.add(new Word("parsnip", "欧洲萝卜", R.raw.bird_cob, R.drawable.vegetable_vegetable));
        vegetableArray.add(new Word("salsify", "婆罗门参", R.raw.bird_cob, R.drawable.vegetable_vegetable));
        vegetableArray.add(new Word("sorrel", "酢浆草", R.raw.bird_cob, R.drawable.vegetable_vegetable));
        vegetableArray.add(new Word("tarragon", "龙嵩叶", R.raw.bird_cob, R.drawable.vegetable_vegetable));
        vegetableArray.add(new Word("truffle", "松露", R.raw.bird_cob, R.drawable.vegetable_vegetable));
        vegetableArray.add(new Word("watercress", "西洋菜", R.raw.bird_cob, R.drawable.vegetable_vegetable));

        WordAdapter itemAdapter =
                new WordAdapter(getActivity(), vegetableArray, R.color.category_vegetable);

        ListView listView = (ListView) rootView.findViewById(R.id.vegetablesView);

        listView.setAdapter(itemAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Word word = vegetableArray.get(position);

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
