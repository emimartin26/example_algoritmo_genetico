/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author emiliano
 */
public class GestorDeEvolucion implements Operaciones {

    private int tamañoPoblacion;
    private ArrayList<Individuo> poblacion;
    private int numGenes;
    private int minGen;
    private int maxGen;
    private int maxGeneracion;

    private ArrayList<Integer> indices;

    public GestorDeEvolucion(int tamañoPoblacion, int numGenes, int minGen, int maxGen, int maxGeneracion) {
        this.tamañoPoblacion = tamañoPoblacion;
        this.numGenes = numGenes;
        this.minGen = minGen;
        this.maxGen = maxGen;
        this.maxGeneracion = maxGeneracion;
        this.poblacion = new ArrayList<Individuo>();
        this.indices = new ArrayList<Integer>();
        this.createPoblacion();

    }

    // Del 0 al 29 - En total 30 individuos
    public void createPoblacion() {
        for (int i = 0; i < tamañoPoblacion; i++) {
            Individuo indiv = new Individuo(numGenes, minGen, maxGen);
            this.poblacion.add(indiv);
            //System.out.println(indiv)
        }
    }

    public int getTamañoPoblacion() {
        return tamañoPoblacion;
    }

    public void setTamañoPoblacion(int tamañoPoblacion) {
        this.tamañoPoblacion = tamañoPoblacion;
    }

    public ArrayList<Individuo> getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(ArrayList<Individuo> poblacion) {
        this.poblacion = poblacion;
    }

    public int getNumGenes() {
        return numGenes;
    }

    public void setNumGenes(int numGenes) {
        this.numGenes = numGenes;
    }

    public int getMinGen() {
        return minGen;
    }

    public void setMinGen(int minGen) {
        this.minGen = minGen;
    }

    public int getMaxGen() {
        return maxGen;
    }

    public void setMaxGen(int maxGen) {
        this.maxGen = maxGen;
    }

    public int getMaxGeneracion() {
        return maxGeneracion;
    }

    public void setMaxGeneracion(int maxGeneracion) {
        this.maxGeneracion = maxGeneracion;
    }

    @Override
    public ArrayList<Individuo> seleccion(int numIndividuos) {
        ArrayList<Individuo> individuosACruzar = new ArrayList<Individuo>();
        ArrayList<Double> individuosConFitnnes = new ArrayList<Double>();

        double acu = 0.0;
        for (int i = 0; i < this.tamañoPoblacion; i++) {
            acu = acu + this.poblacion.get(i).getFitness2() / fitnessTotal();
            individuosConFitnnes.add(acu);
        }

        double sorteo1 = Math.random();
        double sorteo2 = Math.random();

        for (int i = 0; i < this.tamañoPoblacion; i++) {
            if (sorteo1 < individuosConFitnnes.get(i)) {
                Individuo indv1 = this.poblacion.get(i);
                individuosACruzar.add(indv1);
                break;
            }

        }
        for (int i = 0; i < this.tamañoPoblacion; i++) {
            if (sorteo2 < individuosConFitnnes.get(i)) {
                Individuo indv2 = this.poblacion.get(i);
                individuosACruzar.add(indv2);
                break;
            }
        }

        return individuosACruzar;
    }

    public double fitnessPromedio() {
        double fitnessPromedio = 0;
        for (int i = 0; i < this.tamañoPoblacion; i++) {
            fitnessPromedio = fitnessPromedio + this.poblacion.get(i).getFitness2();
        }
        fitnessPromedio = fitnessPromedio / this.tamañoPoblacion;
        return fitnessPromedio;
    }

    public double fitnessTotal() {
        double fitnessTotal = 0;
        for (int i = 0; i < this.tamañoPoblacion; i++) {
            fitnessTotal = fitnessTotal + this.poblacion.get(i).getFitness2();
        }
        return fitnessTotal;
    }

    public boolean yaSalio(int valor) {
        if (this.indices.contains(valor)) {
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<Individuo> reproduccion(ArrayList<Individuo> individuosCruza) {
        Random rnd = new Random();
        int puntoCruza = rnd.nextInt(8 - 1 + 1) + 1;
        Individuo padre1 = individuosCruza.get(0);
        Individuo padre2 = individuosCruza.get(1);

        Individuo hijo1 = new Individuo();
        hijo1.setNumGenes(numGenes);
        hijo1.setInitialCromosoma();

        Individuo hijo2 = new Individuo();
        hijo2.setNumGenes(numGenes);
        hijo2.setInitialCromosoma();

//        System.out.print("Padre1: " + padre1);
//        System.out.print("\n");
//        System.out.print("Padre2: " + padre2);
//        System.out.print("\n");
//        System.out.print("Punto Cruza: " + puntoCruza);
//        System.out.print("\n");
        for (int i = 0; i < puntoCruza; i++) {
            hijo1.getCromosoma()[i] = padre1.getCromosoma()[i];
        }
        for (int i = puntoCruza; i < numGenes; i++) {
            hijo1.getCromosoma()[i] = padre2.getCromosoma()[i];
        }
//        System.out.print("Hijo1: " + hijo1);
//        System.out.print("\n");

        for (int i = 0; i < puntoCruza; i++) {
            hijo2.getCromosoma()[i] = padre2.getCromosoma()[i];
        }
        for (int i = puntoCruza; i < numGenes; i++) {
            hijo2.getCromosoma()[i] = padre1.getCromosoma()[i];
        }
//        System.out.print("Hijo2: " + hijo2);
//        System.out.print("\n");
        ArrayList<Individuo> hijos = new ArrayList<>();
        hijos.add(hijo1);
        hijos.add(hijo2);
        return hijos;
    }

    @Override
    public void remplazar(ArrayList<Individuo> individuosGenerados) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Individuo evolve() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Individuo getTheBest(){
        double mejor = 0;
        Individuo individuoMejor = new Individuo();
        for (int i = 0; i < this.tamañoPoblacion; i++) {
            if(mejor<this.poblacion.get(i).getFitness2()){
                mejor = this.poblacion.get(i).getFitness2();
                individuoMejor = this.poblacion.get(i);
            }            
        }
        return individuoMejor;
    }
    public Individuo getIndividuo() {
        Random rnd = new Random();
        int eleccion = rnd.nextInt((tamañoPoblacion-1) - 0 + 1) + 0;
        //System.out.println(eleccion);
        return this.poblacion.get(eleccion);  
    }

}
