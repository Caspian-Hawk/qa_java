package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline feline;

    private Lion maleLion;
    private Lion femaleLion;

    @Before
    public void setUp() throws Exception {
        maleLion = new Lion("Самец", feline);
        femaleLion = new Lion("Самка", feline);
    }

    @Test
    public void checkGetKittensFemaleLion() {
        when(feline.getKittens()).thenReturn(1);
        assertEquals(1, femaleLion.getKittens());
    }

    @Test
    public void checkGetKittensMaleLion() {
        when(feline.getKittens()).thenReturn(1);
        assertEquals(1, maleLion.getKittens());
    }

    @Test
    public void checkDoesHaveManeMale() {
        assertTrue(maleLion.doesHaveMane());
    }

    @Test
    public void checkDoesHaveManeFemale() {
        assertFalse(femaleLion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void checkExceptionMane() throws Exception {
        new Lion("Оно", feline);
    }

    @Test
    public void checkGetFood() throws Exception {
        when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(List.of("Животные", "Птицы", "Рыба"), maleLion.getFood());
    }
}