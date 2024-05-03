package Environment;

import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Environment {
    private Room model;
    private SimulationGUI view;

    public Environment(){
        // this.room = new Room();
        this.model = new Room(20,20);
        System.out.println("Room constructed");
        this.view = new SimulationGUI();
        System.out.println("View constructed");

        this.view.addSlideListener(new ChangeListener() {
             @Override
             public void stateChanged(ChangeEvent e) {
                 int value = view.getValue();
                 switch (value) {
                     case 1: // Zoom in
                        view.repaint(value);
                        model.updateRoom(view.getNumCols(), view.getNumRows()); 
                         break;
                     case 2: // original
                        view.repaint(value);  
                         break;
                     case 3: // Zoom out
                         view.repaint(value);
                         break;
                     default:
                         break;
                 }
             }
         });
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
