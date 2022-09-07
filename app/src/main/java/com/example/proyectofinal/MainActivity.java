package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    Button btnlogin;
    private EditText txtUsuario;
    private EditText txtContraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnlogin = (Button) findViewById(R.id.btnlogin);

        /*
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText txtUsuario;
                EditText txtContraseña;

                txtUsuario = (EditText) findViewById(R.id.txtUsuario);
                txtContraseña = (EditText) findViewById(R.id.txtContraseña);

                if(txtUsuario.getText().toString().isEmpty() | txtContraseña.getText().toString().isEmpty()){
                    Snackbar.make(view,"Ingrese su usuario y/o contraseña", Snackbar.LENGTH_LONG)
                            .setAction("Action",null).show();
                }else{
                    switch (txtUsuario.getText().toString()){
                        case "david123":
                            if (txtContraseña.getText().toString().equals("12345")){
                                Snackbar.make(view,"Bienvenido " + txtUsuario.getText(), Snackbar.LENGTH_LONG)
                                        .setAction("Action",null).show();

                                Intent intent = new Intent(MainActivity.this, CarteleraActivity.class);
                                String nombre = "David Cuellar Huaringa";
                                intent.putExtra("nomusuario", txtUsuario.getText().toString());
                                startActivity(intent);
                                finish();
                            }else{
                                Snackbar.make(view,"Usuario y/o contraseña incorrecto(s)", Snackbar.LENGTH_LONG)
                                        .setAction("Action",null).show();
                            }
                            break;

                        case "antonyvargas321":
                            if (txtContraseña.getText().toString().equals("54321")){
                                Snackbar.make(view,"Bienvenido " + txtUsuario.getText(), Snackbar.LENGTH_LONG)
                                        .setAction("Action",null).show();

                                Intent intent = new Intent(MainActivity.this, CarteleraActivity.class);
                                String nombre = "Antony Vargas Silva";
                                intent.putExtra("nomusuario", nombre.toString());
                                startActivity(intent);
                                finish();
                            }else{
                                Snackbar.make(view,"Usuario y/o contraseña incorrecto(s)", Snackbar.LENGTH_LONG)
                                        .setAction("Action",null).show();
                            }
                            break;

                        case "gerardo123":
                            if (txtContraseña.getText().toString().equals("123")){
                                Snackbar.make(view,"Bienvenido " + txtUsuario.getText(), Snackbar.LENGTH_LONG)
                                        .setAction("Action",null).show();

                                Intent intent = new Intent(MainActivity.this, CarteleraActivity.class);
                                String nombre = "Gerardo Cuya Lujan";
                                intent.putExtra("nomusuario", nombre.toString());
                                startActivity(intent);
                                finish();
                            }else{
                                Snackbar.make(view,"Usuario y/o contraseña incorrecto(s)", Snackbar.LENGTH_LONG)
                                        .setAction("Action",null).show();
                            }
                            break;

                        case "angelorivero10":
                            if (txtContraseña.getText().toString().equals("4321")){
                                Snackbar.make(view,"Bienvenido " + txtUsuario.getText(), Snackbar.LENGTH_LONG)
                                        .setAction("Action",null).show();

                                Intent intent = new Intent(MainActivity.this, CarteleraActivity.class);
                                String nombre = "Angelo Rivero Roca";
                                intent.putExtra("nomusuario", nombre.toString());
                                startActivity(intent);
                                finish();
                            }else{
                                Snackbar.make(view,"Usuario y/o contraseña incorrecto(s)", Snackbar.LENGTH_LONG)
                                        .setAction("Action",null).show();
                            }
                            break;
                    }

                }
            }
        });
         */
    }

    public void btnLogin(View view) {

        txtUsuario = (EditText) findViewById(R.id.txtUsuario);
        txtContraseña = (EditText) findViewById(R.id.txtContraseña);

        if (txtUsuario.getText().toString().isEmpty() | txtContraseña.getText().toString().isEmpty()) {
            Snackbar.make(view, "Ingrese su usuario y/o contraseña", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        } else {
            switch (txtUsuario.getText().toString()) {
                case "david123":
                    if (txtContraseña.getText().toString().equals("12345")) {
                        Snackbar.make(view, "Bienvenido " + txtUsuario.getText(), Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();

                        Intent intent = new Intent(MainActivity.this, CarteleraActivity.class);
                        String nombre = "David Cuellar Huaringa";
                        intent.putExtra("dato", nombre.toString());
                        startActivity(intent);
                        finish();
                    } else {
                        Snackbar.make(view, "Usuario y/o contraseña incorrecto(s)", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                    break;

                case "antonyvargas321":
                    if (txtContraseña.getText().toString().equals("54321")) {
                        Snackbar.make(view, "Bienvenido " + txtUsuario.getText(), Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();

                        Intent intent = new Intent(MainActivity.this, CarteleraActivity.class);
                        String nombre = "Antony Vargas Silva";
                        intent.putExtra("dato", nombre.toString());
                        startActivity(intent);
                        finish();
                    } else {
                        Snackbar.make(view, "Usuario y/o contraseña incorrecto(s)", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                    break;

                case "gerardo123":
                    if (txtContraseña.getText().toString().equals("123")) {
                        Snackbar.make(view, "Bienvenido " + txtUsuario.getText(), Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();

                        Intent intent = new Intent(MainActivity.this, CarteleraActivity.class);
                        String nombre = "Gerardo Cuya Lujan";
                        intent.putExtra("dato", nombre.toString());
                        startActivity(intent);
                        finish();
                    } else {
                        Snackbar.make(view, "Usuario y/o contraseña incorrecto(s)", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                    break;

                case "angelorivero10":
                    if (txtContraseña.getText().toString().equals("4321")) {
                        Snackbar.make(view, "Bienvenido " + txtUsuario.getText(), Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();

                        Intent intent = new Intent(MainActivity.this, CarteleraActivity.class);
                        String nombre = "Angelo Rivero Roca";
                        intent.putExtra("dato", nombre.toString());
                        startActivity(intent);
                        finish();
                    } else {
                        Snackbar.make(view, "Usuario y/o contraseña incorrecto(s)", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                    break;
            }

        }
    }
}