package sg.edu.rp.c346.p01_dailygoals;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.reflect.Array.getInt;

public class MainActivity extends AppCompatActivity {

    int selectedButtonId,selectedButtonId2, selectedButtonId3;
    String reflect;
    RadioGroup rg, rg2, rg3;
    RadioButton rb, rb2, rb3;
    EditText etReflection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnDone = findViewById(R.id.buttonOk);

        rg = findViewById(R.id.radioGroup1);
        rg2 = findViewById(R.id.radioGroup2);
        rg3 = findViewById(R.id.radioGroup3);

        selectedButtonId = rg.getCheckedRadioButtonId();
        selectedButtonId2 = rg2.getCheckedRadioButtonId();
        selectedButtonId3 = rg3.getCheckedRadioButtonId();

        rg.check(selectedButtonId);
        rg2.check(selectedButtonId2);
        rg3.check(selectedButtonId3);
        etReflection = findViewById(R.id.editTextReflection);

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get textView
                TextView tvReadup = findViewById(R.id.textViewReadUp);
                TextView tvArrival = findViewById(R.id.textViewArrival);
                TextView tvProblem = findViewById(R.id.textViewProblem);

                //Get the RadioGroup object

                //Get the ID of the selected radio button in the RadioGroup
                selectedButtonId = rg.getCheckedRadioButtonId();
                //Get the radio button object from the Id we had gotten above
                rb = findViewById(selectedButtonId);

                //Get the RadioGroup object

                //Get the ID of the selected radio button in the RadioGroup
                selectedButtonId2 = rg2.getCheckedRadioButtonId();
                //Get the radio button object from the Id we had gotten above
                rb2 = findViewById(selectedButtonId2);

                //Get the ID of the selected radio button in the RadioGroup
                selectedButtonId3 = rg3.getCheckedRadioButtonId();
                //Get the radio button object from the Id we had gotten above
                rb3 = findViewById(selectedButtonId3);

                reflect = etReflection.getText().toString();

                String[] summary = {tvReadup.getText().toString(),rb.getText().toString(),tvArrival.getText().toString(), rb2.getText().toString(), tvProblem.getText().toString() ,rb3.getText().toString() ,reflect};



                // Create an intent to start another activity called DemoActivities (which we would create later)
                Intent i = new Intent(MainActivity.this, SummaryActivity.class);
                // Pass the String array holding the name & age to new activity
                i.putExtra("summary", summary);
                // Start the new activity
                startActivity(i);

            }


        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefEdit = prefs.edit();

        prefEdit.putInt("rg",selectedButtonId);
        prefEdit.putInt("rg2", selectedButtonId2);
        prefEdit.putInt("rg3", selectedButtonId3);
        prefEdit.putString("reflect", reflect);
        prefEdit.commit();

    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        int rgRetrieve = prefs.getInt("rg", 0);
        int rg2Retrieve = prefs.getInt("rg2",0);
        int rg3Retrieve = prefs.getInt("rg3",0);
        String reflectRetrieve = prefs.getString("reflect", "");

        rg.check(rgRetrieve);
        rg2.check(rg2Retrieve);
        rg3.check(rg3Retrieve);
        etReflection.setText(reflectRetrieve);

    }


//    String radioGrp1, radioGrp2, radioGrp3;
//    private void saveRadioChoice(){
//        SharedPreferences mSharedPref = getSharedPreferences("MY_PREF_KEY",MODE_PRIVATE);
//
//        SharedPreferences.Editor editor = mSharedPref.edit();
//
//        // Initialize Radiogroup while saving choices
//        RadioGroup localRadioGroup = (RadioGroup) findViewById(R.id.radioGroup1);
//        RadioGroup localRadioGroup2 = (RadioGroup) findViewById(R.id.radioGroup2);
//        RadioGroup localRadioGroup3 = (RadioGroup) findViewById(R.id.radioGroup3);
//        editor.putInt(radioGrp1, localRadioGroup.indexOfChild(findViewById(localRadioGroup.getCheckedRadioButtonId())));
//        editor.putInt(radioGrp2, localRadioGroup2.indexOfChild(findViewById(localRadioGroup2.getCheckedRadioButtonId())));
//        editor.putInt(radioGrp3, localRadioGroup3.indexOfChild(findViewById(localRadioGroup3.getCheckedRadioButtonId())));
//        editor.apply();
//    }

//    private void retrieveChoices(){
//
//        SharedPreferences sharedPref = getSharedPreferences("MY_PREF_KEY",MODE_PRIVATE);
//        int i = sharedPref.getInt(radioGrp1,-1);
//        if( i >= 0){
//            ((RadioButton) ((RadioGroup)findViewById(R.id.radioGroup1)).getChildAt(i)).setChecked(true);
//        }
//        int x = sharedPref.getInt(radioGrp2,-1);
//        if( x >= 0){
//            ((RadioButton) ((RadioGroup)findViewById(R.id.radioGroup2)).getChildAt(i)).setChecked(true);
//        }
//        int y = sharedPref.getInt(radioGrp2,-1);
//        if( y >= 0){
//            ((RadioButton) ((RadioGroup)findViewById(R.id.radioGroup2)).getChildAt(i)).setChecked(true);
//        }
//
//    }
}
