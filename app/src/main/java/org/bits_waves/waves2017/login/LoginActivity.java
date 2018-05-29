package org.bits_waves.waves2017.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseUser;

import org.bits_waves.waves2017.R;

public class LoginActivity extends AppCompatActivity {
    Button login_btn;
    FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if (user != null) {
            Intent i = new Intent(getApplicationContext(), ProfileActivity.class);
            startActivity(i);
        }

        login_btn = findViewById(R.id.btn_login);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), FacebookActivity.class);
                startActivity(i);
            }
        });
    }
}
