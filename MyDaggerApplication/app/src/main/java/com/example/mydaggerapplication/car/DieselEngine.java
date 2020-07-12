package com.example.mydaggerapplication.car;

import android.util.Log;

import javax.inject.Inject;
import javax.inject.Named;

public class DieselEngine implements Engine {
    private static final String TAG = "Car";

    private int horsePower;
    private int engineCapacity;

    // JG20200613 Used to have an @Inject-annotated method here, but
    // Dagger won't know what this runtime parameter is (horsePower) at
    // Design time
    // @Inject
    public DieselEngine(@Named("horse power") int horsePower,
            @Named("engine capacity") int engineCapacity){
        this.horsePower=horsePower;
        this.engineCapacity=engineCapacity;
    }

    @Override
    public void start() {
        Log.d(TAG, "------> Diesel Engine Started. Horsepower: " + horsePower);
    }
    public void stop(){
        Log.d(TAG, "------> Diesel Engine Stopped");
    }
}
