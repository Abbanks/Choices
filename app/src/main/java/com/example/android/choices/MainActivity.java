package com.example.android.choices;

import android.os.Bundle;
import android.view.View;
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

        TextView question6 = findViewById(id.question6);
        question6.setText(string.question6);

        TextView question7 = findViewById(id.question7);
        question7.setText(string.question7);

        TextView question8 = findViewById(id.question8);
        question8.setText(string.question8);

        TextView question9 = findViewById(id.question9);
        question9.setText(string.question9);


        TextView question10 = findViewById(id.question10);
        question10.setText(string.question10);

    }


    public int calculateScore(int question1Answer, String question3Answer, String question4Answer, int question2Answer, int question7Answer,
                              int question8Answer, int question10Answer, String question9Answer) {

        if (question1Answer == id.question1RadioButton2) {
            score = score + 1;
        }

        if (question3Answer.equals("Cheetah")) {
            score = score + 1;
        }

        if (question4Answer.equals("Blue")) {
            score = score + 1;
        }

        if (question2Answer == id.question5RadioButton1) {
            score = score + 1;
        }

        if (question7Answer == id.question7RadioButton2) {
            score = score + 1;
        }

        if (question8Answer == id.question8RadioButton2) {
            score = score + 1;
        }

        if (question9Answer.equals("Ostrich")) {
            score = score + 1;
        }

        if (question10Answer == id.question10RadioButton3) {
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

        CheckBox checkBox4 = findViewById(id.question6CheckBox1);
        boolean ansCheckBox4 = checkBox4.isChecked();
        CheckBox checkBox5 = findViewById(id.question6CheckBox2);
        boolean ansCheckBox5 = checkBox5.isChecked();

        if (ansCheckBox1 && ansCheckBox2 && ansCheckBox3) {
            score = score + 1;
        }

        if (ansCheckBox4 && ansCheckBox5) {
            score = score + 1;
        }
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

        RadioGroup radioGroup7 = findViewById(id.question7RadioGroup);
        int selectedButton7 = radioGroup7.getCheckedRadioButtonId();

        RadioGroup radioGroup8 = findViewById(id.question8RadioGroup);
        int selectedButton8 = radioGroup8.getCheckedRadioButtonId();

        EditText editText9 = findViewById(id.question9EditText);
        String question9Answer = editText9.getText().toString();

        RadioGroup radioGroup10 = findViewById(id.question10RadioGroup);
        int selectedButton10 = radioGroup10.getCheckedRadioButtonId();

        int finalScore = calculateScore(selectedButton1, question3Answer, question4Answer, selectedButton2, selectedButton7, selectedButton8,
                selectedButton10, question9Answer);

        Toast.makeText(this, "Your Score is " + finalScore + " of 10", Toast.LENGTH_SHORT).show();

        reset();

    }

    public void reset() {
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

        CheckBox checkBox4 = findViewById(id.question6CheckBox1);
        checkBox4.setChecked(false);
        CheckBox checkBox5 = findViewById(id.question6CheckBox2);
        checkBox5.setChecked(false);
        CheckBox checkBox6 = findViewById(id.question6CheckBox3);
        checkBox6.setChecked(false);

        RadioGroup radioGroup7 = findViewById(id.question7RadioGroup);
        radioGroup7.clearCheck();

        RadioGroup radioGroup8 = findViewById(id.question8RadioGroup);
        radioGroup8.clearCheck();

        EditText editText9 = findViewById(id.question9EditText);
        editText9.getText().clear();

        RadioGroup radioGroup10 = findViewById(id.question10RadioGroup);
        radioGroup10.clearCheck();

        score = 0;

    }
}