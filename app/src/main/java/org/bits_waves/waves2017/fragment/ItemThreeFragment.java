package org.bits_waves.waves2017.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import org.bits_waves.waves2017.activities.Category_home_page;
import org.bits_waves.waves2017.activities.Mini_fest;
import org.bits_waves.waves2017.activities.NowLive;
import org.bits_waves.waves2017.activities.OurTeam;
import org.bits_waves.waves2017.activities.RegActivity;
import org.bits_waves.waves2017.R;
import org.bits_waves.waves2017.activities.WinnersActivity;

public class ItemThreeFragment extends Fragment {

    public static ItemThreeFragment newInstance() {
        return new ItemThreeFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myFragmentView = inflater.inflate(R.layout.fragment_item_three, container, false);
        ImageButton ourTeam = myFragmentView.findViewById(R.id.ourTeam);
        ImageButton regBut = myFragmentView.findViewById(R.id.regBut);
        Button live = myFragmentView.findViewById(R.id.live);
        Button winner_but = myFragmentView.findViewById(R.id.winners);
        Button category = myFragmentView.findViewById(R.id.category_mainpage);
        Button hello = myFragmentView.findViewById(R.id.minifest_mainpage);

        ourTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplicationContext(), OurTeam.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.transition.enter, R.transition.exit);

            }
        });
        regBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplicationContext(), RegActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.transition.left_to_right, R.transition.right_to_left);
            }
        });
        live.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplicationContext(), NowLive.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.transition.up_to_down, R.transition.down_to_up);
            }
        });
        winner_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplicationContext(), WinnersActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.transition.up_to_down, R.transition.down_to_up);
            }
        });
        category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplicationContext(), Category_home_page.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.transition.up_to_down, R.transition.down_to_up);
            }
        });
        hello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplicationContext(), Mini_fest.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.transition.up_to_down, R.transition.down_to_up);
            }
        });

        return myFragmentView;
    }
}
