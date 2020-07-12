package com.example.mydaggerapplication.dagger;

import com.example.mydaggerapplication.car.Engine;
import com.example.mydaggerapplication.car.PetrolEngine;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class PetrolEngineModule {

    @Binds
    abstract Engine bindEngine(PetrolEngine engine);

}
