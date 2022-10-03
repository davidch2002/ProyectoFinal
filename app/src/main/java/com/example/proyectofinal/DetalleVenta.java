package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class DetalleVenta extends AppCompatActivity {

    TextView txtpelicula, txtprecio, txtcombo, txtpreciocombo, txtlocal, txttotal;
    int idpelicula, precio, idcombo, idlocal, idpersona;
    String pelicula, combo, local;
    double precioCombo, total;
    Button btnCompra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_venta);

        txtpelicula = findViewById(R.id.txt_nombrepelicula1);
        txtprecio = findViewById(R.id.txt_precio1);
        txtcombo = findViewById(R.id.txt_combo);
        txtpreciocombo = findViewById(R.id.txt_precioCombo);
        txtlocal = findViewById(R.id.txt_local);
        txttotal = findViewById(R.id.txt_total);
        btnCompra = findViewById(R.id.btnConfirmarCompra);

        idpelicula = getIntent().getIntExtra("idpelicula", 0);
        pelicula = getIntent().getStringExtra("pelicula");
        precio = getIntent().getIntExtra("precio", 0);

        idcombo = getIntent().getIntExtra("idcombo", 0);
        combo = getIntent().getStringExtra("combo");
        precioCombo = getIntent().getDoubleExtra("preciocombo", 0);

        idpersona = getIntent().getIntExtra("idpersona", 0);

        Locales element = (Locales) getIntent().getSerializableExtra("Locales");

        idlocal = element.getIdlocal();
        local = element.getNombre_local();

        txtpelicula.setText(pelicula);
        txtprecio.setText("S/ " + precio);

        txtcombo.setText(combo);
        txtpreciocombo.setText("S/ " + precioCombo);

        txtlocal.setText(local);

        total = precio + precioCombo;

        txttotal.setText("S/ " + total);

        btnCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ejecutarServicio("https://davidch7.000webhostapp.com/Cineplanet/insertar_venta.php");
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void ejecutarServicio(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "Venta registrada correctamente", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<String, String>();
                //parametros.put("idventa", "");
                parametros.put("idpersona", "" + idpersona);
                parametros.put("idlocal", "" + idlocal);

                parametros.put("idcombo", "" + idcombo);
                parametros.put("idpelicula", "" + idpelicula);
                parametros.put("cantidad", "" + 1);
                parametros.put("preciounidad", "" + precio);
                parametros.put("descuento", "" + 0);
                parametros.put("total", "" + total);

                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}