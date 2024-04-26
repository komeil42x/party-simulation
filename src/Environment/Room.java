package Environment;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.*;

public class Room {
    private ArrayList<ArrayList<SpaceType>> cellsOccupancy;

    // create the pitch 
	// ------------------------------------------
	public void createPitch(JPanel panelLeft, int lines, int numCols) {
        JPanel pitchPanel = new JPanel(new GridLayout(lines, numCols));
        pitchPanel.setBackground(Color.WHITE);
        pitchPanel.setPreferredSize(panelLeft.getSize());
        int numRows = lines-1;
        cellsOccupancy = new ArrayList<>(numRows);
        
        // initialize array cellsOccupancy
        for (int i = 0; i < numRows; i++) {
            cellsOccupancy.add(new ArrayList<>(numCols));
            // Initialize the columns within each row
            for (int j = 0; j < numCols; j++) {
                cellsOccupancy.get(i).add(SpaceType.EMPTY); // SpaceType.EMPTY is the default value for the moment
            }
        }
        // Add border to each cell in the grid
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < numCols; j++) {
                JPanel cell = new JPanel();
                cell.setBackground(Color.WHITE);
                cell.setBorder(BorderFactory.createLineBorder(Color.lightGray));
                // create tool tip for each cell to identify it later
                cell.setToolTipText("(" + i + "," + j + ")");
                pitchPanel.add(cell);
            }
        }
        // create some components
        // createComponent(pitchPanel,"RED",  new int[]{0, 0}, new int[]{1, 0}, 
        // new int[]{2, 0}, new int[]{3, 0}, new int[]{0, 1}, new int[]{0, 2}, new int[]{0, 3});


        panelLeft.add(pitchPanel);
    }


    // Method to get the space at a specific coordinate
    public SpaceType getSpace(int x, int y) {
        if (isValidCoordinate(x, y)) {
            return cellsOccupancy.get(x).get(y);
        } else {
            return null; // Or throw an exception?
        }
    }

    // Method to set the space at a specific coordinate
    public void setSpace(int x, int y, SpaceType spaceType) throws Exception {
        if (isValidCoordinate(x, y)) {
            cellsOccupancy.get(x).set(y, spaceType);
        } else {
            throw new Exception("Cannot set space " + spaceType.toString() + " because the coodinate is not valid.");
        }
    }

    // Helper method to check if the given coordinates are valid
    private boolean isValidCoordinate(int x, int y) {
        return x >= 0 && x < numRows && y >= 0 && y < numCols;
    }

}
