package org.bits_waves.waves2017.fragment;



import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import org.bits_waves.waves2017.Adapters.EventsCardFragmentPagerAdapter;
import org.bits_waves.waves2017.Adapters.EventsCardPagerAdapter;
import org.bits_waves.waves2017.ListItems.EventsCardItem;
import org.bits_waves.waves2017.R;
import org.bits_waves.waves2017.ShadowTransformer;

public class EventsFragment extends Fragment{

    private Button mButton;
    private ViewPager mViewPager;
    private CheckBox mCheckbox;

    private EventsCardPagerAdapter mCardAdapter;
    private ShadowTransformer mCardShadowTransformer;
    private EventsCardFragmentPagerAdapter mFragmentCardAdapter;
    private ShadowTransformer mFragmentCardShadowTransformer;

    private boolean mShowingFragments = false;

    public static EventsFragment newInstance() {
        EventsFragment fragment = new EventsFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onStart() {
        super.onStart();
        mCardAdapter = new EventsCardPagerAdapter();
        mCardAdapter.addCardItem(new EventsCardItem(R.string.title_1, R.string.text_1));
        mCardAdapter.addCardItem(new EventsCardItem(R.string.title_2, R.string.text_1));
        mCardAdapter.addCardItem(new EventsCardItem(R.string.title_3, R.string.text_1));
        mCardAdapter.addCardItem(new EventsCardItem(R.string.title_4, R.string.text_1));
        mFragmentCardAdapter = new EventsCardFragmentPagerAdapter(getActivity().getSupportFragmentManager(),
                dpToPixels(2, getContext()));

        mCardShadowTransformer = new ShadowTransformer(mViewPager, mCardAdapter);
        mFragmentCardShadowTransformer = new ShadowTransformer(mViewPager, mFragmentCardAdapter);

        mViewPager.setAdapter(mCardAdapter);
        mViewPager.setPageTransformer(false, mCardShadowTransformer);
        mViewPager.setOffscreenPageLimit(3);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_events,container, false);


        mViewPager = (ViewPager) view.findViewById(R.id.viewPager);
        mButton = (Button) view.findViewById(R.id.cardTypeBtn);
        CheckBox mCheckbox =  view.findViewById(R.id.checkBox);

        return view;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }

    public interface CardAdapter {

        int MAX_ELEVATION_FACTOR = 8;

        float getBaseElevation();

        CardView getCardViewAt(int position);

        int getCount();
    }

    public static float dpToPixels(int dp, Context context) {
        return dp * (context.getResources().getDisplayMetrics().density);
    }
}
