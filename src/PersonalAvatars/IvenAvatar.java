package PersonalAvatars;

import AvatarInterface.*;
import java.util.ArrayList;
import Environment.*;

public class IvenAvatar extends SuperAvatar { // implements AvatarInterface
    
    int needToDance = 100;
    int needToDrink = 100;
    int needToPee = 100;
    int needToRest = 100;

	public IvenAvatar(int id) {
		super(id);
	}

	@Override
	public Direction yourTurn(ArrayList<SpaceInfo> spacesInRange) {
        for (int i = 0; i>4;i++){
            SpaceType frontTyp = spacesInRange.getType;
            Coordinate frontCoord = spacesInRange.get(i).getRelativeToAvatarCoordinate;
        }
        
		int max = 3;
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