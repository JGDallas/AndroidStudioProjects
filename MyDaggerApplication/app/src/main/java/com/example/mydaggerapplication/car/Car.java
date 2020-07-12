package com.example.mydaggerapplication.car;

import android.util.Log;

import javax.inject.Inject;

public class Car {
    private static final String TAG = "Car";

    //2. Field Injection for Engine
    //@Inject Engine engine;
    private Engine engine;
    private Wheels wheels;

    //1. Constructor
    @Inject
    public Car(Engine engine, Wheels wheels) {
        this.engine = engine;
        this.wheels = wheels;
    }
    //Dagger will not instantiate this method
    // until the object has been completely created
    //3. Method Injection
    // the only good use case for method injection
    // is if you have to pass the instance of the object
    // itself to the dependency.
    @Inject
    public void enableRemote(Remote remote){
        remote.setListener(this);
    }

    public void drive() {
        engine.start();
        Log.d(TAG, "---------->driving.My Car");
    }

    public void stop() {
        engine.stop();
        Log.d(TAG, "---Car class Stopped");
    }
}
