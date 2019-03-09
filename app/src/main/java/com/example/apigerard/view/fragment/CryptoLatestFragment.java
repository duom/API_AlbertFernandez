package com.example.apigerard.view.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.apigerard.MainViewModel;
import com.example.apigerard.R;
import com.example.apigerard.model.Crypto;
import com.example.apigerard.view.CryptoListAdapter;

import java.util.List;


public class CryptoLatestFragment extends Fragment {

    private MainViewModel mViewModel;
    private RecyclerView mRecyclerView;
    private CryptoListAdapter mCryptoListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_crypto_latest, container, false);

        mRecyclerView = view.findViewById(R.id.cryptoList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mCryptoListAdapter = new CryptoListAdapter();
        mRecyclerView.setAdapter(mCryptoListAdapter);

        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mViewModel.getCryptos().observe(this, new Observer<List<Crypto>>() {
            @Override
            public void onChanged(@Nullable List<Crypto> cryptos) {
                mCryptoListAdapter.cryptoList = cryptos;
                mCryptoListAdapter.notifyDataSetChanged();
            }
        });

        return view;
    }
}
