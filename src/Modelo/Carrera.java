package Modelo;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Carrera  {
    private int longitud;
    private Semaphore semaphore;
    
    ArrayList<Competidor> lugares = new ArrayList<Competidor>();

    public Carrera(int longitud){
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
            
                avance = rand.nextInt(20+1);
                Thread.sleep(avance * 100);
            } catch(InterruptedException e){
            }
            finally{
     
                currentCompetidor = (Competidor) Thread.currentThread();

                System.out.println(currentCompetidor.getNombre() + " avanza : " + avance);
                currentCompetidor.avanzar(avance);
            
                if (currentCompetidor.getRecorrido() > this.longitud){
                    System.out.println(currentCompetidor.getNombre() + " ha llegado a la meta!");
                    this.lugares.add(currentCompetidor);
                } 
            
            semaphore.release();
            }
        }while(currentCompetidor.getRecorrido() <= this.longitud);      
    }
           
}
