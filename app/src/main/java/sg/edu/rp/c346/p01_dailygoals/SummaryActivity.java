package sg.edu.rp.c346.p01_dailygoals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        // Get the intent so as to get the "things" inside the intent
        Intent i = getIntent();
        // Get the String array named "info" we passed in
        String[] summary = i.getStringArrayExtra("summary");
        // Get the TextView object
        TextView tvread = findViewById(R.id.textViewReadup);
        TextView tvarrive = findViewById(R.id.textViewArrive);
        TextView tvproblem = findViewById(R.id.textViewAttempt);
        TextView tvreflect = findViewById(R.id.textViewReflect);
        // Display the name and age on the TextView
        tvread.setText(summary[0] + " : " + summary[1]);
        tvarrive.setText(summary[2] + " : " + summary[3]);
        tvproblem.setText(summary[4] + " : " + summary[5]);
        tvreflect.setText("Reflection : " + summary[6]);

        Button btnClose = findViewById(R.id.buttonClose);

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
