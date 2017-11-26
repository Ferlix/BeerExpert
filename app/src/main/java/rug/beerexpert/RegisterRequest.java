package rug.beerexpert;


import android.view.View;
import android.widget.RadioButton;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

// StringRequest: make request for registration to the PHP file on the server, getting as result a string

public class RegisterRequest extends StringRequest {

    // Specify the URL where the PHP file is located for doing a register request
    private static final String REGISTER_REQUEST_URL = "https://myexpert.000webhostapp.com/register.php";

    private Map<String, String> params;

    // Constructor: called when the class is invoked. It needs the registration parameter and the listener response
    public RegisterRequest (String username, String password, int age, String gender, Response.Listener<String> listener){
        // Pass some data to volley to allow the request
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);

        params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);
        // + "" convert the int into a string, so do not remove it :)
        params.put("age", age + "");
        params.put("gender", gender);
    }

    // When there is a register request, volley will call getParams, which returns the parameters
    @Override
    public Map<String, String> getParams() {
        return params;
    }


}
