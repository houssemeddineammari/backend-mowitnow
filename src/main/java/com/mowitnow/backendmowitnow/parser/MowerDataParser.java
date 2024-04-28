package com.mowitnow.backendmowitnow.parser;

import com.mowitnow.backendmowitnow.exceptions.DataFormatException;
import com.mowitnow.backendmowitnow.exceptions.InvalidInstructionException;

public class MowerDataParser {
	private String lawn;
	private String mower;
	private String instructions;

	public void setLawn(String lawn) throws DataFormatException {
		InstructionsDataParser.parseLawn(lawn);
		this.lawn = lawn;
	}

	public void setMower(String mower) throws DataFormatException {
		InstructionsDataParser.parseMower(mower);
		this.mower = mower;
	}

	public void setInstructions(String instructions) throws InvalidInstructionException {
		InstructionsDataParser.parseListInstruction(instructions);
		this.instructions = instructions;
	}

	public String getLawn() {
		return lawn;
	}

	public String getMower() {
		return mower;
	}

	public String getInstructions() {
		return instructions;
	}
}