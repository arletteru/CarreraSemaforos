package Vista;


public class PruebaAnimacion {
    public static void main(String args[]){

        PanelCompetidor p = new PanelCompetidor();
        p.setCompetidor("tortuga");
        VentanaPrincipal v= new VentanaPrincipal(p);
        v.setVisible(true);
         
    }
}
