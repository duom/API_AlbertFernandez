package com.example.apigerard.view.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.apigerard.MainViewModel;
import com.example.apigerard.R;
import com.example.apigerard.model.Crypto;
import com.example.apigerard.view.CryptoListAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mViewModel;
    private RecyclerView mRecyclerView;
    private CryptoListAdapter mCryptoListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.cryptoList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

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
    }
}
