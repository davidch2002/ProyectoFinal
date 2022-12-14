package com.example.proyectofinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.PlayerViewnHolder> {

    private Context mCtx;
    private List<Peliculas> peliculasList;
    final Adapter.OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Peliculas item);
    }

    public Adapter(Context mCtx, List<Peliculas>peliculasList, Adapter.OnItemClickListener listener){
         this.mCtx = mCtx;
         this.peliculasList = peliculasList;
         this.listener = listener;
    }

    @NonNull
    @Override
    public PlayerViewnHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.lista, null);

        return new PlayerViewnHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerViewnHolder holder, int position) {
        Peliculas peliculas = peliculasList.get(position);
        Glide.with(mCtx)
                .load(peliculas.getUrlImg())
                .into(holder.img);
        holder.bindData(peliculasList.get(position));
        holder.txttitulo.setText(peliculas.getNombre_pelicula());
        holder.txtduracion.setText(peliculas.getDuracion_pelicula());
        holder.txtFechaEstreno.setText(peliculas.getFechaEstreno());
        //holder.txtDescripcion.setText(peliculas.getDescripcion_pelicula());
    }

    @Override
    public int getItemCount() {
        return peliculasList.size();
    }

    class PlayerViewnHolder extends RecyclerView.ViewHolder{

        TextView txttitulo, txtduracion, txtFechaEstreno;
        ImageView img;

        public PlayerViewnHolder(@NonNull View itemView) {
            super(itemView);

            txttitulo = itemView.findViewById(R.id.titulo);
            txtduracion = itemView.findViewById(R.id.txt_duracion);
            txtFechaEstreno = itemView.findViewById(R.id.txt_fecha);
            img = itemView.findViewById(R.id.img);
        }

        void bindData(final Peliculas item){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(item);
                }
            });
        }
    }
}
