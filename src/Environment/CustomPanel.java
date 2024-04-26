/********************************************
 * Author: Soodeh,...
 * Version: v.2
 * Date:   20240412
 * ------------------------------------------
 * Description:  
 * This class will extend JPanel and will be responsible for drawing the grid floor.
 * It overrides the paintComponent method to draw the grid floor based on the size and coordinates.
 * It provides methods to set the size of the grid and retrieve the coordinates.
 * 
 * It is responsible for integration with Simulation Control and Avatar Interface:
 * Pass an instance of CustomPanel to simulation control and avatar interface classes.
 * These classes can access the occupancy status information using the methods provided by CustomPanel.
 ********************************************/

 import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CustomPanel extends JPanel {
    private int width = 100;
    private int height = 80;

    private int rows = 10; 
    private int columns = 10; 

    public static final int ORIGINAL_ROWS = 20; // Change as needed
    public static final int ORIGINAL_COLUMNS = 20; // Change as needed

    private int margin = 100;
    private boolean[][] occupancyStatus; // 2D array to store occupancy status of each grid point

    private List<Point> highlightedCells; 

    // Constructor
    public CustomPanel() {
        // for panel properties if needed
    }

    // Method to highlight specific grid cells
    public void highlightCells(List<Point> cells) {
        highlightedCells = cells;
        repaint(); // Redraw the panel to reflect the highlights
    }

    @Override
    protected void paintComponent(Graphics g) {//override the paintComponent method to draw the grid floor based on the size and coordinates
        super.paintComponent(g);

        width = getWidth() - margin;
        height = getHeight() - margin;

        // Calculate cell size based on grid size
        int cellWidth = width / columns; //100
        int cellHeight = height / rows; //100

        g.setColor(Color.LIGHT_GRAY); 

        // Draw horizontal grid lines
        for (int i = 0; i <= rows; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, width, y);
        }
        
        
        // Draw vertical grid lines
        for (int i = 0; i <= columns; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, height);
        }

        /* g.setColor(Color.PINK);
        g.drawRect(0, 0, width, height); */

        if (highlightedCells != null) {
            g.setColor(new Color(0, 0, 255, 128)); // Set the highlight color
            for (Point cell : highlightedCells) {
                int x = cell.x * cellWidth;
                int y = cell.y * cellHeight;
                g.fillRect(x, y, cellWidth - 1, cellHeight - 1); // Fill the highlighted cell with color
            }
        }
    }

    

    //DO we need this after creating the grids??..............
    /* public void setPanelSize(int width, int height) {
        this.width = width;
        this.height = height;
        repaint();
    } */
    //.......................................................

    // Method to set the size of the grid
    public void setGridSize(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        repaint(); // Redraw the panel with the new grid size
        occupancyStatus = new boolean[rows][columns]; // Initialize occupancy status array
        // By default, all grid points are free initially
    
    }
    // set occupancy status of a grid point
    public void setOccupancyStatus(int row, int column, boolean occupied) {
        occupancyStatus[row][column] = occupied;
    }
    //check if a grid point is occupied
    public boolean isOccupied(int row, int column) {
        return occupancyStatus[row][column];
    }

    // Method to retrieve the coordinates of the grid points
    public Coordinate[][] getGridCoordinates() {
        Coordinate[][] coordinates = new Coordinate[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                coordinates[i][j] = new Coordinate(j, i); // Swap x and y to match (row, column) convention
            }
        }

        return coordinates; 
    }
}

