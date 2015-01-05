/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

//import graficador.Graficador;
import graficador.Graficador;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author emiliano
 */
public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double paramMutacion = 0.01;
        int tamañoPoblacion = 30;
        int numGenes = 10;
        int minGen = 0;
        int maxGen = 1;
        int maxGeneracion = 30;

        double[] vector = new double[maxGeneracion];
        GestorDeEvolucion gestor = new GestorDeEvolucion(tamañoPoblacion, numGenes, minGen, maxGen, maxGeneracion);
        for (int j = 0; j < maxGeneracion; j++) {

            ArrayList<Individuo> nuevaPoblacion = new ArrayList<>();
            while (nuevaPoblacion.size() <= tamañoPoblacion) {
                double mutar = Math.random();
                if (mutar <= paramMutacion) { 
                    System.out.println("Muteee en la generacion: " + j);
                    Individuo mutado = gestor.getIndividuo();
                    mutado.mutacion();
                    nuevaPoblacion.add(mutado);
                } else {
                    ArrayList<Individuo> IndividuosACruzar = gestor.seleccion(2);
                    ArrayList<Individuo> hijos = gestor.reproduccion(IndividuosACruzar);
                    Individuo hijo1 = hijos.get(0);
                    Individuo hijo2 = hijos.get(1);
                    nuevaPoblacion.add(hijo1);
                    nuevaPoblacion.add(hijo2);
                }

            }
            vector[j] = gestor.fitnessPromedio();
            //System.out.println("Generacion: "+ j);
            gestor.setPoblacion(nuevaPoblacion);
        }
        
        Graficador.graficar(maxGeneracion, vector);
        System.out.println("Mejor Individuo: " + gestor.getTheBest());
        System.out.println("\n");
        System.out.println("Mejor Individuo Fitness: " + gestor.getTheBest().getFitness());
        System.out.println("\n");
        System.out.println("Pozo1: " + gestor.getTheBest().getPozo1());
        System.out.println("\n");
        System.out.println("Pozo2: " + gestor.getTheBest().getPozo2());
        System.out.println("\n");
    }
    
  public static void ejercicio1(double paramMutacion, int tamañoPoblacion, int numGenes, int minGen, int maxGen, int maxGeneracion) {
System.out.println(paramMutacion);
System.out.println(tamañoPoblacion);
System.out.println(numGenes);
System.out.println(minGen);
System.out.println(maxGen);
System.out.println(maxGeneracion);

  double[] vector = new double[maxGeneracion];
        GestorDeEvolucion gestor = new GestorDeEvolucion(tamañoPoblacion, numGenes, minGen, maxGen, maxGeneracion);
        for (int j = 0; j < maxGeneracion; j++) {

            ArrayList<Individuo> nuevaPoblacion = new ArrayList<>();
            while (nuevaPoblacion.size() <= tamañoPoblacion) {
                double mutar = Math.random();
                if (mutar <= paramMutacion) { 
                    System.out.println("Muteee en la generacion: " + j);
                    Individuo mutado = gestor.getIndividuo();
                    mutado.mutacion();
                    nuevaPoblacion.add(mutado);
                } else {
                    ArrayList<Individuo> IndividuosACruzar = gestor.seleccion(2);
                    ArrayList<Individuo> hijos = gestor.reproduccion(IndividuosACruzar);
                    Individuo hijo1 = hijos.get(0);
                    Individuo hijo2 = hijos.get(1);
                    nuevaPoblacion.add(hijo1);
                    nuevaPoblacion.add(hijo2);
                }

            }
            vector[j] = gestor.fitnessPromedio();
            //System.out.println("Generacion: "+ j);
            gestor.setPoblacion(nuevaPoblacion);
        }
        
        Graficador.graficar(maxGeneracion, vector);
        System.out.println("Mejor Individuo: " + gestor.getTheBest());
        System.out.println("\n");
        System.out.println("Mejor Individuo Fitness: " + gestor.getTheBest().getFitness());
        System.out.println("\n");
        System.out.println("Pozo1: " + gestor.getTheBest().getPozo1());
        System.out.println("\n");
        System.out.println("Pozo2: " + gestor.getTheBest().getPozo2());
        System.out.println("\n");
    }
}
