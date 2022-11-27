package _04_Maze_Maker;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class MazeMaker {

    private static int rows;
    private static int cols;

    private static Maze maze;
    static Random ran = new Random();

    //private static Random randGen = new Random();
    private static Stack<Cell> uncheckedCells = new Stack<Cell>();

    public static Maze generateMaze(int r, int c) {
    	rows = r;
    	cols = c;
    	maze = new Maze(rows, cols);
    	Cell finishingCell;

    	// 1. Pick a random cell along the border and remove its exterior wall.
    	//    This will be the starting point. Then select a random cell along
    	//    the opposite wall and remove its exterior wall. This will be the
    	//    finish line.

    	r = ran.nextInt(rows);
    	c = ran.nextInt(cols);
    	while (r != 0 && r != rows-1 && c != 0 && c != cols-1) {
    		r = ran.nextInt(rows);
    		c = ran.nextInt(cols);

    	}
    	if (r == 0) {
    		maze.getCell(r, c).setNorthWall(false);
    		finishingCell = maze.getCell(rows-1, c = ran.nextInt(cols));
    		finishingCell.setSouthWall(false);
    	}
    	if (r == rows-1) {
    		maze.getCell(r, c).setSouthWall(false);
    		finishingCell = maze.getCell(0, c = ran.nextInt(cols));
    		finishingCell.setNorthWall(false);
    	}
    	if (c == 0) {
    		maze.getCell(r, c).setWestWall(false);
    		finishingCell = maze.getCell(r = ran.nextInt(rows), cols-1);
    		finishingCell.setEastWall(false);
    	}
    	if (c == cols-1) {
    		maze.getCell(r, c).setEastWall(false);
    		finishingCell = maze.getCell(r = ran.nextInt(rows), 0);
    		finishingCell.setWestWall(false);
    	}

    	// 2. select a random cell in the maze to start 
    	Cell startingCell = maze.getCell(r = ran.nextInt(rows), c = ran.nextInt(cols));
    	// 3. call the selectNextPath method with the randomly selected cell
    	selectNextPath(startingCell);
    	
    	
    	
    	
    	
    	return maze;
    }

    // 4. Complete the selectNextPathMethod
    private static void selectNextPath(Cell currentCell) {
    	// A. SET currentCell as visited
    	currentCell.setBeenVisited(true);
    	// B. check for unvisited neighbors using the cell
    	ArrayList<Cell> roommates = getUnvisitedNeighbors(currentCell);


    	// C. if has unvisited neighbors,
    	if (roommates.size() > 0) {
    		// C1. select one at random.
    		Cell swag = roommates.get(ran.nextInt(roommates.size()));
    				
    		//uncheckedCells.add(roommates.get(ran.nextInt(roommates.size())));
    		// C2. push it to the stack
    		uncheckedCells.push(swag);
    		// C3. remove the wall between the two cells
    		removeWalls(currentCell, swag);
    		// C4. make the new cell the current cell and SET it as visited
    		currentCell = swag;
    		currentCell.setBeenVisited(true);
    		// C5. call the selectNextPath method with the current cell
    		selectNextPath(currentCell);
    	}

    	// D. if all neighbors are visited
    	if (uncheckedCells.size() > 0){ 
    		// D1. if the stack is not empty

    		// D1a. pop a cell from the stack
    		currentCell = uncheckedCells.pop();
    		// D1b. make that the current cell

    		// D1c. call the selectNextPath method with the current cell
    		selectNextPath(currentCell);
    	}
    }

    // This method will check if c1 and c2 are adjacent.
    // If they are, the walls between them are removed.
    private static void removeWalls(Cell c1, Cell c2) {
    	if (c1.getRow() == c2.getRow()) {
    		if (c1.getCol() > c2.getCol()) {
    			c1.setWestWall(false);
    			c2.setEastWall(false);
    		} else {
    			c1.setEastWall(false);
    			c2.setWestWall(false);
    		}
    	} else {
    		if (c1.getRow() > c2.getRow()) {
    			c1.setNorthWall(false);
    			c2.setSouthWall(false);
    		} else {
    			c1.setSouthWall(false);
    			c2.setNorthWall(false);
    		}
    	}
    }

    // This method returns a list of all the neighbors around the specified
    // cell that have not been visited. There are up to 4 neighbors per cell.
    //          1
    //       2 cell 3
    //          4
    private static ArrayList<Cell> getUnvisitedNeighbors(Cell c) {
    	int row = c.getRow();
    	int col = c.getCol();

    	ArrayList<Cell> unvisitedNeighbors = new ArrayList<Cell>();

    	if (row > 0 && !maze.getCell(row - 1, col).hasBeenVisited()) {
    		unvisitedNeighbors.add(maze.getCell(row - 1, col));
    	}

    	if (col > 0 && !maze.getCell(row, col - 1).hasBeenVisited()) {
    		unvisitedNeighbors.add(maze.getCell(row, col - 1));
    	}

    	if (row < rows - 1 && !maze.getCell(row + 1, col).hasBeenVisited()) {
    		unvisitedNeighbors.add(maze.getCell(row + 1, col));
    	}

    	if (col < cols - 1 && !maze.getCell(row, col + 1).hasBeenVisited()) {
    		unvisitedNeighbors.add(maze.getCell(row, col + 1));
    	}

    	return unvisitedNeighbors;
    }
}
