package edu.cmu.sv.surya.katas;

import edu.cmu.sv.surya.katas.Rover.Direction;

public class RoverKata {
	public static void main(String[] args) {
		// Data for the kata
		GridSize size = new GridSize(100,100);
		Position initialPosition = new Position(0, 0, size);
		Direction initialDirection = Direction.EAST;
		String navigation = "ffrff";
		
		System.out.println("Directions are considered as follows: ");
		System.out.println(" N ");
		System.out.println("W  E");
		System.out.println(" S ");
		
		// Logic here
		Rover rover = new Rover(initialPosition, initialDirection);
		traverse(rover, navigation);
		System.out.println("Final position = " + rover.getCurrentPosition());
		System.out.println("Final Direction = " + rover.getDirection());
	}
	
	public static final Rover traverse(Rover rover, String navigation) {
		char[] navigationRules = navigation.toLowerCase().toCharArray();
		
		for(char navRule : navigationRules) {
			switch(navRule) {
				case 'f': rover.moveForward(); break;
				case 'b': rover.moveBackwards(); break;
				case 'l': rover.turnLeft(); break;
				case 'r': rover.turnRight(); break;
			}
		}
		
		return rover;
	}
}
