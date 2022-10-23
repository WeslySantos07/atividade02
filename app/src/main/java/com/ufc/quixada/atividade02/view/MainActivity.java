package com.ufc.quixada.atividade02.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.ufc.quixada.atividade02.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSegundaActivity = findViewById(R.id.bnt_Add);
        btnSegundaActivity.setOnClickListener(view -> startActivity(new Intent(this, MainActivity2.class)));

    }
}