package eu.deustotech.beerclipsdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

// Activity to display the information about the chosen beer
// The ID of the beer is sent from the main activity
public class ShowBeer extends Activity  {

    String beerID;
    String nameBeer;
    String typeBeer;
    String colourBeer;
    String flavourBeer;
    String grainBeer;
    String yeastBeer;
    String hopBeer;
    String fermentationBeer;
    String extrasBeer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Set layout
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beer_information);


        beerID = getIntent().getStringExtra("ANSWER");

        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();

        // Set the texts of the section getting them from the dataabase class:
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

        grainBeer = databaseAccess.getBeerGrain(beerID);
        TextView grain = (TextView) findViewById(R.id.grainBeerView);
        grain.setText(grainBeer);

        yeastBeer = databaseAccess.getBeerYeast(beerID);
        TextView yeast = (TextView) findViewById(R.id.yeastBeerView);
        yeast.setText(yeastBeer);

        hopBeer = databaseAccess.getBeerHop(beerID);
        TextView hop = (TextView) findViewById(R.id.hopBeerView);
        hop.setText(hopBeer);

        fermentationBeer = databaseAccess.getBeerFermentation(beerID);
        TextView fermentation = (TextView) findViewById(R.id.fermentationBeerView);
        fermentation.setText(fermentationBeer);

        extrasBeer = databaseAccess.getBeerExtras(beerID);
        TextView extras = (TextView) findViewById(R.id.extrasBeerView);
        extras.setText(extrasBeer);

        // Set titles of section invisible if there is nothing to display:
        TextView grainTitle = (TextView) findViewById(R.id.grainTitle);
        TextView yeastTitle = (TextView) findViewById(R.id.yeastTitle);
        TextView hopTitle = (TextView) findViewById(R.id.hopTitle);
        TextView fermentationTitle = (TextView) findViewById(R.id.fermentationTitle);
        TextView extrasTitle = (TextView) findViewById(R.id.extrasTitle);

        if(grain.getText().length() == 0) grainTitle.setVisibility(View.GONE);
        if(yeast.getText().length() == 0) yeastTitle.setVisibility(View.GONE);
        if(hop.getText().length() == 0) hopTitle.setVisibility(View.GONE);
        if(fermentation.getText().length() == 0) fermentationTitle.setVisibility(View.GONE);
        if(extras.getText().length() == 0) extrasTitle.setVisibility(View.GONE);

        databaseAccess.close();
    }

}