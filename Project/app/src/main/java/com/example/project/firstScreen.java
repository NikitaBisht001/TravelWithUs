package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class firstScreen extends AppCompatActivity {

    //variables
    private String selectedcity, selectedstartPoint;
    private TextView tvcitySpinner, tvstartPtSpinner; //declaring textview to show the errors
    private Spinner citySpinner, startPointSpinner;

    //adapter- android sdk class to provide a datasource to fill list of items
    private ArrayAdapter<CharSequence> cityAdapter, startPointAdapter; //declaration

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);

        //citySpinner Initialization
        citySpinner = findViewById(R.id.cities_spinner);

        //populate arrayAdapter using string array and a spinner layout that we will define
        cityAdapter = ArrayAdapter.createFromResource(this, R.array.cities, R.layout.spinner_layout);

        //specify the layout to use when list of choices appear
        cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //set the adapter to the spinner to populate the cityAdapter
        citySpinner.setAdapter(cityAdapter);

        //when any item of city is selected
        citySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //define starting point but populate options through selected city
                startPointSpinner = findViewById(R.id.startPoint_spinner);

                //obtain the selected city
                selectedcity = citySpinner.getSelectedItem().toString();

                int parentID = parent.getId();
                if(parentID == R.id.cities_spinner){
                    switch(selectedcity){
                        case "Select your city": startPointAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_default_startingPoints, R.layout.spinner_layout);

                        break;
                        case "Dehradun": startPointAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_Dehradun, R.layout.spinner_layout);
                        break;
//                        case "Rishikesh": startPointAdapter = ArrayAdapter.createFromResource(parent.getContext(),
//                                R.array.array_Rishikesh, R.layout.spinner_layout);
//                        break;
                        default: break;

                    }
                    startPointAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                    //populate the starting points according to the selected city
                    startPointSpinner.setAdapter(startPointAdapter);

                    //To obtain the selected starting point from the startPointSpinner
                    startPointSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            selectedstartPoint = startPointSpinner.getSelectedItem().toString();
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                    Button submitButton;
                    submitButton = findViewById(R.id.button_next_gotoPlacesScreen);
                    tvcitySpinner = findViewById(R.id.textView3);
                    tvstartPtSpinner = findViewById(R.id.textView5);

                    submitButton.setOnClickListener(v-> {
                        if (selectedcity.equals("Select your city")) {
                            Toast.makeText(firstScreen.this, "Please select your city from the list", Toast.LENGTH_LONG).show();
                            tvcitySpinner.setError("City is required");   //Set error when submit is pressed without any state being selected
                            tvcitySpinner.requestFocus();
                        }
                        else if (selectedstartPoint.equals("Select your starting point")) {
                            Toast.makeText(firstScreen.this, "Please select your starting point from the list", Toast.LENGTH_LONG).show();
                            tvstartPtSpinner.setError("District is required");
                            tvstartPtSpinner.requestFocus();
                            tvcitySpinner.setError(null);   //Remove error from TextView of City
                        }
                        else {
                            tvstartPtSpinner.setError(null);
                            tvcitySpinner.setError(null);
                            Intent intent = new Intent(firstScreen.this, places_to_visit_screen.class);
                            intent.putExtra("keycity",selectedcity);
                            intent.putExtra("keyStart",selectedstartPoint);
                            startActivity(intent);
//
                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}