package com.example.cosc341_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class CreateFinal extends AppCompatActivity {

    Button backButton;
    Button doneButton;
    Button shareButton;
    Button saveButton;
    LinearLayout foodView;
    LinearLayout drinkView;
    LinearLayout gameView;
    LinearLayout decorationsView;
    TextView partyPlanText;
    TextView themeText;
    TextView budgetText;
    ArrayList<String> food;
    ArrayList<String> drinks;
    ArrayList<String> games;
    ArrayList<String> decoration;
    String theme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createfinal);

        final Intent goBack = new Intent(this,PartyPlanCreate2.class);
        Intent intent = getIntent();
        final Bundle bundle = intent.getExtras();
        String partyType = bundle.getString("partyType");
        final String numOfGuests = bundle.getString("numOf");
        final String budget = bundle.getString("budget");
        final String where = bundle.getString("where");
        final String when = bundle.getString("when");
        final String desc = bundle.getString("desc");
        theme = bundle.getString("theme");
        food =  bundle.getStringArrayList("food");
        drinks =  bundle.getStringArrayList("drinks");
        games =  bundle.getStringArrayList("games");
        decoration = bundle.getStringArrayList("decoration");

        backButton = (Button) (findViewById(R.id.backC2Button));
        doneButton = (Button) (findViewById(R.id.next2cButton));
        saveButton = (Button) (findViewById(R.id.savePlanCFButton));
        shareButton = (Button) (findViewById(R.id.shareButton));
        foodView = (findViewById(R.id.foodCScrollViewLL));
        drinkView = (findViewById(R.id.drinkcLL));
        gameView = (findViewById(R.id.gamesc2LL));
        decorationsView = (findViewById(R.id.decCLL));
        partyPlanText = (findViewById(R.id.partyPlanTempTextView));
        themeText = (findViewById(R.id.partyThemeTempTextView));
        budgetText = (findViewById(R.id.budgetTempTextView));

        if(budget.equals("")){
            budgetText.setText("");
        }else{
            budgetText.setText("Budget: $" + budget);
        }


        if(!when.equals("")){
            partyPlanText.setText("Party plan for your event on the " + when);
        }else{
            partyPlanText.setText("Party plan for your event");
        }

        if(!numOfGuests.equals("")){
            partyPlanText.setText(partyPlanText.getText().toString() + " for "+numOfGuests+" guests");
        }

        if(!where.equals("")){
            partyPlanText.setText(partyPlanText.getText().toString() + " at "+where);
        }

        if(theme.equals("")){
            themeText.setText("");
            theme = ("None");
        }else{
            themeText.setText("The theme is "+theme);
        }

        ArrayList<TextView> foodList = new ArrayList<>();

        for(int i = 0; i< food.size();i++){
            foodList.add(new TextView(this));
            foodList.get(i).setText(food.get(i));
            foodList.get(i).setGravity(Gravity.CENTER);
            foodView.addView(foodList.get(i));
        }

        ArrayList<TextView> drinkList = new ArrayList<>();

        for(int i = 0; i< drinks.size();i++){
            drinkList.add(new TextView(this));
            drinkList.get(i).setText(drinks.get(i));
            drinkList.get(i).setGravity(Gravity.CENTER);
            drinkView.addView(drinkList.get(i));
        }

        ArrayList<TextView> decorationList = new ArrayList<>();

        for(int i = 0; i< decoration.size();i++){
            decorationList.add(new TextView(this));
            decorationList.get(i).setText(decoration.get(i));
            decorationList.get(i).setGravity(Gravity.CENTER);
            decorationsView.addView(decorationList.get(i));
        }

        ArrayList<TextView> gamesList = new ArrayList<>();

        for(int i = 0; i< games.size();i++){
            gamesList.add(new TextView(this));
            gamesList.get(i).setText(games.get(i));
            gamesList.get(i).setGravity(Gravity.CENTER);
            gameView.addView(gamesList.get(i));
        }

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        shareButton .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,desc);
                sendIntent.setType("text/plain");
                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
            }

        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filename = "output.txt";
                String fileContents = numOfGuests+","+budget+","+where+","+when+","
                        +desc.trim().replaceAll("\\s","")+","+theme+"\n";
                String foodContents = Arrays.toString(food.toArray())+"\n";
                String drinkContents = Arrays.toString(drinks.toArray())+"\n";
                String gameContents = Arrays.toString(games.toArray())+"\n";
                String decorationContents = Arrays.toString(decoration.toArray())+"\n";
                FileOutputStream outputStream;
                try {
                    outputStream = openFileOutput(filename, Context.MODE_APPEND);
                    outputStream.write(fileContents.getBytes());
                    outputStream.write(foodContents.getBytes());
                    outputStream.write(drinkContents.getBytes());
                    outputStream.write(gameContents.getBytes());
                    outputStream.write(decorationContents.getBytes());
                    outputStream.close();
                    Context context = getApplicationContext();
                    Toast toast = Toast.makeText(context, "Plan Saved", Toast.LENGTH_SHORT);
                    toast.show();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                goBack.putExtras(bundle);
                startActivity(goBack);
            }
        });
    }
}
