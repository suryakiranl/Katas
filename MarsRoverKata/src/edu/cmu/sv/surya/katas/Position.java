package edu.cmu.sv.surya.katas;

public class Position {
	private int XPos;
	private int YPos;
	private GridSize gridSize;

	public Position(int xPos, int yPos, GridSize gridSize) {
		super();
		XPos = xPos;
		YPos = yPos;
		this.gridSize = gridSize;
	}
	
	public Position(int xPos, int yPos) {
		super();
		XPos = xPos;
		YPos = yPos;
	}

	public void moveRight() {
		YPos += 1;
		if (YPos >= gridSize.getMaxY()) {
			YPos = 0;
		}
	}

	public void moveLeft() {
		YPos -= 1;
		if (YPos < 0) {
			YPos = gridSize.getMaxY() - 1;
		}
	}

	public void moveUp() {
		XPos -= 1;
		if (XPos < 0) {
			XPos = gridSize.getMaxX() - 1;
		}
	}

	public void moveDown() {
		XPos += 1;
		if(XPos >= gridSize.getMaxX()) {
			XPos = 0;
		}
	}

	@Override
	public String toString() {
		return "[Position: x = " + XPos + ", y = " + YPos + " ]";
	}

	public int getXPos() {
		return XPos;
	}

	public int getYPos() {
		return YPos;
	}

	public GridSize getGridSize() {
		return gridSize;
	}
}
