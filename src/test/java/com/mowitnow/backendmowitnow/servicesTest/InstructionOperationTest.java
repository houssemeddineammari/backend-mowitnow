package com.mowitnow.backendmowitnow.servicesTest;

import org.junit.jupiter.api.Test;

import com.mowitnow.backendmowitnow.entities.Coordinates;
import com.mowitnow.backendmowitnow.entities.MowerPosition;
import com.mowitnow.backendmowitnow.entities.Orientation;
import com.mowitnow.backendmowitnow.exceptions.MowerException;
import com.mowitnow.backendmowitnow.services.InstructionOperation;
import static org.junit.jupiter.api.Assertions.*;

public class InstructionOperationTest {

	@Test
	public void testAdvanceTondeuse_ValidMovement_ShouldUpdateCoordinates() throws MowerException {
		MowerPosition position = new MowerPosition(new Coordinates(1, 1), Orientation.NORTH);
		Coordinates newCoordinates = InstructionOperation.advanceMower(position, new Coordinates(5, 5));
		assertEquals(new Coordinates(1, 2), newCoordinates);
	}

	@Test
	public void testTurnRight_ShouldChangeOrientationCorrectly() throws MowerException {
		assertEquals(Orientation.EAST, InstructionOperation.turnRight(Orientation.NORTH));
		assertEquals(Orientation.SOUTH, InstructionOperation.turnRight(Orientation.EAST));
		assertEquals(Orientation.WEST, InstructionOperation.turnRight(Orientation.SOUTH));
		assertEquals(Orientation.NORTH, InstructionOperation.turnRight(Orientation.WEST));
	}

	@Test
	public void testTurnLeft_ShouldChangeOrientationCorrectly() throws MowerException {
		assertEquals(Orientation.WEST, InstructionOperation.turnLeft(Orientation.NORTH));
		assertEquals(Orientation.NORTH, InstructionOperation.turnLeft(Orientation.EAST));
		assertEquals(Orientation.EAST, InstructionOperation.turnLeft(Orientation.SOUTH));
		assertEquals(Orientation.SOUTH, InstructionOperation.turnLeft(Orientation.WEST));
	}

	@Test
	public void testAdvanceTondeuse_OutOfBounds_ShouldThrowMowerException() {
		MowerPosition mowerPosition = new MowerPosition(new Coordinates(5, 5), Orientation.NORTH);
		Coordinates coordonnesMax = new Coordinates(5, 5);
		assertThrows(MowerException.class, () -> InstructionOperation.advanceMower(mowerPosition, coordonnesMax));
	}

	@Test
	public void testTurnRight_NullOrientation_ShouldThrowMowerException() {
		assertThrows(MowerException.class, () -> InstructionOperation.turnRight(null));
	}

	@Test
	public void testTurnLeft_NullOrientation_ShouldThrowMowerException() {
		assertThrows(MowerException.class, () -> InstructionOperation.turnLeft(null));
	}

	@Test
	public void testAdvanceTondeuse_MoveSouth_ShouldDecrementY() throws MowerException {
		MowerPosition position = new MowerPosition(new Coordinates(2, 2), Orientation.SOUTH);
		Coordinates boundaries = new Coordinates(5, 5);
		Coordinates result = InstructionOperation.advanceMower(position, boundaries);
		assertEquals(new Coordinates(2, 1), result);
	}

	@Test
	public void testAdvanceTondeuse_MoveWest_ShouldDecrementX() throws MowerException {
		MowerPosition position = new MowerPosition(new Coordinates(2, 2), Orientation.WEST);
		Coordinates boundaries = new Coordinates(5, 5);
		Coordinates result = InstructionOperation.advanceMower(position, boundaries);
		assertEquals(new Coordinates(1, 2), result);
	}

	@Test
	public void testTurnRight_InvalidOrientation_ShouldThrowMowerException() {
		assertThrows(MowerException.class, () -> InstructionOperation.turnRight(null)); // Déjà présent
	}

	@Test
	public void testTurnLeft_InvalidOrientation_ShouldThrowMowerException() {
		assertThrows(MowerException.class, () -> InstructionOperation.turnLeft(null)); // Déjà présent
	}

	@Test
	public void testExecuterInstruction_InvalidCommand_ShouldThrowMowerException() {
		MowerPosition position = new MowerPosition(new Coordinates(1, 1), Orientation.NORTH);
		Coordinates coordonnesMax = new Coordinates(5, 5);
		assertThrows(MowerException.class,
				() -> InstructionOperation.executerInstruction(position, null, coordonnesMax));
	}
}