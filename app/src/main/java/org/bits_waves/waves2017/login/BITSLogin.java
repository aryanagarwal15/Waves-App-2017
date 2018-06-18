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
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.bits_waves.waves2017.R;

public class BITSLogin extends AppCompatActivity {
    private FirebaseAuth mAuth;
    EditText editEmail, editPassword;
    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitslogin);
        editEmail = findViewById(R.id.bits_email);
        editPassword = findViewById(R.id.bits_pass);
        signup = findViewById(R.id.btn_login);
        mAuth = FirebaseAuth.getInstance();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editEmail.getText().toString() + "@goa.bits-pilani.ac.in";
                String pass = editPassword.getText().toString();
                createUser(email, pass);
            }
        });
    }

    private void createUser(String email, String pass) {
        mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Log.d("BITSLog", "Login Successful");
                    sendVerificationEmail();
                } else {
                    Log.w("BITSLog", "Login unSuccessful");
                }
            }
        });
    }

    private void sendVerificationEmail() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        user.sendEmailVerification()
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            FirebaseAuth.getInstance().signOut();
                            Log.d("BITSLogin", "Email successfully sent");
                            Intent i = new Intent(getApplicationContext(), VerifyBITS.class);
                            mAuth.signOut();
                            Toast.makeText(getApplicationContext(), "We have sent a verification link to your associated BITS Mail", Toast.LENGTH_LONG).show();
                            startActivity(i);
                            finish();
                        } else {
                            Log.w("BITS Login", "Email was not sent");
                        }
                    }
                });
    }
}
