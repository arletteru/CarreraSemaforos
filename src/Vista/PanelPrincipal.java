package Vista;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Control.ControlCarrera;

public class PanelPrincipal extends JPanel {
    private PanelCompetidor competidor1;
    private PanelCompetidor competidor2;
    private PanelCompetidor competidor3;
    private ControlCarrera control;

    public PanelPrincipal(ControlCarrera control){
        this.setLayout(null);
        this.setSize(1200,500);
        this.control = control;

        //Creamos los paneles de los 3 competidores y le seteamos el competidor
        this.competidor1 = new PanelCompetidor();
        competidor1.setCompetidor("tortuga");
        competidor1.setBounds(100, 100, 1200, 50);

        this.competidor2 = new PanelCompetidor();
        competidor2.setCompetidor("liebre");
        competidor2.setBounds(100, 200, 1200, 50);

        this.competidor3 = new PanelCompetidor();
        competidor3.setCompetidor("gato");
        competidor3.setBounds(100, 300, 1200, 50);


        JButton btn = new JButton("START");
        btn.setBounds(500, 350, 100, 50);
        btn.addActionListener( this.control);
       
        this.add(competidor1);
        this.add(competidor2);
        this.add(competidor3);
        this.add(btn);
    }

    public void actualizarPantalla(){
        SwingUtilities.updateComponentTreeUI(this);
        this.validateTree();
    }

    public void avanzar(String competidor, int a){
        switch(competidor.toLowerCase()){
            case "tortuga":
                competidor1.avanzar(a);
                break;
            case "liebre":
                competidor2.avanzar(a);
                break;
            case "gato":
                competidor3.avanzar(a);
                break;
        }
    }
}
