package Environment;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.Hashtable;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * The SimulationGUI class represents the graphical user interface for the nightclub simulation.
 * It provides a grid-based environment for the simulation and allows the user to adjust the size of the grid using a slider.
 */
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
    private  JSlider slider;
    private int numCols;
    private int numRows;

    
    /**
     * The SimulationGUI class represents the graphical user interface for the nightclub simulation.
     * It creates a frame with panels to display the environment and controls.
     */
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
        // create label
        JLabel labelHeadline = new JLabel("SIZE");
        labelHeadline.setHorizontalAlignment(SwingConstants.CENTER);
        labelHeadline.setVerticalAlignment(SwingConstants.CENTER);
        Font font = labelHeadline.getFont();
        labelHeadline.setFont(new Font(font.getName(), Font.BOLD, 12));
        topRight.add(labelHeadline);
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
        environmentRightInside.add(bottomRight, bottomPanelConstraints);
        // add panel to frame
        // --------------------------------------
        frame.add(environmentPanel);
        // create slider
        // --------------------------------------
        // new SliderPanel(bottomRight);
        createSlider(bottomRight);

        // make frame visible
        // --------------------------------------
        frame.setVisible(true);
    }

    /**
     * Adds a change listener to the slider.
     *
     * @param listenForSlider the change listener to be added
     */
    public void addSlideListener(ChangeListener listenForSlider) {
        slider.addChangeListener(listenForSlider);
    }

    /**
     * Sets the number of columns in the simulation grid.
     *
     * @param numCols the number of columns to set
     */
    public void setNumCols(int numCols) {
        this.numCols = numCols;
    }

    /**
     * Sets the number of rows in the simulation GUI.
     *
     * @param numRows the number of rows to set
     */
    public void setNumRows(int numRows) {
        this.numRows = numRows;
    }

    /**
     * Returns the number of columns in the simulation grid.
     *
     * @return the number of columns
     */
    public int getNumCols() {
        return numCols;
    }

    /**
     * Returns the number of rows in the simulation GUI.
     *
     * @return the number of rows
     */
    public int getNumRows() {
        return numRows;
    }

    /**
     * Returns the current value of the slider.
     *
     * @return the current value of the slider
     */
    public int getValue() {
        return slider.getValue();
    }

    /**
     * Repaints the simulation GUI based on the given value.
     * The value determines the size of the pitch to be created.
     * 
     * @param value the value indicating the size of the pitch
     */
    public void repaint(int value) {
        environmentLeft.removeAll();
        if (value == 1) {
            createPitch(environmentLeft, LINES_SMALL, COLUMNS_SMALL);
            setNumCols(COLUMNS_SMALL);
            setNumRows(LINES_SMALL - 1);
        } else if (value == 2) {
            createPitch(environmentLeft, LINES_MEDIUM, COLUMNS_MEDIUM);
            setNumCols(COLUMNS_MEDIUM);
            setNumRows(LINES_MEDIUM - 1);
        } else {
            createPitch(environmentLeft, LINES_LARGE, COLUMNS_LARGE);
            setNumCols(COLUMNS_LARGE);
            setNumRows(LINES_LARGE - 1);
        }
        environmentLeft.revalidate();
        environmentLeft.repaint();
    }

    /**
     * Creates a pitch panel with a grid layout and adds it to the specified panel.
     * Each cell in the grid has a white background and a light gray border.
     * Tooltips are created for each cell to identify their position in the grid.
     *
     * @param panelLeft the panel to which the pitch panel will be added
     * @param lines the number of lines in the grid
     * @param numCols the number of columns in the grid
     */
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

    /**
     * Creates a slider component and adds it to the specified panel.
     * The slider allows the user to adjust the zoom level of the simulation GUI.
     *
     * @param panel the panel to which the slider will be added
     */
    public void createSlider(JPanel panel) {
        panel.setLayout(new BorderLayout());
        slider = new JSlider(SwingConstants.VERTICAL, 1, 3, 2);
        slider.setPaintTicks(true);
        slider.setSnapToTicks(true);
        slider.setMajorTickSpacing(1);
        // label for each tick mark
        slider.setPaintLabels(true);
        Hashtable<Integer, JLabel> labelTable = new Hashtable<>();
        labelTable.put(1, new JLabel("ZoomIn"));
        labelTable.put(2, new JLabel("Original"));
        labelTable.put(3, new JLabel("ZoomOut"));
        slider.setLabelTable(labelTable);
        slider.setBackground(Color.WHITE);

        panel.add(slider, BorderLayout.CENTER);
    }

}
