package org.bits_waves.waves2017.activities;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.bits_waves.waves2017.tabs.AboutEvent;
import org.bits_waves.waves2017.R;
import org.bits_waves.waves2017.tabs.RuleBook;

public class Events extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        TabLayout mFragmentsTabLayout = findViewById(R.id.app_bar_home_tabs);
        ViewPager mFragmentsViewPager = findViewById(R.id.app_bar_home_viewpager);
        ImageView toolbarImage = findViewById(R.id.toolbar_image);
        Toolbar mToolbar = findViewById(R.id.app_bar_home_toolbar);
        TextView event_name = findViewById(R.id.title_event);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (mToolbar != null) {
            mToolbar.setNavigationOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            onBackPressed();
                        }
                    });
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            int colorPrimary = ContextCompat.getColor(this, R.color.colorPrimary);
            int colorPrimaryDark = ContextCompat.getColor(this, R.color.colorPrimaryDark);
            getWindow().setStatusBarColor(colorPrimaryDark);
            getWindow().setNavigationBarColor(colorPrimary);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        }
        String event_name_string;
        String event_img_string;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                event_name_string = null;
                event_img_string = null;
            } else {
                event_name_string = extras.getString("event_name");
                event_img_string =extras.getString("event_image");
            }
        } else {
            event_img_string = (String) savedInstanceState.getSerializable("event_image");
            event_name_string = (String) savedInstanceState.getSerializable("event_name");
        }
//        toolbarImage.setImageResource(R.drawable.ic_hand);
        Picasso.with(this).load(event_img_string).fit().into(toolbarImage);
        event_name.setText(event_name_string);
        mFragmentsViewPager.setAdapter(new SectionsPagerAdapter(getSupportFragmentManager()));
        mFragmentsTabLayout.setupWithViewPager(mFragmentsViewPager);

    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:

                    return new AboutEvent();
                case 1:
                default:
                    return new RuleBook();
            }
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "About Event";
                case 1:
                    return "Rule Book";

            }
            return null;
        }
    }
}
