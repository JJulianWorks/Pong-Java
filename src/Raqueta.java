import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;

public class Raqueta extends JPanel implements KeyListener {
    
    private int x, y, ancho, largo;
    private Rectangle2D colision;
    private final boolean isP1;
    private boolean up, down;
    
    public Raqueta(int x, int y, boolean isP1) {
        this.isP1 = isP1;
        this.x = x;
        this.y = y;
        ancho = 25;
        largo = 100;
    }
    
    public void mover() {
        if (up && y > 0) {
            y -= 8;
        }
        if (down && y < 565) {
            y += 8;
        }
    }
    
    @Override
    public void paint(java.awt.Graphics g) {
        super.paint(g);
        g.setColor(Color.white);
        g.fillRect(x, y, ancho, largo);
    }

    public Rectangle2D getColision() {
        return new Rectangle2D.Double(x, y, ancho, largo);
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_G) {
            System.exit(0);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (isP1) {
            if (e.getKeyCode() == KeyEvent.VK_W) {
                up = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_S) {
                down = true;
            }
        } else {
            if (e.getKeyCode() == KeyEvent.VK_O) {
                up = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_L) {
                down = true;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (isP1) {
            if (e.getKeyCode() == KeyEvent.VK_W) {
                up = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_S) {
                down = false;
            }
        } else {
            if (e.getKeyCode() == KeyEvent.VK_O) {
                up = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_L) {
                down = false;
            }
        }
    }
}
