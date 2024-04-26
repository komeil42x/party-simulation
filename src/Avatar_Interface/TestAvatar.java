package Avatar_Interface;
import java.util.ArrayList;

import Environment.SpaceType;

public class TestAvatar extends SuperAvatar {
	public TestAvatar(int id) {
		super(id);
	}

	@Override
	public Direction yourTurn(ArrayList<SpaceType> si) {
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

	// public void main(String[] args) {
		
	// 	SuperAvatar[] arrayVonSuperAvataren = new SuperAvatar[10];
	// 	arrayVonSuperAvataren[0] = new TestAvatar(0);
		
	// 	arrayVonSuperAvataren[0].getAvatarID();
	// 	arrayVonSuperAvataren[0].yourTurn(null);


	// 	//SpaceType spacesInRange;
	// 	//TestAvatar Maxim = new TestAvatar(42);
	// 	//int TestID = Maxim.getAvatarID();
	// }

}
