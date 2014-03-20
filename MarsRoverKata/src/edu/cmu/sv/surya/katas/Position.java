package edu.cmu.sv.surya.katas;

public class Position {
	private int XPos;
	private int YPos;
	
	public Position(int xPos, int yPos) {
		super();
		XPos = xPos;
		YPos = yPos;
	}

	@Override
	public boolean equals(Object pos) {
		if (pos instanceof Position && XPos == ((Position) pos).getXPos()
				&& YPos == ((Position) pos).getYPos()) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		int hash = 7;
		hash = hash * 23 + XPos;
		hash = hash * 23 + YPos;
		
		return hash;
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
}
