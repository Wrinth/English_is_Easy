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

public class FlowersFragment extends Fragment {

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

    public FlowersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_flowers, container, false);

        // Create and setup the AudioManager to request audio focus
        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> flowerArray = new ArrayList<Word>();
        flowerArray.add(new Word("anemone", "银莲花", R.raw.bird_cob, R.drawable.flower_flower));
        flowerArray.add(new Word("anther", "花药", R.raw.bird_cob, R.drawable.flower_flower));
        flowerArray.add(new Word("azalea", "杜鹃花", R.raw.bird_cob, R.drawable.flower_flower));
        flowerArray.add(new Word("camellia ", "山茶花", R.raw.bird_cob, R.drawable.flower_flower));
        flowerArray.add(new Word("carnation", "康乃馨", R.raw.bird_cob, R.drawable.flower_flower));
        flowerArray.add(new Word("chicory", "菊苣", R.raw.bird_cob, R.drawable.flower_flower));
        flowerArray.add(new Word("chrysanthemum", "菊花", R.raw.bird_cob, R.drawable.flower_flower));
        flowerArray.add(new Word("cosmos", "大波斯菊 ", R.raw.bird_cob, R.drawable.flower_flower));
        flowerArray.add(new Word("cyclamen", "仙客来", R.raw.bird_cob, R.drawable.flower_flower));
        flowerArray.add(new Word("daffodil", "水仙花", R.raw.bird_cob, R.drawable.flower_flower));
        flowerArray.add(new Word("daisy", "雏菊", R.raw.bird_cob, R.drawable.flower_flower));
        flowerArray.add(new Word("dandelion", "蒲公英", R.raw.bird_cob, R.drawable.flower_flower));
        flowerArray.add(new Word("daphne", "瑞香", R.raw.bird_cob, R.drawable.flower_flower));
        flowerArray.add(new Word("dogwood", "山茱萸", R.raw.bird_cob, R.drawable.flower_flower));
        flowerArray.add(new Word("freesia", "小苍兰", R.raw.bird_cob, R.drawable.flower_flower));
        flowerArray.add(new Word("gardenia", "栀子花", R.raw.bird_cob, R.drawable.flower_flower));
        flowerArray.add(new Word("geranium", "天竺葵", R.raw.bird_cob, R.drawable.flower_flower));
        flowerArray.add(new Word("hawthorn", "山楂树", R.raw.bird_cob, R.drawable.flower_flower));
        flowerArray.add(new Word("hyacinth", "风信子", R.raw.bird_cob, R.drawable.flower_flower));
        flowerArray.add(new Word("hydrangea", "绣球花", R.raw.bird_cob, R.drawable.flower_flower));
        flowerArray.add(new Word("iris", "鸢尾", R.raw.bird_cob, R.drawable.flower_flower));
        flowerArray.add(new Word("jasmine", "茉莉", R.raw.bird_cob, R.drawable.flower_flower));
        flowerArray.add(new Word("lilac", "紫丁香 ", R.raw.bird_cob, R.drawable.flower_flower));
        flowerArray.add(new Word("lily", "百合花", R.raw.bird_cob, R.drawable.flower_flower));
        flowerArray.add(new Word("magnolia", "木兰", R.raw.bird_cob, R.drawable.flower_flower));
        flowerArray.add(new Word("marigold", "万寿菊", R.raw.bird_cob, R.drawable.flower_flower));
        flowerArray.add(new Word("narcissus", "水仙", R.raw.bird_cob, R.drawable.flower_flower));
        flowerArray.add(new Word("orchid", "兰花", R.raw.bird_cob, R.drawable.flower_flower));
        flowerArray.add(new Word("pansy", "三色紫罗兰", R.raw.bird_cob, R.drawable.flower_flower));
        flowerArray.add(new Word("peony", "牡丹", R.raw.bird_cob, R.drawable.flower_flower));
        flowerArray.add(new Word("petal", "花瓣", R.raw.bird_cob, R.drawable.flower_flower));
        flowerArray.add(new Word("pink", "石竹花", R.raw.bird_cob, R.drawable.flower_flower));
        flowerArray.add(new Word("pistil", "雌蕊", R.raw.bird_cob, R.drawable.flower_flower));
        flowerArray.add(new Word("pollen", "花粉", R.raw.bird_cob, R.drawable.flower_flower));
        flowerArray.add(new Word("poppy", "罂粟花", R.raw.bird_cob, R.drawable.flower_flower));
        flowerArray.add(new Word("rose", "玫瑰", R.raw.bird_cob, R.drawable.flower_flower));
        flowerArray.add(new Word("sepal", "花萼", R.raw.bird_cob, R.drawable.flower_flower));
        flowerArray.add(new Word("stalk", "植物的茎", R.raw.bird_cob, R.drawable.flower_flower));
        flowerArray.add(new Word("stamen", "雄蕊", R.raw.bird_cob, R.drawable.flower_flower));
        flowerArray.add(new Word("sunflower", "向日葵", R.raw.bird_cob, R.drawable.flower_flower));
        flowerArray.add(new Word("tulip", "郁金香", R.raw.bird_cob, R.drawable.flower_flower));
        flowerArray.add(new Word("violet", "紫罗兰", R.raw.bird_cob, R.drawable.flower_flower));
        flowerArray.add(new Word("yucca", "丝兰", R.raw.bird_cob, R.drawable.flower_flower));
        flowerArray.add(new Word("amaryllis", "孤挺花", R.raw.bird_cob, R.drawable.flower_flower));
        flowerArray.add(new Word("balsam", "凤仙花", R.raw.bird_cob, R.drawable.flower_flower));
        flowerArray.add(new Word("begonia", "秋海棠", R.raw.bird_cob, R.drawable.flower_flower));
        flowerArray.add(new Word("crocus", "番红花", R.raw.bird_cob, R.drawable.flower_flower));
        flowerArray.add(new Word("dahlia", "大丽花", R.raw.bird_cob, R.drawable.flower_flower));
        flowerArray.add(new Word("fuchsia", "倒挂金钟", R.raw.bird_cob, R.drawable.flower_flower));
        flowerArray.add(new Word("gladiolus", "剑兰", R.raw.bird_cob, R.drawable.flower_flower));
        flowerArray.add(new Word("hibiscus", "木槿；芙蓉花", R.raw.bird_cob, R.drawable.flower_flower));
        flowerArray.add(new Word("marguerite", "雏菊", R.raw.bird_cob, R.drawable.flower_flower));
        flowerArray.add(new Word("oleander", "夹竹桃", R.raw.bird_cob, R.drawable.flower_flower));
        flowerArray.add(new Word("rhododendron", "杜鹃花", R.raw.bird_cob, R.drawable.flower_flower));
        flowerArray.add(new Word("wisteria", "紫藤；柴藤", R.raw.bird_cob, R.drawable.flower_flower));

        WordAdapter itemAdapter =
                new WordAdapter(getActivity(), flowerArray, R.color.category_flower);

        ListView listView = (ListView) rootView.findViewById(R.id.flowersView);

        listView.setAdapter(itemAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Word word = flowerArray.get(position);

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
