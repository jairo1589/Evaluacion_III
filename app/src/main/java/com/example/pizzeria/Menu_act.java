package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class Menu_act extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_act);
    }

    public void promociones (View v)
    {

        ArrayList<String> listaClientes = new ArrayList<String>();

        listaClientes.add("Robert");
        listaClientes.add("Ramiro");
        listaClientes.add("Rosa");

        Intent i = new Intent (this, Promociones_act.class);
        i.putExtra("listaClientes", listaClientes);
        startActivity(i);

    }

    public void Gestion (View v){

        Intent i = new Intent (this, Firebase_act.class);
        startActivity(i);

    }
}