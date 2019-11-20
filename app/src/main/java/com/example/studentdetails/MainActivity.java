package com.example.studentdetails;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private AutoCompleteTextView batch;

    private String[] Batch={"21","22","23","24"};

    EditText etName;
    RadioGroup rgGender;
    RadioButton rdoMale, rdoFemale, rdoOthers;
    TextView disName,disGender,disCountry,disBatch;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner=findViewById(R.id.CountrySpin);

        batch = findViewById(R.id.batch);

        String  countries[]={"Nepal","India","Pakistan","Bangladesh"};
        ArrayAdapter adapter=new ArrayAdapter<>(
                 this,
        android.R.layout.simple_list_item_1, countries
        );
        spinner.setAdapter(adapter);

        ArrayAdapter<String> stringArrayAdapter=new ArrayAdapter<>(
                this,android.R.layout.select_dialog_item,Batch);

        batch.setAdapter(stringArrayAdapter);
        batch.setThreshold(1);

        disBatch=findViewById(R.id.disbatch);
        disGender=findViewById(R.id.disgender);
        disCountry=findViewById(R.id.discountry);
        disName=findViewById(R.id.disname);
        etName = findViewById(R.id.etName);
        rgGender = findViewById(R.id.rgGender);
        rdoMale = findViewById(R.id.rdoMale);
        rdoFemale = findViewById(R.id.rdoFemale);
        rdoOthers = findViewById(R.id.rdoOthers);
        spinner = findViewById(R.id.CountrySpin);
        batch = findViewById(R.id.batch);
        btnSave = findViewById(R.id.btnsave);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedId = rgGender.getCheckedRadioButtonId();
                RadioButton button;
                button =findViewById(selectedId);
                disGender.setText(button.getText());

                disName.setText(etName.getText());
                disBatch.setText(batch.getText());
                disCountry.setText(spinner.getSelectedItem().toString());

            }
        });
    }
}
