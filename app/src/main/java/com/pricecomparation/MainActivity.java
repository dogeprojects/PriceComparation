package com.pricecomparation;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.os.VibrationEffect;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

//TODO implement dynamic adding and removing items

public class MainActivity extends AppCompatActivity {

    EditText mEditTextPrice1, mEditTextPrice2, mEditTextPrice3, mEditTextPrice4, mEditTextPrice5;
    EditText mEditTextWeight1, mEditTextWeight2, mEditTextWeight3, mEditTextWeight4, mEditTextWeight5;
    EditText mEditTextProduct1, mEditTextProduct2, mEditTextProduct3, mEditTextProduct4, mEditTextProduct5;
    TextView mTextViewPricePerKg1, mTextViewPricePerKg2, mTextViewPricePerKg3, mTextViewPricePerKg4, mTextViewPricePerKg5;
    CardView cardViewC4, cardViewC5;
    final int defaultVibrationEffect = 20;

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

        mEditTextPrice1.addTextChangedListener(new TextChangeWatcher(this));
        mEditTextWeight1.addTextChangedListener(new TextChangeWatcher(this));

        mEditTextPrice2.addTextChangedListener(new TextChangeWatcher(this));
        mEditTextWeight2.addTextChangedListener(new TextChangeWatcher(this));

        mEditTextPrice3.addTextChangedListener(new TextChangeWatcher(this));
        mEditTextWeight3.addTextChangedListener(new TextChangeWatcher(this));

        mEditTextPrice4.addTextChangedListener(new TextChangeWatcher(this));
        mEditTextWeight4.addTextChangedListener(new TextChangeWatcher(this));

        mEditTextPrice5.addTextChangedListener(new TextChangeWatcher(this));
        mEditTextWeight5.addTextChangedListener(new TextChangeWatcher(this));

        cardViewC4.setVisibility(View.INVISIBLE);
        cardViewC5.setVisibility(View.INVISIBLE);

        //TODO Show change log by click on toolbar
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    // Hide textEdit button handle
    public void onButtonHideClick(MenuItem item) {
        int visibility = cardViewC4.getVisibility() == View.INVISIBLE ? View.VISIBLE : View.INVISIBLE;
        cardViewC4.setVisibility(visibility);
        cardViewC5.setVisibility(visibility);

        //Clear fields after hiding
        clearFields(mEditTextProduct4, mEditTextPrice4, mEditTextWeight4, mTextViewPricePerKg4);
        clearFields(mEditTextProduct5, mEditTextPrice5, mEditTextWeight5, mTextViewPricePerKg5);

        vibrateDevice();
    }

    private void clearFields(EditText editTextProduct, EditText editTextPrice, EditText editTextWeight, TextView textViewPricePerKg) {
        editTextProduct.setText(null);
        editTextPrice.setText(null);
        editTextWeight.setText(null);
        textViewPricePerKg.setText(null);
    }

    // Change theme button handle
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.change_theme) {
            // Save state
            SharedPreferences mPrefs = getSharedPreferences("THEME", 0);
            boolean theme_boolean = mPrefs.getBoolean("theme_boolean", true);
            // Change theme
            theme_boolean = !theme_boolean;

            SharedPreferences.Editor mEditor = mPrefs.edit();
            mEditor.putBoolean("theme_boolean", theme_boolean).apply();
            recreate();

            vibrateDevice();
        }

        if (item.getItemId() == R.id.clear_button) {
            for (int i = 1; i <= 5; i++) {
                EditText productEditText = findViewById(getResources().getIdentifier("editTextProduct" + i, "id", getPackageName()));
                EditText priceEditText = findViewById(getResources().getIdentifier("editTextPrice" + i, "id", getPackageName()));
                EditText weightEditText = findViewById(getResources().getIdentifier("editTextWeight" + i, "id", getPackageName()));
                TextView pricePerKgTextView = findViewById(getResources().getIdentifier("textViewPricePerKg" + i, "id", getPackageName()));

                productEditText.setText("");
                priceEditText.setText("");
                weightEditText.setText("");
                pricePerKgTextView.setText("");
                pricePerKgTextView.setBackgroundColor(Color.TRANSPARENT);
            }

            vibrateDevice();
        }

        return true;
    }

    private void vibrateDevice() {
        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        if (vibrator == null || !vibrator.hasVibrator()) {
            return; // The device does not support vibration
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            VibrationEffect vibrationEffect = VibrationEffect.createOneShot(defaultVibrationEffect, VibrationEffect.DEFAULT_AMPLITUDE);
            vibrator.vibrate(vibrationEffect);
        } else {
            vibrator.vibrate(defaultVibrationEffect); // For devices below Android Oreo
        }
    }

}
