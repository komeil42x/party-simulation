package SimulationControl;

import Environment.*;
import Environment.SpaceType;

import java.util.ArrayList;
import Avatar_Interface.*;
import Avatar_Interface.AvatarNasser.*;


public class SimulationControl {

	private ArrayList<SuperAvatar> avatars = new ArrayList<SuperAvatar>();
	private Environment environment;
	
	public SimulationControl() {
		System.out.println("Hallo");

		environment = new Environment();
		int i = 0;
		for (i = 0; i < 12; i++){
			avatars.add(new TestAvatar(i));
		}
		avatars.add(new AvatarNasser(i+1));
	}
	
	public void loopThroughAvatars() {
		for (SuperAvatar avatar : avatars) {
			SpaceInfo[] si = environment.getAdjacentToAvatar(avatar.getAvatarID());
			Avatar_Interface.Direction dir = avatar.yourTurn(si);
			// boolean hasMoved = environment.moveAvatar(avatar.getAvatarID(), dir);
			// avatars.setHasMoved(hasMoved);
			// Avatar mitteilen, ob er sich tatsächlich bewegt hat: hasMoved
		}
	}
	
}