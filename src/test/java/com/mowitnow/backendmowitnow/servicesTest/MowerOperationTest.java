package com.mowitnow.backendmowitnow.servicesTest;

import org.junit.jupiter.api.Test;

import com.mowitnow.backendmowitnow.entities.Coordinates;
import com.mowitnow.backendmowitnow.entities.Lawn;
import com.mowitnow.backendmowitnow.entities.MowerCommand;
import com.mowitnow.backendmowitnow.entities.MowerPosition;
import com.mowitnow.backendmowitnow.entities.Orientation;
import com.mowitnow.backendmowitnow.exceptions.MowerException;
import com.mowitnow.backendmowitnow.services.MowerOperation;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class MowerOperationTest {

	@Test
	public void testExecuterInstructions_ValidCommands_ShouldUpdatePosition() throws MowerException {
		Lawn lawn = new Lawn(new Coordinates(5, 5));
		MowerPosition position = new MowerPosition(new Coordinates(1, 2), Orientation.NORTH);
		MowerOperation operation = new MowerOperation();
		operation.setPelouse(lawn);
		operation.setPositionTondeuse(position);
		operation.setListeInstruction(Arrays.asList(MowerCommand.AVANCER, MowerCommand.DROITE, MowerCommand.AVANCER));

		operation.executerInstructions();

		assertEquals(new Coordinates(2, 3), position.getMowerCoordinates());
		assertEquals(Orientation.EAST, position.getMowerOrientation());
	}

	@Test
	public void testExecuterInstructions_BoundaryCondition_ShouldThrowMowerException() {
		Lawn lawn = new Lawn(new Coordinates(2, 2));
		MowerPosition position = new MowerPosition(new Coordinates(2, 2), Orientation.NORTH);
		MowerOperation operation = new MowerOperation();
		operation.setPelouse(lawn);
		operation.setPositionTondeuse(position);
		operation.setListeInstruction(Arrays.asList(MowerCommand.AVANCER, MowerCommand.AVANCER));

		MowerException thrown = assertThrows(MowerException.class, operation::executerInstructions);
		assertEquals("Mower is out of bounds.", thrown.getMessage());
		assertEquals(new Coordinates(2, 2), position.getMowerCoordinates());
		assertEquals(Orientation.NORTH, position.getMowerOrientation());
	}
}