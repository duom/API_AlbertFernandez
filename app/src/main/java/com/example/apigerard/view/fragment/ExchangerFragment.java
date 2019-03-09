package com.example.apigerard.view.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.apigerard.GlideApp;
import com.example.apigerard.MainViewModel;
import com.example.apigerard.R;
import com.example.apigerard.model.Crypto;
import com.example.apigerard.model.Exchange;

import java.util.ArrayList;
import java.util.List;

public class ExchangerFragment extends Fragment {
    private MainViewModel mViewModel;
    private RecyclerView mRecyclerView;
    private ExchangeListAdapter mExchangeListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_exchanger, container, false);

        mRecyclerView = view.findViewById(R.id.exchangerList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mExchangeListAdapter = new ExchangeListAdapter();
        mRecyclerView.setAdapter(mExchangeListAdapter);

        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mViewModel.getExchangers().observe(this, new Observer<List<Crypto>>() {
            @Override
            public void onChanged(@Nullable List<Crypto> Exchanges) {
                mExchangeListAdapter.exchangeList = Exchanges;
                mExchangeListAdapter.notifyDataSetChanged();
            }
        });

        return view;
    }
}

class ExchangeListAdapter extends RecyclerView.Adapter<ExchangeListAdapter.ExchangeListViewHolder>{

    public List<Crypto> exchangeList = new ArrayList<>();

    @NonNull
    @Override
    public ExchangeListAdapter.ExchangeListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_exchange, parent, false);
        return new ExchangeListAdapter.ExchangeListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExchangeListAdapter.ExchangeListViewHolder holder, int position) {
        Crypto exchange = exchangeList.get(position);

        // crear otro holder para mostrar otra view
        holder.title.setText(exchange.name);
        holder.id.setText(exchange.id);

        GlideApp.with(holder.itemView.getContext()).load("https://s2.coinmarketcap.com/static/img/exchanges/64x64/" + exchange.id + ".png").into(holder.poster);
    }

    @Override
    public int getItemCount() {
        return exchangeList.size();
    }

    class ExchangeListViewHolder extends RecyclerView.ViewHolder {

        // para mostrar mas elementos crear otra view abajo y en item_Exchange crear una view nueva
        TextView title;
        TextView id;
        ImageView poster;
        public ExchangeListViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.exTitle);
            poster = itemView.findViewById(R.id.exImage);
            id = itemView.findViewById(R.id.exId);
        }
    }
}