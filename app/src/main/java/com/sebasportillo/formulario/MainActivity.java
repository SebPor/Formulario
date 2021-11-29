package com.sebasportillo.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etNombre = findViewById(R.id.etNombre);
        EditText etApellido = findViewById(R.id.etApellidos);
        EditText etCorreo = findViewById(R.id.etCorreo);
        EditText etComentario = findViewById(R.id.etComentario);

        CheckBox cbJava = findViewById(R.id.cbLenguajeProgramacion1);
        CheckBox cbC = findViewById(R.id.cbLenguajeProgramacion2);
        CheckBox cbJavaScript = findViewById(R.id.cbLenguajeProgramacion3);

        RadioButton rbHombre = findViewById(R.id.rbGenero1);
        RadioButton rbMujer = findViewById(R.id.rbGenero2);
        RadioButton rbOtro = findViewById(R.id.rbGenero3);

        TextView tvGenero = findViewById(R.id.tvGenero);
        TextView tvLenguaje = findViewById(R.id.tvLenguajeProgramacion);
        TextView tvHombre = findViewById(R.id.tvGenero1);
        TextView tvMujer = findViewById(R.id.tvGenero2);
        TextView tvOtro = findViewById(R.id.tvGenero3);
        TextView tvJava = findViewById(R.id.tvLenguajeProgramacion1);
        TextView tvC = findViewById(R.id.tvLenguajeProgramacion2);
        TextView tvJavaScript = findViewById(R.id.tvLenguajeProgramacion3);

        Button btnEnviar = findViewById(R.id.btnEnviar);
        Button btnBorrar = findViewById(R.id.btnBorrar);

        btnBorrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                etNombre.setText("");
                etApellido.setText("");
                etCorreo.setText("");
                etComentario.setText("");

                cbJava.setChecked(false);
                cbC.setChecked(false);
                cbJavaScript.setChecked(false);

                rbHombre.setChecked(false);
                rbMujer.setChecked(false);
                rbOtro.setChecked(false);
            }
        });

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Datos Enviados", Toast.LENGTH_SHORT).show();
                btnBorrar.callOnClick();
            }
        });

        etComentario.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b) {
                    etComentario.setGravity(Gravity.NO_GRAVITY);
                }else if(etComentario.getText().length() == 1){
                    etComentario.setGravity(Gravity.CENTER);
                }
                System.out.println(etComentario.getText());
            }
        });

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton radioButton = (RadioButton) view;
                if(R.id.rbGenero1 == radioButton.getId()){
                    rbMujer.setChecked(false);
                    rbOtro.setChecked(false);
                }else if(R.id.rbGenero2 == radioButton.getId()){
                    rbHombre.setChecked(false);
                    rbOtro.setChecked(false);
                }else{
                    rbHombre.setChecked(false);
                    rbMujer.setChecked(false);
                }
            }
        };

        rbHombre.setOnClickListener(listener);
        rbMujer.setOnClickListener(listener);
        rbOtro.setOnClickListener(listener);

    }
}