package SimulationControl;

import java.util.ArrayList;
import Environment.*;
import AvatarInterface.*;
import org.reflections.Reflections;

public class SimulationControl {

    private ArrayList<SuperAvatar> avatars = new ArrayList<>();
    private Environment environment;
    private static int nextAvatarID = 0; // Static counter to ensure unique IDs

    public SimulationControl(int perceptionRange) {
        environment = new Environment();

        Reflections reflections = new Reflections("PersonalAvatars");

        for (Class<? extends SuperAvatar> personalAvatarClass : reflections.getSubTypesOf(SuperAvatar.class)) {
            try {
                SuperAvatar avatar = personalAvatarClass.getDeclaredConstructor(int.class, int.class).newInstance(nextAvatarID++, perceptionRange);
                avatars.add(avatar);
                String avatarName = avatar.getClass().getSimpleName().replace("Avatar", "");
                System.out.println("Added " + avatarName + ": ID: " + avatar.getAvatarID() + ", Perception Range: " + avatar.getPerceptionRange());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void loopThroughAvatars() {
        for (SuperAvatar avatar : avatars) {
            ArrayList<SpaceInfo> si = environment.getAdjacentToAvatar(avatar.getAvatarID(), avatar.getPerceptionRange());
            Direction dir = avatar.yourTurn(si);
            boolean hasMoved = environment.moveAvatar(avatar.getAvatarID(), dir);
            avatar.setHasMoved(hasMoved);
        }
    }
}
