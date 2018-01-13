package eu.deustotech.beerclipsdemo;

import android.app.Activity;
<<<<<<< HEAD
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
=======
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
>>>>>>> master
import android.widget.TextView;

import org.w3c.dom.Text;

// Activity to display the information about the chosen beer
// The ID of the beer is sent from the main activity
public class ShowBeer extends Activity  {

    String debugQueryText;
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
        debugQueryText = getIntent().getStringExtra("DEBUG");

        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();

        // Set the texts of the section getting them from the dataabase class:
        nameBeer = databaseAccess.getBeerName(beerID);
        TextView name = (TextView) findViewById(R.id.beerNameView);
        name.setText(nameBeer);

        ImageView imageView = (ImageView)findViewById(R.id.beerImage);
        imageView.setImageResource(R.mipmap.test);


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

    // Method to create the menu bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.debug_menu, menu);
        return true;
    }

    // Methods for the items in the menu bar
    // action_about_this_app: when clicked, bring to the relative activity
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_about:
                // Create a pop up message with a button to close it
                // with information about the app
                AlertDialog.Builder builderAlert = new AlertDialog.Builder(ShowBeer.this);
                builderAlert.setMessage(R.string.about_this_app);
                builderAlert.setCancelable(true);
                builderAlert.setNeutralButton(
                        "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alertInstance = builderAlert.create();
                alertInstance.show();
                return true;
            case R.id.action_debug:
                Intent intent = new Intent(ShowBeer.this, DebugActivity.class);
                intent.putExtra("DEBUG", debugQueryText);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}