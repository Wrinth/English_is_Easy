package com.wrinth.english_is_easy;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by JohnL on 7/6/2016.
 */
public class CategoryAdapter extends FragmentPagerAdapter {

    /** Context of the app */
    private Context mContext;

    /**
     * Create a new {@link CategoryAdapter} object.
     *
     * @param fm is the fragment manager that will keep each fragment's state in the adapter
     *           across swipes.
     */
    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     */
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new AmphibiansFragment();
        } else if (position == 1) {
            return new BirdsFragment();
        } else if (position == 2) {
            return new CrustaceansFragment();
        } else if (position == 3) {
            return new FishesFragment();
        } else if (position == 4) {
            return new FlowersFragment();
        } else if (position == 5) {
            return new FruitsFragment();
        } else if (position == 6) {
            return new InsectsFragment();
        } else if (position == 7) {
            return new MammalsFragment();
        } else if (position == 8) {
            return new PoultriesFragment();
        } else if (position == 9) {
            return new TreesFragment();
        } else {
            return new VegetablesFragment();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_amphibians);
        } else if (position == 1) {
            return mContext.getString(R.string.category_birds);
        } else if (position == 2) {
            return mContext.getString(R.string.category_crustaceans);
        } else if (position == 3) {
            return mContext.getString(R.string.category_fishes);
        } else if (position == 4) {
            return mContext.getString(R.string.category_flowers);
        } else if (position == 5) {
            return mContext.getString(R.string.category_fruits);
        } else if (position == 6) {
            return mContext.getString(R.string.category_insects);
        } else if (position == 7) {
            return mContext.getString(R.string.category_mammals);
        } else if (position == 8) {
            return mContext.getString(R.string.category_poultries);
        } else if (position == 9) {
            return mContext.getString(R.string.category_trees);
        } else {
            return mContext.getString(R.string.category_vegetables);
        }
    }

    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return 10;
    }

}
