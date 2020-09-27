package com.example.practica1_formularios_especiales;

import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private RadioGroup rbtnGrupo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TextView que nos mostrará que RadioButton está checked

        rbtnGrupo = (RadioGroup)findViewById(R.id.rbtn_group);
    }
}