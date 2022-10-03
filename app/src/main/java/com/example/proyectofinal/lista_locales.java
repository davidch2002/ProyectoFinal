package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class lista_locales extends AppCompatActivity {
    private static String url = "https://davidch7.000webhostapp.com/Cineplanet/mostrarLocales.php";
    List<Locales> localesList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_locales);

        recyclerView=findViewById(R.id.recy2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        localesList = new ArrayList<>();

        cargarImagen();
    }

    private void cargarImagen(){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);

                            for (int i = 0; i < array.length(); i++) {
                                JSONObject Locales = array.getJSONObject(i);

                                localesList.add(new Locales(
                                        Locales.getInt("idlocal"),
                                        Locales.getString("nombre_local"),
                                        Locales.getString("nombre_estado")
                                ));
                            }
                            AdapterLocal adapter = new AdapterLocal(lista_locales.this, localesList, new AdapterLocal.OnItemClickListener() {
                                @Override
                                public void onItemClick(Locales item) {

                                    if(!item.nombre_estado.equals("Activo")){
                                        Toast.makeText(lista_locales.this, "Este local no esta activo por ahora.", Toast.LENGTH_SHORT).show();
                                    }else{
                                        //Toast.makeText(lista_locales.this, "Correcto", Toast.LENGTH_SHORT).show();
                                        moveToDescription(item);
                                    }
                                }
                            });
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(lista_locales.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        Volley.newRequestQueue(this).add(stringRequest);
    }

    public void moveToDescription(Locales item){
        int idpelicula, precio, idcombo, idpersona;
        String pelicula, combo;
        double preciocombo;

        Combos element = (Combos) getIntent().getSerializableExtra("Combos");

        idpelicula = getIntent().getIntExtra("idpelicula", 0);
        pelicula = getIntent().getStringExtra("pelicula");
        precio = getIntent().getIntExtra("precio", 0);
        idpersona = getIntent().getIntExtra("idpersona", 0);

        idcombo = element.getIdcombo();
        combo = element.getNombre_combo();
        preciocombo = element.getPrecio_combo();

        Intent intent = new Intent(lista_locales.this, DetalleVenta.class);
        intent.putExtra("Locales", item);

        intent.putExtra("idpelicula", idpelicula);
        intent.putExtra("pelicula", pelicula);
        intent.putExtra("precio", precio);

        intent.putExtra("idcombo", idcombo);
        intent.putExtra("combo", combo);
        intent.putExtra("preciocombo", preciocombo);

        intent.putExtra("idpersona", idpersona);

        startActivity(intent);
    }
}