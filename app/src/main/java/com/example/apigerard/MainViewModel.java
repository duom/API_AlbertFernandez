package com.example.apigerard;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.apigerard.model.Crypto;
import com.example.apigerard.model.Exchange;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private CryptodbRepository cryptodbRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        cryptodbRepository = new CryptodbRepository();
    }

    public LiveData<List<Crypto>> getCryptos(){
        return cryptodbRepository.getCryptos();
    }

    public LiveData<List<Crypto>> getExchangers(){
        return cryptodbRepository.getExchangers();
    }
    public LiveData<List<Crypto>> getMap(){
        return cryptodbRepository.getMap();
    }

}