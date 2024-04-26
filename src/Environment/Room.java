package Environment;

import java.util.ArrayList;

public class Room {
    private ArrayList<ArrayList<SpaceType>> cellsOccupancy;
    private CustomPanel grid = new CustomPanel();
    private int numRows;
    private int numCols;

    // Constructor
    public Room() {
        ArrayList<Integer> roomSize = paintGrid();
        // TODO is this the best way to set the room size? discuss with team
        this.numRows = roomSize.get(1);
        this.numCols = roomSize.get(2);
        cellsOccupancy = new ArrayList<>(numRows);
        // Initialize the rows
        for (int i = 0; i < numRows; i++) {
            cellsOccupancy.add(new ArrayList<>(numCols));
            // Initialize the columns within each row
            for (int j = 0; j < numCols; j++) {
                cellsOccupancy.get(i).add(SpaceType.EMPTY); // SpaceType.EMPTY is the default value for the moment
            }
        }
    }

    // Method to get the space at a specific coordinate
    public SpaceType getSpace(int x, int y) {
        if (isValidCoordinate(x, y)) {
            return cellsOccupancy.get(x).get(y);
        } else {
            return null; // Or throw an exception?
        }
    }

    // Method to set the space at a specific coordinate
    public void setSpace(int x, int y, SpaceType spaceType) throws Exception {
        if (isValidCoordinate(x, y)) {
            cellsOccupancy.get(x).set(y, spaceType);
        } else {
            throw new Exception("Cannot set space " + spaceType.toString() + " because the coodinate is not valid.");
        }
    }

    // Helper method to check if the given coordinates are valid
    private boolean isValidCoordinate(int x, int y) {
        return x >= 0 && x < numRows && y >= 0 && y < numCols;
    }

    
    public ArrayList<Integer> paintGrid() {
        // TODO implement the drawing part, based on the painted grid, the roomSize is set

        // Array to store the number of columns in the grid (index 1) and the number of rows (index 2)
        ArrayList<Integer> roomSize = new ArrayList<>(); //index 1 should be numColumns and index 2 numRows 
        // Dummy values for the moment
        roomSize.add(10);
        roomSize.add(10);
        return roomSize;
    }

}
