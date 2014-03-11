package edu.cmu.sv.surya.katas;

public class Rover {
	public static enum Direction {
		EAST, WEST, NORTH, SOUTH
	}

	private Position currentPosition;
	private Direction direction;

	public Rover(Position currentPosition, Direction direction) {
		super();
		this.currentPosition = currentPosition;
		this.direction = direction;
	}
	
	public Position getCurrentPosition() {
		return currentPosition;
	}

	public Direction getDirection() {
		return direction;
	}

	public void moveForward() {
		switch(direction) {
			case EAST: currentPosition.moveRight(); break;
			case WEST: currentPosition.moveLeft(); break;
			case NORTH: currentPosition.moveUp(); break;
			case SOUTH: currentPosition.moveDown(); break;
		}
	}

	public void moveBackwards() {
		switch(direction) {
			case EAST: currentPosition.moveLeft(); break;
			case WEST: currentPosition.moveRight(); break;
			case NORTH: currentPosition.moveDown(); break;
			case SOUTH: currentPosition.moveUp(); break;
		}
	}

	public void turnLeft() {
		switch(direction) {
			case EAST: direction = Direction.NORTH; break;
			case WEST: direction = Direction.SOUTH; break;
			case NORTH: direction = Direction.WEST; break;
			case SOUTH: direction = Direction.EAST; break;
		}
	}

	public void turnRight() {
		switch(direction) {
			case EAST: direction = Direction.SOUTH; break;
			case WEST: direction = Direction.NORTH; break;
			case NORTH: direction = Direction.EAST; break;
			case SOUTH: direction = Direction.WEST; break;
		}
	}

	
}
