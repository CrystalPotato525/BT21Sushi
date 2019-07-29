import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

import java.io.File; // For loading from a file
import java.io.IOException; // For catching errors
import javax.imageio.ImageIO; // For loading images from a file
import java.awt.image.BufferedImage; // Variable type to store image
public class Graphics1 extends JPanel
{
  private BufferedImage image;
  private BufferedImage image2;
  public Graphics1()
  {
    image = loadImage("Tata.jpg");
    image2 = loadImage("Wasabi.jpg");
  }
    
  
  /* This is an example of how to write a loadImage method.
   * In your projects, you can just copy this method and use it directly. */
  public static BufferedImage loadImage(String filename)
  {
    BufferedImage loadedImage;
    try // Put "dangerous" operations in here
    {
      // Read the file into a variable
      File file = new File(filename);
    
      // Extract the actual image into a form we can work with
      loadedImage = ImageIO.read(file);
    }
    catch(IOException error)
    {
      loadedImage = null;
      System.out.println("ERROR: " + error.getMessage());
    }
    
    return loadedImage;
  }
  
 

  /* Specifies what will be drawn on the JPanel, as usual. */
  public void paintComponent(Graphics g)
  {
    // Draw to the screen at position (0,0)
    // You can ignore the null for now, it's just a required parameter.
    g.setColor (Color.WHITE);
    g.fillRect(0,0,2000,1600);
    g.drawImage(image, 50, 800, null);
    g.drawImage(image2, 600, 290, null);
    g.drawImage(image2, 1130, 435, null);
    g.drawImage(image2, 1400, 435, null);
 
    g.setColor (Color.BLACK);
    //floor
    g.fillRect(0,930,2000,100);
    
    g.setColor (Color.GRAY);
    g.fillRect(250,790,100,50);
    g.fillRect(400,700,100,50);
    g.fillRect(500,600,100,50);
    g.fillRect(300,500,100,50);
    g.fillRect(500,350,200,50);
    g.fillRect(900,350,75,1000);
    g.fillRect(1100,500,100,50);
    g.fillRect(1300,500,175,50);
    g.fillRect(1500,400,200,1000);
    
    
  }
  
  
  
  
  /* Main method */
  public static void main(String[] args)
  {
    // Usual 6 lines of graphics main method
    JFrame frame = new JFrame();
    frame.setSize(800,600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Graphics1 panel = new Graphics1();
    frame.add(panel);
    frame.setVisible(true);
  
  }
}