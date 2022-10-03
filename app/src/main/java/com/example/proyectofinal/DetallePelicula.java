package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DetallePelicula extends AppCompatActivity {

    TextView descripcion, nom_pelicula, duracion, fechaPelicula, nombre_genero, precio_pelicula;
    ImageView ImgPelicula;
    Button btnComprar;
    private Context mCtx;

    int idpelicula, idpersona;
    int precio;
    String pelicula;

    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_pelicula);

        ImgPelicula = findViewById(R.id.imgPelicula);
        descripcion = findViewById(R.id.txt_descripcion);
        nom_pelicula = findViewById(R.id.tituloPelicula);
        duracion = findViewById(R.id.txt_duracion1);
        fechaPelicula = findViewById(R.id.txt_fecha1);
        nombre_genero = findViewById(R.id.txt_genero);
        precio_pelicula = findViewById(R.id.txt_precio);
        btnComprar = findViewById(R.id.btncomprar);

        Peliculas element = (Peliculas) getIntent().getSerializableExtra("Peliculas");

        idpersona = getIntent().getIntExtra("idpersona", 0);

        idpelicula = element.getIdpelicula();
        pelicula = element.getNombre_pelicula();
        precio = element.getPrecio_pelicula();

        btnComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetallePelicula.this, Lista_combo.class);
                intent.putExtra("idpelicula", idpelicula);
                intent.putExtra("pelicula", pelicula);
                intent.putExtra("precio", precio);
                intent.putExtra("idpersona", idpersona);
                startActivity(intent);
            }
        });

        buscarPelicula("https://davidch7.000webhostapp.com/Cineplanet/buscar_pelicula.php?idpelicula="+idpelicula+"");
    }

    private void buscarPelicula(String URL){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        nom_pelicula.setText(jsonObject.getString("nombre_pelicula"));
                        descripcion.setText(jsonObject.getString("descripcion_pelicula"));
                        duracion.setText(jsonObject.getString("duracion_pelicula"));
                        fechaPelicula.setText(jsonObject.getString("fechaEstreno"));
                        nombre_genero.setText(jsonObject.getString("nombre_genero"));
                        precio_pelicula.setText("S/. " + jsonObject.getString("precio_pelicula"));
                        /*Glide.with(mCtx)
                                .load(jsonObject.getString("urlImg"))
                                .into(ImgPelicula);*/

                        Uri uri = Uri.parse(jsonObject.getString("urlImg"));
                        Picasso.with(DetallePelicula.this).load(uri).into(ImgPelicula);

                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "ERROR DE CONEXIÓN", Toast.LENGTH_SHORT).show();
            }
        }
        );
        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }
}