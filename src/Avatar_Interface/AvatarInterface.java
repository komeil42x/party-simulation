package Avatar_Interface;

import java.util.ArrayList;

import Environment.SpaceType;
import SimulationControl.SpaceInfo;

public interface AvatarInterface {
	abstract Direction yourTurn(ArrayList<SpaceType> si);
}
