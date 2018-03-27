package com.example.usuario.ejercicioaltaspersonas;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.List;
import java.util.logging.SimpleFormatter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            FileInputStream fileInputStream = new FileInputStream("personas.txt");
            ObjectInputStream x = new ObjectInputStream(fileInputStream);
            List<Persona> datos = (List) x.readObject();
            x.close();

            PersonaSingleton.getInstance().setListaPersonas(datos);



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



        findViewById(R.id.buttonAltas).setOnClickListener(this);
        findViewById(R.id.buttonLeer).setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent intent=null;
        switch (v.getId()) {
            case R.id.buttonAltas:
                intent = new Intent(this, Formulario.class);
                break;

            case R.id.buttonLeer:
                intent = new Intent(this, Mostrar.class);
                break;

        }
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"onDestroy",Toast.LENGTH_SHORT).show();
        try {
            FileOutputStream fileOutputStream = openFileOutput("personas.txt", MODE_APPEND);
            ObjectOutputStream x = new ObjectOutputStream(fileOutputStream);
            x.writeObject(PersonaSingleton.getInstance().getListaPersonas());
            SimpleFormatter y= new SimpleFormatter();
            x.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
