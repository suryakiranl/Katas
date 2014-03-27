package edu.cmu.sv.surya.katas;

import java.util.HashSet;
import java.util.Set;

import edu.cmu.sv.surya.katas.Grid.Direction;

public class MissionControl {

	public static void main(String[] args) {
		GridSize gridSize = new GridSize(100,100);
		Grid grid = new Grid(gridSize);
		
		Set<Position> obstacles = new HashSet<Position>();
		obstacles.add(new Position(1, 1));
		obstacles.add(new Position(10, 18));
		obstacles.add(new Position(9, 11));
		obstacles.add(new Position(11, 7));
		obstacles.add(new Position(50, 50));
		obstacles.add(new Position(93, 3));
		grid.setObstacles(obstacles);
		
		Position initialPosition = new Position(0, 0);
		Direction initialDirection = Direction.EAST;
		grid.placeRoverOnGrid(initialPosition, initialDirection);
		System.out.println("Rover's initial state: " + grid.getRover());
		
		String navigationRules = "ffrfflfrffflbbbr";
		System.out.println("Navigation rules: " + navigationRules);
		
		grid.traverse(navigationRules);
		System.out.println("Current state of the rover after navigating: " + grid.getRover());
	}

}
