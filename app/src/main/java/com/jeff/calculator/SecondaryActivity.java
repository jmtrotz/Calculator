package com.jeff.calculator;

// Import packages
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.DecimalFormat;

/**
 * @author Jeffrey Trotz
 * Date: 2/3/18
 * Class: CS 305
 * @version 0.1
 */
public class SecondaryActivity extends AppCompatActivity
{
    // Declare fields used in this class
    private TextView mFormulaTextView;
    private Button mResultButton;
    private String calculation;
    private static final String KEY_INPUT = "input_formula_data";
    private static final String KEY_FORMULA = "formula_from_MainActivity";
    private static final String KEY_NUMBER1 = "number1_from_MainActivity";
    private static final String KEY_NUMBER2 = "number2_from_MainActivity";
    private static final String KEY_OPERATOR = "operator_from_MainActivity";
    private static final String KEY_ANSWER = "answer_from_SecondaryActivity";

    /**
     * This method is called when the activity is launched
     * @param savedInstanceState Saved instance of the application
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        String savedFormula;

        // If the app was closed or the screen rotated, reload saved data
        if (savedInstanceState != null)
        {
            savedFormula = savedInstanceState.getString(KEY_INPUT);
            mFormulaTextView.setText(savedFormula);
        }

        setContentView(R.layout.activity_secondary);

        calculation = getIntent().getStringExtra(KEY_FORMULA);
        mFormulaTextView = findViewById(R.id.formula);
        mFormulaTextView.append(" " + calculation);

        mResultButton = findViewById(R.id.result_button);
        mResultButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                onResultButtonClicked();
            }
        });
    }

    /**
     * Stores data when the application is closed or screen is rotate
     * @param outState Bundle of current data stored in the application
     */
    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_INPUT, mFormulaTextView.getText().toString());
    }

    /**
     * Method to launch a new intent
     * @param packageContext
     * @param input Input from the main activity
     * @return Returns a new Intent
     */
    public static Intent newIntent(Context packageContext, String input)
    {
        Intent intent = new Intent(packageContext, SecondaryActivity.class);
        intent.putExtra(KEY_FORMULA, input);
        return intent;
    }

    /**
     * Method to get the result of the calculation performed by this activity
     * @param data Intent
     * @return Returns the result of the calculation as a double
     */
    public static String getResult(Intent data)
    {
        return data.getStringExtra(KEY_ANSWER);
    }

    /**
     * This method calculates the result and closes the activity when
     * the user selects the "get result" button
     */
    private void onResultButtonClicked()
    {
        double tempAnswer = 0;
        double number1 = getIntent().getDoubleExtra(KEY_NUMBER1, 0);
        double number2 = getIntent().getDoubleExtra(KEY_NUMBER2, 0);
        String operator = getIntent().getStringExtra(KEY_OPERATOR);

        switch (operator)
        {
            case "+":
                tempAnswer = number1 + number2;
                break;

            case "-":
                tempAnswer = number1 - number2;
                break;

            case "x":
                tempAnswer = number1 * number2;
                break;

            case "/":
                tempAnswer = number1 / number2;
                break;

            case "%":
                tempAnswer = number1 % number2;
                break;

            case "^":
                tempAnswer = Math.pow(number1, number2);
                break;

            case "sin":
                tempAnswer = Math.sin(number1);
                break;

            case "cos":
                tempAnswer = Math.log(number1);
                break;

            case "tan":
                tempAnswer = Math.tan(number1);
                break;

            case "log":
                tempAnswer = Math.log(number1);
                break;

            case "root":
                tempAnswer = Math.sqrt(number1);
        }

        // Format the result so it will fit within the text view
        DecimalFormat decimalFormat = new DecimalFormat("#.###");
        String finalAnswer = decimalFormat.format(tempAnswer);

        Intent result = new Intent();
        result.putExtra(KEY_ANSWER, finalAnswer);
        setResult(Activity.RESULT_OK, result);
        finish();
    }
}