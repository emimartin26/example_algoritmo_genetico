/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

//import graficador.Graficador;
import graficador.Graficador;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author emiliano
 */
public class Ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double paramMutacion = 0.01;
        int tamañoPoblacion = 30;
        int numGenes = 24;
        int minGen = 0;
        int maxGen = 1;
        int maxGeneracion = 100;

        double[] vector = new double[maxGeneracion];
        GestorDeEvolucion gestor = new GestorDeEvolucion(tamañoPoblacion, numGenes, minGen, maxGen, maxGeneracion);
        for (int j = 0; j < maxGeneracion; j++) {

            ArrayList<Individuo> nuevaPoblacion = new ArrayList<>();
            while (nuevaPoblacion.size() <= tamañoPoblacion) {
                double mutar = Math.random();
                if (mutar <= paramMutacion) {
                    //System.out.println("Muteee en la generacion: " + j);
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
            System.out.println("Generacion: " + j);
            gestor.setPoblacion(nuevaPoblacion);
        }

        //Graficador.graficar(gestor,vector);
        Graficador.graficar(maxGeneracion, vector);

        System.out.println("Mejor Individuo: " + gestor.getTheBest());
        System.out.println("\n");
        System.out.println("Mejor Individuo Fitness: " + gestor.getTheBest().getFitness2());
        System.out.println("\n");
        System.out.println("A: " + gestor.getTheBest().getA());
        System.out.println("\n");
        System.out.println("B: " + gestor.getTheBest().getB());
        System.out.println("\n");
        System.out.println("C: " + gestor.getTheBest().getC());
        System.out.println("\n");
        System.out.println("D: " + gestor.getTheBest().getD());
        System.out.println("\n");
    }

    public static void ejercicio2(double paramMutacion, int tamañoPoblacion, int numGenes, int minGen, int maxGen, int maxGeneracion) {
        double[] vector = new double[maxGeneracion];
        GestorDeEvolucion gestor = new GestorDeEvolucion(tamañoPoblacion, numGenes, minGen, maxGen, maxGeneracion);
        for (int j = 0; j < maxGeneracion; j++) {

            ArrayList<Individuo> nuevaPoblacion = new ArrayList<>();
            while (nuevaPoblacion.size() <= tamañoPoblacion) {
                double mutar = Math.random();
                if (mutar <= paramMutacion) {
                    //System.out.println("Muteee en la generacion: " + j);
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
            System.out.println("Generacion: " + j);
            gestor.setPoblacion(nuevaPoblacion);
        }

        //Graficador.graficar(gestor,vector);
        Graficador.graficar(maxGeneracion, vector);

        System.out.println("Mejor Individuo: " + gestor.getTheBest());
        System.out.println("\n");
        System.out.println("Mejor Individuo Fitness: " + gestor.getTheBest().getFitness2());
        System.out.println("\n");
        System.out.println("A: " + gestor.getTheBest().getA());
        System.out.println("\n");
        System.out.println("B: " + gestor.getTheBest().getB());
        System.out.println("\n");
        System.out.println("C: " + gestor.getTheBest().getC());
        System.out.println("\n");
        System.out.println("D: " + gestor.getTheBest().getD());
        System.out.println("\n");
    }

}
