package Environment;

import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Environment {
    private Room model;
    private SimulationGUI view;

    public Environment() {
        this.model = new Room(20, 20);
        System.out.println("Room constructed");
        this.view = new SimulationGUI();
        System.out.println("View constructed");

        this.view.addSlideListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = view.getValue();
                switch (value) {
                    case 1: // Zoom in
                        System.out.println("Size changed to small");
                        view.repaint(value);
                        model.updateRoom(view.getNumCols(), view.getNumRows());
                        System.out.println(String.valueOf(view.getNumCols()));
                        break;
                    case 2: // original
                        System.out.println("Size changed to medium");
                        view.repaint(value);
                        break;
                    case 3: // Zoom out
                        System.out.println("Size changed to large");
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

    public ArrayList<SpaceInfo> getAdjacentToAvatar(int avatarId, int perceptionRange) {
        return model.getAdjacentToAvatar(avatarId, perceptionRange);
    }

    public boolean moveAvatar(int avatarID, Direction dir) {        
        // TODO implement method to move avatars location to the direction dir and return true if successful. Check if possible to move to the direction, as safety measure.
        
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'moveAvatar'");
    }

}
