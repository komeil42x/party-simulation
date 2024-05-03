package SimulationControl;

import java.util.Scanner;
/**
 * The main class of the program.
 * It prompts the user to enter a whole number above 0 for the default perception range,
 * creates an instance of SimulationControl with the given perception range,
 * and starts the simulation by calling the loopThroughAvatars method.
 */
public class Main {
    /**
     * The main method of the program.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a whole number above 0 for the default perception range: ");
        int perceptionRange = scanner.nextInt();
        scanner.close();

        new SimulationControl(perceptionRange).loopThroughAvatars();
    }
}
