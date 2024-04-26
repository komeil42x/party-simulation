package SimulationControl;

import Environment.*;
import java.util.ArrayList;
import Avatar_Interface.*;
import Avatar_Interface.AvatarNasser.*;


public class SimulationControl {

	private ArrayList<SuperAvatar> avatars = new ArrayList<SuperAvatar>();
	private Environment environment;
	
	public SimulationControl() {
		System.out.println("Hallo");

		environment = new Environment();

		for (int i = 0; i < 12; i++){
			avatars.add(new AvatarNasser(i));
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