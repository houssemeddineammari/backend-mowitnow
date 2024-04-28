package com.mowitnow.backendmowitnow.services;

import java.util.ArrayList;
import java.util.List;

import com.mowitnow.backendmowitnow.entities.Lawn;
import com.mowitnow.backendmowitnow.entities.MowerCommand;
import com.mowitnow.backendmowitnow.entities.MowerPosition;
import com.mowitnow.backendmowitnow.exceptions.MowerException;

public class MowerOperation {
	private Lawn pelouse;
	private MowerPosition positionTondeuse;
	private List<MowerCommand> orderTondeuseList;

	public void setPelouse(Lawn pelouse) {
		this.pelouse = pelouse;
	}

	public void setPositionTondeuse(MowerPosition positionTondeuse) {
		this.positionTondeuse = positionTondeuse;
	}

	public void setListeInstruction(List<MowerCommand> orderTondeuseList) {
		this.orderTondeuseList = (orderTondeuseList != null) ? orderTondeuseList : new ArrayList<>();
	}

	public void executerInstructions() throws MowerException {
		try {
			for (MowerCommand order : orderTondeuseList) {
				InstructionOperation.executerInstruction(positionTondeuse, order, pelouse.getPositionMax());
			}
		} catch (MowerException e) {
			System.err.println("Failed to execute instruction due to: " + e.getMessage());
			throw e;
		}
	}

	@Override
	public String toString() {
		return positionTondeuse.getMowerCoordinates().getX() + " " + positionTondeuse.getMowerCoordinates().getY() + " "
				+ positionTondeuse.getMowerOrientation().getCodeOrientation();
	}
}
