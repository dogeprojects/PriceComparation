package com.pricecomparation;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

// ======================= Implementation of TextWatcher =======================
class TextChangeWatcher implements TextWatcher {

    private final MainActivity mainActivity;

    TextChangeWatcher(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
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
        if ((editable == mainActivity.mEditTextPrice1.getEditableText())
                || (editable == mainActivity.mEditTextWeight1.getEditableText())) {
            if ((mainActivity.mEditTextPrice1.getText().toString().equals("."))
                    || mainActivity.mEditTextWeight1.getText().toString().equals(".")
                    || mainActivity.mEditTextWeight1.getText().toString().matches("^0([-.]?[0]*)$")) {
                mainActivity.mTextViewPricePerKg1.setText("0.00");

            } else if ((mainActivity.mEditTextPrice1.getText().toString().isEmpty()
                    || (mainActivity.mEditTextWeight1.getText().toString().isEmpty()))) {
                mainActivity.mTextViewPricePerKg1.setText("");
            } else {
                float mPrice1 = Float.parseFloat(mainActivity.mEditTextPrice1.getText().toString());
                float mWeight1 = Float.parseFloat(mainActivity.mEditTextWeight1.getText().toString());
                mainActivity.mTextViewPricePerKg1.setText(String.format("%.2f", mPrice1 * 1000 / mWeight1));
            }
            mainActivity.mTextViewPricePerKg1.setBackgroundColor(Color.TRANSPARENT);
        }
        // ------------------- The second product -------------------
        if ((editable == mainActivity.mEditTextPrice2.getEditableText())
                || (editable == mainActivity.mEditTextWeight2.getEditableText())) {
            if ((mainActivity.mEditTextPrice2.getText().toString().equals("."))
                    || mainActivity.mEditTextWeight2.getText().toString().equals(".")
                    || mainActivity.mEditTextWeight2.getText().toString().matches("^0([-.]?[0]*)$")) {
                mainActivity.mTextViewPricePerKg2.setText("0.00");
            } else if ((mainActivity.mEditTextPrice2.getText().toString().isEmpty()
                    || (mainActivity.mEditTextWeight2.getText().toString().isEmpty()))) {
                mainActivity.mTextViewPricePerKg2.setText("");
            } else {
                float mPrice2 = Float.parseFloat(mainActivity.mEditTextPrice2.getText().toString());
                float mWeight2 = Float.parseFloat(mainActivity.mEditTextWeight2.getText().toString());
                mainActivity.mTextViewPricePerKg2.setText(String.format("%.2f", mPrice2 * 1000 / mWeight2));
            }
            mainActivity.mTextViewPricePerKg2.setBackgroundColor(Color.TRANSPARENT);
        }
        // ------------------- The third product -------------------
        if ((editable == mainActivity.mEditTextPrice3.getEditableText())
                || (editable == mainActivity.mEditTextWeight3.getEditableText())) {
            if ((mainActivity.mEditTextPrice3.getText().toString().equals("."))
                    || mainActivity.mEditTextWeight3.getText().toString().equals(".")
                    || mainActivity.mEditTextWeight3.getText().toString().matches("^0([-.]?[0]*)$")) {
                mainActivity.mTextViewPricePerKg3.setText("0.00");
            } else if ((mainActivity.mEditTextPrice3.getText().toString().isEmpty()
                    || (mainActivity.mEditTextWeight3.getText().toString().isEmpty()))) {
                mainActivity.mTextViewPricePerKg3.setText("");
            } else {
                float mPrice3 = Float.parseFloat(mainActivity.mEditTextPrice3.getText().toString());
                float mWeight3 = Float.parseFloat(mainActivity.mEditTextWeight3.getText().toString());
                mainActivity.mTextViewPricePerKg3.setText(String.format("%.2f", mPrice3 * 1000 / mWeight3));
            }
            mainActivity.mTextViewPricePerKg3.setBackgroundColor(Color.TRANSPARENT);
        }

        // ------------------- The fourth product -------------------
        if ((editable == mainActivity.mEditTextPrice4.getEditableText())
                || (editable == mainActivity.mEditTextWeight4.getEditableText())) {
            if ((mainActivity.mEditTextPrice4.getText().toString().equals("."))
                    || mainActivity.mEditTextWeight4.getText().toString().equals(".")
                    || mainActivity.mEditTextWeight4.getText().toString().matches("^0([-.]?[0]*)$")) {
                mainActivity.mTextViewPricePerKg4.setText("0.00");
            } else if ((mainActivity.mEditTextPrice4.getText().toString().isEmpty()
                    || (mainActivity.mEditTextWeight4.getText().toString().isEmpty()))) {
                mainActivity.mTextViewPricePerKg4.setText("");
            } else {
                float mPrice4 = Float.parseFloat(mainActivity.mEditTextPrice4.getText().toString());
                float mWeight4 = Float.parseFloat(mainActivity.mEditTextWeight4.getText().toString());
                mainActivity.mTextViewPricePerKg4.setText(String.format("%.2f", mPrice4 * 1000 / mWeight4));
            }
            mainActivity.mTextViewPricePerKg4.setBackgroundColor(Color.TRANSPARENT);
        }

        // ------------------- The fifth product -------------------
        if ((editable == mainActivity.mEditTextPrice5.getEditableText())
                || (editable == mainActivity.mEditTextWeight5.getEditableText())) {
            if ((mainActivity.mEditTextPrice5.getText().toString().equals("."))
                    || mainActivity.mEditTextWeight5.getText().toString().equals(".")
                    || mainActivity.mEditTextWeight5.getText().toString().matches("^0([-.]?[0]*)$")) {
                mainActivity.mTextViewPricePerKg5.setText("0.00");
            } else if ((mainActivity.mEditTextPrice5.getText().toString().isEmpty()
                    || (mainActivity.mEditTextWeight5.getText().toString().isEmpty()))) {
                mainActivity.mTextViewPricePerKg5.setText("");
            } else {
                float mPrice5 = Float.parseFloat(mainActivity.mEditTextPrice5.getText().toString());
                float mWeight5 = Float.parseFloat(mainActivity.mEditTextWeight5.getText().toString());
                mainActivity.mTextViewPricePerKg5.setText(String.format("%.2f", mPrice5 * 1000 / mWeight5));
            }
            mainActivity.mTextViewPricePerKg5.setBackgroundColor(Color.TRANSPARENT);
        }

        // ------------------- Finding minimum value -------------------
        String stringFinalPrice1 = mainActivity.mTextViewPricePerKg1.getText().toString();
        String stringFinalPrice2 = mainActivity.mTextViewPricePerKg2.getText().toString();
        String stringFinalPrice3 = mainActivity.mTextViewPricePerKg3.getText().toString();
        String stringFinalPrice4 = mainActivity.mTextViewPricePerKg4.getText().toString();
        String stringFinalPrice5 = mainActivity.mTextViewPricePerKg5.getText().toString();

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
                    int ViewMin = mainActivity.getResources().getIdentifier(entry.getKey(), "id", mainActivity.getPackageName());
                    System.out.println("ViewMin Identifier: " + ViewMin);
                    mainActivity.mTextViewPricePerKg1.setBackgroundColor(Color.TRANSPARENT);
                    mainActivity.mTextViewPricePerKg2.setBackgroundColor(Color.TRANSPARENT);
                    mainActivity.mTextViewPricePerKg3.setBackgroundColor(Color.TRANSPARENT);
                    mainActivity.mTextViewPricePerKg4.setBackgroundColor(Color.TRANSPARENT);
                    mainActivity.mTextViewPricePerKg5.setBackgroundColor(Color.TRANSPARENT);
                    TextView TextViewPriceMin = mainActivity.findViewById(ViewMin);
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
