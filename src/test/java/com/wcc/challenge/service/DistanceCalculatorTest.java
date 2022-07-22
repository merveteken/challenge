package com.wcc.challenge.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
class DistanceCalculatorTest {



    @Test
    void calculateDistance() {
        DistanceCalculator distanceCalculator = new DistanceCalculator();
        assertEquals(0,distanceCalculator.calculateDistance(1,1,1,1));
    }
}