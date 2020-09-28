package com.example.practica1_formularios_especiales;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RadioGroup rbtnGrupo;
    private EditText txtNombre;
    private Button btnLimpiar;
    private Button btnEnviar;
    private EditText txtApellido;
    private EditText fecha;
    private Spinner genero;
    private RadioButton si;
    private RadioButton no;
    private CheckBox java;
    private CheckBox csharp;
    private CheckBox cobol;
    private CheckBox js;
    private CheckBox python;
    private CheckBox go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rbtnGrupo = findViewById(R.id.rbtn_group);
        txtNombre = findViewById(R.id.FirstName);
        txtApellido = findViewById(R.id.LastName);
        fecha = findViewById(R.id.et_mostrar_fecha_picker);
        genero = findViewById(R.id.spn_genero);
        si = findViewById(R.id.rbtn_1);
        no = findViewById(R.id.rbtn_2);
        java = findViewById(R.id.cbx_java);
        csharp = findViewById(R.id.cbx_csharp);
        go = findViewById(R.id.cbx_go);
        python = findViewById(R.id.cbx_python);
        cobol = findViewById(R.id.cbx_cobol);
        js = findViewById(R.id.cbx_js);

        btnLimpiar = findViewById(R.id.btn_limpiar);
        btnLimpiar.setOnClickListener(this);
        btnEnviar = findViewById(R.id.btn_enviar);
        btnEnviar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_limpiar:
                txtNombre.getText().clear(); //or you can use editText.setText("");
                txtApellido.getText().clear();
                fecha.getText().clear();
                genero.setSelection(0);
                si.setChecked(true);
                if(java.isChecked()){
                    java.toggle();
                }
                if(csharp.isChecked()){
                    csharp.toggle();
                }
                if(go.isChecked()){
                    go.toggle();
                }
                if(python.isChecked()){
                    python.toggle();
                }
                if(cobol.isChecked()){
                    cobol.toggle();
                }
                if(js.isChecked()){
                    js.toggle();
                }
                break;
            case R.id.btn_enviar:
                Intent intent = new Intent(getApplicationContext(), ResultsActivity.class);
                intent.putExtra("Nombre", txtNombre.getText().toString());
                intent.putExtra("Apellido", txtApellido.getText().toString());
                intent.putExtra("Fecha", fecha.getText().toString());
                intent.putExtra("Genero", genero.getSelectedItem().toString());
                ArrayList<String> lenguajes = new ArrayList<>();
                if (si.isChecked())
                {
                    intent.putExtra("Gustar", "Si");
                }
                else {
                    intent.putExtra("Gustar", "No");
                }
                if(java.isChecked())
                {
                    lenguajes.add("Java");
                }
                if(csharp.isChecked())
                {
                    lenguajes.add("C#");
                }
                if (cobol.isChecked())
                {
                    lenguajes.add("Cobol");
                }
                if (go.isChecked())
                {
                    lenguajes.add("Go");
                }
                if (python.isChecked())
                {
                    lenguajes.add("Python");
                }
                if (js.isChecked())
                {
                    lenguajes.add("JS");
                }
                intent.putExtra("Lenguajes", lenguajes);
                startActivity(intent);
        }
    }
}