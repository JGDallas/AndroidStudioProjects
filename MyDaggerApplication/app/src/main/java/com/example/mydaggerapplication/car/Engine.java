package com.example.mydaggerapplication.car;

import javax.inject.Inject;
// this was originally a class
// public class Engine {
//
//    @Inject
//    public Engine() {
//    }
// Now we are converting this to an Interface (Interfaces Don't have a constructor,
// but they do "Implement" a class, also we can't use constructor injection)
public interface Engine {
    void start();
    void stop();
}
