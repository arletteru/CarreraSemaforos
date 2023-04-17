package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import Modelo.Carrera;
import Modelo.Competidor;
import Vista.PanelPrincipal;

public class ControlCarrera implements ActionListener{
    private PanelPrincipal panelPrincipal;
    private Carrera carrera;
    private JFrame ventanaP;

    public ControlCarrera(){
        ventanaP  = new JFrame("Competición");
        this.ventanaP.setBounds(50,50,1660,955);
		this.ventanaP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void startCompeticion(){
        carrera = new Carrera(200);
        carrera.setControl(this);
        panelPrincipal = new PanelPrincipal(this);
        ventanaP.setContentPane(panelPrincipal);
        ventanaP.setVisible(true);
    }

    public void avanzar(String Competidor, int a){
        this.panelPrincipal.avanzar(Competidor, a);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Competidor tortuga = new Competidor("tortuga", carrera);
        Competidor liebre = new Competidor("liebre", carrera);
        Competidor gato = new Competidor("gato", carrera);

        
        liebre.start();
        tortuga.start();
        gato.start();
    }
}
