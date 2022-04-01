package com.example.rpg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloApplicationTest {
    @Test
    public void test(){
        HelloApplication test = new HelloApplication();
        int result = test.addNumber(5, 2);
        assertEquals(7, result);
    }

}