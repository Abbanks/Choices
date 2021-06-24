package com.example.android.choices;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.android.choices.R.id;
import static com.example.android.choices.R.layout;
import static com.example.android.choices.R.string;

public class MainActivity extends AppCompatActivity {

    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        TextView question1 = findViewById(id.question1);
        question1.setText(string.question1);

        TextView question2 = findViewById(id.question2);
        question2.setText(string.question2);

        TextView question3 = findViewById(id.question3);
        question3.setText(string.question3);

        TextView question4 = findViewById(id.question4);
        question4.setText(string.question4);

        TextView question5 = findViewById(id.question5);
        question5.setText(string.question5);
    }

    public void submit(View view) {
        RadioGroup radioGroup1 = findViewById(id.question1RadioGroup);
        int selectedButton1 = radioGroup1.getCheckedRadioButtonId();

        EditText editText1 = findViewById(id.question3EditText);
        String question3Answer = editText1.getText().toString();

        EditText editText2 = findViewById(id.question4EditText);
        String question4Answer = editText2.getText().toString();

        RadioGroup radioGroup2 = findViewById(id.question5RadioGroup);
        int selectedButton2 = radioGroup2.getCheckedRadioButtonId();

        int finalScore = calculateScore(selectedButton1, question3Answer, question4Answer, selectedButton2);

        Toast.makeText(this, "Your Score is " + finalScore + " of 5", Toast.LENGTH_SHORT).show();

        Button submitButton = findViewById(id.submitButton);
        submitButton.setEnabled(false);
    }

    public void reset(View view) {
        RadioGroup radioGroup1 = findViewById(id.question1RadioGroup);
        radioGroup1.clearCheck();

        EditText editText1 = findViewById(id.question3EditText);
        editText1.getText().clear();

        EditText editText2 = findViewById(id.question4EditText);
        editText2.getText().clear();

        CheckBox checkBox1 = findViewById(id.question2CheckBox1);
        checkBox1.setChecked(false);
        CheckBox checkBox2 = findViewById(id.question2CheckBox2);
        checkBox2.setChecked(false);
        CheckBox checkBox3 = findViewById(id.question2CheckBox3);
        checkBox3.setChecked(false);

        RadioGroup radioGroup2 = findViewById(id.question5RadioGroup);
        radioGroup2.clearCheck();

        score = 0;
        Button submitButton = findViewById(id.submitButton);
        submitButton.setEnabled(true);
    }

    public int calculateScore(int selectedButton1, String question3Answer, String question4Answer, int selectedButton2) {
        if (selectedButton1 == id.question1RadioButton2) {
            score = score + 1;
        }

        if (question3Answer.equals("Cheetah")) {
            score = score + 1;
        }

        if (question4Answer.equals("Blue")) {
            score = score + 1;
        }

        if (selectedButton2 == id.question5RadioButton1) {
            score = score + 1;
        }

        return score;
    }

    public void checkBoxClicked(View view) {

        CheckBox checkBox1 = findViewById(id.question2CheckBox1);
        boolean ansCheckBox1 = checkBox1.isChecked();
        CheckBox checkBox2 = findViewById(id.question2CheckBox2);
        boolean ansCheckBox2 = checkBox2.isChecked();
        CheckBox checkBox3 = findViewById(id.question2CheckBox3);
        boolean ansCheckBox3 = checkBox3.isChecked();

        if (ansCheckBox1 && ansCheckBox2 && ansCheckBox3) {
            score = score + 1;
        }
    }


}