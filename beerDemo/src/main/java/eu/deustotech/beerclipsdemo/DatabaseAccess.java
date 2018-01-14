package eu.deustotech.beerclipsdemo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    // Define database name and columns
    String table = "beers";
    String[] columns = {"IDbeer", "name", "type", "colour", "flavour", "grain", "yeast", "hop", "fermentation", "extras"};
    String selection = "IDbeer =?";
    String[] selectionArgs;
    String groupBy = null;
    String having = null;
    String orderBy = null;
    String limit = null;

    /**
     * Private constructor to aboid object creation from outside classes.
     *
     * @param context
     */
    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    /**
     * Open the database connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    /**
     * Read all quotes from the database.
     *
     * @return a List of quotes
     */
    public List<String> getQuotes(String IDbeer) {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT name FROM beers WHERE IDbeer = faro", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    /* VARIABLES FOR QUERY:
    * @table String: The table name to compile the query against.
    * @columns String: A list of which columns to return. Passing null will return all columns, which is discouraged to prevent reading data from storage that isn't going to be used.
    * @selection String: A filter declaring which rows to return, formatted as an SQL WHERE clause (excluding the WHERE itself). Passing null will return all rows for the given table.
    * @selectionArgs String: You may include ?s in selection, which will be replaced by the values from selectionArgs, in order that they appear in the selection. The values will be bound as Strings.
    * @groupBy String: A filter declaring how to group rows, formatted as an SQL GROUP BY clause (excluding the GROUP BY itself). Passing null will cause the rows to not be grouped.
    * @having String: A filter declare which row groups to include in the cursor, if row grouping is being used, formatted as an SQL HAVING clause (excluding the HAVING itself). Passing null will cause all row groups to be included, and is required when row grouping is not being used.
    * @orderBy String: How to order the rows, formatted as an SQL ORDER BY clause (excluding the ORDER BY itself). Passing null will use the default sort order, which may be unordered.
    * @limit String: Limits the number of rows returned by the query, formatted as LIMIT clause. Passing null denotes no LIMIT clause.
    */
    public String getBeerName(String IDbeer){
        String beer = new String("Beer not found");
        String[] columns = {"name"};
        String[] selectionArgs = new String[]{IDbeer};
        Cursor cursor = database.query(table, columns, selection, selectionArgs, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            beer = cursor.getString(0);
            cursor.moveToNext();
        }
        cursor.close();
        return beer;
    }

    public String getBeerType(String IDbeer){
        String beer = new String("Beer not found");
        String[] columns = {"type"};
        String[] selectionArgs = new String[]{IDbeer};
        Cursor cursor = database.query(table, columns, selection, selectionArgs, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            beer = cursor.getString(0);
            cursor.moveToNext();
        }
        cursor.close();
        return beer;
    }

    public String getBeerColour(String IDbeer){
        String beer = new String("Beer not found");
        String[] columns = {"colour"};
        String[] selectionArgs = new String[]{IDbeer};
        Cursor cursor = database.query(table, columns, selection, selectionArgs, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            beer = cursor.getString(0);
            cursor.moveToNext();
        }
        cursor.close();
        return beer;
    }

    public String getBeerFlavour(String IDbeer){
        String beer = new String("Beer not found");
        String[] columns = {"flavour"};
        String[] selectionArgs = new String[]{IDbeer};
        Cursor cursor = database.query(table, columns, selection, selectionArgs, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            beer = cursor.getString(0);
            cursor.moveToNext();
        }
        cursor.close();
        return beer;
    }

    public String getBeerGrain(String IDbeer){
        String beer = new String("Beer not found");
        String[] columns = {"grain"};
        String[] selectionArgs = new String[]{IDbeer};
        Cursor cursor = database.query(table, columns, selection, selectionArgs, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            beer = cursor.getString(0);
            cursor.moveToNext();
        }
        cursor.close();
        return beer;
    }

    public String getBeerYeast(String IDbeer){
        String beer = new String("Beer not found");
        String[] columns = {"yeast"};
        String[] selectionArgs = new String[]{IDbeer};
        Cursor cursor = database.query(table, columns, selection, selectionArgs, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            beer = cursor.getString(0);
            cursor.moveToNext();
        }
        cursor.close();
        return beer;
    }

    public String getBeerHop(String IDbeer){
        String beer = new String("Beer not found");
        String[] columns = {"hop"};
        String[] selectionArgs = new String[]{IDbeer};
        Cursor cursor = database.query(table, columns, selection, selectionArgs, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            beer = cursor.getString(0);
            cursor.moveToNext();
        }
        cursor.close();
        return beer;
    }

    public String getBeerFermentation(String IDbeer){
        String beer = new String("Beer not found");
        String[] columns = {"fermentation"};
        String[] selectionArgs = new String[]{IDbeer};
        Cursor cursor = database.query(table, columns, selection, selectionArgs, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            beer = cursor.getString(0);
            cursor.moveToNext();
        }
        cursor.close();
        return beer;
    }

    public String getBeerExtras(String IDbeer){
        String beer = new String("Beer not found");
        String[] columns = {"extras"};
        String[] selectionArgs = new String[]{IDbeer};
        Cursor cursor = database.query(table, columns, selection, selectionArgs, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            beer = cursor.getString(0);
            cursor.moveToNext();
        }
        cursor.close();
        return beer;
    }

    public String getBeerSuggest(String IDbeer){
        String beer = new String("Beer not found");
        String[] columns = {"suggestion"};
        String[] selectionArgs = new String[]{IDbeer};
        Cursor cursor = database.query(table, columns, selection, selectionArgs, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            beer = cursor.getString(0);
            cursor.moveToNext();
        }
        cursor.close();
        return "zimbabwe";
    }
}