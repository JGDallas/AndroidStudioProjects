package com.example.mydaggerapplication.dagger;

import com.example.mydaggerapplication.car.DieselEngine;
import com.example.mydaggerapplication.car.Engine;
import com.example.mydaggerapplication.car.PetrolEngine;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class DieselEngineModule {

    //JG20200613 This @Binds Method must be used in Conjunction with an @Inject Constructor
    // However we removed it in the DieselEngine class
    // Now we must go back to an @Provides constructor
    // because @Binds does not support any configuration
    // Also, removed the abstract designation
    // used to be this "public abstract class DieselEngineModule {"
    // AND abstract Engine bindEngine(DieselEngine engine);

    // Now need to pass in the Horsepower value
    // Create a private variable here.

    private int horsePower;

    public DieselEngineModule(int horsePower) {
        this.horsePower = horsePower;
    }

    @Binds
    abstract Engine bindEngine(DieselEngine engine);

    /*
    @Provides
    int provideHorsePower(){
        return horsePower;
    }
    // JG 20200613 change from Engine bindEngine(DieselEngine engine){
    // to provideEngine
    // And Since we are instantiating this class ourselves we don't need this anymore..
    // Engine provideEngine(DieselEngine engine){
    @Provides
    Engine provideEngine(){
        return new DieselEngine(horsePower);
    }
    */

}
