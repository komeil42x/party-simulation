package Environment;

/********************************************
 * Author: Soodeh,...
 * Version: v.1
 * Date:   20240418
 * ------------------------------------------
 * Description:  
 * This class will extend JPanel and will contain the slider for resizing the grid.
 * It implements ChangeListener to detect changes in size and update the grid accordingly.
 ********************************************/

import java.util.Hashtable;

import javax.swing.*;
import javax.swing.event.*;

public class SliderPanel extends JPanel implements ChangeListener{

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
