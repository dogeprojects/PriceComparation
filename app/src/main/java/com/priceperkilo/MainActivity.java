package com.priceperkilo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//TODO implementation clear button
//TODO localisation

public class MainActivity extends AppCompatActivity {

    private EditText mEditTextPrice1;
    private TextView mEditTextWeight1;
    private TextView textViewPricePerKg1;
    private TextView textViewVersion;

    EditText mEditTextPrice2;
    TextView mEditTextWeight2;
    TextView textViewPricePerKg2;

    EditText mEditTextPrice3;
    TextView mEditTextWeight3;
    TextView textViewPricePerKg3;

    EditText mEditTextPrice4;
    TextView mEditTextWeight4;
    TextView textViewPricePerKg4;

    EditText mEditTextPrice5;
    TextView mEditTextWeight5;
    TextView textViewPricePerKg5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Restore saved application state
        SharedPreferences mPrefs = getSharedPreferences("THEME", 0);
        boolean theme_boolean = mPrefs.getBoolean("theme_boolean", true);

        if (theme_boolean) {
            // Set theme to white
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        } else {
            // Set theme to black
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mEditTextPrice1 = findViewById(R.id.editTextPrice1);
        mEditTextWeight1 = findViewById(R.id.editTextWeight1);
        mEditTextPrice2 = findViewById(R.id.editTextPrice2);
        mEditTextWeight2 = findViewById(R.id.editTextWeight2);
        mEditTextPrice3 = findViewById(R.id.editTextPrice3);
        mEditTextWeight3 = findViewById(R.id.editTextWeight3);
        mEditTextPrice4 = findViewById(R.id.editTextPrice4);
        mEditTextWeight4 = findViewById(R.id.editTextWeight4);
        mEditTextPrice5 = findViewById(R.id.editTextPrice5);
        mEditTextWeight5 = findViewById(R.id.editTextWeight5);

        mEditTextPrice1.addTextChangedListener(new TextChangeWatcher());
        mEditTextWeight1.addTextChangedListener(new TextChangeWatcher());

        mEditTextPrice2.addTextChangedListener(new TextChangeWatcher());
        mEditTextWeight2.addTextChangedListener(new TextChangeWatcher());

        mEditTextPrice3.addTextChangedListener(new TextChangeWatcher());
        mEditTextWeight3.addTextChangedListener(new TextChangeWatcher());

        mEditTextPrice4.addTextChangedListener(new TextChangeWatcher());
        mEditTextWeight4.addTextChangedListener(new TextChangeWatcher());

        mEditTextPrice5.addTextChangedListener(new TextChangeWatcher());
        mEditTextWeight5.addTextChangedListener(new TextChangeWatcher());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    // Hide textEdit button handle
    public void onButtonHideClick(MenuItem item) {
        EditText editTextProduct1 = findViewById(R.id.editTextProduct1);
        EditText editTextProduct2 = findViewById(R.id.editTextProduct2);
        EditText editTextProduct3 = findViewById(R.id.editTextProduct3);
        EditText editTextProduct4 = findViewById(R.id.editTextProduct4);
        EditText editTextProduct5 = findViewById(R.id.editTextProduct5);

        //Toggle
        if (editTextProduct1.getVisibility() == View.VISIBLE) {
            editTextProduct1.setVisibility(View.INVISIBLE);
            editTextProduct2.setVisibility(View.INVISIBLE);
            editTextProduct3.setVisibility(View.INVISIBLE);
            editTextProduct4.setVisibility(View.INVISIBLE);
            editTextProduct5.setVisibility(View.INVISIBLE);
            Toast.makeText(this, "Fields have been hidden", Toast.LENGTH_SHORT).show();
        } else {
            editTextProduct1.setVisibility(View.VISIBLE);
            editTextProduct2.setVisibility(View.VISIBLE);
            editTextProduct3.setVisibility(View.VISIBLE);
            editTextProduct4.setVisibility(View.VISIBLE);
            editTextProduct5.setVisibility(View.VISIBLE);
            Toast.makeText(this, "Fields have been shown", Toast.LENGTH_SHORT).show();
        }


    }

    // Change theme button handle
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.change_theme) {
            // Save application state
            SharedPreferences mPrefs = getSharedPreferences("THEME", 0);
            boolean theme_boolean = mPrefs.getBoolean("theme_boolean", true);
            // Set theme to black
            // Set theme to white
            theme_boolean = !theme_boolean;

            SharedPreferences.Editor mEditor = mPrefs.edit();
            mEditor.putBoolean("theme_boolean", theme_boolean).apply();
            finish();
            startActivity(new Intent(MainActivity.this, MainActivity.this.getClass()));

            Toast toast = Toast.makeText(getApplicationContext(),
                    "Theme successfully changed",
                    Toast.LENGTH_SHORT);
            toast.show();
        }
        //return true;

        if (item.getItemId() == R.id.clear_button) {
            final TextView editTextProduct1 = findViewById(R.id.editTextProduct1);
            final EditText editTextPrice1 = findViewById(R.id.editTextPrice1);
            final TextView editTextWeight1 = findViewById(R.id.editTextWeight1);
            final TextView textViewPricePerKg1 = findViewById(R.id.textViewPricePerKg1);

            final TextView editTextProduct2 = findViewById(R.id.editTextProduct2);
            final EditText editTextPrice2 = findViewById(R.id.editTextPrice2);
            final EditText editTextWeight2 = findViewById(R.id.editTextWeight2);
            final TextView textViewPricePerKg2 = findViewById(R.id.textViewPricePerKg2);

            final TextView editTextProduct3 = findViewById(R.id.editTextProduct3);
            final EditText editTextPrice3 = findViewById(R.id.editTextPrice3);
            final EditText editTextWeight3 = findViewById(R.id.editTextWeight3);
            final TextView textViewPricePerKg3 = findViewById(R.id.textViewPricePerKg3);

            final TextView editTextProduct4 = findViewById(R.id.editTextProduct4);
            final EditText editTextPrice4 = findViewById(R.id.editTextPrice4);
            final EditText editTextWeight4 = findViewById(R.id.editTextWeight4);
            final TextView textViewPricePerKg4 = findViewById(R.id.textViewPricePerKg4);

            final TextView editTextProduct5 = findViewById(R.id.editTextProduct5);
            final EditText editTextPrice5 = findViewById(R.id.editTextPrice5);
            final EditText editTextWeight5 = findViewById(R.id.editTextWeight5);
            final TextView textViewPricePerKg5 = findViewById(R.id.textViewPricePerKg5);

            editTextProduct1.setText("");
            editTextPrice1.setText("");
            editTextWeight1.setText("");
            textViewPricePerKg1.setText("");

            editTextProduct2.setText("");
            editTextPrice2.setText("");
            editTextWeight2.setText("");
            textViewPricePerKg2.setText("");

            editTextProduct3.setText("");
            editTextPrice3.setText("");
            editTextWeight3.setText("");
            textViewPricePerKg3.setText("");

            editTextProduct4.setText("");
            editTextPrice4.setText("");
            editTextWeight4.setText("");
            textViewPricePerKg4.setText("");

            editTextProduct5.setText("");
            editTextPrice5.setText("");
            editTextWeight5.setText("");
            textViewPricePerKg5.setText("");

            textViewPricePerKg1.setBackgroundColor(Color.TRANSPARENT);
            textViewPricePerKg2.setBackgroundColor(Color.TRANSPARENT);
            textViewPricePerKg3.setBackgroundColor(Color.TRANSPARENT);
            textViewPricePerKg4.setBackgroundColor(Color.TRANSPARENT);
            textViewPricePerKg5.setBackgroundColor(Color.TRANSPARENT);

            Toast toast = Toast.makeText(getApplicationContext(),
                    "Fields cleared successfully",
                    Toast.LENGTH_SHORT);
            toast.show();
        }
        return true;
    }

    // ======================= Implementation of TextWatcher =======================
    class TextChangeWatcher implements TextWatcher {
        final EditText editTextPrice1 = findViewById(R.id.editTextPrice1);
        final TextView editTextWeight1 = findViewById(R.id.editTextWeight1);
        final TextView textViewPricePerKg1 = findViewById(R.id.textViewPricePerKg1);

        final EditText editTextPrice2 = findViewById(R.id.editTextPrice2);
        final TextView editTextWeight2 = findViewById(R.id.editTextWeight2);
        final TextView textViewPricePerKg2 = findViewById(R.id.textViewPricePerKg2);

        final EditText editTextPrice3 = findViewById(R.id.editTextPrice3);
        final TextView editTextWeight3 = findViewById(R.id.editTextWeight3);
        final TextView textViewPricePerKg3 = findViewById(R.id.textViewPricePerKg3);

        final EditText editTextPrice4 = findViewById(R.id.editTextPrice4);
        final TextView editTextWeight4 = findViewById(R.id.editTextWeight4);
        final TextView textViewPricePerKg4 = findViewById(R.id.textViewPricePerKg4);

        final EditText editTextPrice5 = findViewById(R.id.editTextPrice5);
        final TextView editTextWeight5 = findViewById(R.id.editTextWeight5);
        final TextView textViewPricePerKg5 = findViewById(R.id.textViewPricePerKg5);

        final TextView textViewVersion = findViewById(R.id.textViewVersion);

        TextChangeWatcher() {
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @SuppressLint({"DefaultLocale", "SetTextI18n"})
        @Override
        public void afterTextChanged(Editable editable) {
            // ------------------- The first product --------------------
            if ((editable == editTextPrice1.getEditableText())
                    || (editable == editTextWeight1.getEditableText())) {
                if ((editTextPrice1.getText().toString().equals("."))
                        || editTextWeight1.getText().toString().equals(".")
                        || editTextWeight1.getText().toString().equals("0")) {
                    textViewPricePerKg1.setText("0.00");
                } else if ((editTextPrice1.getText().toString().isEmpty()
                        || (editTextWeight1.getText().toString().isEmpty()))) {
                    textViewPricePerKg1.setText("");
                } else {
                    float mPrice1 = Float.parseFloat(editTextPrice1.getText().toString());
                    float mWeight1 = Float.parseFloat(editTextWeight1.getText().toString());
                    textViewPricePerKg1.setText(String.format("%.2f", mPrice1 * 1000 / mWeight1));
                }
            }
            // ------------------- The second product -------------------
            if ((editable == editTextPrice2.getEditableText())
                    || (editable == editTextWeight2.getEditableText())) {
                if ((editTextPrice2.getText().toString().equals("."))
                        || editTextWeight2.getText().toString().equals(".")
                        || editTextWeight2.getText().toString().equals("0")) {
                    textViewPricePerKg2.setText("0.00");
                } else if ((editTextPrice2.getText().toString().isEmpty()
                        || (editTextWeight2.getText().toString().isEmpty()))) {
                    textViewPricePerKg2.setText("");
                } else {
                    float mPrice2 = Float.parseFloat(editTextPrice2.getText().toString());
                    float mWeight2 = Float.parseFloat(editTextWeight2.getText().toString());
                    textViewPricePerKg2.setText(String.format("%.2f", mPrice2 * 1000 / mWeight2));
                }

            }
            // ------------------- The third product -------------------
            if ((editable == editTextPrice3.getEditableText())
                    || (editable == editTextWeight3.getEditableText())) {
                if ((editTextPrice3.getText().toString().equals("."))
                        || editTextWeight3.getText().toString().equals(".")
                        || editTextWeight3.getText().toString().equals("0")) {
                    textViewPricePerKg3.setText("0.00");
                } else if ((editTextPrice3.getText().toString().isEmpty()
                        || (editTextWeight3.getText().toString().isEmpty()))) {
                    textViewPricePerKg3.setText("");
                } else {
                    float mPrice3 = Float.parseFloat(editTextPrice3.getText().toString());
                    float mWeight3 = Float.parseFloat(editTextWeight3.getText().toString());
                    textViewPricePerKg3.setText(String.format("%.2f", mPrice3 * 1000 / mWeight3));
                }
            }

            // ------------------- The fourth product -------------------
            if ((editable == editTextPrice4.getEditableText())
                    || (editable == editTextWeight4.getEditableText())) {
                if ((editTextPrice4.getText().toString().equals("."))
                        || editTextWeight4.getText().toString().equals(".")
                        || editTextWeight4.getText().toString().equals("0")) {
                    textViewPricePerKg4.setText("0.00");
                } else if ((editTextPrice4.getText().toString().isEmpty()
                        || (editTextWeight4.getText().toString().isEmpty()))) {
                    textViewPricePerKg4.setText("");
                } else {
                    float mPrice4 = Float.parseFloat(editTextPrice4.getText().toString());
                    float mWeight4 = Float.parseFloat(editTextWeight4.getText().toString());
                    textViewPricePerKg4.setText(String.format("%.2f", mPrice4 * 1000 / mWeight4));
                }
            }

            // ------------------- The fourth product -------------------
            if ((editable == editTextPrice5.getEditableText())
                    || (editable == editTextWeight5.getEditableText())) {
                if ((editTextPrice5.getText().toString().equals("."))
                        || editTextWeight5.getText().toString().equals(".")
                        || editTextWeight5.getText().toString().equals("0")) {
                    textViewPricePerKg5.setText("0.00");
                } else if ((editTextPrice5.getText().toString().isEmpty()
                        || (editTextWeight5.getText().toString().isEmpty()))) {
                    textViewPricePerKg5.setText("");
                } else {
                    float mPrice5 = Float.parseFloat(editTextPrice5.getText().toString());
                    float mWeight5 = Float.parseFloat(editTextWeight5.getText().toString());
                    textViewPricePerKg5.setText(String.format("%.2f", mPrice5 * 1000 / mWeight5));
                }
            }

            //String finalPrice1 = textViewPricePerKg1.getText().toString();
            String stringFinalPrice1 = textViewPricePerKg1.getText().toString();
            String stringFinalPrice2 = textViewPricePerKg2.getText().toString();
            String stringFinalPrice3 = textViewPricePerKg3.getText().toString();
            String stringFinalPrice4 = textViewPricePerKg4.getText().toString();
            String stringFinalPrice5 = textViewPricePerKg4.getText().toString();

           /* if ((!stringFinalPrice1.trim().isEmpty() && !stringFinalPrice2.trim().isEmpty())
                    && !stringFinalPrice3.trim().isEmpty()) {
                float finalPrice1 = Float.parseFloat(stringFinalPrice1);
                float finalPrice2 = Float.parseFloat(stringFinalPrice2);
                float finalPrice3 = Float.parseFloat(stringFinalPrice3);
                if ((finalPrice1 < finalPrice2) || (finalPrice1 < finalPrice3)) {
                    textViewPricePerKg1.setBackgroundColor(Color.parseColor("#3fc4fe"));
                    textViewPricePerKg2.setBackgroundColor(Color.TRANSPARENT);
                    textViewPricePerKg3.setBackgroundColor(Color.TRANSPARENT);
                } else if (finalPrice2 < finalPrice1 && finalPrice2 < finalPrice3) {
                    textViewPricePerKg1.setBackgroundColor(Color.TRANSPARENT);
                    textViewPricePerKg3.setBackgroundColor(Color.TRANSPARENT);
                    textViewPricePerKg2.setBackgroundColor(Color.parseColor("#3fc4fe"));
                } else if (finalPrice3 < finalPrice1 && finalPrice3 < finalPrice2) {
                    textViewPricePerKg1.setBackgroundColor(Color.TRANSPARENT);
                    textViewPricePerKg2.setBackgroundColor(Color.TRANSPARENT);
                    textViewPricePerKg3.setBackgroundColor(Color.parseColor("#3fc4fe"));
                    textViewVersion.setText("awdwadwadwa");
                } else {
                    textViewPricePerKg1.setBackgroundColor(Color.TRANSPARENT);
                    textViewPricePerKg2.setBackgroundColor(Color.TRANSPARENT);
                    textViewPricePerKg3.setBackgroundColor(Color.TRANSPARENT);
                }*/

/*
            if (!stringFinalPrice1.trim().isEmpty() && !stringFinalPrice2.trim().isEmpty()
                    && !stringFinalPrice3.trim().isEmpty()) {




                float finalPrice1 = Float.parseFloat(stringFinalPrice1);
                float finalPrice2 = Float.parseFloat(stringFinalPrice2);
                float finalPrice3 = Float.parseFloat(stringFinalPrice3);
                float smallestPrice;
                if (smallest(finalPrice1, finalPrice2, finalPrice3)){

                }

                textViewPricePerKg1.setBackgroundColor(Color.parseColor("#3fc4fe"));*/


               /* if (finalPrice1 < finalPrice2){
                    textViewPricePerKg1.setBackgroundColor(Color.parseColor("#3fc4fe"));
                    textViewPricePerKg2.setBackgroundColor(Color.TRANSPARENT);
                    textViewPricePerKg3.setBackgroundColor(Color.TRANSPARENT);
                } else if (finalPrice1 > finalPrice2){
                    textViewPricePerKg1.setBackgroundColor(Color.TRANSPARENT);
                    textViewPricePerKg3.setBackgroundColor(Color.TRANSPARENT);
                    textViewPricePerKg2.setBackgroundColor(Color.parseColor("#3fc4fe"));
                }
            }
            if (!stringFinalPrice1.trim().isEmpty() && stringFinalPrice2.trim().isEmpty()
                    && !stringFinalPrice3.trim().isEmpty()) {
                float finalPrice1 = Float.parseFloat(stringFinalPrice1);
                float finalPrice3 = Float.parseFloat(stringFinalPrice3);
                if (finalPrice1 < finalPrice3)  {
                    textViewPricePerKg1.setBackgroundColor(Color.parseColor("#3fc4fe"));
                    textViewPricePerKg2.setBackgroundColor(Color.TRANSPARENT);
                    textViewPricePerKg3.setBackgroundColor(Color.TRANSPARENT);
                } else {
                    textViewPricePerKg1.setBackgroundColor(Color.TRANSPARENT);
                    textViewPricePerKg2.setBackgroundColor(Color.TRANSPARENT);
                    textViewPricePerKg3.setBackgroundColor(Color.parseColor("#3fc4fe"));
                }
            }
            if (stringFinalPrice1.trim().isEmpty() && !stringFinalPrice2.trim().isEmpty()
                    && !stringFinalPrice3.trim().isEmpty()) {
                float finalPrice2 = Float.parseFloat(stringFinalPrice2);
                float finalPrice3 = Float.parseFloat(stringFinalPrice3);
                if (finalPrice2 < finalPrice3)  {
                    textViewPricePerKg2.setBackgroundColor(Color.parseColor("#3fc4fe"));
                    textViewPricePerKg2.setBackgroundColor(Color.TRANSPARENT);
                    textViewPricePerKg3.setBackgroundColor(Color.TRANSPARENT);
                } else {
                    textViewPricePerKg1.setBackgroundColor(Color.TRANSPARENT);
                    textViewPricePerKg2.setBackgroundColor(Color.TRANSPARENT);
                    textViewPricePerKg3.setBackgroundColor(Color.parseColor("#3fc4fe"));
                }*/
            }


           /* float finalPrice2 = Float.parseFloat((textViewPricePerKg2.getText().toString()));
            float finalPrice3 = Float.parseFloat((textViewPricePerKg3.getText().toString()));*/
            //textViewVersion.setText(finalPrice1);

          /*  if (finalPrice1 < finalPrice2) {

            }
*/


        }

    }

    /*    public static float smallest(float a, float b, float c)
        {
            return Math.min(Math.min(a, b), c);
        }*/




