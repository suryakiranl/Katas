package edu.cmu.sv.surya.katas;

import java.util.Set;

public class Grid {
	public static enum Direction {
		EAST, WEST, NORTH, SOUTH
	}

	private GridSize gridSize;
	private Rover rover;
	private Set<Position> obstacles;

	public Grid() {
		initializeGrid();
	}

	private void initializeGrid() {
		// Data for the kata
		gridSize = new GridSize(100, 100);

		System.out
				.println("Directions for the grid are considered as follows: ");
		System.out.println(" N ");
		System.out.println("W  E");
		System.out.println(" S ");
	}

	public void placeRoverOnGrid(Position initialPosition,
			Direction initialDirection) {
		rover = new Rover(initialPosition, initialDirection);
		validateRoverPosition();
	}

	public Rover traverse(String navigation) {
		if (rover == null) {
			throw new RuntimeException("Yikes, I did not find a rover on the map!!");
		}

		if (navigation == null || "".equalsIgnoreCase(navigation.trim())) {
			System.out.println("No command to process and navigate.");
			return rover;
		}

		char[] navigationRules = navigation.toLowerCase().toCharArray();

		for (char navRule : navigationRules) {
			switch (navRule) {
			case 'f':
				rover.moveForward();
				break;
			case 'b':
				rover.moveBackwards();
				break;
			case 'l':
				rover.turnLeft();
				break;
			case 'r':
				rover.turnRight();
				break;
			default:
				throw new RuntimeException(
						"Oops, you gave a wrong command boss!!");
			}
		}

		return rover;
	}

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
