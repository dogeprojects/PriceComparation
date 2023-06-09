package com.pricecomparation;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

//TODO implement dynamic adding and removing items

public class MainActivity extends AppCompatActivity {

    EditText mEditTextPrice1, mEditTextPrice2, mEditTextPrice3, mEditTextPrice4, mEditTextPrice5;
    TextView mEditTextWeight1, mEditTextWeight2, mEditTextWeight3, mEditTextWeight4, mEditTextWeight5;
    TextView mEditTextProduct1, mEditTextProduct2, mEditTextProduct3, mEditTextProduct4, mEditTextProduct5;
    TextView mTextViewPricePerKg1, mTextViewPricePerKg2, mTextViewPricePerKg3, mTextViewPricePerKg4, mTextViewPricePerKg5;
    CardView cardViewC4, cardViewC5;

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
        mEditTextProduct1 = findViewById(R.id.editTextProduct1);
        mTextViewPricePerKg1 = findViewById(R.id.textViewPricePerKg1);

        mEditTextPrice2 = findViewById(R.id.editTextPrice2);
        mEditTextWeight2 = findViewById(R.id.editTextWeight2);
        mEditTextProduct2 = findViewById(R.id.editTextProduct2);
        mTextViewPricePerKg2 = findViewById(R.id.textViewPricePerKg2);

        mEditTextPrice3 = findViewById(R.id.editTextPrice3);
        mEditTextWeight3 = findViewById(R.id.editTextWeight3);
        mEditTextProduct3 = findViewById(R.id.editTextProduct3);
        mTextViewPricePerKg3 = findViewById(R.id.textViewPricePerKg3);

        mEditTextPrice4 = findViewById(R.id.editTextPrice4);
        mEditTextWeight4 = findViewById(R.id.editTextWeight4);
        mEditTextProduct4 = findViewById(R.id.editTextProduct4);
        mTextViewPricePerKg4 = findViewById(R.id.textViewPricePerKg4);

        mEditTextPrice5 = findViewById(R.id.editTextPrice5);
        mEditTextWeight5 = findViewById(R.id.editTextWeight5);
        mEditTextProduct5 = findViewById(R.id.editTextProduct5);
        mTextViewPricePerKg5 = findViewById(R.id.textViewPricePerKg5);

        cardViewC4 = findViewById(R.id.card_view4);
        cardViewC5 = findViewById(R.id.card_view5);

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

        cardViewC4.setVisibility(View.INVISIBLE);
        cardViewC5.setVisibility(View.INVISIBLE);

        //TODO Show change log by click on toolbar
        findViewById(R.id.toolbar).setOnClickListener(v -> {
            //Do something
            Toast.makeText(MainActivity.this, R.string.ThanksForUsing, Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    // Hide textEdit button handle
    public void onButtonHideClick(MenuItem item) {

        //Toggle
        if (cardViewC4.getVisibility() == View.INVISIBLE) {
            cardViewC4.setVisibility(View.VISIBLE);
            cardViewC5.setVisibility(View.VISIBLE);
            Toast.makeText(this, R.string.FieldsShown, Toast.LENGTH_SHORT).show();
        } else {
            cardViewC4.setVisibility(View.INVISIBLE);
            cardViewC5.setVisibility(View.INVISIBLE);
            Toast.makeText(this, R.string.FieldsHidden, Toast.LENGTH_SHORT).show();

            //clear fields after hiding
            mEditTextProduct4.setText("");
            mEditTextPrice4.setText("");
            mEditTextWeight4.setText("");
            mTextViewPricePerKg4.setText("");

            mEditTextProduct5.setText("");
            mEditTextPrice5.setText("");
            mEditTextWeight5.setText("");
            mTextViewPricePerKg5.setText("");
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
            theme_boolean = !theme_boolean;

            SharedPreferences.Editor mEditor = mPrefs.edit();
            mEditor.putBoolean("theme_boolean", theme_boolean).apply();
            recreate();
            //startActivity(new Intent(MainActivity.this, MainActivity.this.getClass()));

            Toast toast = Toast.makeText(getApplicationContext(),
                    R.string.ThemeChanged,
                    Toast.LENGTH_SHORT);
            toast.show();
        }

        if (item.getItemId() == R.id.clear_button) {
            mEditTextProduct1.setText("");
            mEditTextPrice1.setText("");
            mEditTextWeight1.setText("");
            mTextViewPricePerKg1.setText("");

            mEditTextProduct2.setText("");
            mEditTextPrice2.setText("");
            mEditTextWeight2.setText("");
            mTextViewPricePerKg2.setText("");

            mEditTextProduct3.setText("");
            mEditTextPrice3.setText("");
            mEditTextWeight3.setText("");
            mTextViewPricePerKg3.setText("");

            mEditTextProduct4.setText("");
            mEditTextPrice4.setText("");
            mEditTextWeight4.setText("");
            mTextViewPricePerKg4.setText("");

            mEditTextProduct5.setText("");
            mEditTextPrice5.setText("");
            mEditTextWeight5.setText("");
            mTextViewPricePerKg5.setText("");

            mTextViewPricePerKg1.setBackgroundColor(Color.TRANSPARENT);
            mTextViewPricePerKg2.setBackgroundColor(Color.TRANSPARENT);
            mTextViewPricePerKg3.setBackgroundColor(Color.TRANSPARENT);
            mTextViewPricePerKg4.setBackgroundColor(Color.TRANSPARENT);
            mTextViewPricePerKg5.setBackgroundColor(Color.TRANSPARENT);

            Toast toast = Toast.makeText(getApplicationContext(),
                    R.string.FieldsCheared,
                    Toast.LENGTH_SHORT);
            toast.show();
        }
        return true;
    }

    // ======================= Implementation of TextWatcher =======================
    class TextChangeWatcher implements TextWatcher {

        TextChangeWatcher() {
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @RequiresApi(api = Build.VERSION_CODES.N)
        @SuppressLint({"DefaultLocale", "SetTextI18n"})
        @Override
        public void afterTextChanged(Editable editable) {
            // ------------------- The first product --------------------
            if ((editable == mEditTextPrice1.getEditableText())
                    || (editable == mEditTextWeight1.getEditableText())) {
                if ((mEditTextPrice1.getText().toString().equals("."))
                        || mEditTextWeight1.getText().toString().equals(".")
                        || mEditTextWeight1.getText().toString().matches("^0([-.]?[0]*)$")) {
                    mTextViewPricePerKg1.setText("0.00");

                } else if ((mEditTextPrice1.getText().toString().isEmpty()
                        || (mEditTextWeight1.getText().toString().isEmpty()))) {
                    mTextViewPricePerKg1.setText("");
                } else {
                    float mPrice1 = Float.parseFloat(mEditTextPrice1.getText().toString());
                    float mWeight1 = Float.parseFloat(mEditTextWeight1.getText().toString());
                    mTextViewPricePerKg1.setText(String.format("%.2f", mPrice1 * 1000 / mWeight1));
                }
                mTextViewPricePerKg1.setBackgroundColor(Color.TRANSPARENT);
            }
            // ------------------- The second product -------------------
            if ((editable == mEditTextPrice2.getEditableText())
                    || (editable == mEditTextWeight2.getEditableText())) {
                if ((mEditTextPrice2.getText().toString().equals("."))
                        || mEditTextWeight2.getText().toString().equals(".")
                        || mEditTextWeight2.getText().toString().matches("^0([-.]?[0]*)$")) {
                    mTextViewPricePerKg2.setText("0.00");
                } else if ((mEditTextPrice2.getText().toString().isEmpty()
                        || (mEditTextWeight2.getText().toString().isEmpty()))) {
                    mTextViewPricePerKg2.setText("");
                } else {
                    float mPrice2 = Float.parseFloat(mEditTextPrice2.getText().toString());
                    float mWeight2 = Float.parseFloat(mEditTextWeight2.getText().toString());
                    mTextViewPricePerKg2.setText(String.format("%.2f", mPrice2 * 1000 / mWeight2));
                }
                mTextViewPricePerKg2.setBackgroundColor(Color.TRANSPARENT);
            }
            // ------------------- The third product -------------------
            if ((editable == mEditTextPrice3.getEditableText())
                    || (editable == mEditTextWeight3.getEditableText())) {
                if ((mEditTextPrice3.getText().toString().equals("."))
                        || mEditTextWeight3.getText().toString().equals(".")
                        || mEditTextWeight3.getText().toString().matches("^0([-.]?[0]*)$")) {
                    mTextViewPricePerKg3.setText("0.00");
                } else if ((mEditTextPrice3.getText().toString().isEmpty()
                        || (mEditTextWeight3.getText().toString().isEmpty()))) {
                    mTextViewPricePerKg3.setText("");
                } else {
                    float mPrice3 = Float.parseFloat(mEditTextPrice3.getText().toString());
                    float mWeight3 = Float.parseFloat(mEditTextWeight3.getText().toString());
                    mTextViewPricePerKg3.setText(String.format("%.2f", mPrice3 * 1000 / mWeight3));
                }
                mTextViewPricePerKg3.setBackgroundColor(Color.TRANSPARENT);
            }

            // ------------------- The fourth product -------------------
            if ((editable == mEditTextPrice4.getEditableText())
                    || (editable == mEditTextWeight4.getEditableText())) {
                if ((mEditTextPrice4.getText().toString().equals("."))
                        || mEditTextWeight4.getText().toString().equals(".")
                        || mEditTextWeight4.getText().toString().matches("^0([-.]?[0]*)$")) {
                    mTextViewPricePerKg4.setText("0.00");
                } else if ((mEditTextPrice4.getText().toString().isEmpty()
                        || (mEditTextWeight4.getText().toString().isEmpty()))) {
                    mTextViewPricePerKg4.setText("");
                } else {
                    float mPrice4 = Float.parseFloat(mEditTextPrice4.getText().toString());
                    float mWeight4 = Float.parseFloat(mEditTextWeight4.getText().toString());
                    mTextViewPricePerKg4.setText(String.format("%.2f", mPrice4 * 1000 / mWeight4));
                }
                mTextViewPricePerKg4.setBackgroundColor(Color.TRANSPARENT);
            }

            // ------------------- The fifth product -------------------
            if ((editable == mEditTextPrice5.getEditableText())
                    || (editable == mEditTextWeight5.getEditableText())) {
                if ((mEditTextPrice5.getText().toString().equals("."))
                        || mEditTextWeight5.getText().toString().equals(".")
                        || mEditTextWeight5.getText().toString().matches("^0([-.]?[0]*)$")) {
                    mTextViewPricePerKg5.setText("0.00");
                } else if ((mEditTextPrice5.getText().toString().isEmpty()
                        || (mEditTextWeight5.getText().toString().isEmpty()))) {
                    mTextViewPricePerKg5.setText("");
                } else {
                    float mPrice5 = Float.parseFloat(mEditTextPrice5.getText().toString());
                    float mWeight5 = Float.parseFloat(mEditTextWeight5.getText().toString());
                    mTextViewPricePerKg5.setText(String.format("%.2f", mPrice5 * 1000 / mWeight5));
                }
                mTextViewPricePerKg5.setBackgroundColor(Color.TRANSPARENT);
            }

            // ------------------- Finding minimum value -------------------
            String stringFinalPrice1 = mTextViewPricePerKg1.getText().toString();
            String stringFinalPrice2 = mTextViewPricePerKg2.getText().toString();
            String stringFinalPrice3 = mTextViewPricePerKg3.getText().toString();
            String stringFinalPrice4 = mTextViewPricePerKg4.getText().toString();
            String stringFinalPrice5 = mTextViewPricePerKg5.getText().toString();

            HashMap<String, Float> prices = new HashMap<>();

            String[] arrayStringPrices = {stringFinalPrice1, stringFinalPrice2, stringFinalPrice3, stringFinalPrice4, stringFinalPrice5};
            for (int i = 0; i < arrayStringPrices.length; i++) {
                if (!arrayStringPrices[i].trim().isEmpty() && arrayStringPrices[i] != null) {
                    DecimalFormat df = new DecimalFormat("#.#");
                    DecimalFormatSymbols dfs = DecimalFormatSymbols.getInstance();
                    //dfs.setDecimalSeparator(','); //This line is commented out for the correct calculation of decimals
                    df.setDecimalFormatSymbols(dfs);
                    try {
                        Log.i("debug", "arrayStringPrices[i]: " + df.parse(arrayStringPrices[i]));
                        //System.out.println(df.parse(arrayStringPrices[i]));
                        prices.put("textViewPricePerKg" + (i + 1), Float.parseFloat(String.valueOf(df.parse(arrayStringPrices[i]))));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }

            Log.i("debug", "HashMap: " + prices.keySet() + " = " + prices.values());

            // TreeMap to store values of HashMap
            TreeMap<Object, Float> sorted = new TreeMap<>();

            // Copy all data from hashMap into TreeMap
            prices.entrySet();

            if (!sorted.isEmpty()) {
                Log.i("debug", "Minimum: " + sorted.firstEntry().getKey() + " = " + sorted.firstEntry().getValue());
            }

            // Display the TreeMap which is naturally sorted
            for (Map.Entry<Object, Float> entry : sorted.entrySet()) {
                Log.i("debug", "Sorted Hashmap " + entry.getKey() + " = " + entry.getValue());
            }

            if (!prices.values().isEmpty()) {
                Float minValueInMap = (Collections.min(prices.values()));
                for (Map.Entry<String, Float> entry : prices.entrySet()) {  // Iterate through HashMap
                    if (entry.getValue() == minValueInMap) {
                        System.out.println("Minimum of Map.Entry: \n" + entry.getKey() + " = " + entry.getValue());     // Print the key with min value
                        int ViewMin = getResources().getIdentifier(entry.getKey(), "id", getPackageName());
                        System.out.println("ViewMin Identifier: " + ViewMin);
                        mTextViewPricePerKg1.setBackgroundColor(Color.TRANSPARENT);
                        mTextViewPricePerKg2.setBackgroundColor(Color.TRANSPARENT);
                        mTextViewPricePerKg3.setBackgroundColor(Color.TRANSPARENT);
                        mTextViewPricePerKg4.setBackgroundColor(Color.TRANSPARENT);
                        mTextViewPricePerKg5.setBackgroundColor(Color.TRANSPARENT);
                        TextView TextViewPriceMin = findViewById(ViewMin);
                        TextViewPriceMin.setBackgroundColor(Color.parseColor("#3fc4fe"));
                    }
                }
            }

            if (!prices.values().isEmpty()) {
                prices.values().stream().min(Float::compare).get();
                Log.i("debug", "Min value hashmap: " + prices.keySet() + " = " + prices.values().stream().min(Float::compare).get());
            }


        }
    }
}
