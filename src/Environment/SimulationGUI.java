package Environment;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EventListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SimulationGUI {
    
         // Sizes of the grid
     // --------------------------------------
     final int LINES_SMALL = 10;
     final int COLUMNS_SMALL = 20;
     final int LINES_MEDIUM = 20;
     final int COLUMNS_MEDIUM = 40;
     final int LINES_LARGE = 40;
     final int COLUMNS_LARGE = 80;
 

    private JPanel environmentLeft;
    private SliderPanel slider;
    private int numCols;
    private int numRows;

    public SimulationGUI() {
         // Frame
         // --------------------------------------
         JFrame frame = new JFrame("Nightclub Simulation SS24");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setSize(1000, 500);
         // Panel in frame
         // --------------------------------------
         JPanel environmentPanel = new JPanel(new GridBagLayout());
         // Left-Panelside -> 90% of the frame
         // --------------------------------------
         GridBagConstraints leftPanelConstraints = new GridBagConstraints();
         leftPanelConstraints.gridx = 0;
         leftPanelConstraints.gridy = 0;
         leftPanelConstraints.weightx = 0.9;
         leftPanelConstraints.weighty = 1.0;
         leftPanelConstraints.fill = GridBagConstraints.BOTH;
         JPanel environmentLeft = new JPanel();
         this.environmentLeft = environmentLeft;
         environmentLeft.setBackground(Color.WHITE);
         environmentLeft.setBorder(BorderFactory.createLineBorder(Color.BLACK));
         environmentPanel.add(environmentLeft, leftPanelConstraints);
         // Right-Panelside -> 10% of the frame
         // --------------------------------------
         GridBagConstraints rightPanelConstraints = new GridBagConstraints();
         rightPanelConstraints.gridx = 1;
         rightPanelConstraints.gridy = 0;
         rightPanelConstraints.weightx = 0.1;
         rightPanelConstraints.weighty = 1.0;
         rightPanelConstraints.fill = GridBagConstraints.BOTH;
         JPanel environmentRight = new JPanel();
         environmentRight.setBackground(Color.WHITE);
         environmentRight.setBorder(BorderFactory.createLineBorder(Color.BLACK));
         environmentPanel.add(environmentRight, rightPanelConstraints);
         // panel inside the Panel on the rightside
         // --------------------------------------
         JPanel environmentRightInside = new JPanel(new GridBagLayout());
         environmentRightInside.setBackground(Color.WHITE);
         environmentRightInside.setPreferredSize(new Dimension(100, 450));
         environmentRight.add(environmentRightInside);
         // Top-Panel of the inside-panel -> 20%
         // --------------------------------------
         GridBagConstraints topPanelConstraints = new GridBagConstraints();
         topPanelConstraints.gridx = 0;
         topPanelConstraints.gridy = 0;
         topPanelConstraints.weightx = 1.0;
         topPanelConstraints.weighty = 0.2;
         topPanelConstraints.fill = GridBagConstraints.BOTH;
         JPanel topRight = new JPanel();
         topRight.setBackground(Color.WHITE);
        //  slider.createLabels(topRight);                                          // create a label as headline
         environmentRightInside.add(topRight, topPanelConstraints);
         // Bottom-Panel of the inside-panel -> 80%
         // --------------------------------------
         GridBagConstraints bottomPanelConstraints = new GridBagConstraints();
         bottomPanelConstraints.gridx = 0;
         bottomPanelConstraints.gridy = 1;
         bottomPanelConstraints.weightx = 1.0;
         bottomPanelConstraints.weighty = 0.8;
         bottomPanelConstraints.fill = GridBagConstraints.BOTH;
         JPanel bottomRight = new JPanel();
         bottomRight.setBackground(Color.WHITE);
        //  slider.createSliderAndGrid(bottomRight, environmentLeft);               // create the slider and the grid
         environmentRightInside.add(bottomRight, bottomPanelConstraints);
         // make frame visible
         // --------------------------------------
         frame.add(environmentPanel);
         frame.setVisible(true);
    }
    
    public void addSlideListener(EventListener listenForSlider){
        slider.addChangeListener(listenForSlider);
    }

    public void setNumCols(int numCols) {
        this.numCols = numCols;
    }

    public void setNumRows(int numRows) {
        this.numRows = numRows;
    }

    

    public int getNumCols() {
        return numCols;
    }

    public int getNumRows() {
        return numRows;
    }

    public int getValue() {
        return slider.getValue();
    }

    public void repaint(int value) {
        environmentLeft.removeAll();
        if(value==1){
            createPitch(environmentLeft, LINES_SMALL, COLUMNS_SMALL);
            setNumCols(COLUMNS_SMALL);
            setNumRows(LINES_SMALL-1);
        } else if (value == 2){
            createPitch(environmentLeft, LINES_MEDIUM, COLUMNS_MEDIUM);
            setNumCols(COLUMNS_MEDIUM);
            setNumRows(LINES_MEDIUM-1);
        } else {
            createPitch(environmentLeft, LINES_LARGE, COLUMNS_LARGE);
            setNumCols(COLUMNS_LARGE);
            setNumRows(LINES_LARGE-1);
        }
        environmentLeft.revalidate();
        environmentLeft.repaint();
    }

    // create the pitch 
	// ------------------------------------------
	public void createPitch(JPanel panelLeft, int lines, int numCols) {
        JPanel pitchPanel = new JPanel(new GridLayout(lines, numCols));
        pitchPanel.setBackground(Color.WHITE);
        pitchPanel.setPreferredSize(panelLeft.getSize());

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


        panelLeft.add(pitchPanel);
    }


}
