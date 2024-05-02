package Environment;

/********************************************
 * Author: Soodeh, Ole, Paola
 * Version: v.3
 * Date:   20240412
 * ------------------------------------------
 * Description: The frame and the panels it contains 
 * are to be created in this class. 
 ********************************************/

import javax.swing.*;
import java.awt.*;

public class PlaceAvatar {

    public PlaceAvatar(JPanel panel, String colorName, int[]... cellCoordinates) {
        Color color = getColorFromString(colorName); // Convert color string to Color object
        if (color == null) {
            // Handle invalid color string
            System.out.println("Invalid color string: " + colorName);
            return;
        }

        for (int[] coordinates : cellCoordinates) { // Iterate over each passed int array of cell coordinates
            int row = coordinates[0]; // Extract the row number from the cell coordinates
            int col = coordinates[1]; // Extract the column number from the cell coordinates
            Component[] components = panel.getComponents(); // Get all components in the passed JPanel
            int index = row * ((GridLayout) panel.getLayout()).getColumns() + col; // Calculate the index of the
                                                                                   // component
            if (index >= 0 && index < components.length) { // Check if the calculated index is within the valid range
                JPanel cell = (JPanel) components[index]; // Get the cell at the calculated index position from the
                                                          // panel's components
                cell.setBackground(color); // Set the background color
            }
        }

    }

    private static Color getColorFromString(String colorName) {
        try {
            return Color.decode(colorName);					// Try to create color from string
        } catch (NumberFormatException e) {
            try {											// If not a hex string, try to get color by name
                return (Color) Color.class.getField(colorName).get(null);
            } catch (Exception ex) {
                return null;								// Handle invalid color string
            }
        }
    }
}

