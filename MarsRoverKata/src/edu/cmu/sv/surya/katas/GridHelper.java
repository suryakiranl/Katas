package edu.cmu.sv.surya.katas;

public class GridHelper {
	private GridSize gridSize;
	
	public GridHelper(GridSize gridSize) {
		this.gridSize = gridSize;
	}
	
	public Position getRightCell(Position currPos) {
		int yPos = (currPos.getYPos() + 1) % gridSize.getMaxY();
		return new Position(currPos.getXPos(), yPos);
	}

	public Position getLeftCell(Position currPos) {
		int yPos = currPos.getYPos() - 1;
		yPos = (yPos < 0) ? (gridSize.getMaxY() - 1) : yPos;
		return new Position(currPos.getXPos(), yPos);
	}

	public Position getTopCell(Position currPos) {
		int xPos = currPos.getXPos() - 1;
		xPos = (xPos < 0) ? (gridSize.getMaxX() - 1) : xPos;
		return new Position(xPos, currPos.getYPos());
	}

	public Position getBottomCell(Position currPos) {
		int xPos = (currPos.getXPos() + 1) % gridSize.getMaxX();
		return new Position(xPos, currPos.getYPos());
	}
}
