package com.mowitnow.backendmowitnow.entitiesTest;
import org.junit.jupiter.api.Test;

import com.mowitnow.backendmowitnow.entities.Coordinates;
import com.mowitnow.backendmowitnow.entities.Lawn;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LawnTest {
    @Test
    public void verifier_surcharge_equals() {
        Lawn p1 = new Lawn(new Coordinates(1, 2));
        Lawn p2 = new Lawn(new Coordinates(1, 2));
        assertTrue(p1.equals(p2));
        p2 = new Lawn(new Coordinates(1, 3));
        assertTrue(!p1.equals(p2));
    }
}