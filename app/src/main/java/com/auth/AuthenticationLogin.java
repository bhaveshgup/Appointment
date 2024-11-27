package com.auth;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.appointment.R;

public class AuthenticationLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.authentication_login);

        Button button = findViewById(R.id.switchToRegister);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(AuthenticationLogin.this, AuthenticationRegister.class);
            startActivity(intent);
        });
    }
}