import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Gravity extends JPanel implements KeyListener
{ 
  // This tells us the frames per second
  public static final int FPS = 64;
  public static final int TIME_BETWEEN_FRAMES = 1000/FPS;
  
  Character tata = new Character(400,0,100);
  
  // Keep track of which buttons are currently pressed
  boolean jump = false;
  boolean down = true;
  boolean left = false;
  boolean right = false;
  
  public static void main(String[] args)
  {
    JFrame frame = new JFrame();
    frame.setSize(1680,1050);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Gravity panel = new Gravity();
    frame.add(panel);
    frame.setVisible(true);
    
    panel.gameLoop();
  }
  
  public Gravity()
  {
    addKeyListener(this);
    setFocusable(true);
  }
  
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    
    // Draw the tata
    tata.drawTo(g);
  }
  
  
  public void gameLoop()
  {
    long nextFrame = System.currentTimeMillis();
    while(true)
    {
      // As long as the current time is greater than
      // the next frame, do another step
      // This helps deal with getting behind
      while(System.currentTimeMillis() > nextFrame)
      {
        stepGame();
        nextFrame = nextFrame + TIME_BETWEEN_FRAMES;
      }
      // Drawing the screen is slow
      repaint();
    }
  }
  
  public void stepGame()
  {
    if(left)
    {
      tata.moveLeft();
    }
    if(right)
    {
      tata.moveRight();
    }
    if(jump)
    {
      tata.jump();
    }
    if(down)
    {
      tata.moveDown();
    }
  }
  
  public void keyPressed(KeyEvent e)
  {
    int code = e.getKeyCode();
    if(code == KeyEvent.VK_LEFT)
    {
      left = true;
    }
    if(code == KeyEvent.VK_RIGHT)
    {
      right = true;
    }
    if(code == KeyEvent.VK_UP)
    {
      jump = true;
    }
  }
  
  public void keyReleased(KeyEvent e)
  {
    int code = e.getKeyCode();
    if(code == KeyEvent.VK_LEFT)
    {
      left = false;
    }
    if(code == KeyEvent.VK_RIGHT)
    {
      right = false;
    }
    if(code == KeyEvent.VK_UP)
    {
      jump = false;
    }
    down = true;
  }
  
  public void keyTyped(KeyEvent e)
  {
    int code = e.getKeyCode();
    if(code == KeyEvent.VK_UP)
    {
      jump = true;
    }
  }
}

class Character
{
  int x;
  int y;
  int width;
  int height; // we'll change this to import pics
  Color color;
  
  int speed = 5;
  int speedUp = 25; // speed when it goes up
  int speedDown = 5; // speed when it goes down
  int timeJump = 15; // time it has to jump
  
  public Character(int x, int y, int size)
  {
    this.x = x;
    this.y = y;
    width = size; // we will also change this
    height = size;
    color = Color.BLACK;
  }
  
  public void drawTo(Graphics g)
  {
    g.setColor(color);
    g.fillRect(x,y,width,height);
  }
  
  public void moveRight()
  {
    x = x + speed;
  }
  
  public void moveLeft()
  {
    x = x - speed;
  }
  
  public void jump()
  {
    
    if(timeJump > 0)
    {
      y = y - speedUp;
      timeJump--;
    }
    /* if(timeJump = 0)
    {
      timeJump = 10;
    } */
  }
  
  public void moveDown()
  {
    y = y + speedDown;
  }

}