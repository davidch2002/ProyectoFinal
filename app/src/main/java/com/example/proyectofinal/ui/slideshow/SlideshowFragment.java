package com.example.proyectofinal.ui.slideshow;

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
import com.example.proyectofinal.AdapterCompras;
import com.example.proyectofinal.Compras;
import com.example.proyectofinal.Peliculas;
import com.example.proyectofinal.R;
import com.example.proyectofinal.databinding.FragmentSlideshowBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SlideshowFragment extends Fragment {

    private FragmentSlideshowBinding binding;

    List<Compras> comprasList;
    RecyclerView recyclerView;
    RequestQueue requestQueue;
    String user;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textSlideshow;
        slideshowViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        recyclerView=root.findViewById(R.id.recyMiscompras);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        comprasList = new ArrayList<>();

        user = getActivity().getIntent().getExtras().getString("usuario");
        cargarImagen();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void cargarImagen(){
        String url = "https://davidch7.000webhostapp.com/Cineplanet/mostrar_ComprasPersona.php?usuario="+ user + "";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);

                            for (int i = 0; i < array.length(); i++) {
                                JSONObject Compras = array.getJSONObject(i);

                                comprasList.add(new Compras(
                                        Compras.getInt("idventa"),
                                        Compras.getInt("cantidad"),
                                        Compras.getString("nombrecompleto"),
                                        Compras.getString("nombre_combo"),
                                        Compras.getString("nombre_pelicula"),
                                        Compras.getDouble("precio_combo"),
                                        Compras.getDouble("preciounidad"),
                                        Compras.getDouble("descuento"),
                                        Compras.getDouble("total")
                                ));
                            }
                            AdapterCompras adapter = new AdapterCompras(getActivity().getApplicationContext(), comprasList, new AdapterCompras.OnItemClickListener() {
                                @Override
                                public void onItemClick(Compras item) {
                                    //moveToDescription(item);
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
                Toast.makeText(getActivity().getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        Volley.newRequestQueue(getActivity().getApplicationContext()).add(stringRequest);
    }
}