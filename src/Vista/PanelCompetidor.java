package Vista;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class PanelCompetidor extends JPanel {
    private BufferedImage competidor;
    private int posicion = 100;
    private int avance=5;
    
    public PanelCompetidor(){
       super(null);
       setSize(100,50);
       setVisible(true);
           
    }

    public void setCompetidor(String competidor){
        try {
			this.competidor = ImageIO.read(getClass().getResource("/imagenes/"+ competidor + ".png"));
		}catch (IOException ie) {
			JOptionPane.showMessageDialog(null, "Juego atrofiado por favor, restaurar version");
		}
    }

    public void paint(Graphics g){
        /*if(this.avance == 0){
            g.drawImage(competidor, this.posicion ,0, null);
        }else{*/
        super.paint(g);
            for(int i = 0; i< 500; i++){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                g.clearRect(0, 0, 1000, 200);                
                g.drawImage(competidor, i , 50, null);
                g.fillOval(i, 0, 50, 50);
                   
            } 
            
        }
    

    public void avanzar(int a){
        this.avance = a;     
        this.paint(getGraphics());;
        this.posicion += a;
    }
}
