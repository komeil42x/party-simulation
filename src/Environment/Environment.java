package Environment;

import java.util.ArrayList;

public class Environment {
    private Room room = new Room();

    // dictionary to store avatars locations as coordinates (key: avatarId, value: avatar coordinate)
    private AvatarsLocations avatarsLocations = new AvatarsLocations(); 

    public Environment(){
        room.paintGrid();
    }

    // TODO is this better than calling it inside the constructor?
    // public void startEnvironment() {
    //     room.paintGrid();
    // }

    public ArrayList<SpaceType> getAdjacentToAvatar(int avatarId){

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
        SpaceType rightSpace = room.getSpace(rightX, currentY);
        SpaceType upSpace = room.getSpace(currentX, upY);
        SpaceType leftSpace = room.getSpace(leftX, currentY);
        SpaceType downSpace = room.getSpace(currentX, downY);

        // Add spaceTypes to array
        adjacentToAvatar.add(rightSpace);
        adjacentToAvatar.add(upSpace);
        adjacentToAvatar.add(leftSpace);
        adjacentToAvatar.add(downSpace);

        // return an array of SpaceTypes with the spaces that are adjacent to the avatar
        return adjacentToAvatar;
    }
    
}
