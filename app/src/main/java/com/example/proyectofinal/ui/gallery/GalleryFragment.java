package com.example.proyectofinal.ui.gallery;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.proyectofinal.Adapter;
import com.example.proyectofinal.DetallePelicula;
import com.example.proyectofinal.Peliculas;
import com.example.proyectofinal.R;
import com.example.proyectofinal.databinding.FragmentGalleryBinding;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;
    TextView usuario, nombre, apellidos, dni, celular;
    RequestQueue requestQueue;
    String user;
    //int idpersona;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        usuario = (TextView) root.findViewById(R.id.txtusuario);
        nombre = (TextView) root.findViewById(R.id.txtnombre);
        apellidos = (TextView) root.findViewById(R.id.txtapellidos);
        dni = (TextView) root.findViewById(R.id.txtdni);
        celular = (TextView) root.findViewById(R.id.txtcelular);

        user = getActivity().getIntent().getExtras().getString("usuario");

        TraerDatosUsuario("https://davidch7.000webhostapp.com/Cineplanet/mostrar_DatosPersona.php?usuario="+user+"");

        return root;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void TraerDatosUsuario(String URL){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        usuario.setText(jsonObject.getString("usuario"));
                        nombre.setText(jsonObject.getString("nombre"));
                        apellidos.setText(jsonObject.getString("apellidos"));
                        dni.setText(jsonObject.getString("dni"));
                        celular.setText(jsonObject.getString("celular"));
                        //idpersona = jsonObject.getInt("idpersona");

                    } catch (JSONException e) {
                        Toast.makeText(getActivity().getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity().getApplicationContext(), "ERROR DE CONEXIÓN", Toast.LENGTH_SHORT).show();
            }
        }
        );
        requestQueue = Volley.newRequestQueue(this.getContext());
        requestQueue.add(jsonArrayRequest);
    }
}