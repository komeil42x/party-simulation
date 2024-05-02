package Environment;

/********************************************
 * Author: Soodeh, Ole, Paola
 * Version: v.2
 * Date:   20240423
 * ------------------------------------------
 * Description: creating the grid
 ********************************************/

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Grid {

    final static int LINES = 40;
    final static int COLUMNS = 80;

    public Grid(JPanel panel) {

        JPanel pitchPanel = new JPanel(new GridLayout(LINES, COLUMNS));
        pitchPanel.setBackground(Color.WHITE);
        // change size of the grid, if frame changes
        panel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // System.out.println("INSIDE: "+panel.getSize());
                pitchPanel.setPreferredSize(panel.getSize());
            }
        });

        // Add border to each cell in the grid
        for (int i = 0; i < LINES; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                JPanel cell = new JPanel();
                cell.setBackground(Color.WHITE);
                cell.setBorder(BorderFactory.createLineBorder(Color.lightGray));
                // create tool tip for each cell to identify it later
                cell.setToolTipText("(" + i + "," + j + ")");
                pitchPanel.add(cell);
            }
        }
        panel.add(pitchPanel);
    }




    
    // Method to get the space at a specific coordinate
    public static SpaceType getSpace(int x, int y) {
        if (isValidCoordinate(x, y)) {
            // return cellsOccupancy.get(x).get(y);
            return null;
        } else {
            return null; // Or throw an exception?
        }
    }

    // // Method to set the space at a specific coordinate
    // public void setSpace(int x, int y, SpaceType spaceType) throws Exception {
    //     if (isValidCoordinate(x, y)) {
    //         cellsOccupancy.get(x).set(y, spaceType);
    //     } else {
    //         throw new Exception("Cannot set space " + spaceType.toString() + " because the coodinate is not valid.");
    //     }
    // }

    // Helper method to check if the given coordinates are valid
    private static boolean isValidCoordinate(int x, int y) {
        return x >= 0 && x < LINES && y >= 0 && y < COLUMNS;
    }
}