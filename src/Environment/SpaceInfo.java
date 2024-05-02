
public class SpaceInfo {
    Coordinate relativeToAvataCoordinate;
    SpaceType type;

    public SpaceInfo(Coordinate relativeToAvataCoordinate, SpaceType type) {
        this.relativeToAvataCoordinate = relativeToAvataCoordinate;
        this.type = type;
    }

    public Coordinate getRelativeToAvataCoordinate() {
        return relativeToAvataCoordinate;
    }
    public SpaceType getType() {
        return type;
    }

    
    
}
