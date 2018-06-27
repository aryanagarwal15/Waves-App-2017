package org.bits_waves.waves2017.login;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.squareup.picasso.Picasso;

import org.bits_waves.waves2017.activities.CircleTransform;
import org.bits_waves.waves2017.R;

public class ProfileActivity extends AppCompatActivity {
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        TextView username = findViewById(R.id.user_profile_name);
        ImageView profileImage = findViewById(R.id.user_profile_photo);
        for(UserInfo profile : user.getProviderData()) {
            // check if the provider id matches "facebook.com"
            if(FacebookAuthProvider.PROVIDER_ID.equals(profile.getProviderId())) {

                // Name, email address, and profile photo Url
                String name = profile.getDisplayName();
                Uri photoUrl = profile.getPhotoUrl();
                boolean emailVerified = profile.isEmailVerified();
                username.setText(name);
                Picasso.with(getApplicationContext()).load(photoUrl.toString()+"?height=500").transform(new CircleTransform()).into(profileImage);
            }
        }
    }
}
