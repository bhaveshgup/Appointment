package com.auth;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.appointment.R;
import com.google.firebase.auth.FirebaseAuth;

public class AuthenticationLogin extends AppCompatActivity {

    private EditText loginEmail, loginPassword;
    private Button loginActionButton, switchToRegisterButton;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.authentication_login);

        mAuth = FirebaseAuth.getInstance();
        loginEmail = findViewById(R.id.registerEmail);
        loginPassword = findViewById(R.id.registerPassword);
        loginActionButton = findViewById(R.id.signupActionButton);
        switchToRegisterButton = findViewById(R.id.switchToRegister);


        switchToRegisterButton.setOnClickListener(v -> {
            Intent intent = new Intent(AuthenticationLogin.this, AuthenticationRegister.class);
            startActivity(intent);
        });

        loginActionButton.setOnClickListener(v -> {
            String email = loginEmail.getText().toString().trim();
            String password = loginPassword.getText().toString().trim();

            if (validateInputs(email, password)) {
                loginUser(email, password);
            }
        });

    }
    private boolean validateInputs(String email, String password) {
        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            Toast.makeText(this, "All fields are required!", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private void loginUser(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show();
                        // Redirect to another activity (e.g., DashboardActivity)
                    } else {
                        Toast.makeText(this, "Login Failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}