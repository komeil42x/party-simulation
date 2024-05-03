package PersonalAvatars;
import Environment.*;

import java.util.ArrayList;

import AvatarInterface.*;


public class TomAvatar extends SuperAvatar {

    private int counter;

    public TomAvatar(int id) {
        super(id);
        this.counter = 0;
        // TODO Auto-generated constructor stub
    }

    @Override
    public Direction yourTurn(ArrayList<SpaceInfo> spacesInRange) {

        switch (counter) {
            case 0: return Direction.RIGHT; 
            case 1: return Direction.DOWN; 
            case 2: return Direction.LEFT;
            case 3: return Direction.UP;  
        
        }
        counter++;

        if (counter >= 3) {
            counter = 0;
        }

        return null;

    }

}
