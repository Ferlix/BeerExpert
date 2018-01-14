package eu.deustotech.beerclipsdemo;

import android.app.Activity;

/**
 *  Class designed to contain the information about the beers in the app.
 */

public class Beer extends Activity{

    String nameBeer;
    String typeBeer;
    String colourBeer;
    String grainBeer;
    String flavourBeer;
    String yeastBeer;
    String hopBeer;
    String fermentationBeer;
    String extrasBeer;
    String suggestedBeer;


    public Beer(String beerID) {
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();

        // Set the texts of the section getting them from the database class:
        nameBeer = databaseAccess.getBeerName(beerID);
        colourBeer = databaseAccess.getBeerColour(beerID);
        typeBeer = databaseAccess.getBeerType(beerID);
        flavourBeer = databaseAccess.getBeerFlavour(beerID);
        grainBeer = databaseAccess.getBeerGrain(beerID);
        yeastBeer = databaseAccess.getBeerYeast(beerID);
        hopBeer = databaseAccess.getBeerHop(beerID);
        fermentationBeer = databaseAccess.getBeerFermentation(beerID);
        extrasBeer = databaseAccess.getBeerExtras(beerID);
        suggestedBeer = databaseAccess.getBeerSuggest(beerID);

        databaseAccess.close();
    }

    public void retrieveBeer(String beerID){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();

        // Set the texts of the section getting them from the database class:
        nameBeer = databaseAccess.getBeerName(beerID);
        colourBeer = databaseAccess.getBeerColour(beerID);
        typeBeer = databaseAccess.getBeerType(beerID);
        flavourBeer = databaseAccess.getBeerFlavour(beerID);
        grainBeer = databaseAccess.getBeerGrain(beerID);
        yeastBeer = databaseAccess.getBeerYeast(beerID);
        hopBeer = databaseAccess.getBeerHop(beerID);
        fermentationBeer = databaseAccess.getBeerFermentation(beerID);
        extrasBeer = databaseAccess.getBeerExtras(beerID);
        suggestedBeer = databaseAccess.getBeerSuggest(beerID);

        databaseAccess.close();
    }

    // Getters for the beer's variables:

    public String getNameBeer() {
        return nameBeer;
    }



    public String getTypeBeer() {
        return typeBeer;
    }



    public String getColourBeer() {
        return colourBeer;
    }


    public String getFlavourBeer() {
        return flavourBeer;
    }


    public String getGrainBeer() {
        return grainBeer;
    }

    public String getYeastBeer() {
        return yeastBeer;
    }

    public String getHopBeer() {
        return hopBeer;
    }

    public String getFermentationBeer() {
        return fermentationBeer;
    }

    public String getExtrasBeer() {
        return extrasBeer;
    }

    public String getSuggestedBeer() {
        return suggestedBeer;
    }

}
