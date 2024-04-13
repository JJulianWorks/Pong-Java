import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

public class Pelota extends JPanel {
    
    private int x, y, ancho, largo;
    private int vel_x, vel_y;
    
    public Pelota() {
        x = 665;
        y = 300;
        ancho = 30;
        largo = 30;
        vel_x = vel_y = 8;
    }
    
    public int[] getXY() {
        int[] xy = {x, y};
        return xy;
    }
    
    public void mover(Rectangle2D r1, Rectangle2D r2) {
        if(colision(r2)) {
            vel_x = -8;
        }
        if(colision(r1)) {
            vel_x = 8;
        }
        if(y > 640) {
            vel_y = -8;
        }
        if(y < 0) {
            vel_y = 8;
        }
        x += vel_x;
        y += vel_y;
    }
    
    public void reiniciarPelota() {
        x = 665;
        y = 300;
    }
    
    public Rectangle2D getColision() {
        return new Rectangle2D.Double(x, y, ancho, largo);
    }
    
    public boolean colision(Rectangle2D r) {
        return getColision().intersects(r);
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.white);
        g.fillOval(x, y, ancho, largo);
    }
}
