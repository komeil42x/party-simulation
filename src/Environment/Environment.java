package Environment;

import AvatarInterface.*;

import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * The Environment class represents the environment in which the party
 * simulation takes place.
 * It manages the room, the simulation GUI, and the interactions between them.
 */
public class Environment {
    private Room model;
    private SimulationGUI view;

    /**
     * Constructs a new Environment object.
     * Initializes the room and the simulation GUI.
     */
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

    /**
     * Places an avatar in the room.
     * 
     * @param avatarId the ID of the avatar to be placed
     */
    public void placeAvatar(int avatarId) {
        Coordinate avatarCoordinate = model.findPlaceForAvatar(avatarId);
        if (avatarCoordinate != null) {
            view.paintAvatar(avatarCoordinate);
        }
    }

    /**
     * Gets the adjacent spaces to an avatar within a given perception range.
     * 
     * @param avatarId        the ID of the avatar
     * @param perceptionRange the perception range of the avatar
     * @return an ArrayList of SpaceInfo objects representing the adjacent spaces
     */
    public ArrayList<SpaceInfo> getAdjacentToAvatar(int avatarId, int perceptionRange) {
        return model.getAdjacentToAvatar(avatarId, perceptionRange);
    }
}
