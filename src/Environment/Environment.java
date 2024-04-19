
public class Environment {
    private Room room = new Room();
    private AvatarsLocations avatarsLocations = new AvatarsLocations();

    public Environment(){
        room.paintGrid();
    }

    // TODO is this better than calling it inside the constructor?
    // public void startEnvironment() {
    //     room.paintGrid();
    // }

    public SpaceInfo getAdjacentToAvatar(int avatarId){
        // TODO objective of the sprint
        throw new UnsupportedOperationException("Unimplemented method 'getAdjacentToAvatar in class Environment'");

    }





    
}
