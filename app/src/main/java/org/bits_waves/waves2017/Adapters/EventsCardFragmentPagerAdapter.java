package org.bits_waves.waves2017.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;

import org.bits_waves.waves2017.fragment.EventsCardFragment;
import org.bits_waves.waves2017.fragment.EventsFragment;

import java.util.ArrayList;
import java.util.List;

public class EventsCardFragmentPagerAdapter extends FragmentStatePagerAdapter implements EventsFragment.CardAdapter {

    private List<EventsCardFragment> mFragments;
    private float mBaseElevation;

    public EventsCardFragmentPagerAdapter(FragmentManager fm, float baseElevation) {
        super(fm);
        mFragments = new ArrayList<>();
        mBaseElevation = baseElevation;

        for(int i = 0; i< 5; i++){
            addCardFragment(new EventsCardFragment());
        }
    }

    @Override
    public float getBaseElevation() {
        return mBaseElevation;
    }

    @Override
    public CardView getCardViewAt(int position) {
        return mFragments.get(position).getCardView();
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Object fragment = super.instantiateItem(container, position);
        mFragments.set(position, (EventsCardFragment) fragment);
        return fragment;
    }

    public void addCardFragment(EventsCardFragment fragment) {
        mFragments.add(fragment);
    }

}

