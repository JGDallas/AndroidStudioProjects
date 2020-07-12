package com.example.mydaggerapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mydaggerapplication.car.Car;
import com.example.mydaggerapplication.dagger.CarComponent;
import com.example.mydaggerapplication.dagger.DaggerCarComponent;
import com.example.mydaggerapplication.dagger.DieselEngineModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    @Inject
    Car car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // JG 20200613 Create method needs to go away
        // CarComponent component = DaggerCarComponent.create();
        // This convenience method is only available if NONE
        // of the Modules in your component takes arguments
        // over the constructor.
        CarComponent component = DaggerCarComponent.builder()
                .horsePower(150)
                .engineCapacity(1400)
                //.wheelsModule();
                .build();

        component.inject(this);
        //NOTE: You are not calling the Remote Connected Method
        //Dagger is calling this Method for us.
        car.drive();
        car.stop();
    }
}