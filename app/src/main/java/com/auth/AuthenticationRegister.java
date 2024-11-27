package com.auth;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.appointment.R;

public class AuthenticationRegister extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.authentication_register);

        Button button = findViewById(R.id.switchToLogin);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(AuthenticationRegister.this, AuthenticationLogin.class);
            startActivity(intent);
        });
    }
}