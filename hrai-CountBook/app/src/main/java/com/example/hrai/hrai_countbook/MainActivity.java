/* hrai-CountBook
 *
 * Version 0.1
 *
 * October 2, 2017
 *
 * Copyright (c) 2017 hrai, University of Alberta -
 * All Rights Reserved. You may use, distribute or modify this code under terms and conditions of the
 * Code of Student Behavior at University of Alberta.
 * You can find a copy of the license in this project. Otherwise please contact hrai@ualberta.ca
 */

package com.example.hrai.hrai_countbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class MainActivity extends AppCompatActivity {

    /*Initializing the variables to be used throughout the code*/
    private static final String FNAME = "file.sav";
    private int initialCount; //Holds initial value of counter
    private int counterCount; //Maintains count of the counter
    private String counterName; //Name of the counter (given by user)
    private String counterComment; //An optional comment about the counter (given by user)
    private String counterValue; //Initial value of counter (given by user)
    private TextView nameOfCounter; //Displays counter's name
    private TextView countOfCounter; //Displays counter's value
    private TextView commentOfCounter; //Displays counter's comment
    private EditText nameText; //Gets name from user
    private EditText valueText; //Gets value from user
    private EditText commentText; //Gets comment from user
    Button incrementButton;
    Button decrementButton;
    Button createButton;
    Button resetButton;
    Button deleteButton;

    /**
     * Switch case that handles all the actions of the clickable buttons.
     * Idea implemented from a tutorial video by Sylvain Saurel.
     * Link to video: https://www.youtube.com/watch?v=7d6iKupzkEg
     */
    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.createButton :
                    createButtonClicked();
                    break;
                case R.id.incrementButton :
                    incrementButtonClicked();
                    break;
                case R.id.decrementButton :
                    decrementButtonClicked();
                    break;
                case R.id.resetButton :
                    resetButtonClicked();
                    break;
                case R.id.deleteButton :
                    deleteButtonClicked();
                    break;
            }

        }
    };

    /**
     * Sets layout and links variables to views.
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        incrementButton = (Button) findViewById(R.id.incrementButton);
        incrementButton.setOnClickListener(clickListener);
        decrementButton = (Button) findViewById(R.id.decrementButton);
        decrementButton.setOnClickListener(clickListener);
        createButton = (Button) findViewById(R.id.createButton);
        createButton.setOnClickListener(clickListener);
        resetButton = (Button) findViewById(R.id.resetButton);
        resetButton.setOnClickListener(clickListener);
        deleteButton = (Button) findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(clickListener);
        nameOfCounter = (TextView) findViewById(R.id.nameOfCounter);
        countOfCounter = (TextView) findViewById(R.id.countOfCounter);
        commentOfCounter = (TextView) findViewById(R.id.commentOfCounter);
        nameText = (EditText) findViewById(R.id.nameText);
        valueText = (EditText) findViewById(R.id.valueText);
        commentText = (EditText) findViewById(R.id.commentText);

    }

    /**
     * Increments button increases the value of counterCount by 1.
     */
    private void incrementButtonClicked() {
        counterCount++;
        countOfCounter.setText(Integer.toString(counterCount));
    }

    /**
     * Decrements button decreases the value of counterCount by 1 until
     * it reaches a value of 0
     */
    private void decrementButtonClicked() {
        if (counterCount > 0) {
            counterCount--;
        }
        countOfCounter.setText(Integer.toString(counterCount));
    }

    /**
     * Resets the value of the count to the initial value that was set on creation.
     */
    private void resetButtonClicked() {
        counterCount = initialCount;
        countOfCounter.setText(Integer.toString(counterCount));
    }


    /**
     * Deletes (sets to blank) all of the values of the counter.
     */
    private void deleteButtonClicked() {
       /* nameOfCounter = "";
        counterCount = "";
        commentOfCounter = "";*/
        counterCount = 0;
        nameOfCounter.setText("");
        countOfCounter.setText("");
        commentOfCounter.setText("");
    }

    /**
     * Creates a counter with a Name, Initial Value, and an optional comment.
     */
    private void createButtonClicked() {
        setResult(RESULT_OK);
        counterName = nameText.getText().toString();
        counterValue = valueText.getText().toString();
        initialCount = Integer.valueOf(counterValue);
        counterCount = initialCount;
        counterComment = commentText.getText().toString();
        nameOfCounter.setText(counterName);
        countOfCounter.setText(Integer.toString(initialCount));
        commentOfCounter.setText(counterComment);
    }

    /*private void loadFromFile() {
        try {
            FileInputStream fis = openFileInput(FNAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<counterCount>>() {}.getType();
            counterCount = gson.fromJson(in, listType);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            counterCount = new ArrayList<counterCount>();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException(e);
        }
    }

    private void saveInFile() {
        try {
            FileOutputStream fos = openFileOutput(FNAME,
                    Context.MODE_PRIVATE);
            OutputStreamWriter writer = new OutputStreamWriter(fos);
            Gson gson = new Gson();
            gson.toJson(counterCount,writer);
            writer.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }
    }*/
}
