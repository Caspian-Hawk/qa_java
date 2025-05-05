package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionParameterizedManeTest {

    @Mock
    private Feline feline;

    private Lion lion;
    private final String sex;
    private final boolean hasMane;

    public LionParameterizedManeTest(String sex, boolean hasMane) {
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
}