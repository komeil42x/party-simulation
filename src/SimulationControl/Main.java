package SimulationControl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a whole number above 0 for the default perception range: ");
        int perceptionRange = scanner.nextInt();
        scanner.close();

        new SimulationControl(perceptionRange).loopThroughAvatars();
    }
}
