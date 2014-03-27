package edu.cmu.sv.surya.katas;

import edu.cmu.sv.surya.katas.Grid.Direction;

public class Rover {
	private Position position;
	private Direction direction;

	public Rover(Position position, Direction direction) {
		super();
		this.position = position;
		this.direction = direction;
	}

	public void turnLeft() {
		direction = Direction.get((direction.getCode() + 3) % 4); 
	}

	public void turnRight() {
		direction = Direction.get((direction.getCode() + 1) % 4);
	}

	public void advanceTo(Position newPosition) {
		this.position = newPosition;
	}

	public Position getPosition() {
		return position;
	}

	public Direction getDirection() {
		return direction;
	}

	@Override
	public String toString() {
		return "[Rover: position = " + position + ", direction = " + direction + "]";
	}
}
