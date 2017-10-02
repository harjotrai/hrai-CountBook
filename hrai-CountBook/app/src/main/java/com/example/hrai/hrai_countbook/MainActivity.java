package com.example.hrai.hrai_countbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.*;


public class MainActivity extends AppCompatActivity {
    /*Initializing the variables to be used throughout the code*/
    private static final String FNAME = "file.sav";
    private int initialCount;
    private int counterCount;
    private String counterName;
    private String counterComment;
    private String userText;
    private TextView nameOfCounter;
    private EditText countOfCounter;
    private TextView commentOfCounter;
    private EditText inputText;
    Button incrementButton;
    Button decrementButton;
    Button createButton;
    Button resetButton;
    Button deleteButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void displayCounter() {
        incrementButton = (Button) findViewById(R.id.incrementButton);
        decrementButton = (Button) findViewById(R.id.decrementButton);
        createButton = (Button) findViewById(R.id.createButton);
        resetButton = (Button) findViewById(R.id.resetButton);
        deleteButton = (Button) findViewById(R.id.deleteButton);
        nameOfCounter = (TextView) findViewById(R.id.nameOfCounter);
        countOfCounter = (EditText) findViewById(R.id.countOfCounter);
        commentOfCounter = (TextView) findViewById(R.id.commentOfCounter);




        createButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                setResult(RESULT_OK);
                userText = inputText.getText().toString();
                //userTextList.add(Arrays.asList(userText.split((","),3)))
                List<String> userTextList = new ArrayList<String>(Arrays.asList(userText.split(",",3)));
                if (userTextList.size() == 1) {
                    counterName = userTextList.get(0);
                    initialCount = 0;
                    counterComment = "";
                }else if (userTextList.size() == 2) {
                    counterName = userTextList.get(0);
                    initialCount = Integer.parseInt(userTextList.get(1));
                    counterComment = "";
                }else if (userTextList.size() == 3) {
                    counterName = userTextList.get(0);
                    initialCount = Integer.parseInt(userTextList.get(1));
                    counterComment = userTextList.get(3);
                }
                counterCount = initialCount;
                nameOfCounter.setText(counterName);
                countOfCounter.setText(counterCount);
                commentOfCounter.setText(counterComment);



                //saveInFile(counterName, counterCount, counterComment, new Date(System.currentTimeMillis()));


            }}
        );
    }

    private void incrementButtonClicked(View view) {
        counterCount++;
        countOfCounter.setText(counterCount);
    }

    private void decrementButtonClicked(View view) {
        counterCount--;
        countOfCounter.setText(counterCount);
    }


    public void resetButtonClicked(View view) {
        counterCount = initialCount;
        countOfCounter.setText(counterCount);
    }

    public void deleteButtonClicked(View view) {
       /* nameOfCounter = "";
        counterCount = "";
        commentOfCounter = "";*/
        nameOfCounter.setText("");
        countOfCounter.setText("");
        commentOfCounter.setText("");
    }
}
