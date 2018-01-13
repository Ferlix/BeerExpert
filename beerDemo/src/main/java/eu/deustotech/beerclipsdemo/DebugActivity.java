package eu.deustotech.beerclipsdemo;

import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;


/**
 * DebugActivity: Activity to display the debug register, containing the questions and the answers made
 * during the query with the expert system.
 */

public class DebugActivity extends Activity {

    String debugQueryText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.debug_layout);

        debugQueryText = getIntent().getStringExtra("DEBUG");
        TextView debugView = (TextView) findViewById(R.id.debugView);
        debugView.setText(debugQueryText);

    }

}
