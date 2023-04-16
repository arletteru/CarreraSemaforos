package Modelo;

public class Competicion {
    public static void main (String args []){
        Carrera carrera = new Carrera(20);

        Competidor tortuga = new Competidor("tortuga", carrera);
        Competidor liebre = new Competidor("liebre", carrera);
        Competidor caballo = new Competidor("caballo", carrera);

        tortuga.start();
        liebre.start();
        caballo.start();
    }
}
