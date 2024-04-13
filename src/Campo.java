import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Graphics;

public class Campo extends JPanel{
    
    private Pelota pelota;
    private Raqueta raqueta1, raqueta2;
    private int cont1, cont2;
    
    public Campo() {
        setBackground(Color.BLACK);
        pelota = new Pelota();
        raqueta1 = new Raqueta(50, 10, true);
        raqueta2 = new Raqueta(1276, 10, false);
        cont1 = cont2 = 0;
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setFont(new Font("Fixedsys Normal", Font.PLAIN, 70));
        g.setColor(Color.white);
        pintarCampo(g);
        g.drawString(String.valueOf(cont1), 500, 50);
        g.drawString(String.valueOf(cont2), 800, 50);
        pelota.paint(g);
        raqueta1.paint(g);
        raqueta2.paint(g);
    }
    
    private void pintarCampo(Graphics g) {
        int y = 0;
        for (int i = 0; i < 6; i++) {
            g.fillRect(675, y, 10, 80);
            y += 110;
        }
    }
    
    public void actualizar() throws InterruptedException {
        pelota.mover(raqueta1.getColision(), raqueta2.getColision());
        raqueta1.mover();
        raqueta2.mover();
        if (pelota.getXY()[0] <= -35) {
            cont2++;
            pelota.reiniciarPelota();
            repaint();
            Thread.sleep(2000);
        }
        if (pelota.getXY()[0] >= 1400) {
            cont1++;
            pelota.reiniciarPelota();
            repaint();
            Thread.sleep(2000);
        }
    }
    
    public Pelota getPelota() {
        return pelota;
    }
    
    public Raqueta[] getRaqueta() {
        Raqueta[] r = {raqueta1, raqueta2};
        return r;
    }
}
