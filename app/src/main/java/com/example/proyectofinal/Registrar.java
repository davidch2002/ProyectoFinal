package com.example.proyectofinal;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class Registrar extends AppCompatActivity {

    EditText txtnombre, txtapellidos, txtdni, txtcelular,
             txtfechanacimiento, txtusuario, txtcontraseña,
             txtcontraseña2;

    String nombre, apellidos, dni, celular, usuario, contraseña, contraseña2;

    Button btnregistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        txtnombre = (EditText) findViewById(R.id.txtNombre);
        txtapellidos = (EditText) findViewById(R.id.txtApellidos);
        txtdni = (EditText) findViewById(R.id.txtDNI);
        txtcelular = (EditText) findViewById(R.id.txtCelular);
        txtfechanacimiento = (EditText) findViewById(R.id.txtfechanacimiento);
        txtusuario = (EditText) findViewById(R.id.txtUsuario1);
        txtcontraseña = (EditText) findViewById(R.id.txtContraseña1);
        txtcontraseña2 = (EditText) findViewById(R.id.txtContraseña2);

        btnregistrar = (Button) findViewById(R.id.btnRegistrar);

        btnregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nombre = txtnombre.getText().toString();
                apellidos = txtapellidos.getText().toString();
                dni = txtdni.getText().toString();
                celular = txtdni.getText().toString();
                usuario = txtusuario.getText().toString();
                contraseña = txtcontraseña.getText().toString();
                contraseña2 = txtcontraseña2.getText().toString();

                if(!nombre.isEmpty() || !apellidos.isEmpty() || !dni.isEmpty() || !celular.isEmpty() || !contraseña.isEmpty() || !contraseña2.isEmpty()){
                    if(contraseña.equals(contraseña2)){
                        ejecutarServicio("https://davidch7.000webhostapp.com/Cineplanet/insertar_persona.php");
                    }else{
                        Toast.makeText(getApplicationContext(), "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Ingrese los campos, por favor", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void ejecutarServicio(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "Usuario registrado correctamente", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Registrar.this, MainActivity.class);
                startActivity(intent);
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
                //parametros.put("idpersona", "");
                parametros.put("nombre", txtnombre.getText().toString());
                parametros.put("apellidos", txtapellidos.getText().toString());
                parametros.put("dni", txtdni.getText().toString());
                parametros.put("celular", txtcelular.getText().toString());
                parametros.put("fecha_nacimiento", txtfechanacimiento.getText().toString());
                //corregir formato de fecha

                parametros.put("usuario", txtusuario.getText().toString());
                parametros.put("contraseña", txtcontraseña.getText().toString());

                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}