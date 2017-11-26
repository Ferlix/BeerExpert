package rug.beerexpert;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final TextView etUsername = (TextView) findViewById(R.id.etUsername);
        final TextView etPassword = (TextView) findViewById(R.id.etPassword);
        final TextView etRepeatPassword = (TextView) findViewById(R.id.etRepeatPassword);
        final TextView etAge = (TextView) findViewById(R.id.etAge);
        final RadioGroup radioSex = (RadioGroup) findViewById(R.id.radioGender);
        final Button bSignUp2 = (Button) findViewById(R.id.bSignUp2);


        bSignUp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = etUsername.getText().toString();
                final String password = etPassword.getText().toString();
                final int age =  (int) Integer.parseInt(etAge.getText().toString());

                // get selected radio button from radioGroup
                int selectedId = radioSex.getCheckedRadioButtonId();
                // find the radio button by returned id
                final RadioButton radioSexButton = (RadioButton) findViewById(selectedId);
                final String gender = radioSexButton.getText().toString();

                // Create a listener response to pass to the class RegisterRequest:
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                    // everything here will be done after the response is received
                        // Volley put the response in "response" after a request
                        // Convert the response into a JSONobject and get the value
                        try {
                            JSONObject jsonObject = new JSONObject(response.substring(response.indexOf("{"), response.lastIndexOf("}") + 1));


                            // If registration is successuful, we will get "success", as specified
                            // in the PHP file:
                            boolean success = jsonObject.getBoolean("success");

                            // If registration is successful, this intent will bring the user
                            // to the login page, otherwise
                            if(success){
                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                RegisterActivity.this.startActivity(intent);
                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                builder.setMessage("Registration failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show( );
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                RegisterRequest registerRequest = new RegisterRequest(username, password, age, gender, responseListener);
                // Add the request to a request queue from Volley (which holds all the requests)
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);
            }
        });
    }
}
