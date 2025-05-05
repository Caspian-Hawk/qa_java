package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class LionTest {

    private Feline feline;
    private Lion lion;

    @Before
    public void setUp() throws Exception {
        feline = Mockito.mock(Feline.class); // инициализация мока
        lion = new Lion("Самец", feline); // инициализация объекта Lion с правильными параметрами
    }

    @Test(expected = Exception.class)
    public void checkInvalidSex() throws Exception {
        new Lion("Оно", feline);
    }

    @Test
    public void checkGetKittens() throws Exception {
        when(feline.getKittens()).thenReturn(1);
        assertEquals(1, lion.getKittens());
    }

    @Test
    public void checkGetFood() throws Exception {
        when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }
}