package edu.cmu.sv.surya.katas;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import edu.cmu.sv.surya.katas.Grid.Direction;

public class RoverKataTest {
	Grid grid;
	@Before
	public void beforeEachMethod() {
		GridSize gridSize = new GridSize(100,100);
		grid = new Grid(gridSize);
		
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

	}
	
	@Test
	public void test1() {
		String navigation = "f";
		grid.traverse(navigation);
		assertEquals(grid.getRover().getPosition().getXPos(), 0);
		assertEquals(grid.getRover().getPosition().getYPos(), 1);
		assertEquals(grid.getRover().getDirection(), Direction.EAST);
	}
	
	@Test
	public void test2() {
		String navigation = "ff";
		grid.traverse(navigation);
		assertEquals(grid.getRover().getPosition().getXPos(), 0);
		assertEquals(grid.getRover().getPosition().getYPos(), 2);
		assertEquals(grid.getRover().getDirection(), Direction.EAST);
	}
	
	@Test
	public void test3() {
		String navigation = "b";
		grid.traverse(navigation);
		assertEquals(grid.getRover().getPosition().getXPos(), 0);
		assertEquals(grid.getRover().getPosition().getYPos(), 99);
		assertEquals(grid.getRover().getDirection(), Direction.EAST);
	}
	
	@Test
	public void test4() {
		String navigation = "bb";
		grid.traverse(navigation);
		assertEquals(grid.getRover().getPosition().getXPos(), 0);
		assertEquals(grid.getRover().getPosition().getYPos(), 98);
		assertEquals(grid.getRover().getDirection(), Direction.EAST);
	}
	
	@Test
	public void test5() {
		String navigation = "fb";
		grid.traverse(navigation);
		assertEquals(grid.getRover().getPosition().getXPos(), 0);
		assertEquals(grid.getRover().getPosition().getYPos(), 0);
		assertEquals(grid.getRover().getDirection(), Direction.EAST);
	}
	
	@Test
	public void test6() {
		String navigation = "r";
		grid.traverse(navigation);
		assertEquals(grid.getRover().getPosition().getXPos(), 0);
		assertEquals(grid.getRover().getPosition().getYPos(), 0);
		assertEquals(grid.getRover().getDirection(), Direction.SOUTH);
	}
	
	@Test
	public void test7() {
		String navigation = "rr";
		grid.traverse(navigation);
		assertEquals(grid.getRover().getPosition().getXPos(), 0);
		assertEquals(grid.getRover().getPosition().getYPos(), 0);
		assertEquals(grid.getRover().getDirection(), Direction.WEST);
	}
	
	@Test
	public void test8() {
		String navigation = "l";
		grid.traverse(navigation);
		assertEquals(grid.getRover().getPosition().getXPos(), 0);
		assertEquals(grid.getRover().getPosition().getYPos(), 0);
		assertEquals(grid.getRover().getDirection(), Direction.NORTH);
	}
	
	@Test
	public void test9() {
		String navigation = "ll";
		grid.traverse(navigation);
		assertEquals(grid.getRover().getPosition().getXPos(), 0);
		assertEquals(grid.getRover().getPosition().getYPos(), 0);
		assertEquals(grid.getRover().getDirection(), Direction.WEST);
	}
	
	@Test
	public void test10() {
		String navigation = "lr";
		grid.traverse(navigation);
		assertEquals(grid.getRover().getPosition().getXPos(), 0);
		assertEquals(grid.getRover().getPosition().getYPos(), 0);
		assertEquals(grid.getRover().getDirection(), Direction.EAST);
	}
	
	@Test(expected=RuntimeException.class)
	public void test11() {
		String navigation = "frflblf";
		grid.traverse(navigation);
	}
	
	@Test
	public void test12() {
		String navigation = "ffrff";
		grid.traverse(navigation);
		assertEquals(grid.getRover().getPosition().getXPos(), 2);
		assertEquals(grid.getRover().getPosition().getYPos(), 2);
		assertEquals(grid.getRover().getDirection(), Direction.SOUTH);
	}

}
