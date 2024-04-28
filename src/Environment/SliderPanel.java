package Environment;

/********************************************
 * Author: Soodeh, Ole, Paola
 * Version: v.1
 * Date:   20240423
 * ------------------------------------------
 * Description: creating the Slider - 
 *              no functionality for now
 ********************************************/

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Hashtable;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderPanel {

    public SliderPanel(JPanel panel) {
        panel.setLayout(new BorderLayout());
        JSlider slider = new JSlider(SwingConstants.VERTICAL, 1, 3, 2);
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

        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = slider.getValue();
                switch (value) {
                    case 1: // Zoom in
                        System.out.println("Zoom in");
                        break;
                    case 2: // original
                        System.out.println("Original");
                        break;
                    case 3: // Zoom out
                        System.out.println("Zoom out");
                        break;
                    default:
                        break;
                }
            }
        });
        panel.add(slider, BorderLayout.CENTER);
    }
}
