package org.bits_waves.waves2017.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.bits_waves.waves2017.adapters.NowLiveAdapter;
import org.bits_waves.waves2017.listitems.NowLiveItem;
import org.bits_waves.waves2017.NowLivePuller;
import org.bits_waves.waves2017.R;
import org.bits_waves.waves2017.Utils;

import java.util.ArrayList;
import java.util.List;

public class NowLive extends AppCompatActivity {
    public ImageButton backBut1;
    private RecyclerView.Adapter adapter;
    private List<NowLiveItem> listItems = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_live);
        backBut1 = findViewById(R.id.back_button);
        backBut1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NowLive.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.transition.up_to_down, R.transition.down_to_up);

            }
        });
        FirebaseDatabase fData = Utils.getDatabase();
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        listItems = new ArrayList<>();
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        DatabaseReference mDatabase = fData.getReference().child("live");
        mDatabase.keepSynced(true);
        adapter = new NowLiveAdapter(listItems, getApplicationContext());

        recyclerView.setAdapter(adapter);

        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    NowLivePuller dataPuller = snapshot.getValue(NowLivePuller.class);
                    NowLiveItem listItem = new NowLiveItem(
                            dataPuller.getTitle(), dataPuller.getVenue()
                    );
                    listItems.add(listItem);
                    Log.d("Title", dataPuller.getTitle());
                    Log.d("Venue", dataPuller.getVenue());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }

        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.transition.up_to_down, R.transition.down_to_up);
    }
}
