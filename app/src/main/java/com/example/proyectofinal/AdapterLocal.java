package com.example.proyectofinal;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class AdapterLocal extends RecyclerView.Adapter<AdapterLocal.PlayerViewnHolder>{
    private Context mCtx;
    private List<Locales> localesList;
    final AdapterLocal.OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Locales item);
    }

    public AdapterLocal(Context mCtx, List<Locales> localesList, AdapterLocal.OnItemClickListener listener){
        this.mCtx = mCtx;
        this.localesList = localesList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public AdapterLocal.PlayerViewnHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_locales, null);

        return new AdapterLocal.PlayerViewnHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterLocal.PlayerViewnHolder holder, int position) {
        Locales locales = localesList.get(position);
        holder.bindData(localesList.get(position));
        holder.txtnombrelocal.setText(locales.getNombre_local());
        holder.txtnombreestado.setText(locales.getNombre_estado());

        String nombreestado;
        nombreestado = holder.txtnombreestado.getText().toString();

        if(nombreestado.equals("Activo")){
            holder.txtnombreestado.setBackgroundResource(R.drawable.estadoactivo);
        }else{
            holder.txtnombreestado.setBackgroundResource(R.drawable.estadoinactivo);
        }
    }

    @Override
    public int getItemCount() {
        return localesList.size();
    }

    class PlayerViewnHolder extends RecyclerView.ViewHolder{

        TextView txtnombrelocal, txtnombreestado;

        public PlayerViewnHolder(@NonNull View itemView) {
            super(itemView);

            txtnombrelocal = itemView.findViewById(R.id.nombreLocal);
            txtnombreestado = itemView.findViewById(R.id.estadoLocal);
        }

        void bindData(final Locales item){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(item);
                }
            });
        }
    }
}
