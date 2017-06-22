package com.example.arch.architecturecomponentexample;

/**
 * Created by arch on 6/20/17.
 */

public class Response<V, E> {  // V - data type, E - error type

    private V value;

    private E error;

    public Response() {
    }

    public Response(V value, E error) {
        this.value = value;
        this.error = error;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public E getError() {
        return error;
    }

    public void setError(E error) {
        this.error = error;
    }
}
