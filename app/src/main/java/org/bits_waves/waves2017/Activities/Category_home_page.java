package org.bits_waves.waves2017.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.bits_waves.waves2017.R;

public class Category_home_page extends AppCompatActivity implements View.OnClickListener {

    public TextView music, drama, specials, dance;
    Intent it;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_home_page);

        music = (TextView) findViewById(R.id.categories_music);
        drama = (TextView) findViewById(R.id.categories_drama);
        dance = (TextView) findViewById(R.id.categories_dance);

        music.setText("Music\n\nBajna chahiye Gaana");

        music.setOnClickListener(this);
        drama.setOnClickListener(this);
        dance.setOnClickListener(this);



    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.categories_music:
                it = new Intent(getApplicationContext(), Category.class);
                it.putExtra("category_heading", "Music");
            case R.id.categories_dance:
                it = new Intent(getApplicationContext(), Category.class);
                it.putExtra("category_heading", "Dance");
            case R.id.categories_drama:
                it = new Intent(getApplicationContext(), Category.class);
                it.putExtra("category_heading", "Drama");
        }

        startActivity(it);
    }

}

