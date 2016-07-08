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

public class MammalsFragment extends Fragment {

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

    public MammalsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_mammals, container, false);

        // Create and setup the AudioManager to request audio focus
        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> mammalArray = new ArrayList<Word>();
        mammalArray.add(new Word("anteater", "食蚁兽", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("armadillo", "犰狳", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("badger", "獾", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("bat", "蝙蝠", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("bear", "熊", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("beaver", "海狸", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("bison", "北美野牛", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("buffalo", "水牛", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("calf", "小牛(幼崽)", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("camel", "骆驼", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("chimpanzee", "黑猩猩", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("deer", "鹿", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("dolphin", "海豚", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("elephant", "象", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("ferret", "雪貂", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("fox", "狐狸", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("gazelle", "羚羊", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("gibbon", "长臂猿", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("gilt", "小母猪", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("giraffe", "长颈鹿", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("gorilla", "大猩猩", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("hare", "野兔", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("hedgehog", "刺猬", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("heifer", "小母牛", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("hippopotamus", "河马", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("hog", "猪", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("hyena", "鬣狗", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("kangaroo", "袋鼠", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("kitty", "猫咪", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("koala", "树袋熊；无尾熊", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("leopard", "美洲豹", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("lion", "狮子", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("lynx", "猞猁；山猫", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("mole", "鼹鼠", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("monkey", "猴子", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("mouse", "老鼠", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("otter", "水獭", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("panther", "黑豹", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("platypus", "鸭嘴兽", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("pony", "矮种马", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("porcupine", "箭猪", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("porpoise", "海豚", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("puma", "美洲狮", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("pussy", "猫咪", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("rat", "鼠", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("reindeer", "驯鹿", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("rhinoceros", "犀牛", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("seal", "海豹", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("sloth", "树懒", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("squirrel", "松鼠", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("steer", "阉牛", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("swine", "猪", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("thoroughbred", "良种马", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("tiger", "老虎", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("vole", "野鼠", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("walrus", "海象", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("weasel", "鼬鼠", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("whale", "鲸", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("wildcat", "野猫", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("wolf", "狼", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("zebra", "斑马", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("alpaca", "羊驼", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("bullock", "小公牛", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("chinchilla", "南美栗鼠", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("dormouse", " 榛睡鼠", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("dromedary", "单峰骆驼", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("gopher", "囊地鼠", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("grimalkin", "老母猫", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("llama", "美洲无峰驼", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("marmot", "土拨鼠", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("mustang", "野马", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("orangutan", "猩猩", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("tabby", "平纹斑猫", R.raw.bird_cob, R.drawable.mammal_mammal));
        mammalArray.add(new Word("vicuna", "骆马", R.raw.bird_cob, R.drawable.mammal_mammal));

        WordAdapter itemAdapter =
                new WordAdapter(getActivity(), mammalArray, R.color.category_mammal);

        ListView listView = (ListView) rootView.findViewById(R.id.mammalsView);

        listView.setAdapter(itemAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Word word = mammalArray.get(position);

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
