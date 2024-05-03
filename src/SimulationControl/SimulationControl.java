package SimulationControl;

import Environment.*;
import Environment.SpaceType;
import Environment.SpaceInfo;

import java.util.ArrayList;

import AvatarInterface.*;


public class SimulationControl {

	private ArrayList<SuperAvatar> avatars = new ArrayList<SuperAvatar>();
	private Environment environment;
	
	public SimulationControl() {
		System.out.println("Hallo");

		environment = new Environment();

		for (int i = 0; i < 12; i++){
			avatars.add(new TestAvatar(i));
		}
	}
	
	public void loopThroughAvatars() {
		for (SuperAvatar avatar : avatars) {
			ArrayList<SpaceInfo> si = environment.getAdjacentToAvatar(avatar.getAvatarID());
			AvatarInterface.Direction dir = avatar.yourTurn(si);
			boolean hasMoved = environment.moveAvatar(avatar.getAvatarID(), dir);
			// avatars.setHasMoved(hasMoved);
			// Avatar mitteilen, ob er sich tatsächlich bewegt hat: hasMoved
		}
	}
	
}