package AvatarInterface;

public abstract class SuperAvatar implements AvatarInterface {

		private final int avatarID;	// identification of Avatar
		private boolean couldMove;
		//SpaceInfo[] spaceinfo = new SpaceInfo[4];
		
		public SuperAvatar(int id) {
			avatarID = id;
		}
		
		public int getAvatarID() {
			return avatarID;
		}

		public boolean getCouldMove() {
			return couldMove;
		}
		
		public void setHasMoved(boolean couldMove) {
			this.couldMove = couldMove;
		}
		
		
}