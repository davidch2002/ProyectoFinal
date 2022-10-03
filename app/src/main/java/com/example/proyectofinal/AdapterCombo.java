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

public class AdapterCombo extends RecyclerView.Adapter<AdapterCombo.PlayerViewnHolder> {

    private Context mCtx;
    private List<Combos> combosList;
    final AdapterCombo.OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Combos item);
    }

    public AdapterCombo(Context mCtx, List<Combos> combosList, AdapterCombo.OnItemClickListener listener){
        this.mCtx = mCtx;
        this.combosList = combosList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public AdapterCombo.PlayerViewnHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_dulceria, null);

        return new AdapterCombo.PlayerViewnHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCombo.PlayerViewnHolder holder, int position) {
        Combos combos = combosList.get(position);
        Glide.with(mCtx)
                .load(combos.getUrlImg())
                .into(holder.img);
        holder.bindData(combosList.get(position));
        holder.txtnombrecombo.setText(combos.getNombre_combo());
        holder.txtdescripcioncombo.setText(combos.getDescripcion_combo());
        holder.txtpreciocombo.setText("S/ "+combos.getPrecio_combo());
    }

    @Override
    public int getItemCount() {
        return combosList.size();
    }

    class PlayerViewnHolder extends RecyclerView.ViewHolder{

        TextView txtnombrecombo, txtdescripcioncombo, txtpreciocombo;
        ImageView img;

        public PlayerViewnHolder(@NonNull View itemView) {
            super(itemView);

            txtnombrecombo = itemView.findViewById(R.id.nombreCombo);
            txtdescripcioncombo = itemView.findViewById(R.id.descripcion_combo);
            txtpreciocombo = itemView.findViewById(R.id.precio_combo);
            img = itemView.findViewById(R.id.iconImageView);
        }

        void bindData(final Combos item){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(item);
                }
            });
        }
    }
}
