package PersonalAvatars;

import java.util.ArrayList;

import AvatarInterface.SuperAvatar;
import Environment.Direction;
import Environment.SpaceInfo;

public class MaximAvatar_Spock extends SuperAvatar {

    public MaximAvatar_Spock(int id) {
        super(id);
        //TODO Auto-generated constructor stub
    }

    @Override
    public Direction yourTurn(ArrayList<SpaceInfo> spacesInRange) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'yourTurn'");
        return Direction.STAY;
    }
    
}
