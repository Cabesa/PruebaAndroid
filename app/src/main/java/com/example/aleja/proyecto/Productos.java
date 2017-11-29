package com.example.aleja.proyecto;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class Productos extends AppCompatActivity {

    private String lenguajeProgramacion[];
    private String descripciones[];
    private Integer[] imgid={
            R.drawable.hamburguesa,
            R.drawable.ravioles,
            R.drawable.pizza,

    };
    public EditText buscador;
    private ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);
        buscador =(EditText)findViewById(R.id.txtBuscador);
        lenguajeProgramacion=getResources().getStringArray(R.array.opcionesLista);
        descripciones=getResources().getStringArray(R.array.descripcionesLista);
        ListAdapterPractica adapter=new ListAdapterPractica(this,lenguajeProgramacion,descripciones,imgid);
        lista=(ListView)findViewById(R.id.listProductos);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String Slecteditem= lenguajeProgramacion[+position];
                Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void pulsarBuscador(View v)
    {
        String q = buscador.getText().toString();
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH );
        intent.putExtra(SearchManager.QUERY, q);
        startActivity(intent);
    }
}
