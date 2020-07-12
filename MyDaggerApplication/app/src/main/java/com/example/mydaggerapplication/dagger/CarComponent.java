package com.example.mydaggerapplication.dagger;


import com.example.mydaggerapplication.MainActivity;
import com.example.mydaggerapplication.car.Car;

import javax.inject.Named;

import dagger.BindsInstance;
import dagger.Component;
//now dagger knows how to get Wheels, rims or tires
@Component (modules = {WheelsModule.class, PetrolEngineModule.class})
public interface CarComponent {

    Car getCar();

    void inject(MainActivity mainActivity);
    //JG 202000712: Nested Interface
    @Component.Builder
    interface Builder {

        @BindsInstance
        //Dagger does not know this is horsepower, only that
        //it is being passed an integer.
        Builder horsePower(@Named("horse power") int horsePower);

        @BindsInstance
        Builder engineCapacity(@Named("engine capacity") int engineCapacity);

        CarComponent build();
    }

}
