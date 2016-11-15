/* This top-level program takes the name of a file containing maze
 * information, and then reads this into a integers and an array
 * of strings. The Maze object is instantiated, solve() called on it
 * and the results (if any) are output on the console.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RunSolver {

	/**
	 * Runs an external test of the Maze class.
	 * The first line contains the number of rows and the number of columns.
	 * The second line contains the cell number of the entrance to the maze.
	 * The third line contains the cell number of the exit from the maze.
 	 */
	
	public static void main(String args[]) {
		if (args.length < 1) {
			System.err.println("usage: java RunSolver <mazefile");
			System.exit(1);
        	}
	
		Scanner infileScanner = null;
		String infileName = args[0];
		int rows, columns;
		int startRow, startColumn;
		int finishRow, finishColumn;

		try {
			infileScanner = new Scanner(new File(infileName));
		} catch (FileNotFoundException e) {
			System.out.println("Cannot open the given file: "+infileName);
			System.exit(1);
		}

		rows = infileScanner.nextInt();
		columns = infileScanner.nextInt();
		startRow = infileScanner.nextInt();
		startColumn = infileScanner.nextInt();
		finishRow = infileScanner.nextInt();
		finishColumn = infileScanner.nextInt();
		infileScanner.nextLine(); // clears the newline after the last int.
         
		String mazeData[] = new String[rows];
		String line = null;
		for (int row = 0; row < rows; row++) {
			line = infileScanner.nextLine();
			mazeData[row] = line.trim();
		}

		Maze maze = new Maze(mazeData, new Cell(startRow,startColumn),
			new Cell(finishRow,finishColumn));
			System.out.println(maze.toString());
			
	   CellDeque path = maze.solve();

		if (path == null || path.isEmpty()) {
			System.out.println("No path!!");
		} else {
			System.out.println("Solution found");
			while (!path.isEmpty()) {
				System.out.print(path.removeFirst()+" ");
			}
			System.out.println();
		}
	
	}
}
