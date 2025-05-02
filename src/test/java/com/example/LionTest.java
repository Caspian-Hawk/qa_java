package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class LionTest {

    @Mock
    private Feline feline;

    private Lion lion;
    private final String sex;
    private final boolean hasMane;

    public LionTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters(name = "ExpectedSex = {0}, hasMane = {1}")
    public static Object[][] dataSex() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        lion = new Lion(sex, feline);
    }

    @Test
    public void checkLionMane() throws Exception {
        lion = new Lion(sex, feline);
        assertEquals(hasMane, lion.doesHaveMane());
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
