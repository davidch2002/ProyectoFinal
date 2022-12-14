package com.example.proyectofinal;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity{

    TextView txtRegistrar, txtRecuperarContraseña;
    Button btnlogin;
    EditText txtUsuario, txtContraseña;

    String usuario, contraseña;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUsuario = findViewById(R.id.txtUsuario);
        txtContraseña = findViewById(R.id.txtContraseña);

        btnlogin = findViewById(R.id.btnlogin);

        txtRegistrar = (TextView) findViewById(R.id.txtregistrar);
        txtRecuperarContraseña = (TextView) findViewById(R.id.txtRecuperarContraseña);

        recuperarPreferencias();

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usuario = txtUsuario.getText().toString();
                contraseña = txtContraseña.getText().toString();
                if(!usuario.isEmpty() && !contraseña.isEmpty()){
                    validarUsuario("https://davidch7.000webhostapp.com/Cineplanet/validar_usuario.php");
                }else{
                    Toast.makeText(MainActivity.this, "Ingrese su usuario y/o contraseña", Toast.LENGTH_SHORT).show();
                }

            }
        });

        txtRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentRegistrar = new Intent(MainActivity.this, Registrar.class);
                MainActivity.this.startActivity(intentRegistrar);
            }
        });

        txtRecuperarContraseña.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentRecuperarContraseña = new Intent(MainActivity.this, RecuperarContrasena.class);
                MainActivity.this.startActivity(intentRecuperarContraseña);
            }
        });
    }

    private void validarUsuario(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                User item = null;

                if(!response.isEmpty()){
                    guardarPreferencias();
                    llevarInformacion(item);
                }else{
                    Toast.makeText(MainActivity.this, "Usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<String, String>();
                parametros.put("usuario", usuario);
                parametros.put("contraseña", contraseña);
                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void guardarPreferencias(){
        SharedPreferences preferences = getSharedPreferences("preferenciasLogin", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("usuario", usuario);
        editor.putString("contraseña", contraseña);
        editor.putBoolean("sesion", true);
        editor.commit();
    }

    private void recuperarPreferencias(){
        SharedPreferences preferences = getSharedPreferences("preferenciasLogin", Context.MODE_PRIVATE);
        txtUsuario.setText(preferences.getString("usuario", ""));
        txtContraseña.setText(preferences.getString("contraseña", ""));
    }

    public void llevarInformacion(User item){
        Intent intent = new Intent(getApplicationContext(), CarteleraActivity.class);
        intent.putExtra("usuario", usuario);
        startActivity(intent);
        finish();
    }
}