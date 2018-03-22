package com.jeff.calculator;

// Import packages
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author Jeffrey Trotz
 * Date: 1/31/18
 * Class: CS 305
 * @version 0.1
 */
public class MainActivity extends AppCompatActivity
{
    // Declare fields used in this class
    private TextView mInputTextView;
    private TextView mResultTextView;
    private Button mZeroButton;
    private Button mOneButton;
    private Button mTwoButton;
    private Button mThreeButton;
    private Button mFourButton;
    private Button mFiveButton;
    private Button mSixButton;
    private Button mSevenButton;
    private Button mEightButton;
    private Button mNineButton;
    private Button mAddButton;
    private Button mSubtractButton;
    private Button mMultiplyButton;
    private Button mDivideButton;
    private Button mModulusButton;
    private Button mExponentButton;
    private Button mDecimalButton;
    private Button mSineButton;
    private Button mCosineButton;
    private Button mTangentButton;
    private Button mLogarithmButton;
    private Button mRootButton;
    private Button mEqualsButton;
    private Button mClearButton;
    private double temp;
    private String operator;
    private static final String TAG = "MainActivity";
    private static final String KEY_INPUT = "input_view_data";
    private static final String KEY_RESULT = "result_view_data";
    private static final String KEY_NUMBER1 = "number1_from_MainActivity";
    private static final String KEY_NUMBER2 = "number2_from_MainActivity";
    private static final String KEY_OPERATOR = "operator_from_MainActivity";

    /**
     * This method is called when the activity is launched
     * @param savedInstanceState Saved instance of the application
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        String savedInput;
        String savedResult;

        // If the app was closed or the screen rotated, reload saved data
        if (savedInstanceState != null)
        {
            savedInput = savedInstanceState.getString(KEY_INPUT);
            savedResult = savedInstanceState.getString(KEY_RESULT);
            mInputTextView.setText(savedInput);
            mResultTextView.setText(savedResult);
        }

        setContentView(R.layout.activity_main);
        fishOutIDs();
        setButtonListeners();
    }

    /**
     * Stores data when the application is closed or screen is rotated
     * @param outState Bundle of current data stored in the application
     */
    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_INPUT, mInputTextView.getText().toString());
        outState.putString(KEY_RESULT, mResultTextView.getText().toString());
    }

    /**
     * This method is called when the second activity returns data
     * @param requestCode Request code from the other activity
     * @param resultCode Result code from the other activity
     * @param result Final result from the other activity
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent result)
    {
        super.onActivityResult(requestCode, resultCode, result);

        if (resultCode == Activity.RESULT_CANCELED)
        {
            Log.d(TAG, "Second screen cancelled");
        }

        else if (resultCode == Activity.RESULT_OK)
        {
            mResultTextView.setText(SecondaryActivity.getResult(result));
        }
    }

    /**
     * This method "fishes out" the ID's for the text fields and buttons used in this application
     */
    private void fishOutIDs()
    {
        mInputTextView = findViewById(R.id.input_text_view);
        mResultTextView = findViewById(R.id.result_text_view);
        mZeroButton = findViewById(R.id.zero_button);
        mOneButton = findViewById(R.id.one_button);
        mTwoButton = findViewById(R.id.two_button);
        mThreeButton = findViewById(R.id.three_button);
        mFourButton = findViewById(R.id.four_button);
        mFiveButton = findViewById(R.id.five_button);
        mSixButton = findViewById(R.id.six_button);
        mSevenButton = findViewById(R.id.seven_button);
        mEightButton = findViewById(R.id.eight_button);
        mNineButton = findViewById(R.id.nine_button);
        mAddButton = findViewById(R.id.add_button);
        mSubtractButton = findViewById(R.id.subtract_button);
        mMultiplyButton = findViewById(R.id.multiply_button);
        mDivideButton = findViewById(R.id.divide_button);
        mModulusButton = findViewById(R.id.modulus_button);
        mExponentButton = findViewById(R.id.exponent_button);
        mDecimalButton = findViewById(R.id.decimal_button);
        mSineButton = findViewById(R.id.sine_button);
        mCosineButton = findViewById(R.id.cosine_button);
        mTangentButton = findViewById(R.id.tangent_button);
        mLogarithmButton = findViewById(R.id.logarithm_button);
        mRootButton = findViewById(R.id.root_button);
        mEqualsButton = findViewById(R.id.equals_button);
        mClearButton = findViewById(R.id.clear_button);
    }

    /**
     * This method sets the button listeners for the buttons used in this application
     */
    private void setButtonListeners()
    {
        mZeroButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onNumberButtonClicked(mZeroButton.getText().toString());
            }
        });

        mOneButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onNumberButtonClicked(mOneButton.getText().toString());
            }
        });

        mTwoButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onNumberButtonClicked(mTwoButton.getText().toString());
            }
        });

        mThreeButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onNumberButtonClicked(mThreeButton.getText().toString());
            }
        });

        mFourButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onNumberButtonClicked(mFourButton.getText().toString());
            }
        });

        mFiveButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onNumberButtonClicked(mFiveButton.getText().toString());
            }
        });

        mSixButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onNumberButtonClicked(mSixButton.getText().toString());
            }
        });

        mSevenButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onNumberButtonClicked(mSevenButton.getText().toString());
            }
        });

        mEightButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onNumberButtonClicked(mEightButton.getText().toString());
            }
        });

        mNineButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onNumberButtonClicked(mNineButton.getText().toString());
            }
        });

        mAddButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onOperatorButtonClicked(mAddButton.getText().toString());

            }
        });

        mSubtractButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onOperatorButtonClicked(mSubtractButton.getText().toString());
            }
        });

        mMultiplyButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onOperatorButtonClicked(mMultiplyButton.getText().toString());
            }
        });

        mDivideButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onOperatorButtonClicked(mDivideButton.getText().toString());
            }
        });

        mModulusButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onOperatorButtonClicked(mModulusButton.getText().toString());
            }
        });

        mExponentButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onOperatorButtonClicked(mExponentButton.getText().toString());
            }
        });

        mDecimalButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onNumberButtonClicked(mDecimalButton.getText().toString());
            }
        });

        mSineButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onOperatorButtonClicked(mSineButton.getText().toString());
            }
        });

        mCosineButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onOperatorButtonClicked(mCosineButton.getText().toString());
            }
        });

        mTangentButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onOperatorButtonClicked(mTangentButton.getText().toString());
            }
        });

        mLogarithmButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onOperatorButtonClicked(mLogarithmButton.getText().toString());
            }
        });

        mRootButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperatorButtonClicked(mRootButton.getText().toString());
            }
        });
        mEqualsButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onEqualsButtonClicked();
            }
        });

        mClearButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mResultTextView.setText("");
                mInputTextView.setText("");
            }
        });
    }

    /**
     * This method is called when a number button is clicked to display the number in the input
     * and result text views
     * @param number Number chosen by the user to be added to input and result text views
     */
    private void onNumberButtonClicked(String number)
    {
        mInputTextView.append(number);
        mResultTextView.append(number);
    }

    /**
     * This method is called when an operand button is clicked to display it in the input text
     * view, set the operator, and clear the result text view
     * @param operator Operator chosen by the user to be used in the calculation
     */
    private void onOperatorButtonClicked(String operator)
    {
        this.operator = operator;
        mInputTextView.append(operator);
        temp = Double.parseDouble(mResultTextView.getText().toString());
        mResultTextView.setText("");
    }

    /**
     * This method is called when the equals button is clicked to start the second activity
     */
    private void onEqualsButtonClicked()
    {
        String formula = mInputTextView.getText().toString();
        double number1 = temp;
        double number2;

        if (operator.equalsIgnoreCase("sin") ||
                operator.equalsIgnoreCase("cos") ||
                operator.equalsIgnoreCase("tan") ||
                operator.equalsIgnoreCase("log") ||
                operator.equalsIgnoreCase("root"))
        {
            number2 = 0;
        }

        else
        {
            number2 = Double.valueOf(mResultTextView.getText().toString());
        }

        Intent intent = SecondaryActivity.newIntent(MainActivity.this, formula);
        intent.putExtra(KEY_NUMBER1, number1);
        intent.putExtra(KEY_NUMBER2, number2);
        intent.putExtra(KEY_OPERATOR, operator);
        startActivityForResult(intent, 0);
    }
}