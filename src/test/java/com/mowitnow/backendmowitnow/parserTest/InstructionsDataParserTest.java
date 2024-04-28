package com.mowitnow.backendmowitnow.parserTest;

import org.junit.jupiter.api.Test;

import com.mowitnow.backendmowitnow.exceptions.DataFormatException;
import com.mowitnow.backendmowitnow.exceptions.InvalidInstructionException;
import com.mowitnow.backendmowitnow.parser.InstructionsDataParser;

import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.junit.jupiter.api.Assertions.*;

public class InstructionsDataParserTest {

	@Test
	public void testParseTondeuse_ValidInput_ShouldPass() throws DataFormatException {
		assertTrue(InstructionsDataParser.parseMower("1 2 N"));
	}

	@Test
	public void testParseTondeuse_InvalidInput_ShouldThrowDataFormatException() {
		assertThrows(DataFormatException.class, () -> InstructionsDataParser.parseMower("1 Z N"));
	}

	@Test
	public void testParseListInstruction_ValidInput_ShouldPass() throws InvalidInstructionException {
		assertTrue(InstructionsDataParser.parseListInstruction("AAGD"));
	}

	@Test
	public void testParseListInstruction_InvalidInput_ShouldThrowInvalidInstructionException() {
		assertThrows(InvalidInstructionException.class, () -> InstructionsDataParser.parseListInstruction("AAGDX"));
	}

	@Test
	public void testParsePelouse_ValidInput_ShouldPass() throws DataFormatException {
		assertTrue(InstructionsDataParser.parseLawn("5 5"));
	}

	@Test
	public void testParsePelouse_InvalidInput_ShouldThrowDataFormatException() {
		assertThrows(DataFormatException.class, () -> InstructionsDataParser.parseLawn("5 Z"));
	}
}