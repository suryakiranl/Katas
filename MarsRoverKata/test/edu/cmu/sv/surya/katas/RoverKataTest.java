package edu.cmu.sv.surya.katas;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.cmu.sv.surya.katas.Rover.Direction;

public class RoverKataTest {
	Rover rover;
	@Before
	public void beforeEachMethod() {
		GridSize size = new GridSize(100,100);
		Position initialPosition = new Position(0, 0,size);
		Direction initialDirection = Direction.EAST;
		
		rover = new Rover(initialPosition, initialDirection);
	}
	
	@Test
	public void test1() {
		String navigation = "f";
		RoverKata.traverse(rover, navigation);
		assertEquals(rover.getCurrentPosition().getXPos(), 0);
		assertEquals(rover.getCurrentPosition().getYPos(), 1);
		assertEquals(rover.getDirection(), Direction.EAST);
	}
	
	@Test
	public void test2() {
		String navigation = "ff";
		RoverKata.traverse(rover, navigation);
		assertEquals(rover.getCurrentPosition().getXPos(), 0);
		assertEquals(rover.getCurrentPosition().getYPos(), 2);
		assertEquals(rover.getDirection(), Direction.EAST);
	}
	
	@Test
	public void test3() {
		String navigation = "b";
		RoverKata.traverse(rover, navigation);
		assertEquals(rover.getCurrentPosition().getXPos(), 0);
		assertEquals(rover.getCurrentPosition().getYPos(), 99);
		assertEquals(rover.getDirection(), Direction.EAST);
	}
	
	@Test
	public void test4() {
		String navigation = "bb";
		RoverKata.traverse(rover, navigation);
		assertEquals(rover.getCurrentPosition().getXPos(), 0);
		assertEquals(rover.getCurrentPosition().getYPos(), 98);
		assertEquals(rover.getDirection(), Direction.EAST);
	}
	
	@Test
	public void test5() {
		String navigation = "fb";
		RoverKata.traverse(rover, navigation);
		assertEquals(rover.getCurrentPosition().getXPos(), 0);
		assertEquals(rover.getCurrentPosition().getYPos(), 0);
		assertEquals(rover.getDirection(), Direction.EAST);
	}
	
	@Test
	public void test6() {
		String navigation = "r";
		RoverKata.traverse(rover, navigation);
		assertEquals(rover.getCurrentPosition().getXPos(), 0);
		assertEquals(rover.getCurrentPosition().getYPos(), 0);
		assertEquals(rover.getDirection(), Direction.SOUTH);
	}
	
	@Test
	public void test7() {
		String navigation = "rr";
		RoverKata.traverse(rover, navigation);
		assertEquals(rover.getCurrentPosition().getXPos(), 0);
		assertEquals(rover.getCurrentPosition().getYPos(), 0);
		assertEquals(rover.getDirection(), Direction.WEST);
	}
	
	@Test
	public void test8() {
		String navigation = "l";
		RoverKata.traverse(rover, navigation);
		assertEquals(rover.getCurrentPosition().getXPos(), 0);
		assertEquals(rover.getCurrentPosition().getYPos(), 0);
		assertEquals(rover.getDirection(), Direction.NORTH);
	}
	
	@Test
	public void test9() {
		String navigation = "ll";
		RoverKata.traverse(rover, navigation);
		assertEquals(rover.getCurrentPosition().getXPos(), 0);
		assertEquals(rover.getCurrentPosition().getYPos(), 0);
		assertEquals(rover.getDirection(), Direction.WEST);
	}
	
	@Test
	public void test10() {
		String navigation = "lr";
		RoverKata.traverse(rover, navigation);
		assertEquals(rover.getCurrentPosition().getXPos(), 0);
		assertEquals(rover.getCurrentPosition().getYPos(), 0);
		assertEquals(rover.getDirection(), Direction.EAST);
	}
	
	@Test
	public void test11() {
		String navigation = "frflblf";
		RoverKata.traverse(rover, navigation);
		assertEquals(rover.getCurrentPosition().getXPos(), 0);
		assertEquals(rover.getCurrentPosition().getYPos(), 0);
		assertEquals(rover.getDirection(), Direction.NORTH);
	}
	
	@Test
	public void test12() {
		String navigation = "ffrff";
		RoverKata.traverse(rover, navigation);
		assertEquals(rover.getCurrentPosition().getXPos(), 2);
		assertEquals(rover.getCurrentPosition().getYPos(), 2);
		assertEquals(rover.getDirection(), Direction.SOUTH);
	}

}
