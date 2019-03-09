package com.example.apigerard.view;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.apigerard.GlideApp;
import com.example.apigerard.R;
import com.example.apigerard.model.Crypto;

import java.util.ArrayList;
import java.util.List;

public class CryptoListAdapter extends RecyclerView.Adapter<CryptoListAdapter.CryptoListViewHolder>{

    public List<Crypto> cryptoList = new ArrayList<>();

    @NonNull
    @Override
    public CryptoListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_crypto, parent, false);
        return new CryptoListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CryptoListViewHolder holder, int position) {
        Crypto crypto = cryptoList.get(position);

// crear otro holder para mostrar otra view
        holder.title.setText(crypto.name);
        holder.id.setText(crypto.id);


        GlideApp.with(holder.itemView.getContext()).load("https://s2.coinmarketcap.com/static/img/coins/64x64/" + crypto.id + ".png").into(holder.poster);
    }

    @Override
    public int getItemCount() {
        return cryptoList.size();
    }

    class CryptoListViewHolder extends RecyclerView.ViewHolder {

        // para mostrar mas elementos crear otra view abajo y en item_crypto crear una view nueva
        TextView title;
        TextView id;
        ImageView poster;
        public CryptoListViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.cryptoTitle);
            poster = itemView.findViewById(R.id.cryptoImage);
            id = itemView.findViewById(R.id.idCrypto);
        }
    }
}
