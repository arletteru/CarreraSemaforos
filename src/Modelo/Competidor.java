package Modelo;

public class Competidor extends Thread{
    private String nombre;
    private Carrera carrera;
    private int recorrido = 0;

    public Competidor(String nombre, Carrera carrera){
        this.nombre = nombre;
        this.carrera = carrera;
    }

    public void avanzar(int n){
        //System.out.println(nombre + " avanza");
        this.recorrido += n;
    }

    public int getRecorrido(){
        return this.recorrido;
    }

    public String getNombre(){
        return this.nombre;
    }

    @Override
    public void run(){       
        System.out.println(nombre + " entro a la carrera! ");
            carrera.competir();   
    }
}
