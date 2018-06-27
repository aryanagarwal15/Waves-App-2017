package org.bits_waves.waves2017.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import org.bits_waves.waves2017.R;


import com.squareup.picasso.Picasso;


public class Category_home_page extends AppCompatActivity implements View.OnClickListener {

    private Intent it;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_home_page);

        ImageButton back = findViewById(R.id.categories_back);
        ImageView drama = findViewById(R.id.categories_drama);
        ImageView dance = findViewById(R.id.categories_dance);
        ImageView specials = findViewById(R.id.categories_specials);
        ImageView music = findViewById(R.id.categories_music);
        ImageView literary = findViewById(R.id.categories_literary);
        ImageView quiz = findViewById(R.id.categories_quiz);
        ImageView workshop = findViewById(R.id.categories_workshop);
        ImageView design = findViewById(R.id.categories_design);

        Picasso.with(this).load("http://bits-waves.org/static/main/images1/events/natyanjali.JPG").fit().into(dance);
        Picasso.with(this).load("http://bits-waves.org/static/main/images1/events/rangmanch.jpg").fit().into(drama);
        Picasso.with(this).load("http://bits-waves.org/static/main/images1/events/mr_waves.jpg").fit().into(specials);
        Picasso.with(this).load("http://bits-waves.org/static/main/images1/events/searock.JPG").fit().into(music);
        Picasso.with(this).load("http://bits-waves.org/static/main/images1/events/Contention.JPG").fit().into(literary);
        Picasso.with(this).load("http://bits-waves.org/static/main/images1/events/artathon.jpg").fit().into(workshop);
        Picasso.with(this).load("http://bits-waves.org/static/main/images1/events/culturalgauntlet.JPG").fit().into(quiz);
        Picasso.with(this).load("http://bits-waves.org/static/main/images1/events/blindart.JPG").fit().into(design);

        music.setOnClickListener(this);
        drama.setOnClickListener(this);
        dance.setOnClickListener(this);
        design.setOnClickListener(this);
        specials.setOnClickListener(this);
        literary.setOnClickListener(this);
        workshop.setOnClickListener(this);
        quiz.setOnClickListener(this);
        back.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.categories_music:
                it = new Intent(getApplicationContext(), Category.class);
                it.putExtra("category_heading", "Music");
                break;
            case R.id.categories_dance:
                it = new Intent(getApplicationContext(), Category.class);
                it.putExtra("category_heading", "Dance");
                break;
            case R.id.categories_drama:
                it = new Intent(getApplicationContext(), Category.class);
                it.putExtra("category_heading", "Drama");
                break;
            case R.id.categories_specials:
                it = new Intent(getApplicationContext(), Category.class);
                it.putExtra("category_heading", "Specials");
                break;
            case R.id.categories_literary:
                it = new Intent(getApplicationContext(), Category.class);
                it.putExtra("category_heading", "Literary");
                break;
            case R.id.categories_quiz:
                it = new Intent(getApplicationContext(), Category.class);
                it.putExtra("category_heading", "Quiz");
                break;
            case R.id.categories_workshop:
                it = new Intent(getApplicationContext(), Category.class);
                it.putExtra("category_heading", "Workshop");
                break;
            case R.id.categories_design:
                it = new Intent(getApplicationContext(), Category.class);
                it.putExtra("category_heading", "Design");
                break;
            case R.id.categories_back:
                it = new Intent(getApplicationContext(), MainActivity.class);
                it.putExtra("category_heading", "Design");
                break;
        }

        startActivity(it);
    }

}

