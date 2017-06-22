package com.example.arch.architecturecomponentexample;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.arch.architecturecomponentexample.chucknorrisapi.ChuckApi;
import com.example.arch.architecturecomponentexample.chucknorrisapi.pojo.ChuckJoke;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by arch on 6/20/17.
 */

public class MainViewModel extends ViewModel {

    private MutableLiveData<Response<ChuckJoke, String>> chuckJokeData;

    private MutableLiveData<Boolean> loadingData;

    public MainViewModel(){
        this.chuckJokeData = new MutableLiveData<>();
        this.chuckJokeData.setValue(new Response<>(new ChuckJoke(-1, "--//--"), null));
        this.loadingData = new MutableLiveData<>();
    }

    public LiveData<Response<ChuckJoke, String>> joke(){
        return chuckJokeData;
    }

    public LiveData<Boolean> isLoading(){
        return loadingData;
    }

    public void generateJoke() {
        loadingData.setValue(true);
        ChuckApi.get()
                .getRandomJoke()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(j -> {
                    onResponse(new Response<ChuckJoke, String>(j.getJoke(), null));
                }, t -> {
                    onResponse(new Response<ChuckJoke, String>(null, "Error"));
                });
    }

    public void onResponse(Response<ChuckJoke, String> response) {
        chuckJokeData.setValue(response);
        loadingData.setValue(false);
    }
}
