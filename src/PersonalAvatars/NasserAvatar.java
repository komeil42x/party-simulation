package PersonalAvatars;
import java.util.ArrayList;
import AvatarInterface.*;
import Environment.*;

/*
 * Zufällige Bewegung vom Avatar
 * Bewegung vom Avatar in gezielte Richtung
 */

public class NasserAvatar extends SuperAvatar {

    public NasserAvatar(int id) {
        super(id); 
    }

    @Override
    public Direction yourTurn(ArrayList<SpaceInfo> si) {
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
}
