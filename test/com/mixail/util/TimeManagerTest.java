package com.mixail.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class TimeManagerTest {

    @Test
    public void getMaxOfEmployees() {
        int actual = TimeManager.getMaxOfEmployees("office.txt");
        int expected = 4;
        assertEquals(expected, actual);
    }
}