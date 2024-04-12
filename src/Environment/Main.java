import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("Nightclub");
        Panel panel = new Panel();
        CustomPanel customPanel = new CustomPanel();

       
        frame.setContentPane(customPanel); 
        customPanel.add(panel, BorderLayout.CENTER);
        
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(1200, 750);
        frame.setVisible(true);
    }
}
