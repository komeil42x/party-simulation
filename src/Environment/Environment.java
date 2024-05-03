package Environment;

import java.util.ArrayList;

public class Environment {
    private Room model;
    private SimulationGUI view;

    public Environment(){
        // this.room = new Room();
        this.model = new Room(20,20);
        System.out.println("Room constructed");
        this.view = new SimulationGUI();
        System.out.println("View constructed");
    }

    public void placeAvatar(int avatarId) {
        model.findPlaceForAvatar(avatarId);

        // TODO actually implement code below: make room.findPlaceForAvatar() 
        // return coordinate so view can represent the avatar in the grid
        // Coordinate avatarCoordinate = room.findPlaceForAvatar(avatarId);
        // view.paintAvatar(avatarCoordinate);
    }

    public ArrayList<SpaceInfo> getAdjacentToAvatar(int avatarId){
        return model.getAdjacentToAvatar(avatarId);
    }

    
    
}
