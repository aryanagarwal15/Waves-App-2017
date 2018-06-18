package org.bits_waves.waves2017.login;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.bits_waves.waves2017.R;

public class VerifyBITS extends AppCompatActivity {
    private FirebaseAuth mAuth;
    EditText editEmail, editPassword;
    Button signIn;
    String TAG = "DevLog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_bits);
        editEmail = findViewById(R.id.bits_email);
        editPassword = findViewById(R.id.bits_pass);
        signIn = findViewById(R.id.btn_login);
        mAuth = FirebaseAuth.getInstance();

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editEmail.getText().toString() + "@goa.bits-pilani.ac.in";
                String pass = editPassword.getText().toString();
                LoginUser(email, pass);
            }
        });
    }

    private void LoginUser(String email, String pass) {
        mAuth.signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.w(TAG, "signInWithEmail:failure", task.getException());

                        } else {
                            checkIfEmailVerified();
                        }
                    }
                });
    }

    private void checkIfEmailVerified() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user.isEmailVerified()) {
            Log.d(TAG, "signInWithEmail:success");
            updateUI();
            finish();
            Toast.makeText(getApplicationContext(), "Successfully logged in", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Please verify your email before continuing", Toast.LENGTH_SHORT).show();
            FirebaseAuth.getInstance().signOut();
        }
    }

    private void updateUI() {
        Intent i = new Intent(getApplicationContext(), FacebookBITS.class);
        startActivity(i);
        finish();
    }
}

