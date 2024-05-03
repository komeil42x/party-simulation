package Environment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;
import AvatarInterface.*;

public class Room {

    // dictionary to store avatars locations as coordinates (key: avatarId, value:
    // avatar coordinate)
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
            int randomX = (int) (Math.random() * numCols + 1);
            int randomY = (int) (Math.random() * numRows + 1);
            randomCoordinate = new Coordinate(randomX, randomY);

            // Repeat if randomCoordinate is occupied
        } while (randomCoordinateIsOccupied(randomCoordinate));

        // if coordinate is empty, assign it to the avatar and update 2D array
        placeAvatar(avatarId, randomCoordinate);
        System.out.println("Avatar " + String.valueOf(avatarId) + " located at "
                + String.valueOf(randomCoordinate.getX()) + ", " + String.valueOf(randomCoordinate.getY()));
    }

    private void placeAvatar(int avatarId, Coordinate targetCoordinate) {
        // Set the SpaceType of the cell at coordinate targetCoordinate to AVATAR
        cellsOccupancy.get(targetCoordinate.getX()).set(targetCoordinate.getY(), SpaceType.AVATAR);

        // Update HashMap avatarsLocations with key avatarId and value targetCoordinate
        avatarsLocations.put(avatarId, targetCoordinate);
    }

    private boolean randomCoordinateIsOccupied(Coordinate randomCoordinate) {
        // search the internal 2D array to see what is there inside cell with
        // randomCoordinate
        SpaceType cellInfo = cellsOccupancy.get(randomCoordinate.getX()).get(randomCoordinate.getY());
        // check if it is of SpaceType OBSTACLE or AVATAR
        if (cellInfo == SpaceType.OBSTACLE || cellInfo == SpaceType.AVATAR) {
            return true; // It is occupied!
        }
        // If not occupied, return false;
        return false;
    }

    public ArrayList<SpaceInfo> getAdjacentToAvatar(int avatarId, int perceptionRange) {
        ArrayList<SpaceInfo> adjacentToAvatar = new ArrayList<>();

        // Get the avatar's current coordinates from the avatarsLocations map
        Coordinate avatarCoordinate = avatarsLocations.get(avatarId);
        if (avatarCoordinate == null) {
            return adjacentToAvatar; // Return empty list if the avatar's coordinate is not found
        }

        int currentX = avatarCoordinate.getX();
        int currentY = avatarCoordinate.getY();

        // Calculate the coordinates of the adjacent cells within the perception range
        for (int i = currentX - perceptionRange; i <= currentX + perceptionRange; i++) {
            for (int j = currentY - perceptionRange; j <= currentY + perceptionRange; j++) {
                if (i == currentX && j == currentY) {
                    continue; // Skip the current cell (avatar's position)
                }
                if (isValidCoordinate(i, j)) {
                    SpaceType space = cellsOccupancy.get(i).get(j);
                    adjacentToAvatar.add(new SpaceInfo(new Coordinate(i, j), space));
                }
            }
        }

        return adjacentToAvatar; // Return the list of SpaceInfo for adjacent spaces
    }

    public void updateRoom(int newNumCols, int newNumRows) {
        // Handle downsizing
        if (newNumCols < numCols || newNumRows < numRows) {
            relocateAvatarsOutOfBound(newNumCols, newNumRows);
        }

        // Update rows
        while (cellsOccupancy.size() > newNumRows) {
            cellsOccupancy.remove(cellsOccupancy.size() - 1);
        }
        while (cellsOccupancy.size() < newNumRows) {
            ArrayList<SpaceType> newRow = new ArrayList<>();
            for (int i = 0; i < numCols; i++) {
                newRow.add(SpaceType.EMPTY);
            }
            cellsOccupancy.add(newRow);
        }

        // Update columns
        for (ArrayList<SpaceType> row : cellsOccupancy) {
            while (row.size() > newNumCols) {
                row.remove(row.size() - 1);
            }
            while (row.size() < newNumCols) {
                row.add(SpaceType.EMPTY);
            }
        }

        // Update class fields
        numCols = newNumCols;
        numRows = newNumRows;
    }

    private void relocateAvatarsOutOfBound(int newNumCols, int newNumRows) {
        ArrayList<Integer> avatarsToRemove = new ArrayList<>();
        for (Map.Entry<Integer, Coordinate> entry : avatarsLocations.entrySet()) {
            Coordinate coord = entry.getValue();
            if (coord.getX() >= newNumCols || coord.getY() >= newNumRows) {
                avatarsToRemove.add(entry.getKey());
            }
        }

        for (Integer avatarId : avatarsToRemove) {
            avatarsLocations.remove(avatarId);
            findPlaceForAvatar(avatarId);
        }
    }
}