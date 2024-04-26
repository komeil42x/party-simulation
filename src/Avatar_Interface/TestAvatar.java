package Avatar_Interface;

public class TestAvatar extends SuperAvatar implements AvatarInterface {
	public TestAvatar(int id) {
		super(id);
	}

	@Override
	public Direction yourTurn(SpaceInfo[] spacesInRange) {
		int max = 4;
		int min = 0;
		int directionNumber = (int) (Math.random() * ((max - min) + 1) + min);

		switch (directionNumber) {
			case 0: return Direction.LEFT;
			case 1: return Direction.RIGHT;
			case 2: return Direction.UP;
			case 3: return Direction.DOWN;
			case 4: return Direction.STAY;

			default: return Direction.STAY;
		}
		

	}

	public static void main(String[] args) {
		new TestAvatar(42);
		int TestID = SuperAvatar.getAvatarID();

	}




}
