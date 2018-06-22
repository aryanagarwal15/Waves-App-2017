package org.bits_waves.waves2017.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.bits_waves.waves2017.R;

public class EventsView extends AppCompatActivity {

    private int day;
    private TextView titleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_view);
        Intent intent = getIntent();
        day = intent.getIntExtra("day", 0);

        //Code to display
        titleTextView = (TextView) findViewById(R.id.textview_title_events_activity);
        titleTextView.setText("Day " + day + " events here");
    }
}
