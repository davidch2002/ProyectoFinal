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

public class AdapterCompras extends RecyclerView.Adapter<AdapterCompras.PlayerViewnHolder>{

    private Context mCtx;
    private List<Compras> comprasList;
    final AdapterCompras.OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Compras item);
    }

    public AdapterCompras(Context mCtx, List<Compras> comprasList, AdapterCompras.OnItemClickListener listener){
        this.mCtx = mCtx;
        this.comprasList = comprasList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public AdapterCompras.PlayerViewnHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_miscompras, null);

        return new AdapterCompras.PlayerViewnHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCompras.PlayerViewnHolder holder, int position) {
        Compras compras = comprasList.get(position);
        holder.bindData(comprasList.get(position));
        holder.txtnombrecompleto.setText(compras.getNombrecompleto());
        holder.txtpelicula.setText(compras.getNombre_pelicula());
        holder.txtcombo.setText(compras.getNombre_combo());
        holder.txttotal.setText("S/ " + compras.getTotal());
    }

    @Override
    public int getItemCount() {
        return comprasList.size();
    }

    class PlayerViewnHolder extends RecyclerView.ViewHolder{

        TextView txtnombrecompleto, txtpelicula, txtcombo, txttotal;

        public PlayerViewnHolder(@NonNull View itemView) {
            super(itemView);

            txtnombrecompleto = itemView.findViewById(R.id.nombrecompleto);
            txtpelicula = itemView.findViewById(R.id.pelicula);
            txtcombo = itemView.findViewById(R.id.combo);
            txttotal = itemView.findViewById(R.id.total);
        }

        void bindData(final Compras item){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(item);
                }
            });
        }
    }

}
