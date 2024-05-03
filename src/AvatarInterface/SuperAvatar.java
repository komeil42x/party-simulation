package AvatarInterface;

public abstract class SuperAvatar implements AvatarInterface {

		private final int avatarID;	// identification of Avatar
		private boolean couldMove;
		private int perceptionRange; // perception range of Avatar
		//SpaceInfo[] spaceinfo = new SpaceInfo[4];
		
		public SuperAvatar(int id, int perceptionRange) {
			this.avatarID = id;
			this.perceptionRange = perceptionRange;
		}
		
		public int getAvatarID() {
			return avatarID;
		}

		public boolean getCouldMove() {
			return couldMove;
		}

		public int getPerceptionRange() {
			return perceptionRange;
		}

		public void setPerceptionRange(int perceptionRange) {
			this.perceptionRange = perceptionRange;
		}
		
		public void setHasMoved(boolean couldMove) {
			this.couldMove = couldMove;
		}
		
		
}