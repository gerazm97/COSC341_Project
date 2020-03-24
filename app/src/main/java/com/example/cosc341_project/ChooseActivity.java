package com.example.cosc341_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseActivity extends AppCompatActivity {

    Button backButton;
    Button chooseTemplateButton;
    Button createButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_temp_or_own);

        final Intent partyPlan1 = new Intent(this,PartyPlan1Activity.class);
        final Intent partyPlanC1 = new Intent(this,PartyPlanCreate1.class);


        backButton = (Button) (findViewById(R.id.button_BackChoose));
        chooseTemplateButton = (Button) (findViewById(R.id.button_ChooseFromTemplate));
        createButton = (Button) (findViewById(R.id.button_createYour));


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        chooseTemplateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(partyPlan1);
            }
        });

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(partyPlanC1);
            }
        });
    }
}
