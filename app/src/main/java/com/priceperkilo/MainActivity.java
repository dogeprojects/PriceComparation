package com.priceperkilo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;
import androidx.appcompat.widget.Toolbar;
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

//TODO localisation
//TODO implement dynamic adding and removing items

public class MainActivity extends AppCompatActivity {

    EditText mEditTextPrice1;
    TextView mEditTextWeight1;

    EditText mEditTextPrice2;
    TextView mEditTextWeight2;

    EditText mEditTextPrice3;
    TextView mEditTextWeight3;

    EditText mEditTextPrice4;
    TextView mEditTextWeight4;

    EditText mEditTextPrice5;
    TextView mEditTextWeight5;

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

        CardView cardViewC4 = findViewById(R.id.card_view4);
        CardView cardViewC5 = findViewById(R.id.card_view5);

        cardViewC4.setVisibility(View.INVISIBLE);
        cardViewC5.setVisibility(View.INVISIBLE);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    // Hide textEdit button handle
    public void onButtonHideClick(MenuItem item) {

        CardView cardViewC4 = findViewById(R.id.card_view4);
        CardView cardViewC5 = findViewById(R.id.card_view5);

        //Toggle
        if (cardViewC4.getVisibility() == View.INVISIBLE) {
            cardViewC4.setVisibility(View.VISIBLE);
            cardViewC5.setVisibility(View.VISIBLE);
            Toast.makeText(this, "Fields have been shown", Toast.LENGTH_SHORT).show();
        } else {
            cardViewC4.setVisibility(View.INVISIBLE);
            cardViewC5.setVisibility(View.INVISIBLE);
            Toast.makeText(this, "Fields have been hidden", Toast.LENGTH_SHORT).show();
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
        final TextView textViewPrice1 = findViewById(R.id.textViewPricePerKg1);

        final EditText editTextPrice2 = findViewById(R.id.editTextPrice2);
        final TextView editTextWeight2 = findViewById(R.id.editTextWeight2);
        final TextView textViewPrice2 = findViewById(R.id.textViewPricePerKg2);

        final EditText editTextPrice3 = findViewById(R.id.editTextPrice3);
        final TextView editTextWeight3 = findViewById(R.id.editTextWeight3);
        final TextView textViewPrice3 = findViewById(R.id.textViewPricePerKg3);

        final EditText editTextPrice4 = findViewById(R.id.editTextPrice4);
        final TextView editTextWeight4 = findViewById(R.id.editTextWeight4);
        final TextView textViewPrice4 = findViewById(R.id.textViewPricePerKg4);

        final EditText editTextPrice5 = findViewById(R.id.editTextPrice5);
        final TextView editTextWeight5 = findViewById(R.id.editTextWeight5);
        final TextView textViewPrice5 = findViewById(R.id.textViewPricePerKg5);

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
            if ((editable == editTextPrice1.getEditableText())
                    || (editable == editTextWeight1.getEditableText())) {
                if ((editTextPrice1.getText().toString().equals("."))
                        || editTextWeight1.getText().toString().equals(".")
                        || editTextWeight1.getText().toString().matches("^0([-.]?[0]*)$")) {
                    textViewPrice1.setText("0.00");
                } else if ((editTextPrice1.getText().toString().isEmpty()
                        || (editTextWeight1.getText().toString().isEmpty()))) {
                    textViewPrice1.setText("");
                } else {
                    float mPrice1 = Float.parseFloat(editTextPrice1.getText().toString());
                    float mWeight1 = Float.parseFloat(editTextWeight1.getText().toString());
                    textViewPrice1.setText(String.format("%.2f", mPrice1 * 1000 / mWeight1));
                }
            }
            // ------------------- The second product -------------------
            if ((editable == editTextPrice2.getEditableText())
                    || (editable == editTextWeight2.getEditableText())) {
                if ((editTextPrice2.getText().toString().equals("."))
                        || editTextWeight2.getText().toString().equals(".")
                        || editTextWeight2.getText().toString().matches("^0([-.]?[0]*)$")) {
                    textViewPrice2.setText("0.00");
                } else if ((editTextPrice2.getText().toString().isEmpty()
                        || (editTextWeight2.getText().toString().isEmpty()))) {
                    textViewPrice2.setText("");
                } else {
                    float mPrice2 = Float.parseFloat(editTextPrice2.getText().toString());
                    float mWeight2 = Float.parseFloat(editTextWeight2.getText().toString());
                    textViewPrice2.setText(String.format("%.2f", mPrice2 * 1000 / mWeight2));
                }

            }
            // ------------------- The third product -------------------
            if ((editable == editTextPrice3.getEditableText())
                    || (editable == editTextWeight3.getEditableText())) {
                if ((editTextPrice3.getText().toString().equals("."))
                        || editTextWeight3.getText().toString().equals(".")
                        || editTextWeight3.getText().toString().matches("^0([-.]?[0]*)$")) {
                    textViewPrice3.setText("0.00");
                } else if ((editTextPrice3.getText().toString().isEmpty()
                        || (editTextWeight3.getText().toString().isEmpty()))) {
                    textViewPrice3.setText("");
                } else {
                    float mPrice3 = Float.parseFloat(editTextPrice3.getText().toString());
                    float mWeight3 = Float.parseFloat(editTextWeight3.getText().toString());
                    textViewPrice3.setText(String.format("%.2f", mPrice3 * 1000 / mWeight3));
                }
            }

            // ------------------- The fourth product -------------------
            if ((editable == editTextPrice4.getEditableText())
                    || (editable == editTextWeight4.getEditableText())) {
                if ((editTextPrice4.getText().toString().equals("."))
                        || editTextWeight4.getText().toString().equals(".")
                        || editTextWeight4.getText().toString().matches("^0([-.]?[0]*)$")) {
                    textViewPrice4.setText("0.00");
                } else if ((editTextPrice4.getText().toString().isEmpty()
                        || (editTextWeight4.getText().toString().isEmpty()))) {
                    textViewPrice4.setText("");
                } else {
                    float mPrice4 = Float.parseFloat(editTextPrice4.getText().toString());
                    float mWeight4 = Float.parseFloat(editTextWeight4.getText().toString());
                    textViewPrice4.setText(String.format("%.2f", mPrice4 * 1000 / mWeight4));
                }
            }

            // ------------------- The fifth product -------------------
            if ((editable == editTextPrice5.getEditableText())
                    || (editable == editTextWeight5.getEditableText())) {
                if ((editTextPrice5.getText().toString().equals("."))
                        || editTextWeight5.getText().toString().equals(".")
                        || editTextWeight5.getText().toString().matches("^0([-.]?[0]*)$")) {
                    textViewPrice5.setText("0.00");
                } else if ((editTextPrice5.getText().toString().isEmpty()
                        || (editTextWeight5.getText().toString().isEmpty()))) {
                    textViewPrice5.setText("");
                } else {
                    float mPrice5 = Float.parseFloat(editTextPrice5.getText().toString());
                    float mWeight5 = Float.parseFloat(editTextWeight5.getText().toString());
                    textViewPrice5.setText(String.format("%.2f", mPrice5 * 1000 / mWeight5));
                }
            }

            // ------------------- Finding minimum value -------------------
            String stringFinalPrice1 = textViewPrice1.getText().toString();
            String stringFinalPrice2 = textViewPrice2.getText().toString();
            String stringFinalPrice3 = textViewPrice3.getText().toString();
            String stringFinalPrice4 = textViewPrice4.getText().toString();
            String stringFinalPrice5 = textViewPrice5.getText().toString();

            HashMap<String, Float> prices = new HashMap<>();

            String[] arrayStringPrices = {stringFinalPrice1, stringFinalPrice2, stringFinalPrice3, stringFinalPrice4, stringFinalPrice5};
            for (int i = 0; i < arrayStringPrices.length; i++) {
                if (!arrayStringPrices[i].trim().isEmpty() && arrayStringPrices[i] != null) {
                    DecimalFormat df = new DecimalFormat("#.#");
                    DecimalFormatSymbols dfs = DecimalFormatSymbols.getInstance();
                    dfs.setDecimalSeparator(',');
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
                        textViewPrice1.setBackgroundColor(Color.TRANSPARENT);
                        textViewPrice2.setBackgroundColor(Color.TRANSPARENT);
                        textViewPrice3.setBackgroundColor(Color.TRANSPARENT);
                        textViewPrice4.setBackgroundColor(Color.TRANSPARENT);
                        textViewPrice5.setBackgroundColor(Color.TRANSPARENT);
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




