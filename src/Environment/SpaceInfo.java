package Environment;

public class SpaceInfo {
    Coordinate relativeToAvatarCoordinate;
    SpaceType type;

    public SpaceInfo(Coordinate relativeToAvatarCoordinate, SpaceType type) {
        this.relativeToAvatarCoordinate = relativeToAvatarCoordinate;
        this.type = type;
    }

    public Coordinate getRelativeToAvatarCoordinate() {
        return relativeToAvatarCoordinate;
    }
    public SpaceType getType() {
        return type;
    }

    
    
}