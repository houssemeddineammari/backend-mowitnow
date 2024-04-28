package com.mowitnow.backendmowitnow.entitiesTest;

import org.junit.jupiter.api.Test;
import com.mowitnow.backendmowitnow.entities.Coordinates;
import com.mowitnow.backendmowitnow.entities.MowerPosition;
import com.mowitnow.backendmowitnow.entities.Orientation;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MowerPositionTest {

    @Test
    public void testEquals_SamePositionAndOrientation_ShouldReturnTrue() {
        MowerPosition pos1 = new MowerPosition(new Coordinates(1, 1), Orientation.NORTH);
        MowerPosition pos2 = new MowerPosition(new Coordinates(1, 1), Orientation.NORTH);
        assertEquals(pos1, pos2);
    }
}