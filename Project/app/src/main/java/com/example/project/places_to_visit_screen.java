package com.example.project;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import android.view.View;

import java.util.ArrayList;


public class places_to_visit_screen extends AppCompatActivity {
//    ArrayList<String> selectedPlaces;
    CheckBox cb1, cb2, cb3, cb4,cb5;
    Button btnNext;
    private TextView location;
    String selectedStartPoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getSupportActionBar().hide();
        setContentView(R.layout.places_to_visit_screen);

        location = findViewById(R.id.textViewlocation);
        String selectedCity = getIntent().getStringExtra("keycity");
        selectedStartPoint=getIntent().getStringExtra("keyStart");
        location.setText(selectedCity);

        cb1 = findViewById(R.id.checkbox1);
        cb2 = findViewById(R.id.checkbox2);
        cb3 = findViewById(R.id.checkbox3);
        cb4 = findViewById(R.id.checkbox4);
        cb5 = findViewById(R.id.checkbox5);
        btnNext  =findViewById(R.id.buttonGoToMap);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> selectedPlaces = new ArrayList<String>();
//
                if(cb1.isChecked()){
                    selectedPlaces.add(cb1.getText().toString());
                }
                if(cb2.isChecked()){
                    selectedPlaces.add(cb2.getText().toString());
                }
                if(cb3.isChecked()){
                    selectedPlaces.add(cb3.getText().toString());
                }
                if(cb4.isChecked()){
                    selectedPlaces.add(cb4.getText().toString());
                }
                if(cb5.isChecked()){
                    selectedPlaces.add(cb5.getText().toString());
                }
                if(!cb1.isChecked() && !cb2.isChecked() && !cb3.isChecked() && !cb4.isChecked() && !cb5.isChecked())
                    selectedPlaces.add("none");
                Intent intent = new Intent(places_to_visit_screen.this, MapsActivity.class);
                intent.putExtra("keySelectedPlaces", selectedPlaces);
                intent.putExtra("keyStart",selectedStartPoint);
                startActivity(intent);

            }
        });

        cb1.setOnCheckedChangeListener(new MyCheckedChangeListener());
        cb2.setOnCheckedChangeListener(new MyCheckedChangeListener());

    }//onCreate ends
    class MyCheckedChangeListener implements CompoundButton.OnCheckedChangeListener{
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(buttonView == cb1){
                if(isChecked)
                    Log.d("CheckBox1", "Checked");
                else
                    Log.d("CheckBox1", "Uncheched");
            }
            if(buttonView == cb2){
                if(isChecked)
                    Log.d("CheckBox2", "Checked");
                else
                    Log.d("CheckBox2", "Uncheched");
            }
        }
    }

    public void onCheckBoxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()){
            case R.id.checkbox1:
                if(checked)
                    Log.d("CheckBox1", "Checked");
                else
                    Log.d("CheckBox1", "Uncheched");
                break;
            case R.id.checkbox2:
                if(checked)
                    Log.d("CheckBox2", "Checked");
                else
                    Log.d("CheckBox2", "Uncheched");
                break;
            case R.id.checkbox3:
                if(checked)
                    Log.d("CheckBox3", "Checked");
                else
                    Log.d("CheckBox3", "Uncheched");
                break;
            case R.id.checkbox4:
                if(checked)
                    Log.d("CheckBox4", "Checked");
                else
                    Log.d("CheckBox4", "Uncheched");
                break;
            case R.id.checkbox5:
                if(checked)
                    Log.d("CheckBox5", "Checked");
                else
                    Log.d("CheckBox5", "Uncheched");
                break;
        }
    }




}