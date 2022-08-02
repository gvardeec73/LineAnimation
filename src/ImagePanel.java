import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImagePanel extends JPanel {

    private BufferedImage image;
    private int x = 0, y = 0;
    private int imageWidth = 0;
    private int imageHeight = 0;
    public ImagePanel() {
        try {
            image = ImageIO.read(new File("c:\\Users\\FORMULA\\IdeaProjects\\LineAnimation\\ant.png"));
            imageHeight = image.getHeight();
            imageWidth = image.getWidth();
        } catch (IOException e) {
            System.err.println("Не могу найти изображение");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(image,x,y,this);
        x++;
        y++;
        if (x > ImagePanel.this.getWidth() + imageWidth) { x = 0; y = 0;}
        if (y > ImagePanel.this.getHeight() + imageHeight) { x = 0; y = 0;}
        //System.out.println(y);
    }

    public BufferedImage getImage() {
        return image;
    }
}
