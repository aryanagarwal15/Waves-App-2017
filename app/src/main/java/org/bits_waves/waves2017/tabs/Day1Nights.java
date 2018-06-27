package org.bits_waves.waves2017.tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import org.bits_waves.waves2017.R;

public class Day1Nights extends Fragment {

    public static Day1Nights newInstance() {
        Day1Nights fragment = new Day1Nights();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_day2_nights, container, false);
        ImageView night1 = view.findViewById(R.id.image);
        Picasso.with(getActivity().getApplicationContext()).load("https://firebasestorage.googleapis.com/v0/b/waves-2017-97a39.appspot.com/o/nights%20images%2F1.jpg?alt=media&token=03b40622-a510-49dd-8768-3653720e24eb").fit().into(night1);
        ImageView night2 = view.findViewById(R.id.image2);
        Picasso.with(getActivity().getApplicationContext()).load("https://firebasestorage.googleapis.com/v0/b/waves-2017-97a39.appspot.com/o/nights%20images%2F1.jpg?alt=media&token=03b40622-a510-49dd-8768-3653720e24eb").fit().into(night2);
        return view;

    }
}