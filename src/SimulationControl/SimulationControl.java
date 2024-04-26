package SimulationControl;

import Environment.*;
import java.util.ArrayList;
import Avatar_Interface.*;


public class SimulationControl {

	private ArrayList<AvatarInterface> avatars = new ArrayList<AvatarInterface>();
	private Environment environment;
	
	public SimulationControl() {
		System.out.println("Hallo");

		environment = new Environment();

		for (int i = 0; i < 12; i++){
			avatars.add(new TestAvatar(i));
			environment.placeAvatar(avatars.get(i).getID());
		}
	}
	
	public void loopThroughAvatars(AvatarInterface[] avatars) {
		for (AvatarInterface avatar : avatars) {
			SpaceInfo[] si = environment.getAdjacentToAvatar(avatar.getId());
			Direction dir = avatar.yourTurn(si);
			boolean hasMoved = environment.moveAvatar(avatar.getID(), dir);
			// Avatar mitteilen, ob er sich tatsächlich bewegt hat: hasMoved
		}
	}
	
}

// comment