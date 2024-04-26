package SimulationControl;

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
		}
	}
	
	public void loopThroughAvatars(AvatarInterface[] avatars) {
		for (AvatarInterface avatar : avatars) {
			SpaceInfo[] si = environment.getAdjacentToAvatar(avatar.getId());
			avatar.yourTurn(si);
			Direction dir = ;
			boolean hasMoved = environment.moveAvatar(avatar.getID(), dir);
			// Avatar mitteilen, ob er sich tatsächlich bewegt hat: hasMoved
		}
	}
	
}

// comment