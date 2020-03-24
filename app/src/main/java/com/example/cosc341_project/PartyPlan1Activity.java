package com.example.cosc341_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class PartyPlan1Activity extends AppCompatActivity {

    Spinner partyTypeSpinner;
    EditText numOf;
    EditText price;
    EditText whenText;
    EditText whereText;
    EditText descText;
    Button backButton;
    Button nextButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_party_plan1);

        final Intent goBack = new Intent(this,ChooseActivity.class);
        final Intent partyPlan2 = new Intent(this,PartyPlan2Activity.class);

        backButton = (Button) (findViewById(R.id.backPlan1cButton));
        nextButton = (Button) (findViewById(R.id.nextPlan1cButton));
        partyTypeSpinner = (findViewById(R.id.partyTypeSpinner));
        numOf = (findViewById(R.id.numOfcEditText));
        price = (findViewById(R.id.budgetcEditText));
        whenText = findViewById(R.id.whencEditText);
        whereText = findViewById(R.id.wherecEditText);
        descText = findViewById(R.id.desccEditText);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(goBack);
                finish();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String partyType = partyTypeSpinner.getSelectedItem().toString();
                String numOfGuests = numOf.getText().toString();
                String budget = price.getText().toString();
                String where = whereText.getText().toString();
                String when = whenText.getText().toString();
                String desc = descText.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("partyType",partyType);
                bundle.putString("numOfGuests",numOfGuests);
                bundle.putString("budget",budget);
                bundle.putString("where",where);
                bundle.putString("when",when);
                bundle.putString("desc",desc);
                partyPlan2.putExtras(bundle);
                startActivity(partyPlan2);
                finish();
            }
        });


    }
}
