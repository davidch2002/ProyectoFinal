package com.example.proyectofinal.ui.home;

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
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.proyectofinal.Adapter;
import com.example.proyectofinal.Peliculas;
import com.example.proyectofinal.R;
import com.example.proyectofinal.databinding.FragmentHomeBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    private static String url = "https://davidch7.000webhostapp.com/Cineplanet/mostrar.php";
    List<Peliculas> peliculasList;
    RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        recyclerView=root.findViewById(R.id.recy);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        peliculasList = new ArrayList<>();

        cargarImagen();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
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
                            Adapter adapter = new Adapter(getActivity().getApplicationContext(), peliculasList);
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