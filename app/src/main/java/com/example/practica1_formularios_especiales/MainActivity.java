package com.example.practica1_formularios_especiales;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
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
        fecha.setOnClickListener(this);
        no.setOnClickListener(this);
        si.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rbtn_2:
                java.setEnabled(false);
                csharp.setEnabled(false);
                js.setEnabled(false);
                python.setEnabled(false);
                cobol.setEnabled(false);
                go.setEnabled(false);
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
            case R.id.rbtn_1:
                java.setEnabled(true);
                csharp.setEnabled(true);
                js.setEnabled(true);
                python.setEnabled(true);
                cobol.setEnabled(true);
                go.setEnabled(true);
                break;
            case R.id.et_mostrar_fecha_picker:
                showDatePickerDialog();
                break;
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
                if (TextUtils.isEmpty(txtNombre.getText()))
                {
                    txtNombre.setText("Requerido");
                }
                if (TextUtils.isEmpty(txtApellido.getText()))
                {
                    txtApellido.setText("Requerido");
                }
                if (genero.getSelectedItemPosition() == 0)
                {
                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                    alertDialog.setTitle("Alerta");
                    alertDialog.setMessage("El genero debe ser expecificado");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }
                if (si.isChecked() && !java.isChecked() && !cobol.isChecked() && !csharp.isChecked() && !js.isChecked() && !python.isChecked() && !go.isChecked())
                {
                        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                        alertDialog.setTitle("Alerta");
                        alertDialog.setMessage("Jablador, a ti no te gusta na!");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();
                }
                else
                {
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
                break;
        }
    }

    private void showDatePickerDialog() {
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                // +1 because January is zero
                final String selectedDate = day + " / " + (month+1) + " / " + year;
                fecha.setText(selectedDate);
            }
        });

        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
}