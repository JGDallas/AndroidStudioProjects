package com.example.mydaggerapplication.dagger;

import com.example.mydaggerapplication.car.Rims;
import com.example.mydaggerapplication.car.Tires;
import com.example.mydaggerapplication.car.Wheels;

import dagger.Module;
import dagger.Provides;
//Modules are classes that contribute to the object graph
//This modules purpose is to tell dagger how to create these
//objects that are not our own classes, but come from
//an external library where we can't use the Inject annotation

@Module
public abstract class WheelsModule {
    //whenever these provides methods don't
    //depend on any instance state of this module
    //you can make these methods static with a static keyword.
    //then dagger doesn't have to instantiate this module
    //and can call these methods directly.
    @Provides
    static Rims provideRims(){
        return  new Rims();
    }

    @Provides
    static Tires providesTires(){
        Tires tires = new Tires();
        tires.inflate();
        return tires;
    }

    //in real world scenarios, you would not call a
    //constructor, you would call a builder method
    //like retrofit builder
    //but the only thing that matters is that you return
    //whatever you define
    //here\/
    @Provides
    static Wheels provideWheels(Rims rims, Tires tires){
        return new Wheels(rims, tires);
    }
}
