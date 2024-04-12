import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CustomPanel extends JPanel {
    private BufferedImage image;

    public CustomPanel(){

        try {
            image = ImageIO.read(new File("C:/Users/soode/Desktop/CJ2/Bar2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setPreferredSize(new Dimension(1200, 750)); 
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw grid lines with a margin
        int cellSize = 20; 
        int margin = 20; 
        int width = getWidth() - margin * 2; 
        int height = getHeight() - margin * 2; 
        g.setColor(Color.LIGHT_GRAY); 
        // Draw horizontal lines
        for (int y = margin; y < height; y += cellSize) {
            g.drawLine(margin, y, width + margin, y);
        }
        // Draw vertical lines
        for (int x = margin; x < width; x += cellSize) {
            g.drawLine(x, margin, x, height + margin);
        }
        // Draw floor sections
        // draw a main bar in the left
        int barWidth = 3 * cellSize; //60 
        int barHeight = 4 * cellSize; //80
        int barX = cellSize; 
        int barY = getHeight() / 3 - cellSize; 
        //g.setColor(Color.BLUE); 
        g.setColor(new Color(0, 0, 255, 128));
        g.fillRect(barX, barY, barWidth, barHeight);

        g.setColor(Color.CYAN);
        g.drawRect(barX, barY, barWidth, barHeight);

        // Calculate the position and size of the image to fit the main bar
        int barImageX = 30; 
        int barImageY = getHeight() / 3 - 15;
        int barImageWidth = 2 * cellSize;
        int barImageHeight = 3 * cellSize; 

        // Draw the image scaled to fit the main bar
        if (image != null) {
            g.drawImage(image, barImageX, barImageY, barImageWidth, barImageHeight, null);
        }
        
        // Draw surrounding lines
        g.setColor(Color.BLACK);
        g.drawRect(margin, margin, width, height);
    }
}
