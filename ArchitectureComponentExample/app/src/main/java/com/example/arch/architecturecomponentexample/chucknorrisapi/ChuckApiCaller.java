package com.example.arch.architecturecomponentexample.chucknorrisapi;

import com.example.arch.architecturecomponentexample.chucknorrisapi.pojo.ChuckJokeResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by arch on 6/20/17.
 */

public interface ChuckApiCaller {

    @GET("jokes/random")
    Observable<ChuckJokeResponse> getRandomJoke();

}
