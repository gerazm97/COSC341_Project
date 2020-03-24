package com.example.cosc341_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PartyPlanCreate1 extends AppCompatActivity {

    Button backButton;
    Button nextButton;
    EditText theme;
    EditText numOf;
    EditText budget;
    EditText where;
    EditText when;
    EditText desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partyplan1create);

        final Intent back = new Intent(this,ChooseActivity.class);
        final Intent next = new Intent(this,PartyPlanCreate2.class);

        backButton = (Button) (findViewById(R.id.backPlan1cButton));
        nextButton = (Button) (findViewById(R.id.nextPlan1cButton));
        theme = (findViewById(R.id.themeCEditText));
        numOf = (findViewById(R.id.numOfcEditText));
        budget = (findViewById(R.id.budgetcEditText));
        where = (findViewById(R.id.wherecEditText));
        when = (findViewById(R.id.whencEditText));
        desc = (findViewById(R.id.desccEditText));


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(back);
                finish();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String themeB = theme.getText().toString();
                String numOfB = numOf.getText().toString();
                String budgetB = budget.getText().toString();
                String whereB = where.getText().toString();
                String whenB = when.getText().toString();
                String descB = desc.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("theme",themeB);
                bundle.putString("numOf",numOfB);
                bundle.putString("budget",budgetB);
                bundle.putString("where",whereB);
                bundle.putString("when",whenB);
                bundle.putString("desc",descB);
                next.putExtras(bundle);
                startActivity(next);
                finish();
            }
        });


    }
}
