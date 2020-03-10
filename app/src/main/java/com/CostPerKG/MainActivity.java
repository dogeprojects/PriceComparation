package com.CostPerKG;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

/*        SharedPreferences mPrefs = getSharedPreferences("THEME", 0);
        boolean theme_boolean = mPrefs.getBoolean("theme_boolean", true);
        if (theme_boolean) {
            setTheme(R.style.LightTheme);
        }
        else {
            setTheme(R.style.LightTheme);
        }

        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.DarkTheme);
        } else {
            setTheme(R.style.LightTheme);
        }*/

        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        EditText editTextPrice1 = findViewById(R.id.editTextPrice1);
        EditText editTextWeight1 = findViewById(R.id.editTextWeight1);
        EditText editTextPrice2 = findViewById(R.id.editTextPrice2);
        EditText editTextWeight2 = findViewById(R.id.editTextWeight2);
        EditText editTextPrice3 = findViewById(R.id.editTextPrice3);
        EditText editTextWeight3 = findViewById(R.id.editTextWeight3);

        editTextPrice1.addTextChangedListener(new TextChangeWatcher());
        editTextWeight1.addTextChangedListener(new TextChangeWatcher());

        editTextPrice2.addTextChangedListener(new TextChangeWatcher());
        editTextWeight2.addTextChangedListener(new TextChangeWatcher());

        editTextPrice3.addTextChangedListener(new TextChangeWatcher());
        editTextWeight3.addTextChangedListener(new TextChangeWatcher());

        //buttonCalculate.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       // getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.change_theme) {
            /*Intent intent = new Intent(this, SearchUsersActivity.class);
             * startActivity(intent);*/
/*            boolean theme_boolean = true;
            
            if (theme_boolean) {
                // Set theme to black
                theme_boolean = false;
            } else {
                // Set theme to white
                theme_boolean = true;
            }
            SharedPreferences mPrefs = getSharedPreferences("THEME", 0);
            SharedPreferences.Editor mEditor = mPrefs.edit();
            mEditor.putBoolean("theme_boolean", theme_boolean).commit();*/

/*
            setTheme(R.style.DarkTheme);
            if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
*/

            finish();
            startActivity(new Intent(MainActivity.this, MainActivity.this.getClass()));

            Toast toast = Toast.makeText(getApplicationContext(),
                    "Theme successfully changed",
                    Toast.LENGTH_SHORT);
            toast.show();
        }
        return true;
    }

/*    @SuppressLint("DefaultLocale")
    public void onClick(View v){

        // ------------------- The first product --------------------
        EditText editTextPrice1 = findViewById(R.id.editTextPrice1);
        TextView editTextWeight1 = findViewById(R.id.editTextWeight1);
        TextView textViewPricePerKg1 = findViewById(R.id.textViewPricePerKg1);

        if ((editTextPrice1.getText().toString().equals("."))
                || editTextWeight1.getText().toString().equals(".")
                || editTextWeight1.getText().toString().equals("0")) {
            textViewPricePerKg1.setText("0.00");
        }
        else if ((editTextPrice1.getText().toString().isEmpty()
                ||(editTextWeight1.getText().toString().isEmpty())))
        {
            textViewPricePerKg1.setText("");
        }
        else
        {
            float mPrice1 = Float.parseFloat(editTextPrice1.getText().toString());
            float mWeight1 = Float.parseFloat(editTextWeight1.getText().toString());
            textViewPricePerKg1.setText(String.format("%.2f", mPrice1 * 1000 / mWeight1));
        }

        // ------------------- The second product -------------------
        EditText editTextPrice2 = findViewById(R.id.editTextPrice2);
        TextView editTextWeight2 = findViewById(R.id.editTextWeight2);
        TextView textViewPricePerKg2 = findViewById(R.id.textViewPricePerKg2);

        if ((editTextPrice2.getText().toString().equals("."))
                || editTextWeight2.getText().toString().equals(".")
                || editTextWeight2.getText().toString().equals("0")) {
            textViewPricePerKg2.setText("0.00");
        }
        else if ((editTextPrice2.getText().toString().isEmpty()
                ||(editTextWeight2.getText().toString().isEmpty())))
        {
            textViewPricePerKg2.setText("");
        }
        else
        {
            float mPrice2 = Float.parseFloat(editTextPrice2.getText().toString());
            float mWeight2 = Float.parseFloat(editTextWeight2.getText().toString());
            textViewPricePerKg2.setText(String.format("%.2f", mPrice2 * 1000 / mWeight2));
        }

        // ------------------- The third product -------------------
        EditText editTextPrice3 = findViewById(R.id.editTextPrice3);
        TextView editTextWeight3 = findViewById(R.id.editTextWeight3);
        TextView textViewPricePerKg3 = findViewById(R.id.textViewPricePerKg3);

        if ((editTextPrice3.getText().toString().equals("."))
                || editTextWeight3.getText().toString().equals(".")
                || editTextWeight3.getText().toString().equals("0")) {
            textViewPricePerKg3.setText("0.00");
        }
        else if ((editTextPrice3.getText().toString().isEmpty()
                ||(editTextWeight3.getText().toString().isEmpty())))
        {
            textViewPricePerKg3.setText("");
        }
        else
        {
            float mPrice3 = Float.parseFloat(editTextPrice3.getText().toString());
            float mWeight3 = Float.parseFloat(editTextWeight3.getText().toString());
            textViewPricePerKg3.setText(String.format("%.2f", mPrice3 * 1000 / mWeight3));
        }

    }*/

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

        TextChangeWatcher() {
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

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
        }
    }
}


