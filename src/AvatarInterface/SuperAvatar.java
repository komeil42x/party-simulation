package AvatarInterface;

public abstract class SuperAvatar implements AvatarInterface {

		private int avatarID;	// identification of Avatar
		private boolean couldMove;
		//SpaceInfo[] spaceinfo = new SpaceInfo[4];
		
		public SuperAvatar(int id) {
			avatarID = id;
		}
		
		public int getAvatarID() {
			return avatarID;
		}
		
		public boolean setHasMoved(boolean couldMove) {
			return this.couldMove;
		}
		
		
}