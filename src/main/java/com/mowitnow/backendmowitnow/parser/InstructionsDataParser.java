package com.mowitnow.backendmowitnow.parser;

import com.mowitnow.backendmowitnow.exceptions.DataFormatException;
import com.mowitnow.backendmowitnow.exceptions.InvalidInstructionException;

public class InstructionsDataParser {

	public static boolean parseMower(String mower) throws DataFormatException {
		if (!mower.matches("\\d+ \\d+ [NESW]")) {
			throw new DataFormatException("Mower data format error: " + mower
					+ ". Expected format: 'x y [NESW]'.");
		}
		return true;
	}

	public static boolean parseListInstruction(String instructions) throws InvalidInstructionException {
		if (!instructions.matches("[ADG]+")) {
			throw new InvalidInstructionException("Instruction format error: " + instructions
					+ ". Only 'A', 'D', 'G' allowed.");
		}
		return true;
	}

	public static boolean parseLawn(String lawn) throws DataFormatException {
		if (!lawn.matches("\\d+ \\d+")) {
			throw new DataFormatException("Lawn dimensions format error: " + lawn
					+ ". Expected format: 'width length'.");
		}
		return true;
	}
}