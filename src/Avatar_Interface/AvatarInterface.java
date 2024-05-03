package Avatar_Interface;

import java.util.ArrayList;
import Environment.*;

//import java.util.ArrayList;

//import Environment.SpaceType;

public interface AvatarInterface {
	abstract Direction yourTurn(ArrayList<SpaceInfo> spacesInRange);
}
