package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login_act extends AppCompatActivity {

    private EditText nombre, contraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_act);

        nombre = (EditText)findViewById(R.id.nombre);
        contraseña = (EditText)findViewById(R.id.contraseña);

    }

    public void Iniciar(View v)
    {
        String usuario = nombre.getText().toString();
        String clave = contraseña.getText().toString();

        if(usuario.equalsIgnoreCase("android") && clave.equalsIgnoreCase("123"))
        {
            Intent i = new Intent(this, Menu_act.class);
            startActivity(i);
            finish();

        }else if(usuario.equalsIgnoreCase("Android") && clave.equalsIgnoreCase("123"))
        {
            Intent i = new Intent(this, Menu_act.class);
            startActivity(i);
            finish();
        }else{

            Toast.makeText(this, "Login incorrecto", Toast.LENGTH_SHORT).show();
        }


    }

}