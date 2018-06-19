package org.bits_waves.waves2017.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import org.bits_waves.waves2017.R;

public class MainLogin extends AppCompatActivity {
    RelativeLayout bitsian, non_bitsian;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);
        bitsian = findViewById(R.id.bits_login);
        non_bitsian = findViewById(R.id.non_bits_login);

        bitsian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.click_anim));
                Intent i = new Intent(getApplicationContext(), BITSLogin.class);
                startActivity(i);
                finish();
            }
        });
        non_bitsian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.click_anim));
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
