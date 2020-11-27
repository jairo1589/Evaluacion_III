package com.example.pizzeria;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import Clases.Clientes;

public class ListadoClientes_act extends AppCompatActivity {

    private ListView list;
    private ArrayList<Clientes> listClientes = new ArrayList<Clientes>();

    FirebaseDatabase firebase;
    DatabaseReference databaseReference;

    Clientes clientesSelected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listadoclientes_act);
        inicializarBase();

        list = (ListView)findViewById(R.id.list);

        databaseReference.child("Clientes").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot objSnapshot : snapshot.getChildren())
                {
                    Clientes c = objSnapshot.getValue(Clientes.class);
                    listClientes.add(c);

                    ArrayAdapter adapt = new ArrayAdapter(getBaseContext(), android.R.layout.simple_list_item_1,listClientes);
                    list.setAdapter(adapt);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //metodo para seleccionar listview
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                clientesSelected = (Clientes) parent.getItemAtPosition(position);

            }
        });

    }
    public void Eliminar(View v)
    {
        Clientes c = new Clientes();
        c.setId(clientesSelected.getId());
        databaseReference.child("Clientes").child(c.getId()).removeValue();

        Toast.makeText(getBaseContext(),"Se ha eliminado", Toast.LENGTH_SHORT).show();
    }


    public void inicializarBase() {

        FirebaseApp.initializeApp(this);
        firebase = FirebaseDatabase.getInstance();
        databaseReference = firebase.getReference();
    }
}