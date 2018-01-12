package eu.deustotech.beerclipsdemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

// Activity to display the information about the chosen beer
// The ID of the beer is sent from the main activity
public class ShowBeer extends Activity  {

    String beerID;
    String nameBeer;
    String typeBeer;
    String colourBeer;
    String flavourBeer;
    String ingredientsBeer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Set layout
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beer_information);


        beerID = getIntent().getStringExtra("ANSWER");

        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();

        nameBeer = databaseAccess.getBeerName(beerID);
        TextView name = (TextView) findViewById(R.id.beerNameView);
        name.setText(nameBeer);

        ImageView image = (ImageView)findViewById(R.id.beerImage);

        image.setImageResource(test.png);

        colourBeer = databaseAccess.getBeerColour(beerID);
        TextView colour = (TextView) findViewById(R.id.colourBeerView);
        colour.setText(colourBeer);

        typeBeer = databaseAccess.getBeerType(beerID);
        TextView type = (TextView) findViewById(R.id.typeBeerView);
        type.setText(typeBeer);

        flavourBeer = databaseAccess.getBeerFlavour(beerID);
        TextView flavour = (TextView) findViewById(R.id.flavourBeer);
        flavour.setText(flavourBeer);

        databaseAccess.close();
    }

}