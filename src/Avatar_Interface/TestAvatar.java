
public class TestAvatar extends SuperAvatar implements AvatarInterface {
	public TestAvatar(int id) {
		super(id);
	}
	
	public static void main(String[] args) {
		new TestAvatar(42);
	}
}
