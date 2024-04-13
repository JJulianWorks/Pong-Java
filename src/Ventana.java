import javax.swing.JFrame;

public class Ventana extends JFrame {
    
    Campo campo = new Campo();
    
    public Ventana() throws Exception {    
        add(campo);
        setTitle("Pong");
        setSize(1366, 702);
        setResizable(false);
        addKeyListener(campo.getRaqueta()[0]);
        addKeyListener(campo.getRaqueta()[1]);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Thread.sleep(3000);
        while(true) {
            campo.actualizar();
            repaint();
            Thread.sleep(10);
        }
    }
    
    public static void main(String[] args) throws Exception {
        new Ventana();
    }
}
