package com.example.usuario.ejercicioaltaspersonas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class Mostrar extends AppCompatActivity {

    private ListView lista;
    private List<Persona> listaPersonas;
    private ArrayAdapter<Persona> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);

        findViewById(R.id.buttonVolver2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.buttonVolver2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Mostrar.this,MainActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });

        lista=(ListView)findViewById(R.id.list);
        listaPersonas=PersonaSingleton.getInstance().getListaPersonas();


        adapter=new ArrayAdapter <Persona> (this, android.R.layout.simple_list_item_2, android.R.id.text1, listaPersonas) {

            @Override
            public View getView(int position,
                                View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                TextView text1 = (TextView) view.findViewById(android.R.id.text1);
                TextView text2 = (TextView) view.findViewById(android.R.id.text2);

                text1.setText(listaPersonas.get(position).getName());

                text2.setText( listaPersonas.get(position).getSurname()+" "+ listaPersonas.get(position).getSurname2());

                return view;
            }

        };

        lista.setAdapter(adapter);



    }
}
