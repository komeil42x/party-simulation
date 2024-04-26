package SimulationControl;

import Environment.*;
import java.util.ArrayList;
import Avatar_Interface.*;


public class SimulationControl {

	private ArrayList<SuperAvatar> avatars = new ArrayList<SuperAvatar>();
	private Environment environment;
	
	public SimulationControl() {
		System.out.println("Hallo");

		environment = new Environment();

		for (int i = 0; i < 12; i++){
			avatars.add(new TestAvatar(i));
			environment.placeAvatar(avatars.get(i).getID());
		}
	}
	
	public void loopThroughAvatars(SuperAvatar[] avatars) {
		for (SuperAvatar avatar : avatars) {
			SpaceInfo[] si = environment.getAdjacentToAvatar(avatar.getId());
			Direction dir = avatar.yourTurn(si);
			boolean hasMoved = environment.moveAvatar(avatar.getID(), dir);
			avatars.setHasMoved(hasMoved);
			// Avatar mitteilen, ob er sich tatsächlich bewegt hat: hasMoved
		}
	}
	
}

// comment