package com.mowitnow.backendmowitnow.utils;

import java.util.ArrayList;
import java.util.List;

import com.mowitnow.backendmowitnow.entities.Coordinates;
import com.mowitnow.backendmowitnow.entities.Lawn;
import com.mowitnow.backendmowitnow.entities.MowerCommand;
import com.mowitnow.backendmowitnow.entities.MowerPosition;
import com.mowitnow.backendmowitnow.entities.Orientation;

public class MowerUtils {

	private static final String CHAINE_ESPACE = " ";

	public static MowerPosition getMowerInfo(String ligneTondeuse) {
		String[] elts = ligneTondeuse.split(CHAINE_ESPACE);
		Coordinates pCoordonneesTondeuse = new Coordinates(Integer.valueOf(elts[0]), Integer.valueOf(elts[1]));
		Orientation orientationTondeuse = getOrientation(elts[2].charAt(0));
		return new MowerPosition(pCoordonneesTondeuse, orientationTondeuse);
	}

	public static Lawn getLawnInfo(String lignePelouse) {
		String[] elts = lignePelouse.split(CHAINE_ESPACE);
		return new Lawn(new Coordinates(Integer.valueOf(elts[0]), Integer.valueOf(elts[1])));
	}

	public static List<MowerCommand> getInstructionsInfo(String ligneInstruction) {
		List<MowerCommand> listInstruction = new ArrayList<MowerCommand>();
		for (char instruction : ligneInstruction.toCharArray()) {
			listInstruction.add(getInstruction(instruction));
		}
		return listInstruction;
	}

	public static Orientation getOrientation(char cOrientation) {
		for (Orientation orientation : Orientation.values()) {
			if (orientation.getCodeOrientation() == cOrientation) {
				return orientation;
			}
		}
		return null;
	}

	public static MowerCommand getInstruction(char cInstruction) {
		for (MowerCommand instruction : MowerCommand.values()) {
			if (instruction.getCodeInstruction() == cInstruction) {
				return instruction;
			}
		}
		return null;
	}
}
