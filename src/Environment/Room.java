package Environment;

import java.util.ArrayList;
import java.util.HashMap;

public class Room {
    
     // dictionary to store avatars locations as coordinates (key: avatarId, value: avatar coordinate)
    private HashMap<Integer, Coordinate> avatarsLocations = new HashMap<>(); 
    private ArrayList<ArrayList<SpaceType>> cellsOccupancy;
    private int numRows;
    private int numCols;

    // Constructor
    public Room(int numCols, int numRows) {

        this.numRows = numRows;
        this.numCols = numCols;
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

    public void setNumRows(int numRows) {
        this.numRows = numRows;
    }

    public void setNumCols(int numCols) {
        this.numCols = numCols;
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

    public void findPlaceForAvatar(int avatarId) {
        Coordinate randomCoordinate;
        do {
            // Generate a random location
            int randomX = (int )(Math.random() * numCols + 1);
            int randomY = (int )(Math.random() * numRows + 1);
            randomCoordinate = new Coordinate(randomX, randomY);
            
        // Repeat if randomCoordinate is occupied
        } while (randomCoordinateIsOccupied(randomCoordinate));
        
        // if coordinate is empty, assign it to the avatar and update 2D array
        placeAvatar(avatarId, randomCoordinate);
        System.out.println("Avatar " + String.valueOf(avatarId) + " located at " + String.valueOf(randomCoordinate.getX()) + ", " + String.valueOf(randomCoordinate.getY()));
    }

    private void placeAvatar(int avatarId, Coordinate targetCoordinate) {
        // Set the SpaceType of the cell at coordinate targetCoordinate to AVATAR
        cellsOccupancy.get(targetCoordinate.getX()).set(targetCoordinate.getY(), SpaceType.AVATAR);

        // Update HashMap avatarsLocations with key avatarId and value targetCoordinate
        avatarsLocations.put(avatarId, targetCoordinate);
    }

    private boolean randomCoordinateIsOccupied(Coordinate randomCoordinate) {
        // search the internal 2D array to see what is there inside cell with randomCoordinate
        SpaceType cellInfo = cellsOccupancy.get(randomCoordinate.getX()).get(randomCoordinate.getY());
        // check if it is of SpaceType OBSTACLE or AVATAR
        if(cellInfo == SpaceType.OBSTACLE || cellInfo == SpaceType.AVATAR){
            return true; // It is occupied!
        }
        // If not occupied, return false;
        return false;
    }

    public ArrayList<SpaceInfo> getAdjacentToAvatar(int avatarId) {
        ArrayList<SpaceInfo> adjacentToAvatar = new ArrayList<>();

        // with avatarId, look up position of Avatar in avatarsLocations
        Coordinate avatarCoordinate = avatarsLocations.get(avatarId);

        // Get the current coordinates of the avatar
        int currentX = avatarCoordinate.getX();
        int currentY = avatarCoordinate.getY();

        // Calculate the coordinates of the adjacent cells
        int rightX = currentX + 1;
        int upY = currentY + 1;
        int leftX = currentX - 1;
        int downY = currentY - 1;

        // Retrieve what is there in the 2D array/grid
        SpaceType rightSpace = getSpace(rightX, currentY);
        SpaceType upSpace = getSpace(currentX, upY);
        SpaceType leftSpace = getSpace(leftX, currentY);
        SpaceType downSpace = getSpace(currentX, downY);

        // Add spaceInfos to array
        adjacentToAvatar.add(new SpaceInfo(new Coordinate(rightX, currentY), rightSpace));
        adjacentToAvatar.add(new SpaceInfo(new Coordinate(currentX, upY), upSpace));
        adjacentToAvatar.add(new SpaceInfo(new Coordinate(leftX, currentY), leftSpace));
        adjacentToAvatar.add(new SpaceInfo(new Coordinate(currentX, downY), downSpace));

        // return an array of SpaceTypes with the spaces that are adjacent to the avatar
        return adjacentToAvatar;
    }

	public void updateRoom(int numCols, int numRows) {
        // Get the current dimensions of the room
        int currentNumCols = this.numCols;
        int currentNumRows = this.numRows;

        // If the new dimensions are greater than the current dimensions
        if (numCols > currentNumCols && numRows > currentNumRows) {
            // Append empty spaces at the end of each row to accommodate the new numCols
            for (ArrayList<SpaceType> row : cellsOccupancy) {
                int spacesToAdd = numCols - currentNumCols;
                for (int i = 0; i < spacesToAdd; i++) {
                    row.add(SpaceType.EMPTY);
                }
            }
            // Add new rows if needed
            int rowsToAdd = numRows - currentNumRows;
            for (int i = 0; i < rowsToAdd; i++) {
                ArrayList<SpaceType> newRow = new ArrayList<>(numCols);
                for (int j = 0; j < numCols; j++) {
                    newRow.add(SpaceType.EMPTY);
                }
                cellsOccupancy.add(newRow);
            }
        } 

        // If the new dimensions are smaller than the current dimensions
        else if (numCols < currentNumCols && numRows < currentNumRows) {
            // Check and relocate avatars if they are in the locations that will be removed
            for (Integer avatarId : avatarsLocations.keySet()) {
                Coordinate avatarCoordinate = avatarsLocations.get(avatarId);
                int avatarX = avatarCoordinate.getX();
                int avatarY = avatarCoordinate.getY();
                if (avatarX >= numCols || avatarY >= numRows) {
                    findPlaceForAvatar(avatarId);
                }
            }
            // Downsize the room array
            for (ArrayList<SpaceType> row : cellsOccupancy) {
                row.subList(numCols, currentNumCols).clear();
            }
            cellsOccupancy.subList(numRows, currentNumRows).clear();
        }

        cellsOccupancy.size();

        // Update the room dimensions
        setNumCols(numCols);
        setNumRows(numRows);
    }
}
