package com.mowitnow.backendmowitnow.services;

import com.mowitnow.backendmowitnow.constants.Constant;
import com.mowitnow.backendmowitnow.entities.Coordinates;
import com.mowitnow.backendmowitnow.entities.MowerCommand;
import com.mowitnow.backendmowitnow.entities.MowerPosition;
import com.mowitnow.backendmowitnow.entities.Orientation;
import com.mowitnow.backendmowitnow.exceptions.MowerException;

public class InstructionOperation {

	public static Coordinates advanceMower(MowerPosition mowerPosition, Coordinates coordonnesMax)
			throws MowerException {
		int x = mowerPosition.getMowerCoordinates().getX();
		int y = mowerPosition.getMowerCoordinates().getY();

		switch (mowerPosition.getMowerOrientation()) {
		case NORTH:
			y++;
			break;
		case EAST:
			x++;
			break;
		case SOUTH:
			y--;
			break;
		case WEST:
			x--;
			break;
		}

		if (x > coordonnesMax.getX() || y > coordonnesMax.getY() || x < 0 || y < 0) {
			throw new MowerException("Mower is out of bounds.");
		}

		return new Coordinates(x, y);
	}

	public static Orientation turnRight(Orientation orientation) throws MowerException {
		if (orientation == null) {
			throw new MowerException("Orientation cannot be null");
		}

		switch (orientation) {
		case NORTH:
			return Orientation.EAST;
		case EAST:
			return Orientation.SOUTH;
		case SOUTH:
			return Orientation.WEST;
		case WEST:
			return Orientation.NORTH;
		default:
			throw new MowerException("Invalid orientation");
		}
	}

	public static Orientation turnLeft(Orientation orientation) throws MowerException {
		if (orientation == null) {
			throw new MowerException("Orientation cannot be null");
		}

		switch (orientation) {
		case NORTH:
			return Orientation.WEST;
		case EAST:
			return Orientation.NORTH;
		case SOUTH:
			return Orientation.EAST;
		case WEST:
			return Orientation.SOUTH;
		default:
			throw new MowerException("Invalid orientation");
		}
	}

	public static void executerInstruction(MowerPosition positionTondeuse, MowerCommand instruction,
			Coordinates coordonnesMax) throws MowerException {
		if (instruction == null) {
			throw new MowerException(Constant.INCORRECT_INSTRUCTION);
		}

		switch (instruction) {
		case AVANCER:
			positionTondeuse.setMowerCoordinates(InstructionOperation.advanceMower(positionTondeuse, coordonnesMax));
			break;
		case DROITE:
			positionTondeuse
					.setMowerOrientation(InstructionOperation.turnRight(positionTondeuse.getMowerOrientation()));
			break;
		case GAUCHE:
			positionTondeuse.setMowerOrientation(InstructionOperation.turnLeft(positionTondeuse.getMowerOrientation()));
			break;
		default:
			throw new MowerException(Constant.INCORRECT_INSTRUCTION);
		}
	}
}
