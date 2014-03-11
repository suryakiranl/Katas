package edu.cmu.sv.surya.katas;

public class GridSize {
	private int maxX;
	private int maxY;

	public int getMaxX() {
		return maxX;
	}

	public void setMaxX(int maxX) {
		this.maxX = maxX;
	}

	public int getMaxY() {
		return maxY;
	}

	public void setMaxY(int maxY) {
		this.maxY = maxY;
	}

	public GridSize(int maxX, int maxY) {
		super();
		this.maxX = maxX;
		this.maxY = maxY;
	}
}
