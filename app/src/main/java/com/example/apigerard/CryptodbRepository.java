package com.example.apigerard;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.apigerard.api.CryptodbAPI;
import com.example.apigerard.api.CryptodbModule;
import com.example.apigerard.model.Crypto;
import com.example.apigerard.model.CryptoList;
import com.example.apigerard.model.Exchange;
import com.example.apigerard.model.ExchangeList;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CryptodbRepository {

    CryptodbAPI cryptodbAPI;

    public CryptodbRepository(){
        cryptodbAPI = CryptodbModule.getAPI();
    }

    public LiveData<List<Crypto>> getCryptos(){
        final MutableLiveData<List<Crypto>> lista = new MutableLiveData<>();

        cryptodbAPI.getCryptos().enqueue(new Callback<CryptoList>() {
            @Override
            public void onResponse(Call<CryptoList> call, Response<CryptoList> response) {
                System.out.println("RESPUESTA" + response);
                lista.setValue(response.body().data);
            }

            @Override
            public void onFailure(Call<CryptoList> call, Throwable t) {
            }
        });

        return lista;
    }

    public LiveData<List<Crypto>> getExchangers(){
        final MutableLiveData<List<Crypto>> lista = new MutableLiveData<>();

        cryptodbAPI.getExchangers().enqueue(new Callback<CryptoList>() {
            @Override
            public void onResponse(Call<CryptoList> call, Response<CryptoList> response) {
                System.out.println("RESPUESTA" + response);
                lista.setValue(response.body().data);
            }

            @Override
            public void onFailure(Call<CryptoList> call, Throwable t) {
            }
        });

        return lista;
    }

    public LiveData<List<Crypto>> getMap(){
        final MutableLiveData<List<Crypto>> lista = new MutableLiveData<>();

        cryptodbAPI.getMap().enqueue(new Callback<CryptoList>() {
            @Override
            public void onResponse(Call<CryptoList> call, Response<CryptoList> response) {
                System.out.println("RESPUESTA" + response);
                lista.setValue(response.body().data);
            }

            @Override
            public void onFailure(Call<CryptoList> call, Throwable t) {
            }
        });

        return lista;
    }


}
