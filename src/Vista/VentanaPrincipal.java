package Vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class VentanaPrincipal extends JFrame implements ActionListener{
    private PanelCompetidor p;

    public VentanaPrincipal(PanelCompetidor p){
        
        this.p = p;
        //p.setBounds(100, 100, 1000, 50);

        this.setLayout(null);
        this.setSize(1200,200);
        setBackground(Color.BLACK);

        JButton btn = new JButton("AVANZA");
        btn.setBounds(0, 0, 100, 50);
        btn.addActionListener( this);
     
        
        this.setContentPane(p);
        //this.add(btn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.p.avanzar(12);
    }

    public void setPanelCompetidor(PanelCompetidor c){
        this.p = c;
    }

    public void actualizarPantalla(){
        SwingUtilities.updateComponentTreeUI(this);
        this.validateTree();
    }
}
