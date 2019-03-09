package com.example.apigerard.api;
import com.example.apigerard.model.CryptoList;
import com.example.apigerard.model.ExchangeList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CryptodbAPI {
//PONER URL MIA DE CRYPTO
    @GET("v1/cryptocurrency/listings/latest")
    //UNA PARA CAD ACCRCYPTO
    Call<CryptoList> getCryptos();

    //PONER URL MIA DE CRYPTO
    @GET("/v1/cryptocurrency/map")
    //UNA PARA CAD ACCRCYPTO
    Call<CryptoList> getMap();

    @GET("/v1/cryptocurrency/listings/historical")
        //UNA PARA CAD ACCRCYPTO
    Call<CryptoList> getExchangers();

}
