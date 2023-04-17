package Modelo;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;

import javax.swing.JOptionPane;

import Control.ControlCarrera;

public class Carrera  {
    private int longitud;
    private Semaphore semaphore;
    private ControlCarrera control;
    
    ArrayList<Competidor> lugares = new ArrayList<Competidor>();

    public Carrera(int longitud ){
        this.longitud = longitud;
        semaphore = new Semaphore(1);
    }

    public void competir(){
        Competidor currentCompetidor;
        currentCompetidor = (Competidor) Thread.currentThread();
        Random rand = new Random();
        int avance = 0;

        do{
            try{          
                semaphore.acquire();
            
                avance = rand.nextInt(21);
                Thread.sleep(avance * 100);
            } catch(InterruptedException e){
            }
            finally{
     
                currentCompetidor = (Competidor) Thread.currentThread();
                control.avanzar(currentCompetidor.getNombre(), avance);

                System.out.println(currentCompetidor.getNombre() + " avanza : " + avance);
                currentCompetidor.avanzar(avance);
            
                if (currentCompetidor.getRecorrido() > this.longitud){
                    System.out.println(currentCompetidor.getNombre() + " ha llegado a la meta!");
                    JOptionPane.showMessageDialog(null, currentCompetidor.getNombre() + " ha llegado a la meta!");
                    this.lugares.add(currentCompetidor);
                    break;
                } 
            
            semaphore.release();
            }
        }while(currentCompetidor.getRecorrido() <= this.longitud);      
    }
     
    public void setControl(ControlCarrera c){
        this.control = c;
    }
}
