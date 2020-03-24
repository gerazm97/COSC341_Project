package com.example.cosc341_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class PartyPlan2Activity extends AppCompatActivity {

    TextView suggestedTheme;
    Spinner chooseTheme;
    Button backButton;
    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_party_plan2);

        final Intent goBack = new Intent(this,PartyPlan1Activity.class);
        final Intent partyTemplate = new Intent(this,PartyPlanTemplateActivity.class);


        Intent intent = getIntent();
        final Bundle bundle = intent.getExtras();
        backButton = (Button) (findViewById(R.id.backThemebutton));
        nextButton = (Button) (findViewById(R.id.nextThemeButton));
        chooseTheme = (findViewById(R.id.chooseThemeSpinner));
        suggestedTheme = (findViewById(R.id.suggestedThemeTextView));

        if(Math.random() < 0.5) {
            suggestedTheme.setText("Hawaiian");
        }else{
            suggestedTheme.setText("Retro");
        }

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(goBack);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String theme = chooseTheme.getSelectedItem().toString();
                bundle.putString("theme",theme);
                partyTemplate.putExtras(bundle);
                startActivity(partyTemplate);
                finish();
            }
        });






    }
}
