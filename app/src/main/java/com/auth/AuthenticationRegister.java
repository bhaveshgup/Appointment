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


public class AuthenticationRegister extends AppCompatActivity {

    private EditText registerEmail,registerPhone, registerPassword, registerReEnterPassword;
    private Button signupActionButton, switchToLoginButton;
    private FirebaseAuth mauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.authentication_register);

        mauth = FirebaseAuth.getInstance();

        // Bind UI components
        registerEmail = findViewById(R.id.registerEmail);
        registerPhone = findViewById(R.id.registerPhone);
        registerPassword = findViewById(R.id.registerPassword);
        registerReEnterPassword = findViewById(R.id.registerReEnterPassword);
        signupActionButton = findViewById(R.id.signupActionButton);
        switchToLoginButton = findViewById(R.id.switchToLogin);

        switchToLoginButton.setOnClickListener(v -> {
            Intent intent = new Intent(AuthenticationRegister.this, AuthenticationLogin.class);
            startActivity(intent);
        });

        signupActionButton.setOnClickListener(v -> {
            String email = registerEmail.getText().toString().trim();
            String password = registerPassword.getText().toString().trim();
            String reEnterPassword = registerReEnterPassword.getText().toString().trim();

            if (validateInputs(email, password, reEnterPassword)) {
                signUpUser(email, password);
            }
        });
    }
    private boolean validateInputs(String email, String password, String reEnterPassword) {
        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(reEnterPassword)) {
            Toast.makeText(this, "All fields are required!", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!password.equals(reEnterPassword)) {
            Toast.makeText(this, "Passwords do not match!", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
    private void signUpUser(String email, String password) {
        mauth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(this, "Registration Successful!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(AuthenticationRegister.this, AuthenticationLogin.class));
                        finish();
                    } else {
                        Toast.makeText(this, "Registration Failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}