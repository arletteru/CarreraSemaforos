package Vista;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class PanelCompetidor extends JPanel {
    private BufferedImage competidor;
    private int posicion = 0;
    private int avance = 0;
    
    public PanelCompetidor(){
       super(null);
       setSize(1200,60);
       setVisible(true);
    }

    public void setCompetidor(String competidor){
        try {
			this.competidor = ImageIO.read(getClass().getResource("/imagenes/"+ competidor.toLowerCase() + ".png"));
		}catch (IOException ie) {
			JOptionPane.showMessageDialog(null, "Juego atrofiado por favor, restaurar version");
		}
    }


    public void paint(Graphics g){
        super.paint(g);     
        for(int i=0 ;i<this.avance*5;i++){
            g.drawImage(competidor, this.posicion+i ,0, null);
            try {
                Thread.sleep(14);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            g.clearRect(0,0,1200,50);
        }
        this.posicion += this.avance*5;
        g.drawImage(competidor, this.posicion ,0, null);
    }
    

    public void avanzar(int a){
        this.avance = a;     
        this.paint(getGraphics());
    }
}

