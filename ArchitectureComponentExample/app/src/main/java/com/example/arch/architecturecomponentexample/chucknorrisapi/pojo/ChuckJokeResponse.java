package com.example.arch.architecturecomponentexample.chucknorrisapi.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by arch on 6/20/17.
 */

public class ChuckJokeResponse {

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("value")
    @Expose
    private ChuckJoke joke;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ChuckJoke getJoke() {
        return joke;
    }

    public void setJoke(ChuckJoke joke) {
        this.joke = joke;
    }
}
