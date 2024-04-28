package com.mowitnow.backendmowitnow.utilsTest;

import org.junit.jupiter.api.Test;

import com.mowitnow.backendmowitnow.entities.Coordinates;
import com.mowitnow.backendmowitnow.entities.Lawn;
import com.mowitnow.backendmowitnow.entities.MowerCommand;
import com.mowitnow.backendmowitnow.entities.MowerPosition;
import com.mowitnow.backendmowitnow.entities.Orientation;
import com.mowitnow.backendmowitnow.utils.MowerUtils;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class MowerUtilsTest {

	@Test
	public void testGetPelouseInfo_ValidFormat_ShouldReturnLawn() {
		Lawn expectedLawn = new Lawn(new Coordinates(5, 5));
		Lawn actualLawn = MowerUtils.getLawnInfo("5 5");
		assertEquals(expectedLawn.getPositionMax(), actualLawn.getPositionMax());
	}

	@Test
	public void testGetTonteuseInfo_ValidFormat_ShouldReturnMowerPosition() {
		MowerPosition expectedPosition = new MowerPosition(new Coordinates(3, 4), Orientation.NORTH);
		MowerPosition actualPosition = MowerUtils.getMowerInfo("3 4 N");
		assertEquals(expectedPosition.getMowerCoordinates(), actualPosition.getMowerCoordinates());
		assertEquals(expectedPosition.getMowerOrientation(), actualPosition.getMowerOrientation());
	}

	@Test
	public void testGetInstructionsInfo_ValidFormat_ShouldReturnCommandList() {
		List<MowerCommand> commands = MowerUtils.getInstructionsInfo("ADG");
		assertTrue(commands.contains(MowerCommand.AVANCER));
		assertTrue(commands.contains(MowerCommand.DROITE));
		assertTrue(commands.contains(MowerCommand.GAUCHE));
		assertEquals(3, commands.size());
	}

	@Test
	public void testGetOrientation_ValidCharacter_ShouldReturnOrientation() {
		assertEquals(Orientation.NORTH, MowerUtils.getOrientation('N'));
		assertEquals(Orientation.EAST, MowerUtils.getOrientation('E'));
		assertEquals(Orientation.SOUTH, MowerUtils.getOrientation('S'));
		assertEquals(Orientation.WEST, MowerUtils.getOrientation('W'));
	}

	@Test
	public void testGetOrientation_InvalidCharacter_ShouldReturnNull() {
		assertNull(MowerUtils.getOrientation('X'));
	}

	@Test
	public void testGetInstruction_ValidCharacter_ShouldReturnCommand() {
		assertEquals(MowerCommand.AVANCER, MowerUtils.getInstruction('A'));
		assertEquals(MowerCommand.DROITE, MowerUtils.getInstruction('D'));
		assertEquals(MowerCommand.GAUCHE, MowerUtils.getInstruction('G'));
	}

	@Test
	public void testGetInstruction_InvalidCharacter_ShouldReturnNull() {
		assertNull(MowerUtils.getInstruction('X'));
	}
}