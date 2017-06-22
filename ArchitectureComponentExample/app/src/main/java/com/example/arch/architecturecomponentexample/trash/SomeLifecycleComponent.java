package com.example.arch.architecturecomponentexample.trash;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;

/**
 * Created by arch on 6/20/17.
 */

public class SomeLifecycleComponent implements LifecycleObserver {

    private boolean enabled;

    private Context context;

    private Lifecycle lifecycle;

    private UiCallback callback;

    public SomeLifecycleComponent(Context context, Lifecycle lifecycle, UiCallback callback) {
        this.enabled = false;
        this.context = context;
        this.lifecycle = lifecycle;
        this.callback = callback;
    }

    public void enable() {
        enabled = true;
        if (lifecycle.getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {

        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void start() {
        if (enabled) {
            callback.uiCallback("Start");
        }

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void resume() {
        if (enabled) {
            callback.uiCallback("Resume");
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void pause() {
        if (enabled) {
            callback.uiCallback("Pause");
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void stop() {
        if (enabled) {
            callback.uiCallback("Stop");
        }
    }
}
