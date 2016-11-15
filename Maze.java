public class Maze{

	char[][] mazeData;
	Cell start;
	Cell finish;
	Cell temp = null;
	CellDeque path;
	
	public Maze(String[] data, Cell start, Cell finish){
		//fil up mazeData
		mazeData = new char[data.length][data[0].length()];
		for(int r=0; r<data.length; r++){
			for(int c=0; c<data[r].length(); c++){
			mazeData[r][c] = data[r].charAt(c); // 2D character array
			}
		}
		
		this.start = start;
		this.finish = finish;
		path = new CellDeque();
	}
	
	public CellDeque solve(){
		
		boolean solved = findPath(this.start, this.finish);
		if(solved){
		System.out.println("solved");
		}
		else{
		System.out.println("solved");
		}
		
		return path;
	}
	
	private boolean findPath(Cell cur, Cell finish){
	
		System.out.println("We are at " +cur);
		System.out.println("need to reach "+finish);
		mazeData[cur.row][cur.col] = 'v';
		System.out.println(toString());
	
		if(cur.equals(finish)){
			System.out.println("reached destination");
			return true;
		}
 
		// check neighbouring cells 
	
		//down
		if(mazeData[cur.row+1][cur.col] == ' '){
	    temp = new Cell(cur.row+1, cur.col);
	    path.insertLast(temp);
	    if(findPath(temp,finish) == true){
			return true;
			}
		}
		//right
		 if(mazeData[cur.row][cur.col+1] == ' '){
		 temp = new Cell(cur.row, cur.col+1);
		 path.insertLast(temp);
		 
		 if(findPath(temp,finish) == true){
			return true;
			}
		}
		//left
		 if(mazeData[cur.row-1][cur.col] == ' '){
			 temp = new Cell(cur.row-1, cur.col);
		 	path.insertLast(temp);
		 
			if(findPath(temp,finish) == true){
				return true;
			}
		}
		//up
		 if(mazeData[cur.row][cur.col-1] == ' '){
			 temp = new Cell(cur.row, cur.col-1);
			 path.insertLast(temp);
		
			if(findPath(temp,finish) == true){
				return true;
			}
		}
	
		// Backtracking
        
		mazeData[cur.row][cur.col] = 'B';
		path.removeLast();
			return false;
	}
	
	
	public java.lang.String toString(){
		String details = "";
		for(int r=0; r<mazeData.length; r++){
			for(int c=0; c<mazeData[r].length; c++){
				details = details + mazeData[r][c];
			}
			details += "\n";
		}
		return details;
	}
}

