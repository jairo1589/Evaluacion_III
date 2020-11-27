package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

import Clases.Clientes;

public class Firebase_act extends AppCompatActivity {
    private EditText ednombre, eddestino, edpromocion;
    private Button btn;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_act);
        ednombre = (EditText) findViewById(R.id.etnombre);
        eddestino = (EditText) findViewById(R.id.etdestino);
        edpromocion = (EditText) findViewById(R.id.etpromocion);
        btn = (Button) findViewById(R.id.button);

        InicializarFirebase();

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (!ednombre.equals("")) {
                    Clientes p = new Clientes();

                    p.setId(UUID.randomUUID().toString());
                    p.setNombre(ednombre.getText().toString());
                    p.setPromocion(edpromocion.getText().toString());
                    p.setDestino(eddestino.getText().toString());

                    databaseReference.child("Clientes").child(p.getId()).setValue(p);

                    Toast.makeText(getBaseContext(), "se ha guardado !!", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(getBaseContext(), "No se ha guardado", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
    public void InicializarFirebase() {

        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    public void Listado(View v)
    {
        Intent i = new Intent (this, ListadoClientes_act.class);
        startActivity(i);
    }


}