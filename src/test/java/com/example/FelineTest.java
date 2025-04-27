package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Mock
    private Animal animal;

    Feline feline = new Feline();

    @Test
    public void checkEatMeatFeline() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(animal.getFood("Хищник")).thenReturn(expectedFood);
        assertEquals(expectedFood, animal.getFood("Хищник"));
    }

    @Test
    public void checkGetFamilyFeline() {
        when(animal.getFamily()).thenReturn("Кошачьи");
        assertEquals("Кошачьи", animal.getFamily());
    }

    @Test
    public void checkGetKittens() {
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void checkGetKittensCountsOne() {
        assertEquals(1, feline.getKittens());
    }
}