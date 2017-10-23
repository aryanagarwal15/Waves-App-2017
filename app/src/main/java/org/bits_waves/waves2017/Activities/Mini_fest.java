package org.bits_waves.waves2017.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.bits_waves.waves2017.R;

public class Mini_fest extends AppCompatActivity implements View.OnClickListener {

    public TextView beau_vista, florence, specials, carpedictum;
    Intent it;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_home_page);

        beau_vista = (TextView) findViewById(R.id.beau_vista);
        florence = (TextView) findViewById(R.id.florence);
        carpedictum = (TextView) findViewById(R.id.carpedictum);
        specials= (TextView) findViewById(R.id.specials);


        beau_vista.setOnClickListener(this);
        florence.setOnClickListener(this);
        carpedictum.setOnClickListener(this);
        specials.setOnClickListener(this);



    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.beau_vista:
                it = new Intent(getApplicationContext(), Category.class);
                it.putExtra("category_heading", "beau_vista");
            case R.id.carpedictum:
                it = new Intent(getApplicationContext(), Category.class);
                it.putExtra("category_heading", "carpedictum");
            case R.id.florence:
                it = new Intent(getApplicationContext(), Category.class);
                it.putExtra("category_heading", "florence");
            case R.id.specials:
                it = new Intent(getApplicationContext(), Category.class);
                it.putExtra("category_heading", "specials");
        }

        startActivity(it);
    }

}

