
public class Cell {

	public int row;
	
	public int col;

	
	Cell(int row,int column) {
		this.row = row;
		this.col = column;
	}

	
	public String toString() {
		return "("+row+","+col+")";
	}


	public boolean equals(Cell other) {
		return (this.row==other.row && this.col==other.col);
	}
}
