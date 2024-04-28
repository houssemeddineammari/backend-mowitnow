package com.mowitnow.backendmowitnow.entitiesTest;

import org.junit.jupiter.api.Test;
import com.mowitnow.backendmowitnow.entities.Coordinates;
import static org.junit.jupiter.api.Assertions.*;

public class CoordinatesTest {

	@Test
	public void testEquals_SameValues_ShouldReturnTrue() {
		Coordinates coord1 = new Coordinates(1, 1);
		Coordinates coord2 = new Coordinates(1, 1);
		assertEquals(coord1, coord2);
	}

	@Test
	public void testIsOutsideOfPelouse_Inside_ShouldReturnFalse() {
		Coordinates pelouse = new Coordinates(5, 5);
		Coordinates point = new Coordinates(3, 3);
		assertFalse(point.isOutsideOfPelouse(pelouse));
	}
}
