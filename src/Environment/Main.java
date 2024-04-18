/********************************************
 * Author: Soodeh,...
 * Version: v.2
 * Date:   20240412
 * ------------------------------------------
 * Description:  
 * contain the main method and handle the initialization of the Swing application;
 * the main class which includes JFrame and 
 * adding custom panels (customPanel and SliderPanel) to it.
 ********************************************/

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Nightclub Simulation SS24");
            

            CustomPanel customPanel = new CustomPanel();
            customPanel.setGridSize(CustomPanel.ORIGINAL_ROWS, CustomPanel.ORIGINAL_COLUMNS);

            // Highlight specific cells
            List<Point> highlightedCells = new ArrayList<>();
            highlightedCells.add(new Point(1, 1)); // Add a cell to be highlighted
            highlightedCells.add(new Point(0, 0)); // Add another cell to be highlighted
            highlightedCells.add(new Point(1, 0));
            highlightedCells.add(new Point(1, 2));
            highlightedCells.add(new Point(0, 3));
            highlightedCells.add(new Point(1, 3));
            customPanel.highlightCells(highlightedCells); // Highlight the specified cells


            SliderPanel sliderPanel = new SliderPanel(customPanel);

            frame.add(customPanel, BorderLayout.CENTER);
            frame.add(sliderPanel, BorderLayout.EAST);

            //frame.pack();
            //frame.setLocationRelativeTo(null);
            

            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(1200, 750);
            frame.setVisible(true);

        });
    }
}
