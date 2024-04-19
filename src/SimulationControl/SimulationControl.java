package src.SimulationControl;

import java.util.ArrayList;

public class SimulationControl {

	private ArrayList<AvatarInterface> avatars = new ArrayList<AvatarInterface>();
	private Environment environment;

	public SimulationControl() {
		System.out.println("Hallo");
		for (int i = 0; i < 12; i++){
			avatars.add(new TestAvatar(i));
		}
	}
	
	public void loopThroughAvatars(AvatarInterface[] avatars) {
		for (AvatarInterface avatar : avatars) {
			
			if ()
		}
	}

	public boolean move(int avatarId, Direction direction){

		return true; 
	}
	
	public SpaceInfo[] getAdjacentToAvatar(int avatarId) {
		
		return null;
		
	}

	
}

// comment