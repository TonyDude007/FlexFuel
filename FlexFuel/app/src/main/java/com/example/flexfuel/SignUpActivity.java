package com.example.flexfuel;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SignUpActivity extends AppCompatActivity {

    Context context;
    TextView welcomeMsg;
    EditText name;
    EditText email;
    EditText password;
    Spinner sexSpinner;
    Spinner ageSpinner;
    Spinner conversionWeightSpinner;
    Spinner conversionHeightSpinner;
    Spinner weightSpinner;
    Spinner heightSpinner;
    Button signUp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_page);

        context = this;

        welcomeMsg = findViewById(R.id.welcomeMsg);

        name = findViewById(R.id.editTextName);
        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // This method is called before the text is changed.
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                welcomeMsg.setText("Welcome " + name.getText());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // This method is called after the text is changed.
            }
        });

        email = findViewById(R.id.editTextEmail);
        password = findViewById(R.id.editTextPassword);

        sexSpinner = findViewById(R.id.spinnerSex);
        ageSpinner = findViewById(R.id.spinnerAge);
        conversionHeightSpinner = findViewById(R.id.spinnerDistanceConversion);
        conversionWeightSpinner = findViewById(R.id.spinnerWeightConversion);
        weightSpinner = findViewById(R.id.spinnerWeight);
        heightSpinner = findViewById(R.id.spinnerHeight);

        ArrayList<String> ageList = new ArrayList<>();
        for (int i = 14; i <= 120; i++) {
            ageList.add(i - 14,i + " Years Old");
        }

        ArrayAdapter<String> ageAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, ageList);
        ageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ageSpinner.setAdapter(ageAdapter);

        conversionWeightSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                ArrayList<String> values = new ArrayList<>();
                    int num = 0;
                    double conversion = 1;

                    if (selectedItem.equals("Kg")) {
                        conversion = 2.2;
                    }

                    for (int i = 0; i < 40; i++) {
                        double num1 = (num + 1) / conversion;
                        String number1 = String.format("%.1f",num1);
                        double num2 = (num + 10) / conversion;
                        String number2 = String.format("%.1f",num2);
                        values.add(i, number1 + " - " + number2 + " " + selectedItem);
                        num = num + 10;
                    }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, values);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                weightSpinner.setAdapter(adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Handle the case when nothing is selected
            }
        });

        conversionHeightSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                ArrayList<String> values = new ArrayList<>();

                if (selectedItem.equals("Inches")) {
                int index = 0;
                for (int i = 2; i < 9; i++) {

                        for (int j = 0; j < 12; j++) {
                            values.add(index, i + " Feet " + j + " Inches ");
                            index++;
                        }
                    }
                } else {
                    int num1 = 60;
                    for (int i = 0; i < 22; i++) {
                        values.add(i, (num1) + " - " + (num1 = num1 + 10) + " " + selectedItem);
                    }
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, values);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                heightSpinner.setAdapter(adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Handle the case when nothing is selected
            }
        });

        signUp = findViewById(R.id.SignUpBtn);
        signUp.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {
                // Create an AlertDialog Builder
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                // Inflate the custom layout
                View customView = getLayoutInflater().inflate(R.layout.sign_up_popup, null);
                builder.setView(customView);

                ImageView gifPopUp = customView.findViewById(R.id.urGoalGif);

                builder.setView(customView);

                Button finishBtn = customView.findViewById(R.id.finishBtn);
                finishBtn.setOnClickListener(v1 -> {
                    Toast.makeText(context,"Finished",Toast.LENGTH_LONG).show();
                });

                // Create and show the AlertDialog
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }
}