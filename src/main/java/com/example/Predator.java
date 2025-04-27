package com.example;

import java.util.List;

// Отряд Хищники
public interface Predator {

    // список для плотоядных
    List<String> eatMeat() throws Exception;

}