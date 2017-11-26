package rug.beerexpert;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class UserAreaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);

        final TextView etUsername = findViewById(R.id.etUsername);
        final TextView etAge = findViewById(R.id.etAge);
        final TextView etGender = findViewById(R.id.etGender);
        final TextView etPassword = findViewById(R.id.etPassword);

        Intent intent = getIntent();
        String name = intent.getStringExtra("username");
        int age = intent.getIntExtra("age", -1);
        String password = intent.getStringExtra("password");
        String gender = intent.getStringExtra("gender");

        etUsername.setText(name);
        etAge.setText(age + "");
        etGender.setText(gender);
        etPassword.setText(password);
    }
}
