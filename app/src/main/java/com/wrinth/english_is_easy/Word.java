package com.wrinth.english_is_easy;

/**
 * Created by JohnL on 7/6/2016.
 */
public class Word {
    /** English translation for the word */
    private String mEnglishTranslation;

    /** Default translation for the word */
    private String mDefaultTranslation;

    /** Sound for the word */
    private int mSoundResourseId;

    /** Image for the word */
    private int mImageResourceId;

    /**
     * Create a new Word object.
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     *                           (such as Chinese)
     * @param englishTranslation is the word in the English language
     */
    public Word(String englishTranslation, String defaultTranslation, int soundResourceId) {
        mEnglishTranslation = englishTranslation;
        mDefaultTranslation = defaultTranslation;
        mSoundResourseId = soundResourceId;
        mImageResourceId = -1;
    }

    /**
     * Create a new Word object.
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     *                           (such as Chinese)
     * @param englishTranslation is the word in the English language
     * @param imageResourceId is the image resource id of the word
     */
    public Word(String englishTranslation, String defaultTranslation, int soundResourceId, int imageResourceId) {
        mEnglishTranslation = englishTranslation;
        mDefaultTranslation = defaultTranslation;
        mSoundResourseId = soundResourceId;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get the English translation of the word.
     */
    public String getEngliahTranslation() {
        return mEnglishTranslation;
    }

    /**
     * Get the default translation of the word.
     */
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    /**
     * Get the sound's id of the word
     */
    public int getSoundResourseId() { return mSoundResourseId; }

    /**
     * Get the image's id of the word.
     */
    public int getImageResourceId() { return mImageResourceId; }
}
