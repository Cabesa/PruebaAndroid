package com.example.aleja.proyecto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Restaurantes extends AppCompatActivity {

    private String restaurantes[];
    private Spinner lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurantes);
        restaurantes=getResources().getStringArray(R.array.sevillaLista);
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item, restaurantes);
        lista=(Spinner)findViewById(R.id.spinRestaurantes);
        lista.setAdapter(spinnerArrayAdapter);
    }
    public void pulsarFotos(View v)
    {
        Intent i = new Intent(this, Fotos.class );
        startActivity(i);
    }
    public void pulsarProductos(View v)
    {
        Intent i = new Intent(this, Productos.class );
        startActivity(i);
    }
}
