package SimulationControl;

import java.util.ArrayList;
import Environment.*;
import AvatarInterface.*;
import java.io.File;
import org.reflections.Reflections;

public class SimulationControl {

	private ArrayList<SuperAvatar> avatars = new ArrayList<SuperAvatar>();
	private Environment environment;

	public SimulationControl() {
		environment = new Environment();

		Reflections reflections = new Reflections("PersonalAvatars");

		for (Class<? extends SuperAvatar> personalAvatarClass : reflections.getSubTypesOf(SuperAvatar.class)) {
			try {
				SuperAvatar avatar = personalAvatarClass.getDeclaredConstructor().newInstance();
				avatars.add(avatar);
				System.out.println("Added " + avatar.getClass().getName());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// for (int i = 0; i < countFilesInFolder("src/PersonalAvatars"); i++){
		// 	avatars.add(new [PersonalAvatarClass](i));// TODO: change [PersonalAvatarClass] to the actual Avatar classes in the PersonalAvatars package

		// }
	}
	
	public void loopThroughAvatars() {
		for (SuperAvatar avatar : avatars) {
			ArrayList<SpaceInfo> si = environment.getAdjacentToAvatar(avatar.getAvatarID());
			Direction dir = avatar.yourTurn(si);
			boolean hasMoved = environment.moveAvatar(avatar.getAvatarID(), dir);
			avatar.setHasMoved(hasMoved);
		}
	}
	
}