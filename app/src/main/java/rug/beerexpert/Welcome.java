package rug.beerexpert;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        final Button bSignIn1 = (Button) findViewById(R.id.bSignIn1);
        final TextView bSignUp1 = (TextView) findViewById(R.id.bSignUp1);

        // Link buttons to the next pages:
        // Sign in button
        bSignIn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signInIntent = new Intent(Welcome.this, LoginActivity.class);
                Welcome.this.startActivity(signInIntent);
            }
        });

        // Sign up button
        bSignUp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signUpIntent = new Intent(Welcome.this, RegisterActivity.class);
                Welcome.this.startActivity(signUpIntent);
            }
        });
    }
}
