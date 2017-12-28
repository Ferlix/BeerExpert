package eu.deustotech.beerclipsdemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

// Activity to display the information about the chosen beer
// The ID of the beer is sent from the main activity
public class ShowBeer extends Activity  {

<<<<<<< HEAD
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
=======
    String beerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beer_information);
        beerName = getIntent().getStringExtra("ANSWER");

        TextView name = (TextView) findViewById(R.id.beerNameView);
        name.setText(beerName);
>>>>>>> 8b8e23c87ddc31749f0742560f86518370f229dd
    }

}