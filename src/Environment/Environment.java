package Environment;

import java.awt.Color;

/********************************************
 * Author: Soodeh, Ole, Paola
 * Version: v.2
 * Date:   20240412
 * ------------------------------------------
 * Description: 
 ********************************************/

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;

public class Environment {
    private CustomPanel panel = new CustomPanel();
    private HashMap<Integer, Coordinate> avatarsLocations = new HashMap<>();

    // Obtain information about the position of the avatar and its surroundings
    public ArrayList<SpaceType> getAdjacentToAvatar(int avatarId) {

        ArrayList<SpaceType> adjacentToAvatar = new ArrayList<>();

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
        SpaceType rightSpace = Grid.getSpace(rightX, currentY);
        SpaceType upSpace = Grid.getSpace(currentX, upY);
        SpaceType leftSpace = Grid.getSpace(leftX, currentY);
        SpaceType downSpace = Grid.getSpace(currentX, downY);

        // Add spaceTypes to array
        adjacentToAvatar.add(rightSpace);
        adjacentToAvatar.add(upSpace);
        adjacentToAvatar.add(leftSpace);
        adjacentToAvatar.add(downSpace);

        // return an array of SpaceTypes with the spaces that are adjacent to the avatar
        return adjacentToAvatar;
    }

    // move avatar in one direction
    public boolean moveAvatar(int avatarId, Direction direction) {
        return false;
    }

    public void placeAvatar(int avatarId){
        
    }
}
