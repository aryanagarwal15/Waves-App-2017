package org.bits_waves.waves2017.tabs;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.bits_waves.waves2017.adapters.EventAdapter;
import org.bits_waves.waves2017.listitems.EventItem;
import org.bits_waves.waves2017.R;

import java.util.ArrayList;
import java.util.List;

public class Day0 extends Fragment {

    public static Day0 newInstance() {
        return new Day0();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myFragmentView = inflater.inflate(R.layout.activity_day0, container, false);

        RecyclerView recyclerView = myFragmentView.findViewById(R.id.recycle2);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        List<EventItem> listItems = new ArrayList<>();
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        RecyclerView.Adapter adapter = new EventAdapter(listItems, getActivity().getApplicationContext());

        recyclerView.setAdapter(adapter);
        EventItem listItem = new EventItem("Inauguration","","http://bits-waves.org/static/main/images1/events/skime.JPG","17:00","Auditorium","Specials");
        listItems.add(listItem);
        EventItem listItem9 = new EventItem("Moot Court","","http://bits-waves.org/static/main/images1/events/moot.JPG","17:00","A Block","Specials");
        listItems.add(listItem9);
        EventItem listItem1 = new EventItem("Spin Off","Goa Eliminations","http://bits-waves.org/static/main/images1/events/spinoff.JPG","22:00","Outdoor Stage","Music");
        listItems.add(listItem1);
        EventItem listItem2 = new EventItem("Searock","Goa Eliminations","http://bits-waves.org/static/main/images1/events/searock.JPG","23:00","Auditorium","Music");
        listItems.add(listItem2);
        EventItem listItem3 = new EventItem("Sizzle","Eliminations","http://bits-waves.org/static/main/images1/events/sizzle.jpg","00:00","C-301","Dance");
        listItems.add(listItem3);
        EventItem listItem4 = new EventItem("Jukebox","Eliminations","http://bits-waves.org/static/main/images1/events/jokebox.JPG","23:00","LT 1/2 lawns","Music");
        listItems.add(listItem4);
        EventItem listItem5 = new EventItem("Strangely Familiar","Eliminations","http://bits-waves.org/static/main/images1/events/sf.JPG","00:00","C-306","Specials");
        listItems.add(listItem5);
        EventItem listItem6 = new EventItem("FashP","Eliminations","http://bits-waves.org/static/main/images1/events/fashp.jpg","00:00","CC","Specials");
        listItems.add(listItem6);
        EventItem listItem8 = new EventItem("Show Me The Funny","Eliminations","http://bits-waves.org/static/main/images1/events/smtf.JPG","00:00","C-302","Specials");
        listItems.add(listItem8);


//        for (int i = 0; i <= 10; i++) {
//            EventItem listItem = new EventItem("Heading 0 " + (i+1),
//                    "Hello","https://www.w3schools.com/css/trolltunga.jpg","10:00","B-Dome","Music"
//            );
//
//            listItems.add(listItem);
//        }
        return myFragmentView;

    }
}