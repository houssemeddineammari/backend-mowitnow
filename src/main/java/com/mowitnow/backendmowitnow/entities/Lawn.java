package com.mowitnow.backendmowitnow.entities;

import java.util.Objects;

public class Lawn {
	private Coordinates positionMax;

	public Lawn(Coordinates pPositionMax) {
		this.positionMax = pPositionMax;
	}

	public Coordinates getPositionMax() {
		return positionMax;
	}

	public void setPositionMax(Coordinates positionMax) {
		this.positionMax = positionMax;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Lawn lawn = (Lawn) o;
		return Objects.equals(positionMax, lawn.positionMax);
	}

	@Override
	public int hashCode() {
		return Objects.hash(positionMax);
	}
}