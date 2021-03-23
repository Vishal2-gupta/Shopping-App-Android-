package com.example.testca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText Title;
    Button ADD;
    EditText Author;
    ArrayList a1;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Title = findViewById(R.id.et1);
        Author = findViewById(R.id.et2);
        ADD = findViewById(R.id.add);
        lv=findViewById(R.id.lv1);

        a1=new ArrayList();
        a1.add("English");
        a1.add("Spanish");
        a1.add("Hindi");
        a1.add("Punjabi");
        ArrayAdapter ab=new ArrayAdapter(this,android.R.layout.simple_list_item_1,a1);
        lv.setAdapter(ab);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
        ADD.setEnabled(false);

        Title.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().equals("")){
                    ADD.setEnabled(false);
                }
                else
                    ADD.setEnabled(true);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        ADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!Title.getText().toString().isEmpty() && !Author.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Added the record", Toast.LENGTH_LONG).show();}
            }
        });
    }

}