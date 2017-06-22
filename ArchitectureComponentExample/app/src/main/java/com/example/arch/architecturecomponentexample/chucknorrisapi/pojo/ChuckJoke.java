package com.example.arch.architecturecomponentexample.chucknorrisapi.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by arch on 6/20/17.
 */

public class ChuckJoke {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("joke")
    @Expose
    private String joke;

    public ChuckJoke(int id, String joke) {
        this.id = id;
        this.joke = joke;
    }

    public ChuckJoke() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }
}
