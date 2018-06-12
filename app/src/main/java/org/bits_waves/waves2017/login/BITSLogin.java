package org.bits_waves.waves2017.login;

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
        signup = findViewById(R.id.bits_login);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editEmail.getText().toString();

                mAuth = FirebaseAuth.getInstance();
                ActionCodeSettings actionCodeSettings =
                        ActionCodeSettings.newBuilder()
                                // URL you want to redirect back to. The domain (www.example.com) for this
                                // URL must be whitelisted in the Firebase Console.
                                .setUrl("https://www.example.com/finishSignUp?cartId=1234")
                                // This must be true
                                .setHandleCodeInApp(true)
                                .setIOSBundleId("com.example.ios")
                                .setAndroidPackageName(
                                        "org.bits_waves.waves2017",
                                        true, /* installIfNotAvailable */
                                        "12"    /* minimumVersion */)
                                .build();
                mAuth.sendSignInLinkToEmail(email,actionCodeSettings);

            }
        });




    }
}
