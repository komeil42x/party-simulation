import java.util.Hashtable;

import javax.swing.*;
//import java.awt.*;
import javax.swing.event.*;

public class SliderPanel extends JPanel implements ChangeListener{


    //1) Add a JSlider component with three values: original size, 1/2 of the original size, and double size.
    //2) Add a listener to the slider to detect changes in size and update the grid accordingly.
    //my first try:

    private JSlider slider;
    private CustomPanel customPanel;

    public SliderPanel(CustomPanel customPanel){
        this.customPanel = customPanel;

        //init. slider
        slider = new JSlider(JSlider.VERTICAL, 0, 2, 1); //Values: original size, 1/2 size, double size
        slider.setMajorTickSpacing(1); // Set major ticks at each value
        slider.setPaintTicks(true);
        slider.setSnapToTicks(true); // Snap to integer values

        //label for each tick mark
        slider.setPaintLabels(true);
        Hashtable<Integer, JLabel> labelTable = new Hashtable<>();
        labelTable.put(0, new JLabel("ZoomIn"));
        labelTable.put(1, new JLabel("Original"));
        labelTable.put(2, new JLabel("ZoomOut"));
        slider.setLabelTable(labelTable);


        slider.addChangeListener(this); // Add change listener
        add(slider);
    }

    // Implement change listener method
    @Override
    public void stateChanged(ChangeEvent e) {
        
        int value = slider.getValue();

        switch (value) {
            case 0: //Zoom in
                customPanel.setGridSize(CustomPanel.ORIGINAL_ROWS/2, CustomPanel.ORIGINAL_COLUMNS/2);
                break;
            case 1: // original size
                customPanel.setGridSize(CustomPanel.ORIGINAL_ROWS , CustomPanel.ORIGINAL_COLUMNS);
                break;
            case 2: // Zoom out
                customPanel.setGridSize(CustomPanel.ORIGINAL_ROWS * 2, CustomPanel.ORIGINAL_COLUMNS * 2);
                break;
        
            default:
                break;
        }

    }
    



}
