package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
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

public class Lista_combo extends AppCompatActivity {
    private static String url = "https://davidch7.000webhostapp.com/Cineplanet/mostrarCombos.php";
    List<Combos> combosList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_combo);

        recyclerView=findViewById(R.id.recy1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        combosList = new ArrayList<>();

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
                                JSONObject Combos = array.getJSONObject(i);

                                combosList.add(new Combos(
                                        Combos.getInt("idcombo"),
                                        Combos.getString("nombre_combo"),
                                        Combos.getDouble("precio_combo"),
                                        Combos.getString("descripcion_combo"),
                                        Combos.getString("urlImg")
                                ));
                            }
                            AdapterCombo adapter = new AdapterCombo(Lista_combo.this, combosList, new AdapterCombo.OnItemClickListener() {
                                @Override
                                public void onItemClick(Combos item) {
                                    moveToDescription(item);
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
                Toast.makeText(Lista_combo.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        Volley.newRequestQueue(this).add(stringRequest);
    }

    public void moveToDescription(Combos item){
        int idpelicula;
        String pelicula;
        int precio;
        int idpersona;

        idpelicula = getIntent().getIntExtra("idpelicula", 0);
        pelicula = getIntent().getStringExtra("pelicula");
        precio = getIntent().getIntExtra("precio", 0);
        idpersona = getIntent().getIntExtra("idpersona", 0);

        Intent intent = new Intent(Lista_combo.this, lista_locales.class);
        intent.putExtra("Combos", item);
        intent.putExtra("idpelicula", idpelicula);
        intent.putExtra("pelicula", pelicula);
        intent.putExtra("precio", precio);
        intent.putExtra("idpersona", idpersona);
        startActivity(intent);
    }
}