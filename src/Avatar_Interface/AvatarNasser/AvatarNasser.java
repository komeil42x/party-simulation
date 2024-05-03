package Avatar_Interface.AvatarNasser;
import java.util.ArrayList;
import Avatar_Interface.*;
import Environment.SpaceType;

/*
 * Zufällige Bewegung vom Avatar
 * Bewegung vom Avatar in gezielte Richtung
 */

public class AvatarNasser extends SuperAvatar {

    public AvatarNasser(int id) {
        super(id); 
    }

    @Override
    public Direction yourTurn(SpaceInfo[] si) {
       
        int max = 4;
		int min = 0;
   
		int directionNumber = (int) (Math.random() * ((max - min) + 1) + min);

		switch (directionNumber) {
			case 0: return Direction.LEFT;
			case 1: return Direction.RIGHT;
			case 2: return Direction.UP;
			case 3: return Direction.DOWN;
			default: return Direction.STAY;
		}
        
    }

    @Override
    public Direction yourTurn(ArrayList<SpaceType> si) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'yourTurn'");
    }
}
