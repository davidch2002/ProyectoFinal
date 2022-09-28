package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

public class MainActivity_Lista extends AppCompatActivity {
    private static String url = "https://davidch7.000webhostapp.com/Cineplanet/mostrar.php";
    List<Peliculas> peliculasList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lista);

        recyclerView=findViewById(R.id.recy);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        peliculasList = new ArrayList<>();

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
                                JSONObject Peliculas = array.getJSONObject(i);

                                peliculasList.add(new Peliculas(
                                        Peliculas.getInt("idpelicula"),
                                        Peliculas.getString("nombre_pelicula"),
                                        Peliculas.getString("duracion_pelicula"),
                                        Peliculas.getString("descripcion_pelicula"),
                                        Peliculas.getString("fechaEstreno"),
                                        Peliculas.getString("urlImg")
                                ));
                            }
                            Adapter adapter = new Adapter(MainActivity_Lista.this, peliculasList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity_Lista.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        Volley.newRequestQueue(this).add(stringRequest);
    }
}