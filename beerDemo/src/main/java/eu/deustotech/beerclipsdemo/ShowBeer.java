package eu.deustotech.beerclipsdemo;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

// Activity to display the information about the chosen beer
// The ID of the beer is sent from the main activity
public class ShowBeer extends Activity  {

    Beer selectedBeer;
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
    String suggestedBeer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Set layout:
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beer_information);

        // Get input from other activity:
        beerID = getIntent().getStringExtra("ANSWER");
        debugQueryText = getIntent().getStringExtra("DEBUG");

        // Retrieve beer from database:
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        selectedBeer = new Beer(beerID);
        databaseAccess.close();

        // Set the texts of the section getting them from the beer object:
        TextView name = (TextView) findViewById(R.id.beerNameView);
        name.setText(selectedBeer.getNameBeer());

        TextView colour = (TextView) findViewById(R.id.colourBeerView);
        colour.setText(selectedBeer.getColourBeer());

        TextView type = (TextView) findViewById(R.id.typeBeerView);
        type.setText(selectedBeer.getTypeBeer());

        TextView flavour = (TextView) findViewById(R.id.flavourBeer);
        flavour.setText(selectedBeer.getFlavourBeer());

        TextView grain = (TextView) findViewById(R.id.grainBeerView);
        grain.setText(selectedBeer.getGrainBeer());

        TextView yeast = (TextView) findViewById(R.id.yeastBeerView);
        yeast.setText(selectedBeer.getYeastBeer());

        TextView hop = (TextView) findViewById(R.id.hopBeerView);
        hop.setText(selectedBeer.getHopBeer());

        TextView fermentation = (TextView) findViewById(R.id.fermentationBeerView);
        fermentation.setText(selectedBeer.getFermentationBeer());

        TextView extras = (TextView) findViewById(R.id.extrasBeerView);
        extras.setText(selectedBeer.getExtrasBeer());

        TextView suggestView = (TextView) findViewById(R.id.suggestBeerView);
        suggestView.setText(selectedBeer.getSuggestedBeer());

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