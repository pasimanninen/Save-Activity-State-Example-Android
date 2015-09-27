package fi.ptm.saveactivitystateexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

/**
 * Created by PTM on 27/09/15.
 */
public class MainActivity extends Activity {
    private final String EDITTEXT_STATEKEY = "MY_EDITTEXT_KEY";
    private final String SWITCH_STATEKEY = "MY_SWITCH_KEY";
    private Switch mySwitch;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // draw layout
        setContentView(R.layout.activity_main);
        // find switch on UI
        mySwitch = (Switch) findViewById(R.id.switch1);
        // find EditText on UI
        editText = (EditText) findViewById(R.id.editText);
        // read data back from saved instance state
        if (savedInstanceState != null) {
            // read text view state
            if (savedInstanceState.containsKey(EDITTEXT_STATEKEY)) {
                String text = savedInstanceState.getString(EDITTEXT_STATEKEY);
                editText.setText(text);
            }
            // read switch state
            if (savedInstanceState.containsKey(SWITCH_STATEKEY)) {
                boolean save = savedInstanceState.getBoolean(SWITCH_STATEKEY);
                mySwitch.setChecked(save);
            }
        }

    }

    @Override
    public void onSaveInstanceState(Bundle saveInstanceState) {
        // save data if mySwitch is checked
        if (mySwitch.isChecked()) {
            // save edit text view state
            saveInstanceState.putString(EDITTEXT_STATEKEY, editText.getText().toString());
            // save switch state
            saveInstanceState.putBoolean(SWITCH_STATEKEY, mySwitch.isChecked());
        }
    }

}
