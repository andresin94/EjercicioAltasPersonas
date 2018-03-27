package com.example.usuario.ejercicioaltaspersonas;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Formulario extends AppCompatActivity {
    private EditText nombre;
    private EditText apellido1;
    private EditText apellido2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        nombre = (EditText) findViewById(R.id.nombreEditText);
        apellido1 = (EditText) findViewById(R.id.apellidoEditText);
        apellido2 = (EditText) findViewById(R.id.apellido2EditText);

        findViewById(R.id.buttonConfirmar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(Formulario.this);
                alert.setMessage("¿Quieres confirmar el alta?");
                alert.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        PersonaSingleton.getInstance().add(new Persona(nombre.getText().toString(), apellido1.getText().toString(),apellido2.getText().toString()));
                        finish();
                    }
                });

                alert.setNegativeButton(android.R.string.cancel, null);
                alert.setCancelable(false);

                alert.show();
            }
        });

        findViewById(R.id.buttonVolver).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent (Formulario.this, MainActivity.class);
                //startActivity(intent);
                finish();
            }
        });

    }

}
