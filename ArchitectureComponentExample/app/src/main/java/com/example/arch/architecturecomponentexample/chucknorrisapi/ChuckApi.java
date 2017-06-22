package com.example.arch.architecturecomponentexample.chucknorrisapi;

import com.example.arch.architecturecomponentexample.chucknorrisapi.pojo.ChuckJokeResponse;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by arch on 6/20/17.
 */

public class ChuckApi {

    public static final String BASE_URL = "https://api.icndb.com";

    private static ChuckApi chuckApi;

    private ChuckApiCaller chuckApiCaller;

    private ChuckApi(){
        this.chuckApiCaller = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ChuckApiCaller.class);
    }

    public static ChuckApi get(){
        if (chuckApi == null) {
            chuckApi = new ChuckApi();
        }
        return chuckApi;
    }

    public Observable<ChuckJokeResponse> getRandomJoke() {
        return this.chuckApiCaller.getRandomJoke();
    }

}
