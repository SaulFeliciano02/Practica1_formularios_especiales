package com.example.practica1_formularios_especiales;

import android.app.Activity;
import android.content.Intent;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Intent intent = getIntent();
        TextView lblResNombre = findViewById(R.id.lbl_resnombre);
        lblResNombre.setText(intent.getStringExtra("Nombre"));

        TextView lblResApellido = findViewById(R.id.lbl_resapellido);
        lblResApellido.setText(intent.getStringExtra("Apellido"));

        TextView lblResFecha = findViewById(R.id.lbl_resnacimiento);
        lblResFecha.setText(intent.getStringExtra("Fecha"));

        TextView lblResGenero = findViewById(R.id.lbl_resgenero);
        lblResGenero.setText(intent.getStringExtra("Genero"));

        TextView lblResGustar = findViewById(R.id.lbl_resprogramar);
        lblResGustar.setText(intent.getStringExtra("Gustar"));

        TableLayout tableLenguajes = findViewById(R.id.table_lenguajes);

        ArrayList<String> lenguajes = intent.getStringArrayListExtra("Lenguajes");

        TableRow.LayoutParams  params1=new TableRow.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT,1.0f);
        TableRow.LayoutParams params2=new TableRow.LayoutParams(TableLayout.LayoutParams.FILL_PARENT, TableLayout.LayoutParams.WRAP_CONTENT);

        for (String lenguaje: lenguajes
             ) {
            TableRow row = new TableRow(this);
            TextView leng = new TextView(this);
            leng.setText(lenguaje);
            leng.setLayoutParams(params1);
            row.addView(leng);
            row.setLayoutParams(params2);
            tableLenguajes.addView(row);
        }
    }
}