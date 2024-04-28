package com.mowitnow.backendmowitnow.entities;

import java.util.Objects;

public class MowerPosition {
	private Coordinates mowerCoordinates;
	private Orientation mowerOrientation;

	public MowerPosition(Coordinates pMowerCoordinates, Orientation pMowerOrientation) {
		this.mowerCoordinates = pMowerCoordinates;
		this.mowerOrientation = pMowerOrientation;
	}

	public Coordinates getMowerCoordinates() {
		return mowerCoordinates;
	}

	public void setMowerCoordinates(Coordinates mowerCoordinates) {
		this.mowerCoordinates = mowerCoordinates;
	}

	public Orientation getMowerOrientation() {
		return mowerOrientation;
	}

	public void setMowerOrientation(Orientation mowerOrientation) {
		this.mowerOrientation = mowerOrientation;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		MowerPosition that = (MowerPosition) o;
		return Objects.equals(mowerCoordinates, that.mowerCoordinates) && mowerOrientation == that.mowerOrientation;
	}

	@Override
	public int hashCode() {
		return Objects.hash(mowerCoordinates, mowerOrientation);
	}
}
