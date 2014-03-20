package edu.cmu.sv.surya.katas;

import java.util.Set;

public class Grid {
	public static enum Direction {
		EAST, WEST, NORTH, SOUTH
	}

	private GridSize gridSize;
	private Rover rover;
	private Set<Position> obstacles;

	private void validateRoverPosition() {
		StringBuffer exceptionMessage = new StringBuffer(
				"Homer, you cannot place the rover ");
		boolean raiseException = false;

		if (rover.getCurrentPosition().getXPos() < 0
				|| rover.getCurrentPosition().getYPos() < 0
				|| rover.getCurrentPosition().getXPos() >= gridSize.getMaxX()
				|| rover.getCurrentPosition().getYPos() >= gridSize.getMaxY()) {
			raiseException = true;
			exceptionMessage.append("outside the grid!!");
		}

		if (obstacles.contains(rover.getCurrentPosition())) {
			raiseException = true;
			exceptionMessage.append("where an obstacle is!!");
		}

		if (raiseException) {
			throw new RuntimeException(exceptionMessage.toString());
		}
	}
}
