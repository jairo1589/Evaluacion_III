package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import Clases.Promocion;

public class Promociones_act extends AppCompatActivity {

    private TextView resultado,saldo_final;
    private EditText promocion, envio;
    private Spinner clientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promociones_act);

        saldo_final= (TextView)findViewById(R.id.saldo);
        resultado= (TextView)findViewById(R.id.resultado);
        promocion= (EditText)findViewById(R.id.promocion);
        envio= (EditText)findViewById(R.id.envio);
        clientes = (Spinner)findViewById(R.id.spinner);

        ArrayList<String> listaClientes = (ArrayList<String>) getIntent().getSerializableExtra("listaClientes");

        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listaClientes);


        clientes.setAdapter(adapt);

    }


    public void Calcular(View v)
    {
        Promocion pl = new Promocion();


        int saldo = Integer.parseInt(envio.getText().toString());
        String cliente = clientes.getSelectedItem().toString();

        int resultNormal = pl.getMaster() + saldo;
        int resultPremium = pl.getMax() + saldo;
        int resultpro = pl.getPromo() + saldo;

        String promo = promocion.getText().toString();


        if(saldo <= 0)
        {
            Toast.makeText(this, "Ingrese saldo de envio correctamente", Toast.LENGTH_SHORT).show();
        }

        if(promo.equals("Master Pizza"))
        {
            resultado.setText("Estimado " + cliente + " el valor final es de " + resultNormal);

        }else if(promo.equals("Master Pizza")){

            resultado.setText("Estimado " + cliente + " el valor final es de " + resultNormal);

        }

        if(promo.equals("Pizza Max"))
        {
            resultado.setText("Estimado " + cliente + " el valor final es de " + resultPremium);

        }else if(promo.equals("pizza max")){

            resultado.setText("Estimado " + cliente + " el valor final es de " + resultPremium);

        }


        if(promo.equals("Pizzas Promo"))
        {
            resultado.setText("Estimado " + cliente + " el valor final es de " + resultpro);

        }else if(promo.equals("pizzas promo")){

            resultado.setText("Estimado " + cliente + " el valor final es de " + resultpro);

        }

    }
}