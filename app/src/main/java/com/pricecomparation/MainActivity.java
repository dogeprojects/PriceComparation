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
import android.widget.Toast;

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
    int defaultVibrationEffect = 20;

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
            //Toast.makeText(this, R.string.FieldsShown, Toast.LENGTH_SHORT).show();
        } else {
            cardViewC4.setVisibility(View.INVISIBLE);
            cardViewC5.setVisibility(View.INVISIBLE);
            //Toast.makeText(this, R.string.FieldsHidden, Toast.LENGTH_SHORT).show();

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
        vibrateDevice();
    }

    // Change theme button handle
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.change_theme) {
            // Invert the theme_boolean value
            boolean theme_boolean = !getSharedPreferences("THEME", Context.MODE_PRIVATE).getBoolean("theme_boolean", true);

            // Update the theme_boolean value in SharedPreferences
            getSharedPreferences("THEME", Context.MODE_PRIVATE).edit().putBoolean("theme_boolean", theme_boolean).apply();

            recreate();
            vibrateDevice();
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
