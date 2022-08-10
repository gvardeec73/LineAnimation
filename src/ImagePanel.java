import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.RescaleOp;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

public class ImagePanel extends JPanel {

    private BufferedImage image;
    private int x = 0, y = 0;
    private int imageWidth = 0;
    private int imageHeight = 0;

    private boolean down = true;
    private boolean right = true;
    private  int color = 0xFFFFFFFF;

    {
        ImagePanel.this.setBackground(Color.BLACK);

    }

    public ImagePanel() {
        try {
            image = ImageIO.read(new File("c:\\Users\\FORMULA\\IdeaProjects\\LineAnimation\\DVD.png"));
            imageHeight = image.getHeight();
            imageWidth = image.getWidth();
            //replaceColor(image,color);

        } catch (IOException e) {
            System.err.println("Не могу найти изображение");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int k = 2;

        g.drawImage(image, x, y, this);
        if (down && right) {
            x++;
            y++;
        }
        if (down && !right) {
            x--;
            y++;
        }
        if (!down && right) {
            x++;
            y--;
        }
        if (!down && !right) {
            x--;
            y--;
        }

        if (x > ImagePanel.this.getWidth() - imageWidth) {
            right = false;
            color = 0xFFFF0000;
            replaceColor(image,color);
        }
        if (y > ImagePanel.this.getHeight() - imageHeight) {
            down = false;
            color = 0xFF00FF00;
            //replaceColor(image,color);
        }
        if (x < 0) {
            right = true;
            color = 0xFF0000FF;
           // replaceColor(image,color);
        }
        if (y < 0) {
            down = true;
            color = 0xFFFF00FF;
          //  replaceColor(image,color);
        }


    }

    public BufferedImage getImage() {
        return image;
    }

    public void replaceColor(BufferedImage bImage, int color) {
        //int [] rgbArray = new int[bImage.getHeight() * bImage.getWidth()];
        int q;
        for (int i = 0; i < bImage.getWidth(); i++) {
            for (int j = 0; j < bImage.getHeight(); j++) {
              /*if (bImage.getRGB(i,j) == 0xFF000000) {
                    bImage.setRGB(i,j,0xFF0000FF);
                }*/
                q = bImage.getRGB(i, j);
                bImage.setRGB(i, j, q & color | 0xFF000000);

               // System.out.printf("%h", bImage.getRGB(i, j));
               // System.out.println();
            }


        }
    }
}








