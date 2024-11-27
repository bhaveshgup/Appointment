package com.appointment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.auth.AuthenticationRegister;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.authentication_login);

        Button button = findViewById(R.id.switchToRegister);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Start", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, AuthenticationRegister.class);
                startActivity(intent);
            }
        });
    }
}