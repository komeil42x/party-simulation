package Environment;

/********************************************
 * Author: Soodeh, Ole, Paola
 * Version: v.2
 * Date:   20240412
 * ------------------------------------------
 * Description: Test class to check the code. 
 * Will be completed later by another team.
 ********************************************/

 public class Main {
    public static void main(String[] args) {

        Environment environment = new Environment();

        // Obtain information about the position of the avatar and its surroundings
        environment.getAdjacentToAvatar(1);
        // move avatar in one direction
        environment.moveAvatar(1, Direction.UP);
        // place avatar in the desired cell
        // environment.placeAvatar(1);
    }
}