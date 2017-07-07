package ChampCDImg;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {

    private BufferedImage image;

    public ImagePanel() {
        try {
            image = ImageIO.read(new File("image name and path"));
        } catch (IOException ex) {
            // handle exception...
        }
    }

    public ImagePanel(BufferedImage img) {
        image = img;

    }

    public void setImage(String img) {

        File resource = null;
        resource = new File(img);
        try {
            if(resource != null) {
                image = ImageIO.read(resource);
            } else {
                image = null;
            }
        } catch (IOException ea) {
            ea.printStackTrace();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            Dimension d = this.getSize();
            g.drawImage(image, 0, 0, (int) d.getWidth(), (int) d.getHeight(), this);


        }
    }
}