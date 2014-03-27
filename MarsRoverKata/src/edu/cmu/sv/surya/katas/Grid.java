package edu.cmu.sv.surya.katas;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Grid {
	public static enum Direction {
		EAST(1), WEST(3), NORTH(0), SOUTH(2);
		
		private static final Map<Integer, Direction> lookup = 
				new HashMap<Integer, Direction>();
		static {
			for(Direction d : EnumSet.allOf(Direction.class))
		           lookup.put(d.getCode(), d);
		}
		
		private int code;
		private Direction(int code) {
			this.code = code;
		}
		public int getCode() {
			return this.code;
		}
		public static Direction get(int code) { 
		      return lookup.get(code); 
		}
	}

	private GridSize gridSize;
	private Rover rover;
	private Set<Position> obstacles;
	private GridHelper helper;

	public Grid(GridSize gridSize) {
		this.gridSize = gridSize;
		helper = new GridHelper(gridSize);
	}
	
	public static  void printDirectionGuidelines() {
		System.out.println("Directions for the grid are considered as follows: ");
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
			navigate(navRule);
		}

		return rover;
	}
	
	private void navigate(char navigationRule) {
		switch (navigationRule) {
		case 'f': 
		case 'b':
			Position newPosition = getNextPosition(navigationRule);
			if(obstacles.contains(newPosition)) {
				throw new RuntimeException("Oops, I ran into an obstacle !!!");
			}
			rover.advanceTo(newPosition);
			break;
		case 'l': rover.turnLeft(); break;
		case 'r': rover.turnRight(); break;
		default: throw new RuntimeException("Oops, you gave a wrong command Homer!!");
		}
	}
	
	private Position getNextPosition(char navigationRule) {
		Position newPosition = null;
		Position currPos = rover.getPosition();
		
		switch(rover.getDirection()) {
			case EAST: 
				newPosition = (navigationRule == 'f') ? helper
					.getRightCell(currPos) : helper.getLeftCell(currPos);
				break;
			case NORTH:
				newPosition = (navigationRule == 'f') ? helper
						.getTopCell(currPos) : helper.getBottomCell(currPos);
				break;
			case SOUTH:
				newPosition = (navigationRule == 'f') ? helper
						.getBottomCell(currPos) : helper.getTopCell(currPos);
				break;
			case WEST:
				newPosition = (navigationRule == 'f') ? helper
						.getLeftCell(currPos) : helper.getRightCell(currPos);
				break;
		}
		
		return newPosition;
	}

	private void validateRoverPosition() {
		StringBuffer exceptionMessage = new StringBuffer(
				"Homer, you cannot place the rover ");
		boolean raiseException = false;

		if (rover.getPosition().getXPos() < 0
				|| rover.getPosition().getYPos() < 0
				|| rover.getPosition().getXPos() >= gridSize.getMaxX()
				|| rover.getPosition().getYPos() >= gridSize.getMaxY()) {
			raiseException = true;
			exceptionMessage.append("outside the grid!!");
		}

		if (obstacles.contains(rover.getPosition())) {
			raiseException = true;
			exceptionMessage.append("where an obstacle is!!");
		}

		if (raiseException) {
			throw new RuntimeException(exceptionMessage.toString());
		}
	}
	
	public void setObstacles(Set<Position> obstacles) {
		this.obstacles = obstacles;
	}

	public Rover getRover() {
		return rover;
	}

	
}
