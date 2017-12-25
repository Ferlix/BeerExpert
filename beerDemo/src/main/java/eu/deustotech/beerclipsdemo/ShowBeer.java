package eu.deustotech.beerclipsdemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

// Activity to display the information about the chosen beer
// The ID of the beer is sent from the main activity
public class ShowBeer extends Activity  {

    String beerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beer_information);
        beerName = getIntent().getStringExtra("ANSWER");

        TextView name = (TextView) findViewById(R.id.beerNameView);
        name.setText(beerName);
    }

}