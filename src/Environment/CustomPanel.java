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

public class CustomPanel {

    final int LINES = 40;
    final int COLUMNS = 80;

    public CustomPanel() {
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
        new SliderPanel(bottomRight);
        // create grid
        // --------------------------------------
        new Grid(environmentLeft, LINES, COLUMNS);
        // make frame visible
        // --------------------------------------
        frame.setVisible(true);
    }
}
