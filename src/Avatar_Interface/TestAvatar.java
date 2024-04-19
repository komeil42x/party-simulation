package Avatar_Interface;

public class TestAvatar extends SuperAvatar implements AvatarInterface {
	public TestAvatar(int id) {
		super(id);
	}
	
	public static void main(String[] args) {
		new TestAvatar(42);
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getID'");
	}

	@Override
	public void yourTurn(SpaceInfo[] spacesInRange) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'yourTurn'");
	}
}
